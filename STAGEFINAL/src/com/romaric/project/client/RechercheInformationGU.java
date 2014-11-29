package com.romaric.project.client;

import com.extjs.gxt.ui.client.Registry;
import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.widget.Info;
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
import com.romaric.project.model.RechercheEntrepriseCode;

import java.util.List;
import java.util.ArrayList;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.FieldEvent;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.button.ToolButton;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;

public class RechercheInformationGU extends Window {
	
	 GreetingServiceAsync greetingService = GWT.create(GreetingService.class);
	
	/*Rechercher entreprise à partir nif*/
	 ListStore<RechercheEntrepriseCode> storeFindSoct = new ListStore<RechercheEntrepriseCode>();
	 List<RechercheEntrepriseCode> stocksFindSoct = new ArrayList<RechercheEntrepriseCode>();
	

	public RechercheInformationGU() {
		setModal(true);
		setBlinkModal(true);
		setResizable(false);
		setBlinkModal(true);
		setOnEsc(false);
		setWidth(661);
		setHeight(468);
		setHeading("Accueil > Recherche global");
		setLayout(new AbsoluteLayout());
		
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
					stocksFindSoct.add(s[i]);
				       
				}
				storeFindSoct.add(stocksFindSoct);
				
			}
		};
		List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
		
		ContentPanel cntntpnlNewContentpanel = new ContentPanel();
		cntntpnlNewContentpanel.setHeaderVisible(false);
		cntntpnlNewContentpanel.setHeading("New ContentPanel");
		cntntpnlNewContentpanel.setLayout(new AbsoluteLayout());
		
		ColumnConfig clmncnfgDnomination = new ColumnConfig("denomination", "D\u00E9nomination", 150);
		configs.add(clmncnfgDnomination);
		
		ColumnConfig clmncnfgSige = new ColumnConfig("siege", "Si\u00E8ge", 150);
		configs.add(clmncnfgSige);
		
		ColumnConfig clmncnfgCapital = new ColumnConfig("capital", "Capital", 150);
		configs.add(clmncnfgCapital);
		
		ColumnConfig clmncnfgFormeJuridique = new ColumnConfig("fj", "Forme juridique", 150);
		configs.add(clmncnfgFormeJuridique);
		
		final Grid<RechercheEntrepriseCode> grid = new Grid<RechercheEntrepriseCode>(storeFindSoct, new ColumnModel(configs));
		cntntpnlNewContentpanel.add(grid, new AbsoluteData(0, 6));
		grid.setSize("612px", "260px");
		grid.setBorders(true);
		
		ToolBar toolBar = new ToolBar();
		
		Button btnNouveau = new Button("Nouveau");
		toolBar.add(btnNouveau);
		btnNouveau.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {
				grid.getStore().removeAll();
			}
		});
		cntntpnlNewContentpanel.add(toolBar, new AbsoluteData(0, 268));
		toolBar.setSize("614px", "25px");
		add(cntntpnlNewContentpanel, new AbsoluteData(21, 101));
		cntntpnlNewContentpanel.setSize("620px", "301px");
		
		ContentPanel cntntpnlNewContentpanel_1 = new ContentPanel();
		cntntpnlNewContentpanel_1.setHeaderVisible(false);
		cntntpnlNewContentpanel_1.setHeading("New ContentPanel");
		cntntpnlNewContentpanel_1.setCollapsible(true);
		cntntpnlNewContentpanel_1.setLayout(new AbsoluteLayout());
		
		LabelField lblfldInsrezNomDe = new LabelField("Ins\u00E9rez nom de l'entreprise:");
		cntntpnlNewContentpanel_1.add(lblfldInsrezNomDe, new AbsoluteData(23, 17));
		
		final TextField<String> txtfldNewTextfield = new TextField<String>();
		cntntpnlNewContentpanel_1.add(txtfldNewTextfield, new AbsoluteData(198, 14));
		txtfldNewTextfield.setSize("159px", "22px");
		
		
				txtfldNewTextfield.setAllowBlank(false);
				txtfldNewTextfield.setFieldLabel("New TextField");
				
				Button btnOk = new Button("OK");
				cntntpnlNewContentpanel_1.add(btnOk, new AbsoluteData(386, 17));
				btnOk.setSize("60px", "22px");
				
						
						
						
						btnOk.addSelectionListener(new SelectionListener<ButtonEvent>() {
							public void componentSelected(ButtonEvent ce) {
								
								
								
									String textNom = txtfldNewTextfield.getValue();
									stocksFindSoct.clear();
									storeFindSoct.removeAll();
									greetingService.findtEntrepriseApartirNomGlobal(textNom, asyncCallbackFindEnste);
									
							}
						});
				
				txtfldNewTextfield.addListener(Events.Change, new Listener<FieldEvent>() {
					public void handleEvent(FieldEvent e) {

					}
				});
				
				
				txtfldNewTextfield.addListener(Events.KeyPress, new Listener<FieldEvent>() {
					public void handleEvent(FieldEvent e) {
						
						
						
					String textNom = txtfldNewTextfield.getValue();
					
					
					stocksFindSoct.clear();
					storeFindSoct.removeAll();
					greetingService.findtEntrepriseApartirNomGlobal(textNom, asyncCallbackFindEnste);
						
					}
				});
		add(cntntpnlNewContentpanel_1, new AbsoluteData(143, 16));
		cntntpnlNewContentpanel_1.setSize("478px", "50px");
		
		
		/*Rechercher à partir nom **/
		

	}
}
