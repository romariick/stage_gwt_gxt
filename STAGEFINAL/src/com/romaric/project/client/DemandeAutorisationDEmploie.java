package com.romaric.project.client;

import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import com.extjs.gxt.ui.client.widget.layout.AbsoluteLayout;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.layout.AbsoluteData;
import com.extjs.gxt.ui.client.Style;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import java.util.Collections;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import java.util.List;
import java.util.ArrayList;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.form.NumberField;
import com.extjs.gxt.ui.client.widget.form.TextArea;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HTML;
import com.romaric.project.Visa.MonService;
import com.romaric.project.Visa.MonServiceAsync;
import com.romaric.project.autorisationDEmploi.AutorisationDEmploiService;
import com.romaric.project.autorisationDEmploi.AutorisationDEmploiServiceAsync;
import com.romaric.project.model.RechercheEntrepriseCode;
import com.romaric.project.model.Client;
import com.extjs.gxt.ui.client.widget.menu.MenuBar;
import com.extjs.gxt.ui.client.widget.menu.MenuBarItem;
import com.extjs.gxt.ui.client.widget.menu.Menu;
import com.extjs.gxt.ui.client.widget.menu.MenuItem;
import com.extjs.gxt.ui.client.event.MenuEvent;

public class DemandeAutorisationDEmploie extends Window {
	final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);
	
	final MonServiceAsync monServ = GWT.create(MonService.class);
	final AutorisationDEmploiServiceAsync monServAE = GWT.create(AutorisationDEmploiService.class);
	/*Rechercher entreprise à partir nif*/
	final ListStore<RechercheEntrepriseCode> storeFindSoct = new ListStore<RechercheEntrepriseCode>();
	final List<RechercheEntrepriseCode> stocksFindSoct = new ArrayList<RechercheEntrepriseCode>();
	
	final ListStore<Client> storeClientNumPass = new ListStore<Client>();
	final List<Client> stocksClientNumPass = new ArrayList<Client>();
	
	
	/*societe */
	
	static String nifsociete;
	static String numPass;
	
	public DemandeAutorisationDEmploie() {
		setModal(true);
		
		
		setResizable(false);
		setOnEsc(false);
		setWidth(852);
		setHeight(564);
		setBlinkModal(true);
		setHeading("Accueil > Demande Autorisation d'emploi");
		setLayout(new AbsoluteLayout());
		
		ContentPanel cntntpnlCritreDinsrtion = new ContentPanel();
		cntntpnlCritreDinsrtion.setHeading("Information entreprise");
		cntntpnlCritreDinsrtion.setCollapsible(true);
		cntntpnlCritreDinsrtion.setLayout(new AbsoluteLayout());
		
		LabelField lblfldNif = new LabelField("NIF:");
		cntntpnlCritreDinsrtion.add(lblfldNif, new AbsoluteData(6, 25));
		lblfldNif.setSize("34px", "14px");
		
		final TextField txtfldNewTextfield = new TextField();
		txtfldNewTextfield.setAllowBlank(false);
		cntntpnlCritreDinsrtion.add(txtfldNewTextfield, new AbsoluteData(46, 25));
		txtfldNewTextfield.setSize("159px", "22px");
		txtfldNewTextfield.setFieldLabel("New TextField");
		List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
		
		ColumnConfig clmncnfgDnomination = new ColumnConfig("denomination", "D\u00E9nomination", 150);
		configs.add(clmncnfgDnomination);
		
		ColumnConfig clmncnfgSige = new ColumnConfig("siege", "Si\u00E8ge", 150);
		configs.add(clmncnfgSige);
		
		final Grid<RechercheEntrepriseCode> grid = new Grid<RechercheEntrepriseCode>(storeFindSoct, new ColumnModel(configs));
		//Grid<RechercheEntrepriseCode> grid = new Grid(new ListStore(), new ColumnModel(configs));
		cntntpnlCritreDinsrtion.add(grid, new AbsoluteData(6, 62));
		grid.setSize("296px", "130px");
		grid.setBorders(true);
		
		Button btnOk_1 = new Button("OK");
		

		cntntpnlCritreDinsrtion.add(btnOk_1, new AbsoluteData(222, 25));
		btnOk_1.setSize("80px", "22px");
		add(cntntpnlCritreDinsrtion, new AbsoluteData(6, 23));
		cntntpnlCritreDinsrtion.setSize("320px", "241px");
		
		ContentPanel cntntpnlInformationClient = new ContentPanel();
		cntntpnlInformationClient.setHeading("Information client");
		cntntpnlInformationClient.setCollapsible(true);
		cntntpnlInformationClient.setLayout(new AbsoluteLayout());
		
		LabelField lblfldNumpassport = new LabelField("Num.Passport:");
		cntntpnlInformationClient.add(lblfldNumpassport, new AbsoluteData(19, 23));
		List<ColumnConfig> configs_1 = new ArrayList<ColumnConfig>();
		
		ColumnConfig clmncnfgNomEtPrnom = new ColumnConfig("nomEtPrenom", "Nom et Pr\u00E9nom", 150);
		configs_1.add(clmncnfgNomEtPrnom);
		
		ColumnConfig clmncnfgDateExpirationVisa = new ColumnConfig("expiration", "Date expiration visa", 150);
		configs_1.add(clmncnfgDateExpirationVisa);
		
		ColumnConfig clmncnfgNationalit = new ColumnConfig("nationalite", "Nationalit\u00E9", 150);
		configs_1.add(clmncnfgNationalit);
		
		Grid<Client> grid_1 = new Grid<Client>(storeClientNumPass, new ColumnModel(configs_1));
		
		cntntpnlInformationClient.add(grid_1, new AbsoluteData(12, 65));
		grid_1.setSize("464px", "124px");
		grid_1.setBorders(true);
		
		final TextField txtfldNewTextfield_1 = new TextField();
		txtfldNewTextfield_1.setAllowBlank(false);
		cntntpnlInformationClient.add(txtfldNewTextfield_1, new AbsoluteData(107, 20));
		txtfldNewTextfield_1.setSize("159px", "22px");
		txtfldNewTextfield_1.setFieldLabel("New TextField");
		
		Button btnOk_2 = new Button("OK");
		
		cntntpnlInformationClient.add(btnOk_2, new AbsoluteData(302, 18));
		btnOk_2.setSize("80px", "22px");
		add(cntntpnlInformationClient, new AbsoluteData(346, 23));
		cntntpnlInformationClient.setSize("484px", "241px");
		
		ContentPanel cntntpnlInformationDemande = new ContentPanel();
		cntntpnlInformationDemande.setHeading("Information demande");
		cntntpnlInformationDemande.setCollapsible(true);
		cntntpnlInformationDemande.setLayout(new AbsoluteLayout());
		
		LabelField lblfldNewLabelfield = new LabelField("Ref.autorisation:");
		cntntpnlInformationDemande.add(lblfldNewLabelfield, new AbsoluteData(16, 16));
		
		TextField<String> txtfldNewTextfield_2 = new TextField();
		
		txtfldNewTextfield_2.setFieldLabel("New TextField");
		
		LabelField lblfldNumarrive = new LabelField("Num.Arriv\u00E9e:");
		cntntpnlInformationDemande.add(lblfldNumarrive, new AbsoluteData(16, 63));
		
		TextField<String> txtfldNewTextfield_3 = new TextField();
		
		txtfldNewTextfield_3.setFieldLabel("New TextField");
		
		LabelField lblfldDateDemande = new LabelField("Date demande:");
		cntntpnlInformationDemande.add(lblfldDateDemande, new AbsoluteData(16, 105));
		
		final DateField dtfldNewDatefield = new DateField();
		cntntpnlInformationDemande.add(dtfldNewDatefield, new AbsoluteData(114, 105));
		dtfldNewDatefield.setSize("159px", "22px");
		dtfldNewDatefield.setFieldLabel("New DateField");
		
		LabelField lblfldDure = new LabelField("Dur\u00E9e:");
		cntntpnlInformationDemande.add(lblfldDure, new AbsoluteData(16, 145));
		
		final NumberField nmbrfldNewNumberfield = new NumberField();
		cntntpnlInformationDemande.add(nmbrfldNewNumberfield, new AbsoluteData(114, 142));
		nmbrfldNewNumberfield.setSize("74px", "22px");
		nmbrfldNewNumberfield.setFieldLabel("New NumberField");
		
		LabelField lblfldDateDeffet = new LabelField("Date deffet:");
		cntntpnlInformationDemande.add(lblfldDateDeffet, new AbsoluteData(405, 14));
		
		final DateField dtfldNewDatefield_1 = new DateField();
		cntntpnlInformationDemande.add(dtfldNewDatefield_1, new AbsoluteData(514, 13));
		dtfldNewDatefield_1.setSize("159px", "22px");
		dtfldNewDatefield_1.setFieldLabel("New DateField");
		
		LabelField lblfldDateDexpiration = new LabelField("Date d'expiration:");
		cntntpnlInformationDemande.add(lblfldDateDexpiration, new AbsoluteData(405, 61));
		
		final DateField dtfldNewDatefield_2 = new DateField();
		cntntpnlInformationDemande.add(dtfldNewDatefield_2, new AbsoluteData(514, 60));
		dtfldNewDatefield_2.setSize("159px", "22px");
		dtfldNewDatefield_2.setFieldLabel("New DateField");
		
		LabelField lblfldRsultat = new LabelField("Date signature:");
		cntntpnlInformationDemande.add(lblfldRsultat, new AbsoluteData(405, 105));
		
		final DateField dtfldNewDatefield_3 = new DateField();
		cntntpnlInformationDemande.add(dtfldNewDatefield_3, new AbsoluteData(514, 102));
		dtfldNewDatefield_3.setSize("159px", "22px");
		dtfldNewDatefield_3.setFieldLabel("New DateField");
		
		LabelField lblfldRsultat_1 = new LabelField("R\u00E9sultat:");
		cntntpnlInformationDemande.add(lblfldRsultat_1, new AbsoluteData(405, 143));
		
		final TextArea txtrNewTextarea = new TextArea();
		cntntpnlInformationDemande.add(txtrNewTextarea, new AbsoluteData(514, 134));
		txtrNewTextarea.setSize("159px", "42px");
		txtrNewTextarea.setFieldLabel("New TextArea");
		
		Button btnOk = new Button("Enregistrer");

		cntntpnlInformationDemande.add(btnOk, new AbsoluteData(16, 199));
		btnOk.setSize("159px", "22px");
		
		final TextField txtfldNewTextfield_4 = new TextField();
		txtfldNewTextfield_4.setAllowBlank(false);
		cntntpnlInformationDemande.add(txtfldNewTextfield_4, new AbsoluteData(114, 16));
		txtfldNewTextfield_4.setSize("159px", "22px");
		txtfldNewTextfield_4.setFieldLabel("New TextField");
		
		final TextField txtfldNewTextfield_5 = new TextField();
		txtfldNewTextfield_5.setAllowBlank(false);
		cntntpnlInformationDemande.add(txtfldNewTextfield_5, new AbsoluteData(114, 60));
		txtfldNewTextfield_5.setSize("159px", "22px");
		txtfldNewTextfield_5.setFieldLabel("New TextField");
		
		LabelField lblfldanne = new LabelField("[Ann\u00E9e]");
		cntntpnlInformationDemande.add(lblfldanne, new AbsoluteData(210, 145));
		add(cntntpnlInformationDemande, new AbsoluteData(6, 270));
		cntntpnlInformationDemande.setSize("822px", "256px");
		
		MenuBar menuBar = new MenuBar();
		
		Menu menu = new Menu();
		
		MenuItem mntmImprimerDemandeAutorisation = new MenuItem("Imprimer Demande autorisation");

		menu.add(mntmImprimerDemandeAutorisation);
		MenuBarItem mnbrtmFichier = new MenuBarItem("Fichier", menu);
		menuBar.add(mnbrtmFichier);
		
		Menu menu_1 = new Menu();
		menuBar.setContextMenu(menu_1);
		add(menuBar, new AbsoluteData(6, 0));

		
		
		/************Rechercher NIF ************/
		
		final AsyncCallback<RechercheEntrepriseCode[]> asyncCallbackFind = new AsyncCallback<RechercheEntrepriseCode[]>() 
		{
			@Override
			public void onFailure(Throwable caught) {
				
				MessageBox.info("Information", "Aucune information valide", null);
			}

			@Override
			public void onSuccess(RechercheEntrepriseCode[] s) {
				int i;
				
				for(i = 0; i < s.length; i++)
				{	
					stocksFindSoct.add(s[i]);
				
								       
				}
				storeFindSoct.add(stocksFindSoct);
			}
		};
		btnOk_1.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {
				
				 
				 
					nifsociete = (String)txtfldNewTextfield.getValue();
					
					stocksFindSoct.clear();
					storeFindSoct.clearFilters();
					
					greetingService.findtEntreprise(nifsociete, asyncCallbackFind);
				 
			}
		});
		
		
		
		/************************RECUPERER INFORMATION CLIEN A PARTIR NUMPASSPORT ***************************************/
		final AsyncCallback<Client[]> asyncCallbackAPartirNumPassport = new AsyncCallback<Client[]>() 
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
					stocksClientNumPass.add(s[i]);

								       
				}
				storeClientNumPass.add(stocksClientNumPass);
			}
		};
		
		btnOk_2.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {
		
					storeClientNumPass.removeAll();
					stocksClientNumPass.clear();
					
					numPass = (String) txtfldNewTextfield_1.getValue();
					monServ.getInformationClientApartirNumPassport(numPass, asyncCallbackAPartirNumPassport);
			
			}
		});

		
		/*****AJOUT DEMANDE AUTORISATION D EMPLOIE**************/
		
		final AsyncCallback<String> callback1 = new AsyncCallback<String>() {
			@Override
			public void onFailure(Throwable caught) {
				MessageBox.info("Affichage d'erreur", "Erreur d'enregistrement!", null);		
			}
 
			@Override
			public void onSuccess(String result) {
				MessageBox.info("Affichage d'information", result, null);	
				
			}
		};
		
		btnOk.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {
				

				String refAuto = (String) txtfldNewTextfield_4.getValue();
				
				String numArrivee = (String)txtfldNewTextfield_5.getValue();
				
				String dateDemande = DateTimeFormat.getFormat("dd/MM/yyyy").format(dtfldNewDatefield.getValue());
				
				Number duree = (Number)nmbrfldNewNumberfield.getValue();
				
				//date effet
				String dateEffet = DateTimeFormat.getFormat("dd/MM/yyyy").format(dtfldNewDatefield_1.getValue());
				

				//date expiration
				String dateExpiration = DateTimeFormat.getFormat("dd/MM/yyyy").format(dtfldNewDatefield_2.getValue());
				

				//date signature
				String dateSignature = DateTimeFormat.getFormat("dd/MM/yyyy").format(dtfldNewDatefield_3.getValue());
				

				//Résultat

				String resultat = txtrNewTextarea.getValue();
				 if(com.google.gwt.user.client.Window.confirm("Voulez-vous vraiment enregistrer ces informations?") == true)	
				 {
					 monServAE.ajout_demandeAutorisationEmploie(refAuto, nifsociete, numPass, numArrivee, dateDemande, duree+"", dateEffet, dateExpiration, dateSignature, resultat, callback1);
				 }
				
			}
		});
		
		
		final AsyncCallback<String> callback2 = new AsyncCallback<String>() {
			@Override
			public void onFailure(Throwable caught) {
				MessageBox.info("Affichage d'erreur", "Erreur d'exportation!", null);		
			}
 
			@Override
			public void onSuccess(String result) {
				AffichageAE ae = new AffichageAE();
				ae.show();
				
			}
		};
		
		mntmImprimerDemandeAutorisation.addSelectionListener(new SelectionListener<MenuEvent>() {
			public void componentSelected(MenuEvent ce) {
				
				
				
					 monServAE.AutorisationEmploiePdf( storeClientNumPass.getAt(0).getNomEtPrenom(),storeFindSoct.getAt(0).getDenomination(), callback2);
				
			}
		});

	}
}
