package com.romaric.project.client;

import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.TabPanel;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.layout.RowData;
import com.extjs.gxt.ui.client.Style;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.layout.AbsoluteLayout;
import com.extjs.gxt.ui.client.widget.layout.AbsoluteData;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.google.gwt.user.client.ui.Label;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.form.NumberField;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.grid.ColumnData;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import java.util.Collections;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import java.util.List;
import java.util.ArrayList;

import com.extjs.gxt.ui.client.data.BeanModel;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.google.gwt.user.client.ui.Image;
import com.romaric.project.Visa.MonService;
import com.romaric.project.Visa.MonServiceAsync;
import com.romaric.project.model.Client;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.GridEvent;

public class RechercherVisa extends Window {
	
	final MonServiceAsync monServ = GWT.create(MonService.class);

	 
/*Statistique ville*/
	final ListStore<Client> storeClient = new ListStore<Client>();
	final List<Client> stocksClient = new ArrayList<Client>();

	/*RECUPERATION INFO CLIENT A PARTIR NumPass */
	final ListStore<Client> storeClientNumPass = new ListStore<Client>();
	final List<Client> stocksClientNumPass = new ArrayList<Client>();

	
	/*RECUPERATION INFO CLIENT A PARTIR Nom et Prénom */
	final ListStore<Client> storeClientNom = new ListStore<Client>();
	final List<Client> stocksClientNom = new ArrayList<Client>();

	public RechercherVisa() {
		setModal(true);
		setHeight(438);
		setWidth(804);
		setSize("804px", "438px");
		setResizable(false);
		setBlinkModal(true);
		setOnEsc(false);
		setHeading("Accueil > Rechercher \u00E9tranger");
		setLayout(new AbsoluteLayout());
		
		TabPanel tabPanel = new TabPanel();
		
		TabItem tbtmNewTabitem_1 = new TabItem("Num dossier");
		tbtmNewTabitem_1.setLayout(new AbsoluteLayout());
		
		Label lblNumDossier = new Label("Num. dossier:");
		tbtmNewTabitem_1.add(lblNumDossier, new AbsoluteData(34, 39));
		lblNumDossier.setSize("66px", "18px");
		
		Button btnOk_1 = new Button("OK");

		

		
		tbtmNewTabitem_1.add(btnOk_1, new AbsoluteData(321, 35));
		btnOk_1.setSize("100px", "24px");
		List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
		
		ColumnConfig clmncnfgNomEtPrnom = new ColumnConfig("nomEtPrenom", "Nom et Pr\u00E9nom", 150);
		configs.add(clmncnfgNomEtPrnom);
		
		ColumnConfig clmncnfgNumPassport = new ColumnConfig("numPassport", "Num Passport", 150);
		configs.add(clmncnfgNumPassport);
		
		ColumnConfig clmncnfgEtatDeDossier = new ColumnConfig("typeEtranger", "Type de l'\u00E9tranger", 150);
		configs.add(clmncnfgEtatDeDossier);
		
		GridCellRenderer<Client> gridCellRender = new GridCellRenderer<Client>() {
			@Override
			public Object render(Client model, String property,
			ColumnData config, int rowIndex, int colIndex,
			ListStore<Client> store, Grid<Client> grid) {
				
		        String val = (String) model.get(property);
		        
		        String style = val.contains("Arriv") ? "red" : "blue";  
		        return "<span style='color:" + style + "'>" +val + "</span>";  
		        
		        
			}
			};
		
		ColumnConfig clmncnfgEtatDeDossier_1 = new ColumnConfig("etatDossier", "Etat de dossier", 150);
		clmncnfgEtatDeDossier_1.setRenderer(gridCellRender);
		configs.add(clmncnfgEtatDeDossier_1);
		
		
		ColumnConfig clmncnfgDateEtat = new ColumnConfig("dateEtat", "Date etat", 150);
	//	clmncnfgDateEtat.setRenderer(change);
		configs.add(clmncnfgDateEtat);
		
		Grid<Client> grid = new Grid<Client>(storeClient, new ColumnModel(configs));
		
		grid.addListener(Events.CellClick, new Listener<GridEvent<Client>>() {
			public void handleEvent(GridEvent<Client> e) {
				
				//Info.display("Valeur", ""+e.getModel().getNomEtPrenom());
				//MessageBox.info("Valeur clic",""+e.getModel().getEtatDossier(), null);
				
			}
				
			
		});
		
		

	

		AbsoluteData ad_grid = new AbsoluteData(6, 101);
		ad_grid.setAnchorSpec("-10");
		tbtmNewTabitem_1.add(grid, ad_grid);
		grid.setHeight("202px");
		grid.setBorders(true);
		
		final TextField txtfldNewTextfield_2 = new TextField();
		txtfldNewTextfield_2.setAllowBlank(false);
		tbtmNewTabitem_1.add(txtfldNewTextfield_2, new AbsoluteData(119, 35));
		txtfldNewTextfield_2.setSize("159px", "22px");
		txtfldNewTextfield_2.setFieldLabel("New TextField");
		

	
		tabPanel.add(tbtmNewTabitem_1);
		tbtmNewTabitem_1.setSize("543px", "325px");
		
		TabItem tbtmNewTabitem = new TabItem("Num. Passport");
		tbtmNewTabitem.setLayout(new AbsoluteLayout());
		
		Label lblNumVisa = new Label("Num. Passport:");
		tbtmNewTabitem.add(lblNumVisa, new AbsoluteData(6, 30));
		
		Button btnOk = new Button("OK");

		tbtmNewTabitem.add(btnOk, new AbsoluteData(324, 28));
		btnOk.setSize("100px", "24px");
		List<ColumnConfig> configs_1 = new ArrayList<ColumnConfig>();
		
		ColumnConfig clmncnfgNomEtPrnom_1 = new ColumnConfig("nomEtPrenom", "Nom et Pr\u00E9nom", 150);
		configs_1.add(clmncnfgNomEtPrnom_1);
		
		ColumnConfig clmncnfgDateEtLieu = new ColumnConfig("dateNaiss", "Date et lieu de Naissance", 150);
		configs_1.add(clmncnfgDateEtLieu);
		
		ColumnConfig clmncnfgAdresse = new ColumnConfig("adresse", "Adresse", 150);
		configs_1.add(clmncnfgAdresse);
		
		ColumnConfig clmncnfgDateDlivrancePassport = new ColumnConfig("dateDelivrance", "D\u00E9livrance Passport", 150);
		configs_1.add(clmncnfgDateDlivrancePassport);
		
		ColumnConfig clmncnfgExpiration = new ColumnConfig("expiration", "Expiration", 150);
		configs_1.add(clmncnfgExpiration);
		
		Grid<Client> grid_1 = new Grid<Client>(storeClientNumPass, new ColumnModel(configs_1));
		tbtmNewTabitem.add(grid_1, new AbsoluteData(6, 85));
		grid_1.setSize("764px", "192px");
		grid_1.setBorders(true);
		
		Button btnExporter_1 = new Button("Exporter...");
		btnExporter_1.setEnabled(false);
		tbtmNewTabitem.add(btnExporter_1, new AbsoluteData(6, 331));
		
		final TextField txtfldNewTextfield_3 = new TextField();
		txtfldNewTextfield_3.setAllowBlank(false);
		tbtmNewTabitem.add(txtfldNewTextfield_3, new AbsoluteData(116, 31));
		txtfldNewTextfield_3.setSize("159px", "22px");
		txtfldNewTextfield_3.setFieldLabel("New TextField");
		tabPanel.add(tbtmNewTabitem);
		tbtmNewTabitem.setSize("569px", "318px");
		
		TabItem tbtmNewTabitem_2 = new TabItem("Nom et pr\u00E9nom");
		tbtmNewTabitem_2.setLayout(new AbsoluteLayout());
		
		Label lblNom = new Label("Nom et Pr\u00E9nom:");
		tbtmNewTabitem_2.add(lblNom, new AbsoluteData(18, 27));
		lblNom.setSize("103px", "18px");
		
		final TextField<String> txtfldNewTextfield = new TextField<String>();
		txtfldNewTextfield.setAllowBlank(false);
		tbtmNewTabitem_2.add(txtfldNewTextfield, new AbsoluteData(119, 23));
		txtfldNewTextfield.setSize("159px", "22px");
		txtfldNewTextfield.setFieldLabel("New TextField");
		
		Button btnOk_2 = new Button("OK");

		tbtmNewTabitem_2.add(btnOk_2, new AbsoluteData(306, 20));
		btnOk_2.setSize("100px", "24px");
		List<ColumnConfig> configs_2 = new ArrayList<ColumnConfig>();
		
		ColumnConfig clmncnfgNumpassport = new ColumnConfig("numPassport", "Num.Passeport", 150);
		configs_2.add(clmncnfgNumpassport);
		
		ColumnConfig clmncnfgAdresse_1 = new ColumnConfig("adresse", "Adresse", 150);
		configs_2.add(clmncnfgAdresse_1);
		
		ColumnConfig clmncnfgDateEtLieu_1 = new ColumnConfig("dateNaiss", "Date et lieu de Naissance", 150);
		configs_2.add(clmncnfgDateEtLieu_1);
		
		ColumnConfig clmncnfgNationalit = new ColumnConfig("nationalite", "Nationalit\u00E9", 150);
		configs_2.add(clmncnfgNationalit);
		
		ColumnConfig clmncnfgTypetranger = new ColumnConfig("typeEtranger", "Type \u00E9tranger", 150);
		configs_2.add(clmncnfgTypetranger);
		
		Grid<Client> grid_2 = new Grid<Client>(storeClientNom, new ColumnModel(configs_2));
		AbsoluteData ad_grid_2 = new AbsoluteData(18, 66);
		ad_grid_2.setAnchorSpec("0% -150");
		tbtmNewTabitem_2.add(grid_2, ad_grid_2);
		grid_2.setWidth("752px");
		grid_2.setBorders(true);
		
		Button btnExporter_2 = new Button("Exporter...");
		btnExporter_2.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {
				
				ExportationEtrangerPDF etranger = new ExportationEtrangerPDF();
				etranger.show();
			}
		});
		tbtmNewTabitem_2.add(btnExporter_2, new AbsoluteData(18, 324));
		btnExporter_2.setSize("100px", "22px");
		tabPanel.add(tbtmNewTabitem_2);
		tbtmNewTabitem_2.setHeight("340px");
		add(tabPanel, new AbsoluteData(0, 0));
		tabPanel.setSize("780px", "422px");
		
		
		
		final AsyncCallback<Client[]> asyncCallbackFj = new AsyncCallback<Client[]>() 
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
					stocksClient.add(s[i]);
						       
				}
				storeClient.add(stocksClient);
				
				
			}
		};
		
		
		btnOk_1.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {

			
				
					String numDossier = (String) txtfldNewTextfield_2.getValue();
					stocksClient.clear();
					storeClient.removeAll();
					
					monServ.getInformationClientApartirNumDossier(numDossier, asyncCallbackFj);
				
				
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
		

		
		btnOk.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {
				
			
				
					String numPass = (String) txtfldNewTextfield_3.getValue();
					stocksClientNumPass.clear();
					storeClientNumPass.removeAll();
					monServ.getInformationClientApartirNumPassport(numPass, asyncCallbackAPartirNumPassport);
				
				
			}
		});
		
		/*********************RECUPERATION INFORMATION CLIENT A PARTIR NOM ET PRENOM ************************/
		
		final AsyncCallback<Client[]> asyncCallbackAPartirNom = new AsyncCallback<Client[]>() 
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
					stocksClientNom.add(s[i]);
								       
				}
				storeClientNom.add(stocksClientNom);
			}
		};

		btnOk_2.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {
				
			
				
					String nomEtPrenom = (String) txtfldNewTextfield.getValue();
					storeClientNom.removeAll();
					stocksClientNom.clear();
					monServ.getInformationClientApartirNomEtPrenom(nomEtPrenom, asyncCallbackAPartirNom);
				
				
			}
		});
	}
}
