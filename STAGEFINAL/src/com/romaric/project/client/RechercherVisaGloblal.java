package com.romaric.project.client;

import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import com.extjs.gxt.ui.client.widget.layout.AbsoluteLayout;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.layout.AbsoluteData;
import com.extjs.gxt.ui.client.Style;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import java.util.Collections;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.romaric.project.Visa.MonService;
import com.romaric.project.Visa.MonServiceAsync;
import com.romaric.project.model.Client;

import java.util.List;
import java.util.ArrayList;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.FieldEvent;

public class RechercherVisaGloblal extends Window {

	final MonServiceAsync monServ = GWT.create(MonService.class);
	/*RECUPERATION INFO CLIENT A PARTIR Nom et Prénom */
	final ListStore<Client> storeClientNom = new ListStore<Client>();
	final List<Client> stocksClientNom = new ArrayList<Client>();

	
	public RechercherVisaGloblal() {
		setOnEsc(false);
		setModal(true);
		setHeight(421);
		setWidth(680);
		setBlinkModal(true);
		setResizable(false);
		setHeading("Accueil > Rechercher Etranger");
		setLayout(new AbsoluteLayout());
		
		LabelField lblfldNomDeLtranger = new LabelField("Nom de l'\u00E9tranger:");
		add(lblfldNomDeLtranger, new AbsoluteData(333, 23));
		
		final TextField<String> txtfldNewTextfield = new TextField<String>();

		add(txtfldNewTextfield, new AbsoluteData(446, 20));
		txtfldNewTextfield.setFieldLabel("New TextField");
		
		Button btnNewButton = new Button("OK");

		add(btnNewButton, new AbsoluteData(610, 18));
		List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
		
		ContentPanel cntntpnlNewContentpanel = new ContentPanel();
		cntntpnlNewContentpanel.setHeaderVisible(false);
		cntntpnlNewContentpanel.setHeading("New ContentPanel");
		cntntpnlNewContentpanel.setLayout(new AbsoluteLayout());
		
		ColumnConfig clmncnfgNumPasseport = new ColumnConfig("numPassport", "Num Passeport", 150);
		configs.add(clmncnfgNumPasseport);
		
		ColumnConfig clmncnfgAdresse = new ColumnConfig("adresse", "Adresse", 150);
		configs.add(clmncnfgAdresse);
		
		ColumnConfig clmncnfgDateDeNaissance = new ColumnConfig("dateNaiss", "Date et lieu de Naissance", 150);
		configs.add(clmncnfgDateDeNaissance);
		
		ColumnConfig clmncnfgNationnalit = new ColumnConfig("nationalite", "Nationnalit\u00E9", 150);
		configs.add(clmncnfgNationnalit);
		
		final Grid<Client> grid = new Grid<Client>(storeClientNom, new ColumnModel(configs));
		cntntpnlNewContentpanel.add(grid, new AbsoluteData(0, 6));
		grid.setSize("625px", "240px");
		grid.setBorders(true);
		
		ToolBar toolBar = new ToolBar();
		
		Button btnNouveau = new Button("Nouveau");
		btnNouveau.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {
				grid.getStore().removeAll();
			}
		});
		toolBar.add(btnNouveau);
		cntntpnlNewContentpanel.add(toolBar, new AbsoluteData(0, 254));
		toolBar.setSize("619px", "25px");
		add(cntntpnlNewContentpanel, new AbsoluteData(29, 75));
		cntntpnlNewContentpanel.setSize("631px", "281px");
		
		
		/*********************RECUPERATION INFORMATION CLIENT A PARTIR NOM ET PRENOM ************************/
		
		final AsyncCallback<Client[]> asyncCallbackAPartirNom = new AsyncCallback<Client[]>() 
		{
			@Override
			public void onFailure(Throwable caught) {
				
				MessageBox.info("Erreur", "Aucune information valide!", null);
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
		
		btnNewButton.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {

			
				  
					String text = txtfldNewTextfield.getValue();
					
					storeClientNom.removeAll();
					stocksClientNom.clear();
					
					monServ.getInformationClientApartirNomEtPrenomGlobal(text, asyncCallbackAPartirNom);
				  
			}
		});
		
		txtfldNewTextfield.addListener(Events.KeyPress, new Listener<FieldEvent>() {
			public void handleEvent(FieldEvent e) {

				String text = txtfldNewTextfield.getValue();
				storeClientNom.removeAll();
				stocksClientNom.clear();
				
				monServ.getInformationClientApartirNomEtPrenomGlobal(text, asyncCallbackAPartirNom);
			}
		});
	}
}
