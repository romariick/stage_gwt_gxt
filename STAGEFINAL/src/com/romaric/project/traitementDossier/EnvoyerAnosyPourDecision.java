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
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import java.util.Collections;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.romaric.project.Visa.MonService;
import com.romaric.project.Visa.MonServiceAsync;
import com.romaric.project.model.Client;

import java.util.List;
import java.util.ArrayList;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.event.ButtonEvent;

public class EnvoyerAnosyPourDecision extends Window {
	
	final MonServiceAsync monServ = GWT.create(MonService.class);
	
	/*Récuperation information client DEMANDE VISA **********************/
	final ListStore<Client> storeInfoClient2 = new ListStore<Client>();
	final List<Client> stocksInfoClient2 = new ArrayList<Client>();

	public EnvoyerAnosyPourDecision() {
		setOnEsc(false);
		setResizable(false);
		setWidth(799);
		setHeight(353);
		setModal(true);
		setHeading("Accueil > Envoyer Anosy pour d\u00E9cision");
		setLayout(new AbsoluteLayout());
		
		LabelField lblfldNumDossier = new LabelField("Num. dossier:");
		add(lblfldNumDossier, new AbsoluteData(30, 28));
		
		final TextField txtfldNewTextfield = new TextField();
		add(txtfldNewTextfield, new AbsoluteData(109, 25));
		txtfldNewTextfield.setFieldLabel("New TextField");
		
		LabelField lblfldDate = new LabelField("date:");
		add(lblfldDate, new AbsoluteData(306, 28));
		
		final DateField dtfldNewDatefield = new DateField();
		add(dtfldNewDatefield, new AbsoluteData(359, 28));
		dtfldNewDatefield.setFieldLabel("New DateField");
		List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
		
		ColumnConfig clmncnfgNomEtPrnom = new ColumnConfig("nomEtPrenom", "Nom et Pr\u00E9nom", 150);
		configs.add(clmncnfgNomEtPrnom);
		
		ColumnConfig clmncnfgNumPasseport = new ColumnConfig("numPassport", "num. Passeport", 150);
		configs.add(clmncnfgNumPasseport);
		
		ColumnConfig clmncnfgDateDeNaissance = new ColumnConfig("dateNaiss", "Date de Naissance", 150);
		configs.add(clmncnfgDateDeNaissance);
		
		ColumnConfig clmncnfgAdresse = new ColumnConfig("adresse", "Adresse", 150);
		configs.add(clmncnfgAdresse);
		
		ColumnConfig clmncnfgTypetranger = new ColumnConfig("typeEtranger", "Type \u00E9tranger", 150);
		configs.add(clmncnfgTypetranger);
		
		Grid<Client> grid = new Grid<Client>(storeInfoClient2, new ColumnModel(configs));
		add(grid, new AbsoluteData(19, 83));
		grid.setSize("758px", "188px");
		grid.setBorders(true);
		
		Button btnAjouter = new Button("Ajouter");
		
		
		final AsyncCallback<Client[]> asyncCallbackInfoClientVisa2 = new AsyncCallback<Client[]>() 
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
				

				String idDossier = (String)txtfldNewTextfield.getValue();
				String dates = DateTimeFormat.getFormat("dd/MM/yyyy").format(dtfldNewDatefield.getValue());
				
				stocksInfoClient2.clear();
				storeInfoClient2.removeAll();
				if(com.google.gwt.user.client.Window.confirm("Voulez-vous vraiment ajouter ces informations?") == true)
				{
					monServ.ajoutEtatDemandeVisa(idDossier, dates+"", callbackajoutDemandeVisa);
					monServ.getInformationClientVisaNumDoss(idDossier, asyncCallbackInfoClientVisa2);
				}
			}
		});
		add(btnAjouter, new AbsoluteData(19, 290));
		btnAjouter.setSize("63px", "24px");
	}
}
