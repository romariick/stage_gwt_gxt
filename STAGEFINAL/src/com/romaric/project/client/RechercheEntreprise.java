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
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import java.util.Collections;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import java.util.List;
import java.util.ArrayList;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.FieldEvent;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.romaric.project.model.RechercheEntrepriseCode;
import com.romaric.project.model.RecuperationInfoEntrepriseModif;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.widget.TabPanel;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;

public class RechercheEntreprise extends Window {

	public RechercheEntreprise() {
		setModal(true);
		
		final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);
		
		setOnEsc(false);
		setWidth(718);
		setHeight(398);
		setBlinkModal(true);
		setResizable(false);
		setHeading("Accueil > Recherche soci\u00E9t\u00E9");
		
/*Rechercher entreprise à partir nif*/
		final ListStore<RechercheEntrepriseCode> storeFindSoct = new ListStore<RechercheEntrepriseCode>();
		final List<RechercheEntrepriseCode> stocksFindSoct = new ArrayList<RechercheEntrepriseCode>();
		
/*Rechercher entreprise à partir dénomination*/
		final ListStore<RechercheEntrepriseCode> storeFindSoctEnse = new ListStore<RechercheEntrepriseCode>();
		final List<RechercheEntrepriseCode> stocksFindSoctEnse = new ArrayList<RechercheEntrepriseCode>();

		
		final ListStore<RecuperationInfoEntrepriseModif> storeFindModif = new ListStore<RecuperationInfoEntrepriseModif>();
		final List<RecuperationInfoEntrepriseModif> stocksFindModif = new ArrayList<RecuperationInfoEntrepriseModif>();
		
		setLayout(new AbsoluteLayout());
		List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
		
		Button btnEffacer = new Button("Effacer");

		add(btnEffacer, new AbsoluteData(580, 438));
		btnEffacer.setSize("48px", "24px");
		
		TabPanel tabPanel = new TabPanel();
		
		TabItem tbtmNewTabitem = new TabItem("Rechercher Entreprise");
		tbtmNewTabitem.setLayout(new AbsoluteLayout());
		
		 tbtmNewTabitem.setIconStyle("tab-icon");
				LabelField lblfldNif = new LabelField("NIF:");
				tbtmNewTabitem.add(lblfldNif, new AbsoluteData(24, 39));
				lblfldNif.setSize("22px", "14px");
				
				final TextField txtfldNewTextfield = new TextField();
				txtfldNewTextfield.setAllowBlank(false);
				tbtmNewTabitem.add(txtfldNewTextfield, new AbsoluteData(52, 39));
				txtfldNewTextfield.setSize("159px", "22px");
				txtfldNewTextfield.setFieldLabel("New TextField");
				
				Button btnOk = new Button("OK");
				tbtmNewTabitem.add(btnOk, new AbsoluteData(233, 35));
				btnOk.setSize("100px", "26px");
				
				ColumnConfig clmncnfgDnomination = new ColumnConfig("denomination", "D\u00E9nomination", 150);
				configs.add(clmncnfgDnomination);
				
				ColumnConfig clmncnfgSige = new ColumnConfig("siege", "Si\u00E8ge", 150);
				configs.add(clmncnfgSige);
				
				ColumnConfig clmncnfgCapital = new ColumnConfig("capital", "Capital [Ar]", 150);
				configs.add(clmncnfgCapital);
				
				ColumnConfig clmncnfgFormeJuridique = new ColumnConfig("fj", "Forme juridique", 150);
				configs.add(clmncnfgFormeJuridique);
				
				final Grid<RechercheEntrepriseCode> grid = new Grid<RechercheEntrepriseCode>(storeFindSoct, new ColumnModel(configs));
				grid.setColumnLines(true);
				tbtmNewTabitem.add(grid, new AbsoluteData(19, 93));
				grid.setSize("628px", "190px");
				grid.setBorders(true);
				

				
				
				txtfldNewTextfield.addListener(Events.Change, new Listener<FieldEvent>() {
					public void handleEvent(FieldEvent e) {
						

						
					}
				});
				tabPanel.add(tbtmNewTabitem);

		
		TabItem tbtmNewTabitem_1 = new TabItem("Rechercher historique entreprise modifier");
		tbtmNewTabitem_1.setLayout(new AbsoluteLayout());
		
		LabelField lblfldNif_1 = new LabelField("NIF:");
		tbtmNewTabitem_1.add(lblfldNif_1, new AbsoluteData(24, 32));
		
		final TextField txtfldNewTextfield_1 = new TextField();
		txtfldNewTextfield_1.setAllowBlank(false);
		tbtmNewTabitem_1.add(txtfldNewTextfield_1, new AbsoluteData(68, 32));
		txtfldNewTextfield_1.setSize("159px", "22px");
		txtfldNewTextfield_1.setFieldLabel("New TextField");
		
		Button btnNewButton = new Button("OK");

		tbtmNewTabitem_1.add(btnNewButton, new AbsoluteData(260, 30));
		btnNewButton.setSize("100px", "26px");
		List<ColumnConfig> configs_1 = new ArrayList<ColumnConfig>();
		
		ColumnConfig clmncnfgDnomination_1 = new ColumnConfig("denomination", "D\u00E9nomination", 150);
		configs_1.add(clmncnfgDnomination_1);
		
		ColumnConfig clmncnfgSigeSociale = new ColumnConfig("modification", "Modification", 150);
		configs_1.add(clmncnfgSigeSociale);
		
		ColumnConfig clmncnfgValeurModifier = new ColumnConfig("valeur", "Date de modification", 150);
		configs_1.add(clmncnfgValeurModifier);
		
		ColumnConfig clmncnfgDateModification = new ColumnConfig("datemodif", "Valeur modifier", 150);
		configs_1.add(clmncnfgDateModification);
		
		Grid<RecuperationInfoEntrepriseModif> grid_1 = new Grid<RecuperationInfoEntrepriseModif>(storeFindModif, new ColumnModel(configs_1));
		tbtmNewTabitem_1.add(grid_1, new AbsoluteData(24, 79));
		grid_1.setSize("616px", "198px");
		grid_1.setBorders(true);
		tabPanel.add(tbtmNewTabitem_1);
		
		TabItem tbtmNomEntreprise = new TabItem("Nom Entreprise");
		tbtmNomEntreprise.setLayout(new AbsoluteLayout());
		
		final TextField<String> txtfldNewTextfield_2 = new TextField<String>();
		txtfldNewTextfield_2.setAllowBlank(false);
		tbtmNomEntreprise.add(txtfldNewTextfield_2, new AbsoluteData(125, 31));
		txtfldNewTextfield_2.setSize("159px", "22px");
		txtfldNewTextfield_2.setFieldLabel("New TextField");
		
		Button btnOk_1 = new Button("OK");

		tbtmNomEntreprise.add(btnOk_1, new AbsoluteData(302, 29));
		btnOk_1.setSize("100px", "26px");
		List<ColumnConfig> configs_2 = new ArrayList<ColumnConfig>();
		
		LabelField lblfldNomEntreprise = new LabelField("Nom entreprise:");
		tbtmNomEntreprise.add(lblfldNomEntreprise, new AbsoluteData(17, 30));
		
		ContentPanel cntntpnlNewContentpanel = new ContentPanel();
		cntntpnlNewContentpanel.setHeaderVisible(false);
		cntntpnlNewContentpanel.setHeading("New ContentPanel");
		cntntpnlNewContentpanel.setLayout(new AbsoluteLayout());
		
		ColumnConfig clmncnfgDnomination_2 = new ColumnConfig("denomination", "D\u00E9nomination", 150);
		configs_2.add(clmncnfgDnomination_2);
		
		ColumnConfig clmncnfgSige_1 = new ColumnConfig("siege", "Si\u00E8ge", 150);
		configs_2.add(clmncnfgSige_1);
		
		ColumnConfig clmncnfgCapital_1 = new ColumnConfig("capital", "Capital", 150);
		configs_2.add(clmncnfgCapital_1);
		
		ColumnConfig clmncnfgFormeJuridique_1 = new ColumnConfig("fj", "Forme Juridique", 150);
		configs_2.add(clmncnfgFormeJuridique_1);
		
		final Grid<RechercheEntrepriseCode> grid_2 = new Grid<RechercheEntrepriseCode>(storeFindSoctEnse, new ColumnModel(configs_2));
		cntntpnlNewContentpanel.add(grid_2, new AbsoluteData(0, 0));
		grid_2.setSize("625px", "217px");
		grid_2.setBorders(true);
		
		ToolBar toolBar = new ToolBar();
		
		Button btnExporter = new Button("Exporter...");
		toolBar.add(btnExporter);
		btnExporter.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {
				
				ExportationEntrepriseRechercherPDF pdf = new ExportationEntrepriseRechercherPDF();
				pdf.show();
				
			}
		});
		cntntpnlNewContentpanel.add(toolBar, new AbsoluteData(0, 220));
		toolBar.setSize("627px", "25px");
		AbsoluteData ad_cntntpnlNewContentpanel = new AbsoluteData(17, 80);
		ad_cntntpnlNewContentpanel.setAnchorSpec("-130");
		tbtmNomEntreprise.add(cntntpnlNewContentpanel, ad_cntntpnlNewContentpanel);
		cntntpnlNewContentpanel.setHeight("247px");
		tabPanel.add(tbtmNomEntreprise);
		add(tabPanel, new AbsoluteData(6, 6));
		tabPanel.setSize("762px", "391px");
		
		
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
		
		btnOk.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {
				
				

					String a = (String)txtfldNewTextfield.getValue();
			
					stocksFindSoct.clear();
					storeFindSoct.removeAll();
					
					greetingService.findtEntreprise(a, asyncCallbackFind);
				
			}
		});
		
		btnEffacer.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {
				grid.getStore().removeAll();
				stocksFindSoct.clear();
				storeFindSoct.clearFilters();
			}
		});

		
		/**********AVEC MODIFICATION ENTREPRISE ***********/
		
		final AsyncCallback<RecuperationInfoEntrepriseModif[]> asyncCallbackFindWihtModif = new AsyncCallback<RecuperationInfoEntrepriseModif[]>() 
		{
			@Override
			public void onFailure(Throwable caught) {
				
				MessageBox.info("Information", "Aucune information valide", null);
			}

			@Override
			public void onSuccess(RecuperationInfoEntrepriseModif[] s) {
				int i;
				
				for(i = 0; i < s.length; i++)
				{	
					stocksFindModif.add(s[i]);
				}
				storeFindModif.add(stocksFindModif);
			}
		};

		
		btnNewButton.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {
				

					String val = (String) txtfldNewTextfield_1.getValue();
					
					storeFindModif.removeAll();
					stocksFindModif.clear();
					
					greetingService.findtEntrepriseWihtModif(val, asyncCallbackFindWihtModif);
				
			}
		});
		
		
		/*Rechercher à partir nom **/
		
		final AsyncCallback<RechercheEntrepriseCode[]> asyncCallbackFindEnste = new AsyncCallback<RechercheEntrepriseCode[]>() 
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
					stocksFindSoctEnse.add(s[i]);
				}
				storeFindSoctEnse.add(stocksFindSoctEnse);
				
				
			}
		};
		
		btnOk_1.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {
				

					String a = (String)txtfldNewTextfield_2.getValue();
					
					storeFindSoctEnse.removeAll();
					stocksFindSoctEnse.clear();
					
					greetingService.findtEntrepriseApartirNom(a, asyncCallbackFindEnste);
				
				}
		});
	}
}
