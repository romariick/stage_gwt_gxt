package com.romaric.project.client;

import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import com.extjs.gxt.ui.client.widget.layout.AbsoluteLayout;
import com.extjs.gxt.ui.client.widget.TabPanel;
import com.extjs.gxt.ui.client.widget.layout.AbsoluteData;
import com.extjs.gxt.ui.client.Style;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Label;
import com.romaric.project.Visa.MonService;
import com.romaric.project.Visa.MonServiceAsync;
import com.romaric.project.model.RechercheEntrepriseCode;
import com.romaric.project.model.Client;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;

import java.util.Collections;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import java.util.List;
import java.util.ArrayList;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.form.NumberField;
import com.extjs.gxt.ui.client.widget.grid.EditorGrid;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.FieldEvent;

public class RechercheAutorisationDEmploie extends Window {

	final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);
	final MonServiceAsync monServ = GWT.create(MonService.class);
	/*Rechercher entreprise à partir nif*/
	final ListStore<RechercheEntrepriseCode> storeFindSoct = new ListStore<RechercheEntrepriseCode>();
	final List<RechercheEntrepriseCode> stocksFindSoct = new ArrayList<RechercheEntrepriseCode>();
	
	/*RECUPERATION INFO CLIENT A PARTIR Nom et Prénom */
	final ListStore<Client> storeClientNom = new ListStore<Client>();
	final List<Client> stocksClientNom = new ArrayList<Client>();

	
	public RechercheAutorisationDEmploie() {
		setModal(true);
		setOnEsc(false);
		setWidth(667);
		setHeight(391);
		setBlinkModal(true);
		setHeading("Accueil > Recherche Information");
		setLayout(new AbsoluteLayout());
		
		TabPanel tabPanel = new TabPanel();
		
		TabItem tbtmNomEtPrnom = new TabItem("Nom et Pr\u00E9nom");
		tbtmNomEtPrnom.setLayout(new AbsoluteLayout());
		
		final TextField txtfldNewTextfield = new TextField();
		txtfldNewTextfield.setAllowBlank(false);
		tbtmNomEtPrnom.add(txtfldNewTextfield, new AbsoluteData(115, 27));
		txtfldNewTextfield.setSize("159px", "22px");
		txtfldNewTextfield.setFieldLabel("New TextField");
		
		Label lblNomEtPrnom = new Label("Nom et Pr\u00E9nom:");
		tbtmNomEtPrnom.add(lblNomEtPrnom, new AbsoluteData(16, 27));
		
		Button btnOk = new Button("OK");

		tbtmNomEtPrnom.add(btnOk, new AbsoluteData(295, 25));
		btnOk.setSize("100px", "20px");
		List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
		
		TabItem tbtmEntreprise = new TabItem("Entreprise");
		tbtmEntreprise.setLayout(new AbsoluteLayout());
		
		LabelField lblfldNif = new LabelField("NIF:");
		tbtmEntreprise.add(lblfldNif, new AbsoluteData(21, 30));
		List<ColumnConfig> configs_1 = new ArrayList<ColumnConfig>();
		
		Button btnOk_1 = new Button("OK");

		tbtmEntreprise.add(btnOk_1, new AbsoluteData(229, 27));
		btnOk_1.setSize("100px", "20px");
		List<ColumnConfig> configs_2 = new ArrayList<ColumnConfig>();
		
		ColumnConfig clmncnfgDnomination = new ColumnConfig("denomination", "D\u00E9nomination", 150);
		configs_2.add(clmncnfgDnomination);
		
		ColumnConfig clmncnfgSige = new ColumnConfig("siege", "Si\u00E8ge", 150);
		configs_2.add(clmncnfgSige);
		
		ColumnConfig clmncnfgCapital = new ColumnConfig("capital", "Capital", 150);
		configs_2.add(clmncnfgCapital);
		
		ColumnConfig clmncnfgFormeJuridique = new ColumnConfig("fj", "Forme Juridique", 150);
		configs_2.add(clmncnfgFormeJuridique);
		
		final Grid<RechercheEntrepriseCode> grid_1 = new Grid<RechercheEntrepriseCode>(storeFindSoct, new ColumnModel(configs_2));
		
		tbtmEntreprise.add(grid_1, new AbsoluteData(21, 80));
		grid_1.setSize("616px", "196px");
		grid_1.setBorders(true);
		
		final TextField txtfldNewTextfield_1 = new TextField();
	
	
		txtfldNewTextfield_1.setAllowBlank(false);
		tbtmEntreprise.add(txtfldNewTextfield_1, new AbsoluteData(53, 27));
		txtfldNewTextfield_1.setFieldLabel("New TextField");
		tabPanel.add(tbtmEntreprise);
		tbtmEntreprise.setSize("621px", "327px");
		
		ColumnConfig clmncnfgNomEtPrnom = new ColumnConfig("numPassport", "Num.Passeport", 150);
		configs.add(clmncnfgNomEtPrnom);
		
		ColumnConfig clmncnfgDateDeNaissance = new ColumnConfig("adresse", "Adresse", 150);
		configs.add(clmncnfgDateDeNaissance);
		
		ColumnConfig clmncnfgAdresse = new ColumnConfig("dateNaiss", "Date de Naissance", 150);
		configs.add(clmncnfgAdresse);
		
		ColumnConfig clmncnfgNationalit = new ColumnConfig("nationalite", "Nationalit\u00E9", 150);
		configs.add(clmncnfgNationalit);
		
		Grid<Client> grid = new Grid<Client>(storeClientNom, new ColumnModel(configs));
		
		tbtmNomEtPrnom.add(grid, new AbsoluteData(16, 84));
		grid.setSize("621px", "194px");
		grid.setBorders(true);
		tabPanel.add(tbtmNomEtPrnom);
		tbtmNomEtPrnom.setSize("465px", "333px");
		add(tabPanel, new AbsoluteData(0, 0));
		tabPanel.setSize("647px", "353px");
		
		
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

				
					String a = (String)txtfldNewTextfield_1.getValue();
					
					stocksFindSoct.clear();
					storeFindSoct.removeAll();
					
					greetingService.findtEntreprise(a, asyncCallbackFind);
				
			}
		});
		
		
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
		
		btnOk.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {	
				
					String nomEtPrenom = (String) txtfldNewTextfield.getValue();
					
					monServ.getInformationClientApartirNomEtPrenom(nomEtPrenom, asyncCallbackAPartirNom);
				
			}
		});

	}
}
