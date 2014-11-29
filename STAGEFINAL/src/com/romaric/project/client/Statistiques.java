package com.romaric.project.client;

import com.extjs.gxt.charts.client.Chart;
import com.extjs.gxt.charts.client.model.ChartModel;
import com.extjs.gxt.charts.client.model.Legend;
import com.extjs.gxt.charts.client.model.Legend.Position;
import com.extjs.gxt.charts.client.model.axis.XAxis;
import com.extjs.gxt.charts.client.model.axis.YAxis;
import com.extjs.gxt.charts.client.model.charts.BarChart;
import com.extjs.gxt.charts.client.model.charts.PieChart;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.AbsoluteLayout;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.TabPanel;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.layout.AbsoluteData;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

import com.extjs.gxt.ui.client.store.ListStore;

import com.google.gwt.user.client.ui.ListBox;

import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;

import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import java.util.List;
import java.util.ArrayList;

import com.extjs.gxt.ui.client.widget.ContentPanel;

import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ChangeEvent;

import com.google.gwt.user.client.ui.Hyperlink;
import com.romaric.project.model.Nationalite;
import com.romaric.project.model.StatistiqueFormeJuridique;
import com.romaric.project.model.StatistiqueMoisAnnnee;
import com.romaric.project.model.StatistiqueNationaliteTous;
import com.romaric.project.model.StatistiqueParSecteur;
import com.romaric.project.model.StatistiqueVilleTous;
import com.extjs.gxt.ui.client.widget.button.ToggleButton;
import com.extjs.gxt.ui.client.Style;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;


public class Statistiques extends Window {
	
	final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);
	
	
	ArrayList<String[]> valuesEntreprise = new ArrayList<String[]>();
/*Statistique ville*/
	final ListStore<StatistiqueVilleTous> storeVilleTous = new ListStore<StatistiqueVilleTous>();
	final List<StatistiqueVilleTous> stocksVilleTous = new ArrayList<StatistiqueVilleTous>();
	
	
/*Statistique nationalite tous*/
	final ListStore<StatistiqueNationaliteTous> storeNationaliteTous = new ListStore<StatistiqueNationaliteTous>();
	final  List<StatistiqueNationaliteTous> stocksNationaliteTous = new ArrayList<StatistiqueNationaliteTous>();
	
/*Statistique par secteurs*/
	final ListStore<StatistiqueParSecteur> storeSecteurs = new ListStore<StatistiqueParSecteur>();
	final List<StatistiqueParSecteur> stocksSecteurs = new ArrayList<StatistiqueParSecteur>();

/*Statistique sur fj*/
	
	final ListStore<StatistiqueFormeJuridique> storeFj = new ListStore<StatistiqueFormeJuridique>();
	final List<StatistiqueFormeJuridique> stocksFj = new ArrayList<StatistiqueFormeJuridique>();
	
	/********LISTSTORE<> DE LA STATISTIQUE PAR MOIS ET ANNEE********/
	
	final static ListStore<StatistiqueMoisAnnnee> store = new ListStore<StatistiqueMoisAnnnee>();
	final List<StatistiqueMoisAnnnee> stocks = new ArrayList<StatistiqueMoisAnnnee>();

	ContentPanel cntntpnlStatistiques_2 = new ContentPanel();
	ContentPanel cntntpnlStatistiques_1 = new ContentPanel();
	ContentPanel cntntpnlStatistiques = new ContentPanel();
	
	public Statistiques() {
		setModal(true);
		
		setResizable(false);
		setOnEsc(false);
		setMinimizable(true);
		setWidth(933);
		setHeight(497);
		setBlinkModal(true);
		setHeading("Accueil > Statistiques générals");
		setLayout(new AbsoluteLayout());
		
		TabPanel tabPanel = new TabPanel();
		
/** TRAITEMENT STATISTIQUE GRAPHE NATIONALITES TOUS**/
		      
	    String url = "resources/chart/open-flash-chart.swf";  
	    final Chart chart = new Chart(url);

/** TRAITEMENT STATISTIQUE GRAPHE SECTEURS**/
	    final Chart chart_1 = new Chart(url);
	    chart_1.setBorders(true);

/** TRAITEMENT STATISTIQUE GRAPHE FORME JURIDIQUE**/
	    final Chart chart_2 = new Chart(url);

/** TRAITEMENT STATISTIQUE VILLE**/
	    final Chart chart_3 = new Chart(url);
	
	    final Chart chart_4 = new Chart(url);
	  
		final TabItem tbtmNewTabitem = new TabItem("Cr\u00E9es par mois");
	
		tbtmNewTabitem.setLayout(new AbsoluteLayout());
				

		
		Button btnNewButton = new Button("Exporter...");

		tbtmNewTabitem.add(btnNewButton, new AbsoluteData(623, 500));
		
		LabelField lblfldNombresDenregistrements = new LabelField("Nombres d'enregistrements:");
		tbtmNewTabitem.add(lblfldNombresDenregistrements, new AbsoluteData(64, 500));
		List<ColumnConfig> configs_3 = new ArrayList<ColumnConfig>();
		
		ColumnConfig clmncnfgNewColumn_3 = new ColumnConfig("denomination", "Mois", 150);
		configs_3.add(clmncnfgNewColumn_3);
		
		
		ColumnConfig clmncnfgActivites = new ColumnConfig("activites", "Nombres", 150);
		configs_3.add(clmncnfgActivites);
		
		ColumnConfig clmncnfgNewColumn_5 = new ColumnConfig("siegesociale", "Pourcentage", 150);
		configs_3.add(clmncnfgNewColumn_5);
		
		//ColumnModel cm1 = ;
		
/*GRID DE LA STATISITIQUE PAR MOIS ET ANNEE*/
		final Grid<StatistiqueMoisAnnnee> grid_1 = new Grid<StatistiqueMoisAnnnee>(store, new ColumnModel(configs_3));
		grid_1.setStripeRows(true);
		AbsoluteData ad_grid_1 = new AbsoluteData(16, 108);
		ad_grid_1.setAnchorSpec("-445");
		tbtmNewTabitem.add(grid_1, ad_grid_1);
		grid_1.setHeight("259px");
		grid_1.setBorders(true);
		
		final ListBox comboBox = new ListBox();
		comboBox.addItem("1");
		comboBox.addItem("2");
		comboBox.addItem("3");
		comboBox.addItem("4");
		comboBox.addItem("5");
		comboBox.addItem("6");
		comboBox.addItem("7");
		comboBox.addItem("8");
		comboBox.addItem("9");
		comboBox.addItem("10");
		comboBox.addItem("11");
		comboBox.addItem("12");
		tbtmNewTabitem.add(comboBox, new AbsoluteData(64, 29));
		
		LabelField lblfldMois_1 = new LabelField("Mois:");
		tbtmNewTabitem.add(lblfldMois_1, new AbsoluteData(16, 29));
		
		LabelField lblfldAnne = new LabelField("Ann\u00E9e:");
		tbtmNewTabitem.add(lblfldAnne, new AbsoluteData(155, 29));
		
		final ListBox comboBox_1 = new ListBox();
		comboBox_1.addItem("2013");
		comboBox_1.addItem("2014");
		comboBox_1.addItem("2015");
		comboBox_1.addItem("2016");

		tbtmNewTabitem.add(comboBox_1, new AbsoluteData(243, 29));
		
		Button btnOk_1 = new Button("OK");
		tbtmNewTabitem.add(btnOk_1, new AbsoluteData(335, 29));
		
		ToolBar toolBar = new ToolBar();
		
		final Button btnNewButton_1 = new Button("Exporter...");
		btnNewButton_1.setEnabled(false);
		toolBar.add(btnNewButton_1);

		tbtmNewTabitem.add(toolBar, new AbsoluteData(16, 337));
		toolBar.setSize("454px", "28px");
		
		
		
		tabPanel.add(tbtmNewTabitem);
		tbtmNewTabitem.setSize("635px", "428px");
		
		TabItem tbtmNewTabitem_1 = new TabItem("Nationalit\u00E9s");
		tbtmNewTabitem_1.setLayout(new AbsoluteLayout());
		List<ColumnConfig> configs_5 = new ArrayList<ColumnConfig>();
		
/*GRID DE LA STATISITIQUE DE LA NATIONALITE TOUS ET UN A UN*/
				
				ContentPanel cntntpnlCritres = new ContentPanel();
				cntntpnlCritres.setHeaderVisible(false);
				cntntpnlCritres.setHeading("Crit\u00E8res");
				cntntpnlCritres.setCollapsible(true);
				cntntpnlCritres.setLayout(new AbsoluteLayout());
				
				LabelField lblfldNationalit = new LabelField("Nationalit\u00E9:");
				cntntpnlCritres.add(lblfldNationalit, new AbsoluteData(6, 24));
				
				final ListBox comboBox_3 = new ListBox();
				cntntpnlCritres.add(comboBox_3, new AbsoluteData(76, 24));
				
						comboBox_3.addItem("Tous");
						comboBox_3.setSize("136px", "22px");
					
		
						
						final AsyncCallback<Nationalite[]> callbackListe4 = new AsyncCallback<Nationalite[]>() 
						{
							@Override
							public void onFailure(Throwable caught) {
								
							
								
								GWT.log(caught.getMessage(),caught);
							}

							@Override
							public void onSuccess(Nationalite[] s) {
												
							
								
								for(int i = 0; i < s.length; i++)
								{	
									comboBox_3.addItem(s[i].nationalite);
									
								}
								
							}
						};
						greetingService.getListeNationalite(callbackListe4);
						
						
						LabelField lblfldAnne_1 = new LabelField("Ann\u00E9e:");
						cntntpnlCritres.add(lblfldAnne_1, new AbsoluteData(239, 24));
						
						final ListBox comboBox_5 = new ListBox();
						comboBox_5.addItem("2013");
						comboBox_5.addItem("2014");
						comboBox_5.addItem("2015");
						cntntpnlCritres.add(comboBox_5, new AbsoluteData(288, 21));
						comboBox_5.setSize("111px", "22px");
				
				Button btnOk = new Button("OK");
				cntntpnlCritres.add(btnOk, new AbsoluteData(427, 19));
				
	
				tbtmNewTabitem_1.add(cntntpnlCritres, new AbsoluteData(16, 18));
				cntntpnlCritres.setSize("471px", "72px");
		    
		    ContentPanel cntntpnlNewContentpanel = new ContentPanel();
		    cntntpnlNewContentpanel.setHeaderVisible(false);
		    cntntpnlNewContentpanel.setHeading("New ContentPanel");
		    cntntpnlNewContentpanel.setLayout(new AbsoluteLayout());
		    
		    ColumnConfig clmncnfgNationalite = new ColumnConfig("nationalite", "Nationalite", 150);
		    configs_5.add(clmncnfgNationalite);
		    
		    ColumnConfig clmncnfgNombreEntreprise = new ColumnConfig("nombresociete", "Nombre entreprise", 150);
		    configs_5.add(clmncnfgNombreEntreprise);
		    
		    ColumnConfig clmncnfgNewColumn = new ColumnConfig("pourcentage", "Pourcentage", 150);
		    configs_5.add(clmncnfgNewColumn);
		    final Grid<StatistiqueNationaliteTous> grid = new Grid<StatistiqueNationaliteTous>(storeNationaliteTous, new ColumnModel(configs_5));
		    cntntpnlNewContentpanel.add(grid, new AbsoluteData(0, 0));
		    grid.setSize("462px", "214px");
		    grid.setBorders(true);
		    
		    ToolBar toolBar_1 = new ToolBar();
		    

		    
		    final Button btnNewButton_3 = new Button("Exporter...");
		    toolBar_1.add(btnNewButton_3);
		    btnNewButton_3.setEnabled(false);
		    

		    cntntpnlNewContentpanel.add(toolBar_1, new AbsoluteData(0, 222));
		    toolBar_1.setSize("460px", "27px");
		    tbtmNewTabitem_1.add(cntntpnlNewContentpanel, new AbsoluteData(16, 110));
		    cntntpnlNewContentpanel.setSize("471px", "253px");
	
		tabPanel.add(tbtmNewTabitem_1);
		tbtmNewTabitem_1.setWidth("583px");
		
		
		TabItem tbtmNewTabitem_2 = new TabItem("Ville");
		tbtmNewTabitem_2.setLayout(new AbsoluteLayout());
		List<ColumnConfig> configs_4 = new ArrayList<ColumnConfig>();
		
		TabItem tbtmNewTabitem_3 = new TabItem("Secteur");
		tbtmNewTabitem_3.setLayout(new AbsoluteLayout());
		
		LabelField lblfldTypesSecteurs = new LabelField("Types secteurs:");
		tbtmNewTabitem_3.add(lblfldTypesSecteurs, new AbsoluteData(28, 18));
		
		final ListBox comboBox_4 = new ListBox();
		comboBox_4.addItem("Tous");
		comboBox_4.addItem("Primaire");
		comboBox_4.addItem("Secondaire");
		comboBox_4.addItem("Tertiaire");
		tbtmNewTabitem_3.add(comboBox_4, new AbsoluteData(124, 18));
		comboBox_4.setSize("152px", "22px");
		List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
		
		ColumnConfig clmncnfgSecteurs = new ColumnConfig("secteurs", "Secteurs", 150);
		configs.add(clmncnfgSecteurs);
		
		ColumnConfig clmncnfgNombres_1 = new ColumnConfig("nombres", "Nombres", 150);
		configs.add(clmncnfgNombres_1);
		
		ColumnConfig clmncnfgPourcentage = new ColumnConfig("pourcentage", "Pourcentage", 150);
		configs.add(clmncnfgPourcentage);
		
		/*Statistique par secteurs*/
		
		final Grid<StatistiqueParSecteur> grid_3 = new Grid<StatistiqueParSecteur>(storeSecteurs, new ColumnModel(configs));
		tbtmNewTabitem_3.add(grid_3, new AbsoluteData(28, 71));
		grid_3.setSize("448px", "313px");
		grid_3.setBorders(true);
		
		LabelField lblfldAnne_2 = new LabelField("Ann\u00E9e:");
		tbtmNewTabitem_3.add(lblfldAnne_2, new AbsoluteData(312, 18));
		
		final ListBox comboBox_7 = new ListBox();

		comboBox_7.addItem("2013");
		comboBox_7.addItem("2014");
		comboBox_7.addItem("2015");
		tbtmNewTabitem_3.add(comboBox_7, new AbsoluteData(379, 18));
		
		Button btnOk_2 = new Button("OK");

		tbtmNewTabitem_3.add(btnOk_2, new AbsoluteData(451, 18));
		

		
		ColumnConfig clmncnfgVille = new ColumnConfig("ville", "Ville", 150);
		configs_4.add(clmncnfgVille);
		
		ColumnConfig clmncnfgNombres = new ColumnConfig("nombres", "Nombres", 150);
		configs_4.add(clmncnfgNombres);
		
		ColumnConfig clmncnfgPourcentage_1 = new ColumnConfig("pourcentage", "Pourcentage", 150);
		configs_4.add(clmncnfgPourcentage_1);
		
		final Grid<StatistiqueVilleTous> grid_2 = new Grid<StatistiqueVilleTous>(storeVilleTous, new ColumnModel(configs_4));
		tbtmNewTabitem_2.add(grid_2, new AbsoluteData(25, 95));
		grid_2.setSize("461px", "235px");
		grid_2.setBorders(true);
		
		LabelField lblfldVille = new LabelField("Ville:");
		tbtmNewTabitem_2.add(lblfldVille, new AbsoluteData(25, 39));
		
		final ListBox comboBox_2 = new ListBox();
		tbtmNewTabitem_2.add(comboBox_2, new AbsoluteData(79, 39));
		comboBox_2.addItem("Tous");
		comboBox_2.addItem("Fianarantsoa");
		comboBox_2.addItem("Antananarivo");
		comboBox_2.addItem("Antsirabe");
		comboBox_2.addItem("Majunga");
		comboBox_2.addItem("Diego");
		comboBox_2.addItem("Tul\u00E9ar");
		comboBox_2.setSize("149px", "22px");
		
		LabelField lblfldAnnee = new LabelField("Annee:");
		tbtmNewTabitem_2.add(lblfldAnnee, new AbsoluteData(274, 39));
		
		final ListBox comboBox_6 = new ListBox();
		comboBox_6.addItem("2013");
		comboBox_6.addItem("2014");
		comboBox_6.addItem("2015");
		tbtmNewTabitem_2.add(comboBox_6, new AbsoluteData(342, 39));
		
		final Button btnNewButton_2 = new Button("OK");
		tbtmNewTabitem_2.add(btnNewButton_2, new AbsoluteData(418, 39));
		
		final Button btnExporter = new Button("Exporter...");
		btnExporter.setEnabled(false);

		tbtmNewTabitem_2.add(btnExporter, new AbsoluteData(25, 341));
		

		
	

		tabPanel.add(tbtmNewTabitem_2);
		
		TabItem tbtmNewTabitem_4 = new TabItem("Forme juridique");
		tbtmNewTabitem_4.setLayout(new AbsoluteLayout());
		
		LabelField lblfldTypesFormes = new LabelField("Types formes:");
		tbtmNewTabitem_4.add(lblfldTypesFormes, new AbsoluteData(20, 24));
		
		final ListBox comboBox_8 = new ListBox();
		comboBox_8.addItem("Tous");
		comboBox_8.addItem("SARL");
		comboBox_8.addItem("SA");
		tbtmNewTabitem_4.add(comboBox_8, new AbsoluteData(117, 24));
		comboBox_8.setSize("124px", "22px");
		
		LabelField lblfldAnne_3 = new LabelField("Ann\u00E9e:");
		tbtmNewTabitem_4.add(lblfldAnne_3, new AbsoluteData(271, 24));
		
		final ListBox comboBox_9 = new ListBox();

		comboBox_9.addItem("2013");
		comboBox_9.addItem("2014");
		comboBox_9.addItem("2015");
		tbtmNewTabitem_4.add(comboBox_9, new AbsoluteData(343, 24));
		
		Button btnOk_3 = new Button("OK");

		tbtmNewTabitem_4.add(btnOk_3, new AbsoluteData(442, 24));
		List<ColumnConfig> configs_1 = new ArrayList<ColumnConfig>();
		
		ColumnConfig clmncnfgFormeJuridique = new ColumnConfig("formejuridique", "Forme Juridique", 150);
		configs_1.add(clmncnfgFormeJuridique);
		
		ColumnConfig clmncnfgNombresSocits = new ColumnConfig("nombresociete", "Nombres soci\u00E9t\u00E9s", 150);
		configs_1.add(clmncnfgNombresSocits);
		
		ColumnConfig clmncnfgPourcentage_2 = new ColumnConfig("pourcentage", "Pourcentage", 150);
		configs_1.add(clmncnfgPourcentage_2);
		
/**************** FORME JURIDIQUE *****************************************/
		final Grid<StatistiqueFormeJuridique> grid_4 = new Grid<StatistiqueFormeJuridique>(storeFj, new ColumnModel(configs_1));
		tbtmNewTabitem_4.add(grid_4, new AbsoluteData(20, 115));
		grid_4.setSize("475px", "245px");
		grid_4.setBorders(true);
		
		final Button btnExporter_1 = new Button("Exporter...");
		btnExporter_1.setEnabled(false);
		tbtmNewTabitem_4.add(btnExporter_1, new AbsoluteData(20, 381));
		

		tabPanel.add(tbtmNewTabitem_4);
		add(tabPanel, new AbsoluteData(6, 6));
		tabPanel.setSize("907px", "453px");
		

				
/************************* STATISTIQUE A TOUS LES VILLES ET UN PAR UN ********************/
		
		final AsyncCallback<StatistiqueVilleTous[]> asyncCallbackVilleTous = new AsyncCallback<StatistiqueVilleTous[]>() 
		{
			@Override
			public void onFailure(Throwable caught) {
				
				GWT.log(caught.getMessage(),caught);
			}

			@Override
			public void onSuccess(StatistiqueVilleTous[] s) {
				int i;
				
				for(i = 0; i < s.length; i++)
				{
					stocksVilleTous.add(s[i]);
				}
				storeVilleTous.add(stocksVilleTous);
				btnExporter.setEnabled(true);
				 cntntpnlStatistiques_2.setExpanded(true);
				chart_3.setChartModel(getHorizontalBarChartModelVille());
				
				
			}
		};
		
		//greetingService.getStatistique_villeTous("Tous", "2013", asyncCallbackVilleTous);
		
		
		
		btnNewButton_2.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {
				
				
				
					int a = comboBox_2.getSelectedIndex();
					String ville = comboBox_2.getItemText(a);
					
					int b = comboBox_6.getSelectedIndex();
					String annee = comboBox_6.getItemText(b);
					
					/*STATISTIQUE VILLE TOUS*/
					
					stocksVilleTous.clear();
					
					storeVilleTous.removeAll();
					
					greetingService.getStatistique_villeTous(ville, annee, asyncCallbackVilleTous);
				
			}
		});		

	btnNewButton.addSelectionListener(new SelectionListener<ButtonEvent>() {
		public void componentSelected(ButtonEvent ce) {
			grid_1.getStore().removeAll();
			//grid_1.getStore().remove(0);
			
		}
	});
		

		
/*****************  *FORME JURIDIQUE* *************************/
	
		final AsyncCallback<StatistiqueFormeJuridique[]> asyncCallbackFj = new AsyncCallback<StatistiqueFormeJuridique[]>() 
		{
			@Override
			public void onFailure(Throwable caught) {
				
				GWT.log(caught.getMessage(),caught);
			}

			@Override
			public void onSuccess(StatistiqueFormeJuridique[] s) {
				int i;
				
				for(i = 0; i < s.length; i++)
				{	
					stocksFj.add(s[i]);
					
				}
				storeFj.add(stocksFj);
				chart_2.setChartModel(getHorizontalBarChartModelFormeJuridique());
				 cntntpnlStatistiques_1.setEnabled(true);
				btnExporter_1.setEnabled(true);
			}
		};
		//greetingService.getStatistique_FormeJuridique("Tous", "2013", asyncCallbackFj);
		
		btnOk_3.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {
				int a = comboBox_8.getSelectedIndex();
				String text = comboBox_8.getItemText(a);
				
				int b = comboBox_9.getSelectedIndex();
				String text2 = comboBox_9.getItemText(b);
				
				
				storeFj.removeAll();
				stocksFj.clear();
				
				greetingService.getStatistique_FormeJuridique(text, text2, asyncCallbackFj);
			}
		});
		

/******************* GRAPHE NATIONALITE TOUS *****************/		
	  final ContentPanel cp = new ContentPanel();
	  cp.setExpanded(false);
	  cp.setCollapsible(true);
	  tbtmNewTabitem_1.add(cp, new AbsoluteData(493, 17));
	  cp.setSize("353px", "363px");
	  cp.setHeading("Statistiques");  
	  cp.setFrame(true);  
	  cp.setSize(400, 400);  
	  cp.setLayout(new FitLayout());  
	  chart.setBorders(true);
	  
      cp.add(chart);
      
      
      /***********************STATISTIQUE NATIONALITE******************************/
		
  	final AsyncCallback<StatistiqueNationaliteTous[]> asyncCallbackNationaliteTous = new AsyncCallback<StatistiqueNationaliteTous[]>() 
  	{
  		@Override
  		public void onFailure(Throwable caught) {
  			
  			GWT.log(caught.getMessage(),caught);
  		}

  		@Override
  		public void onSuccess(StatistiqueNationaliteTous[] s) {

  			
  			for(int i = 0; i < s.length; i++)
  			{	
  				stocksNationaliteTous.add(s[i]);
  			}
  			
  			storeNationaliteTous.add(stocksNationaliteTous);
  			chart.setChartModel(getHorizontalBarChartModel());
  			btnNewButton_3.setEnabled(true);
  			cp.setExpanded(true);
  			
  			//new RechercheEntrepriseCode(s[i].denomination, s[i].siege, s[i].capital, s[i].fj, s[i].rcs, s[i].activite, s[i].gerant, s[i].stat, s[i].nationalite, s[i].modification, s[i].datemodif, s[i].valeur)
  		}
  	};

  		
//  	greetingService.getStatistique_NationaliteTous("Tous", "2013", asyncCallbackNationaliteTous);
  	
  	
  	btnOk.addSelectionListener(new SelectionListener<ButtonEvent>() {
  		public void componentSelected(ButtonEvent ce) {
  			
  			
  			
  				int recupre = comboBox_3.getSelectedIndex();
  				String texte = comboBox_3.getItemText(recupre);
  				
  				int recupre2 = comboBox_5.getSelectedIndex();
  				String text2 = comboBox_5.getItemText(recupre2);
  				
  				
  				storeNationaliteTous.removeAll();
  				stocksNationaliteTous.clear();
  						
  				greetingService.getStatistique_NationaliteTous(texte, text2, asyncCallbackNationaliteTous);
  			
  				  
  		}
  	});  
 /***************** GRAPHE SECTEUR ***************************/
      
		
		cntntpnlStatistiques.setExpanded(false);
		
		cntntpnlStatistiques.setHeading("Statistiques");
		cntntpnlStatistiques.setCollapsible(true);
		cntntpnlStatistiques.setLayout(new FitLayout());
		cntntpnlStatistiques.add(chart_1, new AbsoluteData(27, 6));
		chart_1.setSize(400, 400);
		cntntpnlStatistiques.setFrame(true);
		tbtmNewTabitem_3.add(cntntpnlStatistiques, new AbsoluteData(517, 18));
		cntntpnlStatistiques.setSize("355px", "370px");
		
		final Button btnExporter_2 = new Button("Exporter...");
		btnExporter_2.setEnabled(false);

		tbtmNewTabitem_3.add(btnExporter_2, new AbsoluteData(28, 395));
		tabPanel.add(tbtmNewTabitem_3);
		
		cntntpnlStatistiques.add(chart_1);
		
		
		/************************STATISTIQUE PAR SECTEURS**************************/
		
		final AsyncCallback<StatistiqueParSecteur[]> asyncCallbackParSecteur = new AsyncCallback<StatistiqueParSecteur[]>() 
		{
			@Override
			public void onFailure(Throwable caught) {
				
				GWT.log(caught.getMessage(),caught);
			}

			@Override
			public void onSuccess(StatistiqueParSecteur[] s) {
				int i;
				
				for(i = 0; i < s.length; i++)
				{	
					stocksSecteurs.add(s[i]);
								       
				}
				
				storeSecteurs.add(stocksSecteurs);
				btnExporter_2.setEnabled(true);
				cntntpnlStatistiques.setExpanded(true);
				chart_1.setChartModel(getHorizontalBarChartModelSecteur());
				
			}
		};
			

		//greetingService.getStatistique_ParSecteur("Tous", "2013", asyncCallbackParSecteur);
			
		btnOk_2.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {
				
				int a = comboBox_4.getSelectedIndex();
				String text = comboBox_4.getItemText(a);
				
				int b = comboBox_7.getSelectedIndex();
				String text2 = comboBox_7.getItemText(b);
				
				/*STATISTIQUE VILLE TOUS*/
				
				grid_3.getStore().removeAll();
				storeSecteurs.removeAll();
				stocksSecteurs.clear();
				
				greetingService.getStatistique_ParSecteur(text, text2, asyncCallbackParSecteur);
					
				}
			});		

		
/************** GRAPHE FORME JURIDIQUE *******/
		
		
		cntntpnlStatistiques_1.setExpanded(false);
		
		cntntpnlStatistiques_1.setHeading("STATISTIQUES");
		cntntpnlStatistiques_1.setCollapsible(true);
		cntntpnlStatistiques_1.setLayout(new FitLayout());
		cntntpnlStatistiques_1.add(chart_2);
		tbtmNewTabitem_4.add(cntntpnlStatistiques_1, new AbsoluteData(540, 6));
		cntntpnlStatistiques_1.setSize("332px", "354px");
	
/************** GRAPHE VILLE *****************/
		
		
		cntntpnlStatistiques_2.setExpanded(false);
		cntntpnlStatistiques_2.setHeading("Statistiques");
		cntntpnlStatistiques_2.setCollapsible(true);
		cntntpnlStatistiques_2.setLayout(new FitLayout());
		cntntpnlStatistiques_2.add(chart_3);
		tbtmNewTabitem_2.add(cntntpnlStatistiques_2, new AbsoluteData(512, 19));
		cntntpnlStatistiques_2.setSize("367px", "346px");
		
/************** GRAPHE MOIS ANNEE *****************/		
		final ContentPanel cntntpnlStatistiques_3 = new ContentPanel();
		cntntpnlStatistiques_3.setExpanded(false);
		cntntpnlStatistiques_3.setHeading("STATISTIQUES");
		cntntpnlStatistiques_3.setLayout(new FitLayout());
		
		
		cntntpnlStatistiques_3.add(chart_4);
		cntntpnlStatistiques_3.setCollapsible(true);
		tbtmNewTabitem.add(cntntpnlStatistiques_3, new AbsoluteData(500, 29));
		cntntpnlStatistiques_3.setSize("357px", "338px");

		
		/**************************** STATISTIQUE PAR MOIS ET ANNEE *********************************************/		
		final AsyncCallback<StatistiqueMoisAnnnee[]> callbackListe = new AsyncCallback<StatistiqueMoisAnnnee[]>() 
		{
			@Override
			public void onFailure(Throwable caught) {
				
				GWT.log(caught.getMessage(),caught);
			}

			@Override
			public void onSuccess(StatistiqueMoisAnnnee[] s) {
				
				for(int i = 0; i < s.length; i++)
				{
		    
					stocks.add(s[i]);
				}
				store.add(stocks);
				
				btnNewButton_1.setEnabled(true);
				chart_4.setChartModel(getHorizontalBarChartModelMoisAnnee());
				
			}
		};
		
		//greetingService.getStatistique_am("1", "2013", callbackListe);

/**************************** STATISTIQUE DANS UNE ANNEE *********************************************/		
		final AsyncCallback<StatistiqueMoisAnnnee[]> callbackListeDansUneAnnee = new AsyncCallback<StatistiqueMoisAnnnee[]>() 
		{
			@Override
			public void onFailure(Throwable caught) {
				
				GWT.log(caught.getMessage(),caught);
			}

			@Override
			public void onSuccess(StatistiqueMoisAnnnee[] s) {
				
				for(int i = 0; i < s.length; i++)
				{
		    
					stocks.add(s[i]);
				}
				store.add(stocks);
				
				
				chart_4.setChartModel(getHorizontalBarChartModelMoisAnnee());
				
			}
		};
		comboBox_1.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				
				int b = comboBox_1.getSelectedIndex();
				String annee = comboBox_1.getItemText(b);
				
			
				
				greetingService.getStatistique_dansUneAnne(annee, callbackListeDansUneAnnee);
			}
		});

		
		btnOk_1.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {
				
				/*On récupère les valeurs du combobox*/
			
				
					int a = comboBox.getSelectedIndex();
					String mois = comboBox.getItemText(a);
					
					int b = comboBox_1.getSelectedIndex();
					String annee = comboBox_1.getItemText(b);
		
					stocks.clear();
					store.removeAll();
					cntntpnlStatistiques_3.setExpanded(true);
					greetingService.getStatistique_am(mois, annee, callbackListe);
				
				
				
			}
		});
		
		

	
/*****************APPEL GREETING SERVICE NATIONALITE TOUS (GRAPHE) LANCER AU DEMMARAGE*********************/
	
	greetingService.getStatistique_NationaliteTous("Tous", "2013", asyncCallbackNationaliteTous);
	

    
    
    
    /**********EXPORTATION EXCEL Utiliser pour tous les éxportations**************/
	
	final AsyncCallback<String> ExportationExcelParVille = new AsyncCallback<String>() {
		@Override
		public void onFailure(Throwable caught) {
			//MessageBox.info("Affichage d'erreur", "Erreur d'enregistrement!", null);		
		}

		@Override
		public void onSuccess(String result) {
			
			
		}
	};
    btnNewButton_3.addSelectionListener(new SelectionListener<ButtonEvent>() {
    	public void componentSelected(ButtonEvent ce) {
    		
			
			
    		greetingService.ExportationNationalite(ExportationExcelParVille);
    	
    		com.google.gwt.user.client.Window.open("http://127.0.0.1:8888/resources/Excel/NatinaliteFinal.xls", "_parent", null);
			
    		
    	}
    });
	btnNewButton_1.addSelectionListener(new SelectionListener<ButtonEvent>() {
		public void componentSelected(ButtonEvent ce) {
			
		
			
				greetingService.ExportationExcel(ExportationExcelParVille);
				com.google.gwt.user.client.Window.open("http://127.0.0.1:8888/resources/Excel/StatCreeParMois.xls", "_parent", null);
			
	
		}
	});
	
	btnExporter.addSelectionListener(new SelectionListener<ButtonEvent>() {
		public void componentSelected(ButtonEvent ce) {
			
			
			greetingService.ExportationVille( ExportationExcelParVille);
			com.google.gwt.user.client.Window.open("http://127.0.0.1:8888/resources/Excel/Ville.xls", "_parent", null);
			
		}
	});
	
	btnExporter_1.addSelectionListener(new SelectionListener<ButtonEvent>() {
		public void componentSelected(ButtonEvent ce) {
			
			
			greetingService.ExportationFormeJuridique( ExportationExcelParVille);
			com.google.gwt.user.client.Window.open("http://127.0.0.1:8888/resources/Excel/FormeJuridique.xls", "_parent", null);
			
		}
	});
	
	btnExporter_2.addSelectionListener(new SelectionListener<ButtonEvent>() {
		public void componentSelected(ButtonEvent ce) {
			
			
			greetingService.ExportationSecteur(ExportationExcelParVille);
			com.google.gwt.user.client.Window.open("http://127.0.0.1:8888/resources/Excel/Secteur.xls", "_parent", null);
			

		}
	});
    
	}
	
/**********       GRAPHE STATISTIQUE NATIONALITE      *********/
   private ChartModel getHorizontalBarChartModel() {
	   
    ChartModel cm = new ChartModel("STATISTIQUES",  
        "font-size: 14px; font-family: Verdana; text-align: center;");
    
    cm.setBackgroundColour("#fffff5");  
    
    Legend lg = new Legend(Position.RIGHT, true);  
    
    lg.setBorder(true);
    lg.setPadding(5);  
    cm.setLegend(lg);  

    
    PieChart pie = new PieChart();  
    pie.setAlpha(0.5f);  
    pie.setNoLabels(true);  
    pie.setTooltip("#label#<br>#percent#");  
    pie.setColours("#ff0000", "#00aa00", "#0000ff", "#ff9900", "#ff00ff");
 
    int nmbr = storeNationaliteTous.getCount();
   
     for(int i = 0; i < nmbr; i++) {
	   
	   int value = Integer.parseInt(storeNationaliteTous.getAt(i).getNombreEntreprise());
	   
	   pie.addSlices(new PieChart.Slice(value, storeNationaliteTous.getAt(i).getNationalite(), storeNationaliteTous.getAt(i).getNationalite()));	   
     }
	    
	 cm.addChartConfig(pie);
	 
 	 return cm;
    }

   
   /**********       GRAPHE STATISTIQUE SECTEUR   *********/
   private ChartModel getHorizontalBarChartModelSecteur() 
   {
	   
    ChartModel cm = new ChartModel("STATISTIQUES",  
        "font-size: 14px; font-family: Verdana; text-align: center;");
    
    cm.setBackgroundColour("#fffff5");  
    
    Legend lg = new Legend(Position.RIGHT, true);  
    
    lg.setBorder(true);
    lg.setPadding(5);  
    cm.setLegend(lg);  

    
    PieChart pie = new PieChart();  
    pie.setAlpha(0.5f);  
    pie.setNoLabels(true);  
    pie.setTooltip("#label#<br>#percent#");  
    pie.setColours("#ff0000", "#00aa00", "#0000ff", "#ff9900", "#ff00ff");
 
    int nmbr = storeSecteurs.getCount();
   
     for(int i = 0; i < nmbr; i++) {
	   
	   int value = Integer.parseInt(storeSecteurs.getAt(i).getNombres());
	   
	   pie.addSlices(new PieChart.Slice(value, storeSecteurs.getAt(i).getSecteurs() , storeSecteurs.getAt(i).getSecteurs()));	   
     }
	    
	 cm.addChartConfig(pie);
	 
 	 return cm;
    }
 
   /**********       GRAPHE STATISTIQUE SECTEUR      *********/
   private ChartModel getHorizontalBarChartModelFormeJuridique() {
	   
    ChartModel cm = new ChartModel("STATISTIQUES",  
        "font-size: 14px; font-family: Verdana; text-align: center;");
    
    cm.setBackgroundColour("#fffff5");  
    
    Legend lg = new Legend(Position.RIGHT, true);  
    
    lg.setBorder(true);
    lg.setPadding(5);  
    cm.setLegend(lg);  

    
    PieChart pie = new PieChart();  
    pie.setAlpha(0.5f);  
    pie.setNoLabels(true);  
    pie.setTooltip("#label#<br>#percent#");  
    pie.setColours("#ff0000", "#00aa00", "#0000ff", "#ff9900", "#ff00ff");
 
    int nmbr = storeFj.getCount();
    
   
     for(int i = 0; i < nmbr; i++) {
	   
	   int value = Integer.parseInt(storeFj.getAt(i).getNombresociete());
	   
	   pie.addSlices(new PieChart.Slice(value, storeFj.getAt(i).getFormejuridique() , storeFj.getAt(i).getFormejuridique()));	   
     }
	    
	 cm.addChartConfig(pie);
	 
 	 return cm;
    }

 /**********       GRAPHE STATISTIQUE VILLE      ***********/
   private ChartModel getHorizontalBarChartModelVille() {
	   
    ChartModel cm = new ChartModel("STATISTIQUES",  
        "font-size: 14px; font-family: Verdana; text-align: center;");
    
    cm.setBackgroundColour("#fffff5");  
    
    Legend lg = new Legend(Position.RIGHT, true);  
    
    lg.setBorder(true);
    lg.setPadding(5);  
    cm.setLegend(lg);  

    
    PieChart pie = new PieChart();  
    pie.setAlpha(0.5f);  
    pie.setNoLabels(true);  
    pie.setTooltip("#label#<br>#percent#");  
    pie.setColours("#ff0000", "#00aa00", "#0000ff", "#ff9900", "#ff00ff");
 
    int nmbr = storeVilleTous.getCount();
    
   
     for(int i = 0; i < nmbr; i++) {
	   
	   int value = Integer.parseInt(storeVilleTous.getAt(i).getNombreEntreprise());
	   
	   pie.addSlices(new PieChart.Slice(value, storeVilleTous.getAt(i).getNomville() , storeVilleTous.getAt(i).getNomville()));	   
     }
	    
	 cm.addChartConfig(pie);
	 
 	 return cm;
    }

   /**********       GRAPHE STATISTIQUE VILLE      ***********/
   private ChartModel getHorizontalBarChartModelMoisAnnee() {
	   
	    ChartModel cm = new ChartModel("STATISTIQUES",  
	        "font-size: 14px; font-family: Verdana; text-align: center;");
	    
	    cm.setBackgroundColour("#fffff5");  
	    
	    Legend lg = new Legend(Position.RIGHT, true);  
	    
	    lg.setBorder(true);
	    lg.setPadding(5);  
	    cm.setLegend(lg);  

	    
	    PieChart pie = new PieChart();  
	    pie.setAlpha(0.5f);  
	    pie.setNoLabels(true);  
	    pie.setTooltip("#label#<br>#percent#");  
	    pie.setColours("#ff0000", "#00aa00", "#0000ff", "#ff9900", "#ff00ff");
	 
	    
	     for(int i = 0; i < 12; i++) {
		   
		   int value = Integer.parseInt(stocks.get(i).getActivite());
		   
		  if(value != 0)
		  {
			  pie.addSlices(new PieChart.Slice(value, stocks.get(i).getDenomination() ,  stocks.get(i).getDenomination()));
			  
		  }
	     }
		    
		 cm.addChartConfig(pie);
		 
	 	 return cm;
	    }
	  
  

   public void TestRecuprVar()
   {
	   int nmbr = storeNationaliteTous.getCount();
	   
	   for (int i = 0; i < nmbr; i++) 
	   {
		   MessageBox.info("Nationalite"+storeNationaliteTous.getAt(i).getNationalite(), "Nombre"+storeNationaliteTous.getAt(i).getNombreEntreprise(), null);
		   
	   }

   }
}
