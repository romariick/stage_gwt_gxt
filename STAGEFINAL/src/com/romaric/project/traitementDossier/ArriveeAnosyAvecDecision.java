package com.romaric.project.traitementDossier;

import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import com.extjs.gxt.ui.client.widget.layout.AbsoluteLayout;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.layout.AbsoluteData;
import com.extjs.gxt.ui.client.Style;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import java.util.Collections;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.button.Button;
import java.util.List;
import java.util.ArrayList;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.romaric.project.Visa.MonService;
import com.romaric.project.Visa.MonServiceAsync;
import com.romaric.project.model.Client;

public class ArriveeAnosyAvecDecision extends Window {
	final MonServiceAsync monServ = GWT.create(MonService.class);
	/***************Recupération information client Arrive anosy avec décision **************/
	final ListStore<Client> storeInfoClient5 = new ListStore<Client>();
	final List<Client> stocksInfoClient5 = new ArrayList<Client>();
	
	public ArriveeAnosyAvecDecision() {
		setResizable(false);
		setOnEsc(false);
		setWidth(685);
		setHeight(365);
		setModal(true);
		setHeading("Accueil > Arriv\u00E9e \u00E0 Anosy avec d\u00E9cision");
		setLayout(new AbsoluteLayout());
		
		LabelField lblfldNumdossier = new LabelField("Num.dossier:");
		add(lblfldNumdossier, new AbsoluteData(31, 30));
		
		final TextField<String> txtfldNewTextfield = new TextField<String>();
		add(txtfldNewTextfield, new AbsoluteData(120, 27));
		txtfldNewTextfield.setFieldLabel("New TextField");
		
		LabelField lblfldDate = new LabelField("Date:");
		add(lblfldDate, new AbsoluteData(308, 28));
		
		final DateField dtfldNewDatefield = new DateField();
		add(dtfldNewDatefield, new AbsoluteData(367, 27));
		dtfldNewDatefield.setFieldLabel("New DateField");
		List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
		
		ColumnConfig clmncnfgNumpasseport = new ColumnConfig("numPassport", "Num.Passeport", 150);
		configs.add(clmncnfgNumpasseport);
		
		ColumnConfig clmncnfgNomEtPrnom = new ColumnConfig("nomEtPrenom", "Nom et Pr\u00E9nom", 150);
		configs.add(clmncnfgNomEtPrnom);
		
		ColumnConfig clmncnfgDateDeNaissance = new ColumnConfig("dateNaiss", "Date de naissance", 150);
		configs.add(clmncnfgDateDeNaissance);
		
		ColumnConfig clmncnfgTypetranger = new ColumnConfig("TypeEtranger", "Type \u00E9tranger", 150);
		configs.add(clmncnfgTypetranger);
		
		Grid<Client> grid = new Grid<Client>(storeInfoClient5, new ColumnModel(configs));
		add(grid, new AbsoluteData(31, 77));
		grid.setSize("626px", "198px");
		grid.setBorders(true);
		
		Button btnAjouter = new Button("Ajouter");
		
		/******************************MISE A JOUR TABLE APPARTENIR (ARRIVEE ANOSY AVEC DECISION ***********************************************/
		final AsyncCallback<Client[]> asyncCallbackInfoClientVisaArriveAnosyAvecDecision = new AsyncCallback<Client[]>() 
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
					stocksInfoClient5.add(s[i]);
								       
				}
				storeInfoClient5.add(stocksInfoClient5);
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
					String numdoss = (String) txtfldNewTextfield.getValue();
					String dates = DateTimeFormat.getFormat("dd/MM/yyyy").format(dtfldNewDatefield.getValue());
					
					stocksInfoClient5.clear();
					storeInfoClient5.removeAll();
					
				    monServ.miseAjourTableAppartenirAvecDecision(numdoss, dates+"", callbackajoutDemandeVisa);
				    monServ.getInformationClientVisaNumDoss(numdoss+"", asyncCallbackInfoClientVisaArriveAnosyAvecDecision);
				}
			}
		});
		add(btnAjouter, new AbsoluteData(31, 292));
		btnAjouter.setSize("73px", "24px");
	}
}
