package com.romaric.project.main;

import com.extjs.gxt.charts.client.*;
import com.extjs.gxt.themes.client.Slate;
import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import com.extjs.gxt.ui.client.widget.layout.AbsoluteLayout;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.layout.AbsoluteData;
import com.extjs.gxt.ui.client.Style;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Image;
import com.extjs.gxt.ui.client.widget.form.SimpleComboBox;




import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.layout.AbsoluteLayout;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.layout.AbsoluteData;
import com.extjs.gxt.ui.client.widget.tips.ToolTipConfig;
import com.extjs.gxt.ui.client.GXT;
import com.extjs.gxt.ui.client.Style;
import com.extjs.gxt.ui.client.Style.Direction;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.Html;
import com.extjs.gxt.ui.client.widget.Header;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.Viewport;
import com.extjs.gxt.ui.client.widget.Window;
import com.google.gwt.user.client.ui.Image;
import com.extjs.gxt.ui.client.widget.Text;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.fx.Draggable;
import com.extjs.gxt.ui.client.fx.FxConfig;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.HtmlContainer;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.user.client.ui.Tree;
import com.extjs.gxt.ui.client.widget.layout.CenterLayout;
import com.extjs.gxt.ui.client.widget.ColorPalette;
import com.extjs.gxt.ui.client.widget.form.HtmlEditor;
import com.extjs.gxt.ui.client.widget.custom.Portal;
import com.extjs.gxt.ui.client.widget.custom.Portlet;
import com.extjs.gxt.ui.client.widget.layout.AccordionLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.menu.MenuBar;
import com.extjs.gxt.ui.client.widget.menu.MenuBarItem;
import com.extjs.gxt.ui.client.widget.menu.Menu;
import com.extjs.gxt.ui.client.widget.menu.MenuItem;
import com.extjs.gxt.ui.client.widget.button.ButtonBar;
import com.extjs.gxt.ui.client.widget.button.SplitButton;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.widget.layout.FillLayout;
import com.extjs.gxt.ui.client.widget.layout.RowData;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.util.ThemeManager;
import com.extjs.gxt.ui.client.Style.ButtonArrowAlign;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import java.util.Collections;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.HorizontalPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.extjs.gxt.ui.client.widget.menu.SeparatorMenuItem;
import com.extjs.gxt.ui.client.event.MenuEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.romaric.project.client.Authentification;
import com.romaric.project.client.CreationDEntreprise;
import com.romaric.project.client.DemandeAutorisationDEmploie;
import com.romaric.project.client.GestionAjoutInformationDeLetrangerVisa;
import com.romaric.project.client.GreetingService;
import com.romaric.project.client.GreetingServiceAsync;
import com.romaric.project.client.InformationGestionDossierVisa;
import com.romaric.project.client.ModificationSocieteFinal;
import com.romaric.project.client.OutilDAdministration;
import com.romaric.project.client.RechercheAutorisationDEmploie;
import com.romaric.project.client.RechercheEntreprise;
import com.romaric.project.client.RechercheInformationGU;
import com.romaric.project.client.RechercherVisa;
import com.romaric.project.client.RechercherVisaGloblal;
import com.romaric.project.client.StatistiqueAutorisationDEmploi;
import com.romaric.project.client.StatistiqueDemandeVisa;
import com.romaric.project.client.Statistiques;
import com.romaric.project.client.TraitementDossiers;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class STAGEFINAL implements EntryPoint{
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";

	private RootPanel rootPanel;
	
	ContentPanel cntntpnlConfigurations_1 = new ContentPanel();
	
	ContentPanel cntntpnlTousLesFonctions_1 = new ContentPanel();
	
	ContentPanel cntntpnlTousLesFonctions = new ContentPanel();
	ContentPanel cntntpnlNewContentpanel_1 = new ContentPanel();
	ContentPanel cntntpnlNewContentpanel_2 = new ContentPanel();
	ContentPanel cntntpnlTousLesFonctions_1_1 = new ContentPanel();
	/**
	 * This is the entry point method.
	 */
	
	
	
	public void onModuleLoad() {
		
	
		final Authentification2 login = new Authentification2();

		
		
		login.show();
		//final Label errorLabel = new Label();

		// Add the nameField and sendButton to the RootPanel
		// Use RootPanel.get() to get the entire body element
		rootPanel = RootPanel.get("nameFieldContainer");
		Viewport viewport = new Viewport();
		
		ThemeManager.register(Slate.SLATE);
		// Theme.GRAY.set("file","css/gxt-gray.css");
		// Theme.BLUE.set("file","css/gxt-all.css");
		Slate.SLATE.set("file", "resources/themes/slate/css/xtheme-slate.css");
		GXT.setDefaultTheme(Slate.SLATE, true);
		
		viewport.setLoadingPanelId("loading");
		RootPanel.get("loading").add(viewport);
//		rootPanel.setStyleName("#x-history-frame");
		
		ToolTipConfig config = new ToolTipConfig();  
	    config = new ToolTipConfig();  
	    config.setTitle("Information");  
	    config.setText("Cliquez ici pour créer une entreprise.");  
	    config.setTrackMouse(true);
	   
		
		Image image = new Image("resources/desktop/images/entete.png");
		//Ovaina
		
		//RootPanel.get().add(image, 49, 40);
		//Taloha
		rootPanel.add(image, 49, 40);
		image.setSize("853px", "80px");
		image.setStyleName("gwt-logo");
		
		final ContentPanel cntntpnlGuSocit_1 = new ContentPanel();
		rootPanel.add(cntntpnlGuSocit_1);
		cntntpnlGuSocit_1.setHeading("GU Soci\u00E9t\u00E9");
		cntntpnlGuSocit_1.setLayout(new AccordionLayout());
		
		
		
		
		cntntpnlNewContentpanel_2.setHeading("Toutes les fonctions");
		cntntpnlNewContentpanel_2.setCollapsible(true);
		cntntpnlNewContentpanel_2.setLayout(new AbsoluteLayout());
		
		com.extjs.gxt.ui.client.widget.button.Button btnInformations = new com.extjs.gxt.ui.client.widget.button.Button("Cr\u00E9ation d'entreprise");
		cntntpnlNewContentpanel_2.add(btnInformations, new AbsoluteData(6, 6));
		btnInformations.setToolTip(config);
		
		//btnInformations.setToolTip(new ToolTipConfig("Information", "Cr&eacute;ation d'entreprise"));
		
		btnInformations.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {
				CreationDEntreprise ajoutSociete = new CreationDEntreprise();
				ajoutSociete.show();
			}
		});
		btnInformations.setSize("189px", "26px");
		
		com.extjs.gxt.ui.client.widget.button.Button btnModificationDeSocit = new com.extjs.gxt.ui.client.widget.button.Button("Modification des soci\u00E9t\u00E9s");
		cntntpnlNewContentpanel_2.add(btnModificationDeSocit, new AbsoluteData(6, 38));
		btnModificationDeSocit.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {
			//	ModificationSociete modifsocte = new ModificationSociete();
				//modifsocte.show();
				
				ModificationSocieteFinal modif = new ModificationSocieteFinal();
				modif.show();
			}
		});
		btnModificationDeSocit.setSize("189px", "26px");
		
		
		ToolTipConfig configModification = new ToolTipConfig();  
		configModification = new ToolTipConfig();  
		configModification.setTitle("Information");  
		configModification.setText("Cliquez ici pour modifier une entreprise.");  
		configModification.setTrackMouse(true);
		
		 btnModificationDeSocit.setToolTip(configModification);
		 
		com.extjs.gxt.ui.client.widget.button.Button btnRecherche_1 = new com.extjs.gxt.ui.client.widget.button.Button("Recherche");
		
		
		cntntpnlNewContentpanel_2.add(btnRecherche_1, new AbsoluteData(6, 77));
		btnRecherche_1.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {
				RechercheEntreprise findSct = new RechercheEntreprise();
				findSct.show();
			}
		});
		btnRecherche_1.setSize("189px", "26px");
		
		ToolTipConfig confiRecherch = new ToolTipConfig();  
		confiRecherch = new ToolTipConfig();  
		confiRecherch.setTitle("Information");  
		confiRecherch.setText("Cliquez ici pour chercher une entreprise.");  
		confiRecherch.setTrackMouse(true);   
		
		btnRecherche_1.setToolTip(confiRecherch);
		
		com.extjs.gxt.ui.client.widget.button.Button btnStatistiques = new com.extjs.gxt.ui.client.widget.button.Button("Statistiques g\u00E9n\u00E9raux");
		cntntpnlNewContentpanel_2.add(btnStatistiques, new AbsoluteData(6, 122));
		btnStatistiques.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {
				Statistiques stat = new Statistiques();
				stat.show();
			}
		});
		
		ToolTipConfig statGU = new ToolTipConfig();  
		statGU  = new ToolTipConfig();  
		statGU.setTitle("Aide");  
		statGU.setText("Cliquez ici pour voir statistique.");  
		statGU.setTrackMouse(true); 
		btnStatistiques.setToolTip(statGU);
		
		
		ContentPanel cntntpnlAide = new ContentPanel();
		cntntpnlAide.setHeading("Aide");
		cntntpnlAide.setCollapsible(true);
		cntntpnlAide.setLayout(new AbsoluteLayout());
		
		ToolTipConfig recherRapideGU = new ToolTipConfig();  
		recherRapideGU = new ToolTipConfig();  
		recherRapideGU.setTitle("Aide");  
		recherRapideGU.setText("Cliquez sur l'image pour faire une recherche rapide.");  
		recherRapideGU.setTrackMouse(true);  
		cntntpnlAide.setToolTip(recherRapideGU);
		

		Html htmlnewhtmlcomponent_1 = new Html("<b>Guichet Unique des soci&eacutet&eacutes </b>");
		cntntpnlAide.add(htmlnewhtmlcomponent_1, new AbsoluteData(6, 105));
		htmlnewhtmlcomponent_1.addStyleName("titreMenu");
		htmlnewhtmlcomponent_1.setSize("195px", "43px");
		
		final Image image_2 = new Image("resources/desktop/images/guinique.png");


		image_2.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				RechercheInformationGU rechGU = new RechercheInformationGU();
				rechGU.show();
			}
		});
		
		
		
		cntntpnlAide.add(image_2, new AbsoluteData(61, 6));
		image_2.setSize("89px", "93px");
		cntntpnlGuSocit_1.add(cntntpnlAide);
		btnStatistiques.setSize("189px", "26px");
		cntntpnlGuSocit_1.add(cntntpnlNewContentpanel_2);
		rootPanel.setWidgetPosition(cntntpnlGuSocit_1, 29, 183);
		cntntpnlGuSocit_1.setSize("205px", "228px");
		
		final ContentPanel cntntpnlGuSocit = new ContentPanel();
		rootPanel.add(cntntpnlGuSocit);
		cntntpnlGuSocit.setHeading("Visa");
		cntntpnlGuSocit.setLayout(new AccordionLayout());
		
		ContentPanel cntntpnlNewContentpanel = new ContentPanel();
		cntntpnlNewContentpanel.setHeading("Aide");
		cntntpnlNewContentpanel.setLayout(new AbsoluteLayout());
		
		ToolTipConfig aideVisa = new ToolTipConfig();  
		aideVisa = new ToolTipConfig();  
		aideVisa.setTitle("Aide");  
		aideVisa.setText("Cliquez sur l'image pour faire une recherche rapide.");  
		aideVisa.setTrackMouse(true);
		cntntpnlNewContentpanel.setToolTip(aideVisa);
		
		
		Html htmlnewhtmlcomponent = new Html("<b>Traitement de dossier Visa</b>");
		htmlnewhtmlcomponent.addStyleName("titreMenu");
		cntntpnlNewContentpanel.add(htmlnewhtmlcomponent, new AbsoluteData(6, 102));
		htmlnewhtmlcomponent.setSize("189px", "44px");
		
		Image image_3 = new Image((String) null);
		cntntpnlNewContentpanel.add(image_3, new AbsoluteData(56, 43));
		image_3.setSize("6px", "-3px");
		
		Image image_4 = new Image("resources/desktop/images/passport.png");
		image_4.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				RechercherVisaGloblal visaGlobal = new RechercherVisaGloblal();
				visaGlobal.show();
				
			}
		});
		cntntpnlNewContentpanel.add(image_4, new AbsoluteData(63, 6));
		image_4.setSize("73px", "90px");
		cntntpnlGuSocit.add(cntntpnlNewContentpanel);
		
		
		cntntpnlNewContentpanel_1.setHeading("Toutes les fonctions");
		cntntpnlNewContentpanel_1.setCollapsible(true);
		cntntpnlNewContentpanel_1.setLayout(new AbsoluteLayout());
		
		com.extjs.gxt.ui.client.widget.button.Button btnInformations_1 = new com.extjs.gxt.ui.client.widget.button.Button("Gestion visa");
		cntntpnlNewContentpanel_1.add(btnInformations_1, new AbsoluteData(6, 6));
		btnInformations_1.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {
				GestionAjoutInformationDeLetrangerVisa gestion = new GestionAjoutInformationDeLetrangerVisa();
				gestion.show();
			}
		});
		
		ToolTipConfig enregVisa = new ToolTipConfig();  
		enregVisa = new ToolTipConfig();  
		enregVisa.setTitle("Information");  
		enregVisa.setText("Cliquez ici pour enregistrer un étranger.");  
		enregVisa.setTrackMouse(true); 
		btnInformations_1.setToolTip(enregVisa);
		
		
		btnInformations_1.setSize("189px", "26px");
		
		com.extjs.gxt.ui.client.widget.button.Button btnEnregistrementDeDossiers = new com.extjs.gxt.ui.client.widget.button.Button("Mvts. des dossiers");
		cntntpnlNewContentpanel_1.add(btnEnregistrementDeDossiers, new AbsoluteData(6, 44));
		btnEnregistrementDeDossiers.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {
				TraitementDossiers trtmn = new TraitementDossiers();
				trtmn.show();
			}
		});
		
		
		ToolTipConfig mvmDossier = new ToolTipConfig();  
		mvmDossier = new ToolTipConfig();  
		mvmDossier.setTitle("Information");  
		mvmDossier.setText("Cliquez ici pour insérer un mouvement d'un dossier.");  
		mvmDossier.setTrackMouse(true); 
		btnEnregistrementDeDossiers.setToolTip(mvmDossier);
		
		btnEnregistrementDeDossiers.setSize("189px", "26px");
		
		com.extjs.gxt.ui.client.widget.button.Button btnRechercher = new com.extjs.gxt.ui.client.widget.button.Button("Recherche");
		cntntpnlNewContentpanel_1.add(btnRechercher, new AbsoluteData(6, 76));
		btnRechercher.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {
				RechercherVisa rechvisa = new RechercherVisa();
				rechvisa.show();
			}
		});
		
		ToolTipConfig recherVisa = new ToolTipConfig();  
		recherVisa = new ToolTipConfig();  
		recherVisa.setTitle("Information");  
		recherVisa.setText("Cliquez ici pour voir un étranger.");  
		recherVisa.setTrackMouse(true);
		btnRechercher.setToolTip(recherVisa);
		
		btnRechercher.setSize("189px", "26px");
		
		com.extjs.gxt.ui.client.widget.button.Button btnStatistiques_1 = new com.extjs.gxt.ui.client.widget.button.Button("Statistiques");
		cntntpnlNewContentpanel_1.add(btnStatistiques_1, new AbsoluteData(6, 122));
		btnStatistiques_1.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {
				StatistiqueDemandeVisa statdemandevisa = new StatistiqueDemandeVisa();
				statdemandevisa.show();
			}
		});
		
	
		
		ToolTipConfig statVisa = new ToolTipConfig();  
		statVisa = new ToolTipConfig();  
		statVisa.setTitle("Information");  
		statVisa.setText("Cliquez ici pour voir les statistiques.");  
		statVisa.setTrackMouse(true);  
		btnStatistiques_1.setToolTip(statVisa);
		
		
		btnStatistiques_1.setSize("189px", "26px");
		
		ToolTipConfig recher = new ToolTipConfig();  
		recher = new ToolTipConfig();  
		recher.setTitle("Information");  
		recher.setText("Cliquez ici pour voir les statistiques.");  
		recher.setTrackMouse(true);  
		btnStatistiques_1.setToolTip(recher);
		
		cntntpnlGuSocit.add(cntntpnlNewContentpanel_1);
		rootPanel.setWidgetPosition(cntntpnlGuSocit, 273, 183);
		cntntpnlGuSocit.setSize("205px", "228px");
		
		ContentPanel cntntpnlAutorisationDemploie = new ContentPanel();
		rootPanel.add(cntntpnlAutorisationDemploie);
		cntntpnlAutorisationDemploie.setHeading("Autorisation d'emploi");
		cntntpnlAutorisationDemploie.setLayout(new AccordionLayout());
		
		
		
		cntntpnlTousLesFonctions.setHeading("Toutes les fonctions");
		cntntpnlTousLesFonctions.setCollapsible(true);
		cntntpnlTousLesFonctions.setLayout(new AbsoluteLayout());
		
		com.extjs.gxt.ui.client.widget.button.Button btnEtat = new com.extjs.gxt.ui.client.widget.button.Button("Enregistrement");
		cntntpnlTousLesFonctions.add(btnEtat, new AbsoluteData(6, 6));
		btnEtat.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {
					
				DemandeAutorisationDEmploie demande = new DemandeAutorisationDEmploie();
				demande.show();

			}
		});
		
		ToolTipConfig depot = new ToolTipConfig();  
		depot = new ToolTipConfig();  
		depot.setTitle("Information");  
		depot.setText("Cliquez ici pour enregistrer un demande de depôt.");  
		depot.setTrackMouse(true);
		btnEtat.setToolTip(depot);
		btnEtat.setSize("186px", "26px");
		
		com.extjs.gxt.ui.client.widget.button.Button btnStatistique = new com.extjs.gxt.ui.client.widget.button.Button("Statistique");
		btnStatistique.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {
				StatistiqueAutorisationDEmploi stAE = new StatistiqueAutorisationDEmploi();
				stAE.show();
			}
		});
		
		
		ToolTipConfig statAE = new ToolTipConfig();  
		statAE = new ToolTipConfig();  
		statAE.setTitle("Information");  
		statAE.setText("Cliquez ici pour voir les statistiques.");  
		statAE.setTrackMouse(true);
		btnStatistique.setToolTip(statAE);
		
		cntntpnlTousLesFonctions.add(btnStatistique, new AbsoluteData(6, 45));
		btnStatistique.setSize("186px", "25px");
		
		com.extjs.gxt.ui.client.widget.button.Button btnSuivi = new com.extjs.gxt.ui.client.widget.button.Button("Information");
		cntntpnlTousLesFonctions.add(btnSuivi, new AbsoluteData(6, 89));
		btnSuivi.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {
				InformationGestionDossierVisa infodossier = new InformationGestionDossierVisa();				
				infodossier.show();

			}
		});
		
		ContentPanel cntntpnlAide_1 = new ContentPanel();
		cntntpnlAide_1.setHeading("Aide");
		cntntpnlAide_1.setLayout(new AbsoluteLayout());
		
		ToolTipConfig visaDoss = new ToolTipConfig();  
		visaDoss = new ToolTipConfig();  
		visaDoss.setTitle("Aide");  
		visaDoss.setText("Cliquez sur l'image pour faire une recherche rapide.");  
		visaDoss.setTrackMouse(true); 
		cntntpnlAide_1.setToolTip(visaDoss);
		
		
		Html htmlnewhtmlcomponent_2 = new Html("<b>Autorisation d'emploi des &eacutetrangers</b>");
		htmlnewhtmlcomponent_2.addStyleName("titreMenu");
		
		cntntpnlAide_1.add(htmlnewhtmlcomponent_2, new AbsoluteData(6, 104));
		htmlnewhtmlcomponent_2.setSize("189px", "44px");
		
		Image image_5 = new Image("resources/desktop/images/autorisation.png");
		
		cntntpnlAide_1.add(image_5, new AbsoluteData(52, 10));
		image_5.setSize("80px", "88px");
		cntntpnlAide_1.setCollapsible(true);
		cntntpnlAutorisationDemploie.add(cntntpnlAide_1);
		btnSuivi.setSize("186px", "26px");
		
		com.extjs.gxt.ui.client.widget.button.Button btnRecherche = new com.extjs.gxt.ui.client.widget.button.Button("Recherche");
		btnRecherche.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {
				RechercheAutorisationDEmploie rechAuto = new RechercheAutorisationDEmploie();
				
				rechAuto.show();
			
			}
		});
		
		
		ToolTipConfig recherAE = new ToolTipConfig();  
		recherAE = new ToolTipConfig();  
		recherAE.setTitle("Information");  
		recherAE.setText("Cliquez ici pour rechercher une information.");  
		recherAE.setTrackMouse(true);
		btnRecherche.setToolTip(recherAE);
		
		
		
		
		cntntpnlTousLesFonctions.add(btnRecherche, new AbsoluteData(6, 122));
		btnRecherche.setSize("186px", "25px");
		cntntpnlAutorisationDemploie.add(cntntpnlTousLesFonctions);
		rootPanel.setWidgetPosition(cntntpnlAutorisationDemploie, 502, 183);
		cntntpnlAutorisationDemploie.setSize("205px", "228px");
		rootPanel.add(cntntpnlConfigurations_1);
		
		
		cntntpnlConfigurations_1.setHeading("Configurations");
		cntntpnlConfigurations_1.setLayout(new AccordionLayout());
		
		
		cntntpnlTousLesFonctions_1_1.setHeading("Toutes les fonctions");
		cntntpnlTousLesFonctions_1_1.setCollapsible(true);
		cntntpnlTousLesFonctions_1_1.setLayout(new AbsoluteLayout());
		
		com.extjs.gxt.ui.client.widget.button.Button btnSuperAdmin = new com.extjs.gxt.ui.client.widget.button.Button("Super Admin.");
		cntntpnlTousLesFonctions_1_1.add(btnSuperAdmin, new AbsoluteData(6, 6));
		btnSuperAdmin.setSize("189px", "25px");
		
		com.extjs.gxt.ui.client.widget.button.Button btnAdmin = new com.extjs.gxt.ui.client.widget.button.Button("Admin.");
		cntntpnlTousLesFonctions_1_1.add(btnAdmin, new AbsoluteData(6, 45));
		btnAdmin.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {
				OutilDAdministration admin = new OutilDAdministration();
				admin.show();
			}
		});
		
		ContentPanel cntntpnlAide_2 = new ContentPanel();
		cntntpnlAide_2.setHeading("Aide");
		cntntpnlAide_2.setCollapsible(true);
		cntntpnlAide_2.setLayout(new AbsoluteLayout());
		
		Html htmlnewhtmlcomponent_3 = new Html("<b>Param\u00E8tre de configuration</b>");
		cntntpnlAide_2.add(htmlnewhtmlcomponent_3, new AbsoluteData(6, 105));
		htmlnewhtmlcomponent_3.addStyleName("titreMenu");
		htmlnewhtmlcomponent_3.setSize("189px", "43px");
		
		Image image_6 = new Image("resources/desktop/images/configuration.png");
		
		cntntpnlAide_2.add(image_6, new AbsoluteData(64, 6));
		image_6.setSize("74px", "93px");
		cntntpnlConfigurations_1.add(cntntpnlAide_2);
		btnAdmin.setSize("189px", "26px");
		cntntpnlConfigurations_1.add(cntntpnlTousLesFonctions_1_1);
		rootPanel.setWidgetPosition(cntntpnlConfigurations_1, 732, 183);
		cntntpnlConfigurations_1.setSize("205px", "228px");
		
		ContentPanel cntntpnlNombreUtilisateurConnects = new ContentPanel();
		rootPanel.add(cntntpnlNombreUtilisateurConnects);
		cntntpnlNombreUtilisateurConnects.setHeading("Nombre utilisateur connect\u00E9s");
		cntntpnlNombreUtilisateurConnects.setLayout(new AbsoluteLayout());
		
		LabelField lblfldNombresUtilisateurs = new LabelField("Nombres utilisateurs:");
		cntntpnlNombreUtilisateurConnects.add(lblfldNombresUtilisateurs, new AbsoluteData(25, 28));
		
		LabelField lblfldEtatsDuServeurs = new LabelField("Etats du serveurs:");
		cntntpnlNombreUtilisateurConnects.add(lblfldEtatsDuServeurs, new AbsoluteData(25, 82));
		
		Html html = new Html("<b>1</b>");
		cntntpnlNombreUtilisateurConnects.add(html, new AbsoluteData(150, 28));
		
		Image image_7 = new Image("resources/images/default/grid/drop-yes.gif");
		cntntpnlNombreUtilisateurConnects.add(image_7, new AbsoluteData(131, 82));
		image_7.setSize("18px", "18px");
		rootPanel.setWidgetPosition(cntntpnlNombreUtilisateurConnects, 29, 414);
		cntntpnlNombreUtilisateurConnects.setSize("205px", "157px");
		
		ContentPanel cntntpnlNewContentpanel_3 = new ContentPanel();
		cntntpnlNewContentpanel_3.setHeading("Informations");
		rootPanel.add(cntntpnlNewContentpanel_3);
		cntntpnlNewContentpanel_3.setLayout(new AbsoluteLayout());
		
		Html htmlaideLjd = new Html("<b>Ce logiciel permet de faciliter les cr\u00E9ations d'entreprises, traitements des dossiers des \u00E9trang\u00E9s, enfin concernant l'autorisation d'emploi.</b>");
		cntntpnlNewContentpanel_3.add(htmlaideLjd, new AbsoluteData(26, 26));
		htmlaideLjd.setSize("605px", "81px");
		rootPanel.setWidgetPosition(cntntpnlNewContentpanel_3, 273, 424);
		cntntpnlNewContentpanel_3.setSize("639px", "157px");
		
		MenuBar menuBar = new MenuBar();
		
		Menu menu = new Menu();
		
		MenuItem mntmSeDconnecter = new MenuItem("se d\u00E9connecter");
		mntmSeDconnecter.addSelectionListener(new SelectionListener<MenuEvent>() {
			public void componentSelected(MenuEvent ce) {
				Authentification2 auth22 = new Authentification2();
				auth22.show();
				
				cntntpnlNewContentpanel_2.setVisible(true);
				cntntpnlNewContentpanel_1.setVisible(true);
				cntntpnlTousLesFonctions.setVisible(true);
				cntntpnlTousLesFonctions_1_1.setVisible(true);
			}
		});
		menu.add(mntmSeDconnecter);
		MenuBarItem mnbrtmFichier = new MenuBarItem("Fichier", menu);
		menuBar.add(mnbrtmFichier);
		
		Menu menu_1 = new Menu();
		
		MenuItem mntmConfigur = new MenuItem("Configuration IP serveur");
		menu_1.add(mntmConfigur);
		MenuBarItem mnbrtmOption = new MenuBarItem("Option", menu_1);
		menuBar.add(mnbrtmOption);
		
		Menu menu_2 = new Menu();
		
		MenuItem mntmAide = new MenuItem("Aide...");
		menu_2.add(mntmAide);
		MenuBarItem mnbrtmAPropos = new MenuBarItem("A Propos", menu_2);
		menuBar.add(mnbrtmAPropos);
		rootPanel.add(menuBar);
		rootPanel.setWidgetPosition(menuBar, 49, 139);
		
	    RootPanel.get("image").add(image);
		
		RootPanel.get("cntntpnlGuSocit_1").add(cntntpnlGuSocit_1);
		RootPanel.get("cntntpnlGuSocit").add(cntntpnlGuSocit);
		RootPanel.get("cntntpnlAutorisationDemploie").add(cntntpnlAutorisationDemploie);
		RootPanel.get("cntntpnlConfigurations_1").add(cntntpnlConfigurations_1);
		
		RootPanel.get("cntntpnlNombreUtilisateurConnects").add(cntntpnlNombreUtilisateurConnects);
		RootPanel.get("cntntpnlNewContentpanel_3").add(cntntpnlNewContentpanel_3);
		RootPanel.get("menuBar").add(menuBar);
		

	}
	
	
	public class Authentification2 extends Window {
		
		public final GreetingServiceAsync greetingService = GWT
		.create(GreetingService.class);

		public Authentification2() {
			setResizable(false);
			setClosable(false);
			setOnEsc(false);
			setModal(true);
			setBlinkModal(true);
			setWidth(404);
			setHeight(259);
			setHeading("AUTHENTIFICATION");
			setLayout(new AbsoluteLayout());
			
			LabelField lblfldLogin = new LabelField("Login:");
			
			ToolTipConfig config = new ToolTipConfig();  
		    config = new ToolTipConfig();  
		    config.setTitle("Information");  
		    config.setText("Prints the current document");  
		    config.setMouseOffset(new int[] {0, 0});  
		    config.setAnchor("left");
		  //  ((Component) login).setToolTip(config);
			add(lblfldLogin, new AbsoluteData(85, 88));
			
			LabelField lblfldMotDePasse = new LabelField("Mot de Passe:");
			add(lblfldMotDePasse, new AbsoluteData(85, 132));
			
			final PasswordTextBox motDePasse = new PasswordTextBox();
			add(motDePasse, new AbsoluteData(175, 132));
			motDePasse.setSize("153px", "16px");
			
			Button btnOk = new Button("se connecter...");
			add(btnOk, new AbsoluteData(85, 173));
			btnOk.setSize("90px", "24px");
			
			Button btnAnnuler = new Button("Annuler");
			btnAnnuler.addSelectionListener(new SelectionListener<ButtonEvent>() {
				public void componentSelected(ButtonEvent ce) {
					cntntpnlNewContentpanel_2.setVisible(false);
					cntntpnlNewContentpanel_1.setVisible(false);
					cntntpnlTousLesFonctions.setVisible(false);
					cntntpnlTousLesFonctions_1_1.setVisible(false);
					
					close();
					
				}
			});
			add(btnAnnuler, new AbsoluteData(264, 173));
			btnAnnuler.setSize("72px", "24px");
			
			Image image = new Image("resources/desktop/images/uuthentification.png");
			add(image, new AbsoluteData(6, 88));
			image.setSize("62px", "69px");
			
			Image image_1 = new Image("resources/desktop/images/Identification.png");
			add(image_1, new AbsoluteData(6, 6));
			image_1.setSize("378px", "46px");
			
			final TextField<String> txtfldNewTextfield = new TextField<String>();
			txtfldNewTextfield.setAllowBlank(false);
			txtfldNewTextfield.getMessages().setBlankText("Insérez login");
			
			add(txtfldNewTextfield, new AbsoluteData(175, 88));
			txtfldNewTextfield.setSize("161px", "22px");
			txtfldNewTextfield.setFieldLabel("New TextField");
			
			
			/* CONNEXION GLOBAL */	
			final AsyncCallback<String> callback = new AsyncCallback<String>() {
				@Override
				public void onFailure(Throwable caught) {
				System.out.println("fail");
					GWT.log(caught.getMessage(),caught);
	 
				}
	 
				@Override
				public void onSuccess(String result) {
					// TODO Auto-generated method stub
				//	textBox.setText(result);
					//Window.alert("bravo");
					System.out.println("Vlauer de s:"+result);
				
				
				}
	 
			};

			greetingService.conBDD(callback);
			

			final AsyncCallback<String> authentification = new AsyncCallback<String>() 
			{
				@Override
				public void onFailure(Throwable caught) {
					MessageBox.alert("Erreur", "fail", null);
					GWT.log(caught.getMessage(),caught);
				}

				@Override
				public void onSuccess(String s) 
				{	
						if(s.equals("A"))
						{
							close();
						}
						else
						{
							if(s.equals("C"))
							{
								cntntpnlNewContentpanel_1.setVisible(false);
								cntntpnlTousLesFonctions.setVisible(false);
								close();
							}
							else
							{
								
								if(s.equals("E"))
								{
									cntntpnlNewContentpanel_2.setVisible(false);
									cntntpnlTousLesFonctions.setVisible(false);
									close();
								}
								else
								{

									if(s.equals("D"))
									{
										cntntpnlNewContentpanel_2.setVisible(false);
										cntntpnlNewContentpanel_1.setVisible(false);
										close();
									}
									else
									{
							
										MessageBox.alert("Erreur", "Login ou mot de passe incorrecte", null);
									}
										
								}
							}
							
						}		
							
						
				}
			};

			btnOk.addSelectionListener(new SelectionListener<ButtonEvent>() {
				public void componentSelected(ButtonEvent ce) {

					String loginUser = txtfldNewTextfield.getValue();

					   greetingService.authentifier(loginUser, motDePasse.getText(), authentification);
		
				  
					  
				}
			});



		}
	}
	
	
}
