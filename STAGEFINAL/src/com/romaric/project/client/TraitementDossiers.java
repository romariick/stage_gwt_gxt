package com.romaric.project.client;

import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.TabPanel;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.layout.AbsoluteLayout;
import com.extjs.gxt.ui.client.widget.layout.AbsoluteData;
import com.extjs.gxt.ui.client.Style;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Label;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.form.NumberField;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.store.ListStore;
import com.google.gwt.user.client.ui.ListBox;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import java.util.Collections;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.cellview.client.PageSizePager;
import com.romaric.project.Visa.MonService;
import com.romaric.project.Visa.MonServiceAsync;
import com.romaric.project.model.Nationalite;
import com.romaric.project.model.Client;
import com.romaric.project.traitementDossier.ArriveeAnosyAvecDecision;
import com.romaric.project.traitementDossier.CarteDeResidentEnvoyeAnosy;
import com.romaric.project.traitementDossier.EnvoyerAnosyPourDecision;
import com.romaric.project.traitementDossier.PasseportArriveeAnosy;
import com.romaric.project.traitementDossier.PasseportEnvoyeAnosy;
import com.extjs.gxt.ui.client.widget.SplitBar;
import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.widget.treetable.TreeTable;
import com.extjs.gxt.ui.client.widget.treetable.TreeTableColumnModel;
import com.extjs.gxt.ui.client.widget.treetable.TreeTableColumn;
import com.extjs.gxt.ui.client.widget.treegrid.TreeGrid;
import com.extjs.gxt.ui.client.store.TreeStore;
import com.extjs.gxt.ui.client.widget.grid.EditorGrid;
import com.extjs.gxt.ui.client.widget.menu.MenuBar;
import com.extjs.gxt.ui.client.widget.menu.MenuBarItem;
import com.extjs.gxt.ui.client.widget.menu.Menu;
import com.extjs.gxt.ui.client.widget.layout.AccordionLayout;

public class TraitementDossiers extends Window {
	final MonServiceAsync monServ = GWT.create(MonService.class);
	//final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);
	
	/*Récuperation information client DEMANDE VISA **********************/
	final ListStore<Client> storeInfoClient = new ListStore<Client>();
	final List<Client> stocksInfoClient = new ArrayList<Client>();
	
	/*Récuperation information client DEMANDE VISA **********************/
	final ListStore<Client> storeInfoClient2 = new ListStore<Client>();
	final List<Client> stocksInfoClient2 = new ArrayList<Client>();

/************* Récuperation information client ENVOYE ANOSY **********************/
	final ListStore<Client> storeInfoClient3 = new ListStore<Client>();
	final List<Client> stocksInfoClient3 = new ArrayList<Client>();
	
	/************* Récuperation information client ARRIVE A ANOSY **********************/
	final ListStore<Client> storeInfoClient4 = new ListStore<Client>();
	final List<Client> stocksInfoClient4 = new ArrayList<Client>();
	
	/***************Recupération information client Arrive anosy avec décision **************/
	final ListStore<Client> storeInfoClient5 = new ListStore<Client>();
	final List<Client> stocksInfoClient5 = new ArrayList<Client>();

	public TraitementDossiers() {
		setModal(true);
		setOnEsc(false);
		setWidth(953);
		setHeight(425);
		setBlinkModal(true);
		setHeading("Accueil > Traitements des dossiers");
		setLayout(new AbsoluteLayout());
		
		TabPanel tabPanel = new TabPanel();
		
		TabItem tbtmDpot_1 = new TabItem("R\u00E9\u00E7us \u00E0 l'EDBM");
		tbtmDpot_1.setLayout(new AbsoluteLayout());
		List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
		
		ContentPanel cntntpnlTches = new ContentPanel();
		cntntpnlTches.setHeading("T\u00E2ches");
		cntntpnlTches.setLayout(new AccordionLayout());
		
		ContentPanel cntntpnlOutils = new ContentPanel();
		cntntpnlOutils.setHeading("Outils");
		cntntpnlOutils.setCollapsible(true);
		cntntpnlOutils.setLayout(new AbsoluteLayout());
		
		Button btnNewButton = new Button("Env. \u00E0 Anosy pour d\u00E9c.");
		btnNewButton.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {
				EnvoyerAnosyPourDecision envAnosy = new EnvoyerAnosyPourDecision();
				envAnosy.show();
			}
		});
		cntntpnlOutils.add(btnNewButton, new AbsoluteData(31, 6));
		btnNewButton.setSize("154px", "25px");
		
		Button btnNewButton_1 = new Button("Arriv\u00E9 \u00E0 Anosy avec d\u00E9c.");
		btnNewButton_1.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {
				ArriveeAnosyAvecDecision arri = new ArriveeAnosyAvecDecision();
				arri.show();
			}
		});
		cntntpnlOutils.add(btnNewButton_1, new AbsoluteData(31, 55));
		btnNewButton_1.setSize("154px", "24px");
		
		Button btnPasseportEnv = new Button("Passeport env. \u00E0 Anosy");
		btnPasseportEnv.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {
				PasseportEnvoyeAnosy pass = new PasseportEnvoyeAnosy();
				pass.show();
			}
		});
		cntntpnlOutils.add(btnPasseportEnv, new AbsoluteData(31, 96));
		btnPasseportEnv.setSize("154px", "25px");
		
		Button btnPasseportArrive = new Button("Passeport arriv\u00E9e \u00E0 Anosy");
		btnPasseportArrive.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {
				PasseportArriveeAnosy arrPass = new PasseportArriveeAnosy();
				arrPass.show();
			}
		});
		cntntpnlOutils.add(btnPasseportArrive, new AbsoluteData(31, 145));
		btnPasseportArrive.setSize("154px", "24px");
		
		Button btnCarteDeRsident = new Button("Carte de r\u00E9sident env. Anosy");
		btnCarteDeRsident.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {
				CarteDeResidentEnvoyeAnosy carte = new CarteDeResidentEnvoyeAnosy();
				carte.show();
			}
		});
		cntntpnlOutils.add(btnCarteDeRsident, new AbsoluteData(31, 184));
		cntntpnlTches.add(cntntpnlOutils);
		tbtmDpot_1.add(cntntpnlTches, new AbsoluteData(16, 20));
		cntntpnlTches.setSize("213px", "279px");
		
		ContentPanel cntntpnlNewContentpanel = new ContentPanel();
		cntntpnlNewContentpanel.setHeaderVisible(false);
		cntntpnlNewContentpanel.setHeading("New ContentPanel");
		cntntpnlNewContentpanel.setLayout(new AbsoluteLayout());
		
		ColumnConfig clmncnfgNomEtPrnom = new ColumnConfig("nomEtPrenom", "Nom et Pr\u00E9nom", 150);
		configs.add(clmncnfgNomEtPrnom);
		
		ColumnConfig clmncnfgDateDeNaissance = new ColumnConfig("dateNaiss", "Date de naissance", 150);
		configs.add(clmncnfgDateDeNaissance);
		
		ColumnConfig clmncnfgAdresse = new ColumnConfig("adresse", "Adresse", 150);
		configs.add(clmncnfgAdresse);
		
		ColumnConfig clmncnfgTypeDeLtranger = new ColumnConfig("typeEtranger", "Type de l'\u00E9tranger", 150);
		configs.add(clmncnfgTypeDeLtranger);
		
		final Grid<Client> grid = new Grid<Client>(storeInfoClient, new ColumnModel(configs));
		cntntpnlNewContentpanel.add(grid, new AbsoluteData(6, 6));
		grid.setSize("608px", "157px");
		grid.setBorders(true);
		
		ToolBar toolBar = new ToolBar();
		
		Button btnAjouter = new Button("Ajouter");
		toolBar.add(btnAjouter);
		btnAjouter.setSize("74px", "24px");
		
		
				
	
		cntntpnlNewContentpanel.add(toolBar, new AbsoluteData(0, 168));
		toolBar.setSize("612px", "30px");
		tbtmDpot_1.add(cntntpnlNewContentpanel, new AbsoluteData(294, 126));
		cntntpnlNewContentpanel.setSize("618px", "200px");
		
		ContentPanel cntntpnlNewContentpanel_1 = new ContentPanel();
		cntntpnlNewContentpanel_1.setHeaderVisible(false);
		cntntpnlNewContentpanel_1.setHeading("New ContentPanel");
		tbtmDpot_1.add(cntntpnlNewContentpanel_1, new AbsoluteData(296, 20));
		cntntpnlNewContentpanel_1.setLayout(new AbsoluteLayout());
		
		LabelField lblfldNumClient = new LabelField("Num Passport:");
		cntntpnlNewContentpanel_1.add(lblfldNumClient, new AbsoluteData(28, 25));
		
		final ListBox comboBox = new ListBox();
		cntntpnlNewContentpanel_1.add(comboBox, new AbsoluteData(137, 22));
		comboBox.setSize("150px", "22px");
		
		LabelField lblfldDate = new LabelField("Date:");
		cntntpnlNewContentpanel_1.add(lblfldDate, new AbsoluteData(321, 25));
		
		final DateField dtfldNewDatefield = new DateField();
		cntntpnlNewContentpanel_1.add(dtfldNewDatefield, new AbsoluteData(411, 22));
		dtfldNewDatefield.setFieldLabel("New DateField");
		
		Label lblNumDossier = new Label("Num. dossier:");
		cntntpnlNewContentpanel_1.add(lblNumDossier, new AbsoluteData(28, 68));
		
		final TextField txtfldNewTextfield = new TextField();
		cntntpnlNewContentpanel_1.add(txtfldNewTextfield, new AbsoluteData(137, 59));
		txtfldNewTextfield.setFieldLabel("New TextField");
		
		Label lblNumrcepiss = new Label("Num.r\u00E9cepiss\u00E9:");
		cntntpnlNewContentpanel_1.add(lblNumrcepiss, new AbsoluteData(321, 68));
		
		final TextField txtfldNewTextfield_1 = new TextField();
		cntntpnlNewContentpanel_1.add(txtfldNewTextfield_1, new AbsoluteData(411, 59));
		txtfldNewTextfield_1.setFieldLabel("New TextField");
		cntntpnlNewContentpanel_1.setSize("616px", "90px");
		tabPanel.add(tbtmDpot_1);
		tbtmDpot_1.setSize("960px", "460px");
		List<ColumnConfig> configs_1 = new ArrayList<ColumnConfig>();
		List<ColumnConfig> configs_2 = new ArrayList<ColumnConfig>();
		List<ColumnConfig> configs_3 = new ArrayList<ColumnConfig>();
		List<ColumnConfig> configs_4 = new ArrayList<ColumnConfig>();
		List<ColumnConfig> configs_5 = new ArrayList<ColumnConfig>();
		List<ColumnConfig> configs_6 = new ArrayList<ColumnConfig>();
		List<ColumnConfig> configs_7 = new ArrayList<ColumnConfig>();
		add(tabPanel, new AbsoluteData(-6, 0));
		tabPanel.setSize("934px", "381px");
		
	    
		final AsyncCallback<Nationalite[]> callbackListe = new AsyncCallback<Nationalite[]>() 
		{
			@Override
			public void onFailure(Throwable caught) {
				
				System.out.println("Erreur");
				
				GWT.log(caught.getMessage(),caught);
			}

			@Override
			public void onSuccess(Nationalite[] s) {
								
				System.out.println("Mandeha");
				
				for(int i = 0; i < s.length; i++)
				{	
					comboBox.addItem(s[i].nationalite);
				}
				
			}
		};
		
/*		final AsyncCallback<String> callbackNumDossier = new AsyncCallback<String>() 
		{
			@Override
			public void onFailure(Throwable caught) {
				
				System.out.println("Erreur");
				
				GWT.log(caught.getMessage(),caught);
			}

			@Override
			public void onSuccess(String s) {
								
				System.out.println("Mandeha");
				
				for(int i = 0; i < s.length(); i++)
				{	
					
					txtfldNewTextfield.setValue(s);
					txtfldNewTextfield_1.setValue(s);
					MessageBox.info("Valeur", s, null);
				}
				
			}


		};*/

		monServ.getListeNumeroPassport(callbackListe);
		
		
		
/*********************AJOUT DANS DEMANDE DE VISA ******************************************************/
		
		final AsyncCallback<Client[]> asyncCallbackInfoClientVisa2 = new AsyncCallback<Client[]>() 
		{
			@Override
			public void onFailure(Throwable caught) {
				
				MessageBox.info("Erreur", "Aucune information valide", null);
			}

			@Override
			public void onSuccess(Client[] s) {
				int i;
				
				
				for(i = 0; i < s.length; i++)
				{	
					stocksInfoClient2.add(s[i]);
					
								       
				}
				storeInfoClient2.add(stocksInfoClient2);
			}
		};
		

		
		final AsyncCallback<String> callbackajoutDemandeVisa = new AsyncCallback<String>() {
			@Override
			public void onFailure(Throwable caught) {
				MessageBox.info("Affichage d'erreur", "Erreur d'enregistrement!", null);		
			}
 
			@Override
			public void onSuccess(String result) {
				MessageBox.info("Affichage d'information", result, null);	
				
			}
		};
		
		btnAjouter.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {
				
				if(com.google.gwt.user.client.Window.confirm("Voulez-vous vraiment ajouter ces informations?") == true)
				{
				
					int a = comboBox.getSelectedIndex();
					String text = comboBox.getItemText(a);
					
					String numDossier = (String) txtfldNewTextfield.getValue();
					
					String dates = DateTimeFormat.getFormat("dd/MM/yyyy").format(dtfldNewDatefield.getValue());
					
					
					String numRecp = (String) txtfldNewTextfield_1.getValue();
					
					monServ.ajoutDansDemandeVisa(text, numDossier, dates+"", numRecp, callbackajoutDemandeVisa);
				}
			}
		});
/******************************MISE A JOUR TABLE APPARTENIR (ARRIVEE ANOSY AVEC DECISION ***********************************************/
		final AsyncCallback<Client[]> asyncCallbackInfoClientVisaArriveAnosyAvecDecision = new AsyncCallback<Client[]>() 
		{
			@Override
			public void onFailure(Throwable caught) {
				
				GWT.log(caught.getMessage(),caught);
			}

			@Override
			public void onSuccess(Client[] s) {
				int i;
				
				
				for(i = 0; i < s.length; i++)
				{	
					stocksInfoClient5.add(new Client(s[i].nomEtPrenom, s[i].dateNaiss, s[i].adresse, s[i].numPassport, s[i].typeEtranger, s[i].etatDossier, s[i].dateEtat, s[i].dateDelivrance, s[i].expiration, s[i].nationalite));
					storeInfoClient5.add(stocksInfoClient5);
								       
				}
				
			}
		};

		
/*******************RECUPERATION INFORMATION CLIENTS VISA ********************************************/
		final AsyncCallback<Client[]> asyncCallbackInfoClientVisa = new AsyncCallback<Client[]>() 
		{
			@Override
			public void onFailure(Throwable caught) {
				
				MessageBox.info("Information", "Aucune information valide", null);
			}

			@Override
			public void onSuccess(Client[] s) {
				int i;
				
				
				for(i = 0; i < s.length; i++)
				{	
					stocksInfoClient.add(s[i]);
					
								       
				}
				storeInfoClient.add(stocksInfoClient);
			}
		};
		comboBox.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				
				int a = comboBox.getSelectedIndex();
				String numPassport = comboBox.getItemText(a);
				
				grid.getStore().removeAll();
				stocksInfoClient.clear();
				storeInfoClient.remove(0);
				storeInfoClient.clearFilters();
				
				//greetingService.numeroDossier(callbackNumDossier);
				monServ.getInformationClientVisa(numPassport, asyncCallbackInfoClientVisa);
			
				
			}
		});
		/*********************AJOUT PASSPORT ENVOYE ANOSY **********************************************/
		
		final AsyncCallback<Client[]> asyncCallbackInfoClientVisa3 = new AsyncCallback<Client[]>() 
		{
			@Override
			public void onFailure(Throwable caught) {
				
				GWT.log(caught.getMessage(),caught);
			}

			@Override
			public void onSuccess(Client[] s) {
				int i;
				
				
				for(i = 0; i < s.length; i++)
				{	
					stocksInfoClient3.add(s[i]);
				}
				storeInfoClient3.add(stocksInfoClient3);
			}
		};
		
		final AsyncCallback<String> asyncCallbackAjoutPassportEnvoyeAnosy = new AsyncCallback<String>() 
		{
			@Override
			public void onFailure(Throwable caught) {
				
				System.out.println("Erreur");
				
				GWT.log(caught.getMessage(),caught);
			}

			@Override
			public void onSuccess(String s) {
								
				MessageBox.info("Information", s, null);
				
			}


		};
		
		
		/****************************AJOUT PASSPORT ARRIVE ANOSY ********************************/
		
		final AsyncCallback<String> asyncCallbackAjoutPassportArriveAnosy = new AsyncCallback<String>() 
		{
			@Override
			public void onFailure(Throwable caught) {
				
				System.out.println("Erreur");
				
				GWT.log(caught.getMessage(),caught);
			}

			@Override
			public void onSuccess(String s) {
								
				MessageBox.info("Information", s, null);
				
			}


		};
		
		final AsyncCallback<Client[]> asyncCallbackInfoClientArriveAnosy = new AsyncCallback<Client[]>() 
		{
			@Override
			public void onFailure(Throwable caught) {
				
				GWT.log(caught.getMessage(),caught);
			}

			@Override
			public void onSuccess(Client[] s) {
				int i;
				
				
				for(i = 0; i < s.length; i++)
				{	
					stocksInfoClient4.add(s[i]);
					
								       
				}
				storeInfoClient4.add(stocksInfoClient4);
			}
		};
		
		
		/*************************** AJOUT CARTE DE RESIDENT ENVOYE ANOSY ***************************/
		
		final AsyncCallback<String> asyncCallbackAjoutAjoutCarteResidentArriveAnosy = new AsyncCallback<String>() 
		{
			@Override
			public void onFailure(Throwable caught) {
				
				System.out.println("Erreur");
				
				GWT.log(caught.getMessage(),caught);
			}

			@Override
			public void onSuccess(String s) {
								
				MessageBox.info("Information", s, null);
				
			}


		};

		

	}
}
