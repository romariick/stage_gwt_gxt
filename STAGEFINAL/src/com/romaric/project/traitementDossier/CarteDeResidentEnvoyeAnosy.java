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
import java.util.List;
import java.util.ArrayList;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.romaric.project.Visa.MonService;
import com.romaric.project.Visa.MonServiceAsync;
import com.romaric.project.model.Client;

public class CarteDeResidentEnvoyeAnosy extends Window {
	final MonServiceAsync monServ = GWT.create(MonService.class);
	final ListStore<Client> storeInfoClient3 = new ListStore<Client>();
	final List<Client> stocksInfoClient3 = new ArrayList<Client>();
	public CarteDeResidentEnvoyeAnosy() {
		setWidth(692);
		setHeight(365);
		setModal(true);
		setHeading("Accueil > Carte de r\u00E9sident envoy\u00E9 \u00E0 Anosy");
		setLayout(new AbsoluteLayout());
		
		LabelField lblfldNumDossier = new LabelField("Num. dossier:");
		add(lblfldNumDossier, new AbsoluteData(22, 31));
		
		final TextField txtfldNewTextfield = new TextField();
		add(txtfldNewTextfield, new AbsoluteData(121, 31));
		txtfldNewTextfield.setFieldLabel("New TextField");
		
		LabelField lblfldDate = new LabelField("Date:");
		add(lblfldDate, new AbsoluteData(315, 31));
		
		final DateField dtfldNewDatefield = new DateField();
		add(dtfldNewDatefield, new AbsoluteData(382, 31));
		dtfldNewDatefield.setFieldLabel("New DateField");
		List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
		
		ColumnConfig clmncnfgNumPasseport = new ColumnConfig("numPassport", "Num. Passeport", 150);
		configs.add(clmncnfgNumPasseport);
		
		ColumnConfig clmncnfgNomEtPrnom = new ColumnConfig("nomEtPrenom", "nom et Pr\u00E9nom", 150);
		configs.add(clmncnfgNomEtPrnom);
		
		ColumnConfig clmncnfgDateDeNaissance = new ColumnConfig("dateNaiss", "Date de naissance", 150);
		configs.add(clmncnfgDateDeNaissance);
		
		ColumnConfig clmncnfgTypetranger = new ColumnConfig("typeEtranger", "Type \u00E9tranger", 150);
		configs.add(clmncnfgTypetranger);
		
		Grid<Client> grid = new Grid<Client>(storeInfoClient3, new ColumnModel(configs));
		add(grid, new AbsoluteData(22, 80));
		grid.setSize("628px", "198px");
		grid.setBorders(true);
		
		Button btnAjouter = new Button("Ajouter");
		
		final AsyncCallback<String> asyncCallbackAjoutPassportArriveAnosy = new AsyncCallback<String>() 
		{
			@Override
			public void onFailure(Throwable caught) {
				
				MessageBox.info("Information", "Impossible d'ajouter ces informations", null);
			}

			@Override
			public void onSuccess(String s) {
								
				MessageBox.info("Information", s, null);
				
			}


		};
		
		
		final AsyncCallback<Client[]> asyncCallbackInfoClientVisa3 = new AsyncCallback<Client[]>() 
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
					stocksInfoClient3.add(s[i]);
				}
				storeInfoClient3.add(stocksInfoClient3);
			}
		};
		btnAjouter.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {
				

				String numDossier = (String) txtfldNewTextfield.getValue();
				
				
				String dates = DateTimeFormat.getFormat("dd/MM/yyyy").format(dtfldNewDatefield.getValue());
				stocksInfoClient3.clear();
				storeInfoClient3.removeAll();
				if(com.google.gwt.user.client.Window.confirm("Voulez-vous vraiment ajouter ces informations") == true)
				{
					monServ.ajoutCarteResidentEnvoyeAnosy(numDossier, dates, asyncCallbackAjoutPassportArriveAnosy);
					monServ.getInformationClientVisaNumDoss(numDossier+"", asyncCallbackInfoClientVisa3);
				}
			}
		});
		add(btnAjouter, new AbsoluteData(22, 296));
		btnAjouter.setSize("77px", "24px");
	}
}
