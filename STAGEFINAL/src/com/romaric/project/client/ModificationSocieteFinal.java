package com.romaric.project.client;

import java.util.Date;

import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import com.extjs.gxt.ui.client.widget.layout.AbsoluteLayout;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.layout.AbsoluteData;
import com.extjs.gxt.ui.client.Style;
import com.extjs.gxt.ui.client.widget.form.TextArea;
import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.DateLabel;
import com.romaric.project.model.RechercheEntrepriseCode;
import com.extjs.gxt.ui.client.widget.form.NumberField;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import java.util.Collections;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import java.util.List;
import java.util.ArrayList;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.FieldEvent;

public class ModificationSocieteFinal extends Window {
	
	final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);
	final ListStore<RechercheEntrepriseCode> storeFindSoct = new ListStore<RechercheEntrepriseCode>();
	final List<RechercheEntrepriseCode> stocksFindSoct = new ArrayList<RechercheEntrepriseCode>();
	Number nif;

	public ModificationSocieteFinal() {
		setModal(true);
		setWidth(750);
		setHeight(433);
		setResizable(false);
		setBlinkModal(true);
		setOnEsc(false);
		setHeading("Accueil > Modification soci\u00E9t\u00E9");
		setLayout(new AbsoluteLayout());
		List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
		
		final ContentPanel cntntpnlValeurModifier = new ContentPanel();
		cntntpnlValeurModifier.setHeading("Valeur \u00E0 modifier");
		cntntpnlValeurModifier.setCollapsible(true);
		cntntpnlValeurModifier.setLayout(new AbsoluteLayout());
		
		LabelField lblfldModification = new LabelField("Modification:");
		cntntpnlValeurModifier.add(lblfldModification, new AbsoluteData(6, 26));
		
		final ListBox comboBox = new ListBox();
		cntntpnlValeurModifier.add(comboBox, new AbsoluteData(98, 23));
		comboBox.addItem("D\u00E9nomination");
		comboBox.addItem("Si\u00E8ge sociale");
		comboBox.addItem("Forme juridique");
		comboBox.addItem("Capital");
		comboBox.addItem("Activit\u00E9s");
		comboBox.addItem("G\u00E9rant");
		comboBox.addItem("RCS");
		comboBox.addItem("Instat");
		comboBox.setSize("159px", "22px");
		
		LabelField lblfldValeur = new LabelField("Valeur:");
		cntntpnlValeurModifier.add(lblfldValeur, new AbsoluteData(6, 74));
		
		final TextArea txtrNewTextarea = new TextArea();
		txtrNewTextarea.setAllowBlank(false);
		cntntpnlValeurModifier.add(txtrNewTextarea, new AbsoluteData(98, 60));
		txtrNewTextarea.setSize("159px", "42px");
		txtrNewTextarea.setFieldLabel("New TextArea");
		
		final NumberField nmbrfldNewNumberfield = new NumberField();
		cntntpnlValeurModifier.add(nmbrfldNewNumberfield, new AbsoluteData(98, 145));
		nmbrfldNewNumberfield.setSize("159px", "22px");
		nmbrfldNewNumberfield.setFieldLabel("New NumberField");
		
		LabelField lblfldMois = new LabelField("Mois:");
		cntntpnlValeurModifier.add(lblfldMois, new AbsoluteData(6, 148));
		
		LabelField lblfldAnne = new LabelField("Ann\u00E9e:");
		cntntpnlValeurModifier.add(lblfldAnne, new AbsoluteData(6, 186));
		
		final NumberField nmbrfldNewNumberfield_1 = new NumberField();
		cntntpnlValeurModifier.add(nmbrfldNewNumberfield_1, new AbsoluteData(98, 183));
		nmbrfldNewNumberfield_1.setSize("159px", "22px");
		nmbrfldNewNumberfield_1.setFieldLabel("New NumberField");
		
		LabelField lblfldDateDeModif = new LabelField("Date de modif.:");
		cntntpnlValeurModifier.add(lblfldDateDeModif, new AbsoluteData(6, 226));
		
		final DateField dtfldNewDatefield = new DateField();
		cntntpnlValeurModifier.add(dtfldNewDatefield, new AbsoluteData(98, 223));
		dtfldNewDatefield.setSize("159px", "22px");
		dtfldNewDatefield.setFieldLabel("New DateField");
		
		Button btnAjouter = new Button("Ajouter");
		cntntpnlValeurModifier.add(btnAjouter, new AbsoluteData(6, 283));
		btnAjouter.setSize("73px", "25px");
		
		Button btnNouveau = new Button("Nouveau");
		btnNouveau.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {

					txtrNewTextarea.setValue("");
					nmbrfldNewNumberfield.setRawValue("");
					nmbrfldNewNumberfield_1.setRawValue("");
					dtfldNewDatefield.setRawValue("");
				
			}
		});
		cntntpnlValeurModifier.add(btnNouveau, new AbsoluteData(184, 283));
		btnNouveau.setSize("73px", "25px");
		

		add(cntntpnlValeurModifier, new AbsoluteData(397, 18));
		cntntpnlValeurModifier.setSize("300px", "367px");
		
		ContentPanel cntntpnlRechercheDeLa = new ContentPanel();
		cntntpnlRechercheDeLa.setHeading("Recherche de la soci\u00E9t\u00E9");
		cntntpnlRechercheDeLa.setCollapsible(true);
		cntntpnlRechercheDeLa.setLayout(new AbsoluteLayout());
		
		FieldSet fldstCritreDeModification = new FieldSet();
		AbsoluteData ad_fldstCritreDeModification = new AbsoluteData(6, 18);
		ad_fldstCritreDeModification.setAnchorSpec("-15");
		cntntpnlRechercheDeLa.add(fldstCritreDeModification, ad_fldstCritreDeModification);
		fldstCritreDeModification.setLayout(new AbsoluteLayout());
		
		LabelField lblfldNif = new LabelField("NIF:");
		fldstCritreDeModification.add(lblfldNif, new AbsoluteData(0, 14));
		
		final NumberField nmbrfldNewNumberfield_2 = new NumberField();
		fldstCritreDeModification.add(nmbrfldNewNumberfield_2, new AbsoluteData(43, 14));
		nmbrfldNewNumberfield_2.setSize("159px", "22px");
		nmbrfldNewNumberfield_2.setFieldLabel("New NumberField");
		
		Button btnOk = new Button("OK");
		fldstCritreDeModification.add(btnOk, new AbsoluteData(230, 7));
		btnOk.setSize("73px", "25px");
		fldstCritreDeModification.setHeight("77px");
		fldstCritreDeModification.setHeading("Crit\u00E8re de modification");
		fldstCritreDeModification.setCollapsible(true);
		
		ColumnConfig clmncnfgDnomination = new ColumnConfig("denomination", "D\u00E9nomination", 150);
		configs.add(clmncnfgDnomination);
		
		ColumnConfig clmncnfgGrant = new ColumnConfig("gerant", "G\u00E9rant", 150);
		configs.add(clmncnfgGrant);
		
		Grid<RechercheEntrepriseCode> grid = new Grid<RechercheEntrepriseCode>(storeFindSoct, new ColumnModel(configs));
		cntntpnlRechercheDeLa.add(grid, new AbsoluteData(6, 128));
		grid.setSize("352px", "166px");
		grid.setBorders(true);
		

		add(cntntpnlRechercheDeLa, new AbsoluteData(6, 18));
		cntntpnlRechercheDeLa.setSize("371px", "367px");
		
		
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
		
		final AsyncCallback<String> callback1 = new AsyncCallback<String>() {
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
				

					int a = comboBox.getSelectedIndex();
					String text = comboBox.getItemText(a);
					
					String valeur = txtrNewTextarea.getValue();
					 
					String result = DateTimeFormat.getFormat("dd/MM/yyyy").format(dtfldNewDatefield.getValue());
					
					if(com.google.gwt.user.client.Window.confirm("Voulez-vous vraiment modifier ces informations?") == true)
					{
						greetingService.modificationSociete(text, result, valeur, nif+"", callback1);
				
					}
				
				
			}
		});
		
		btnOk.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {
				

					nif = nmbrfldNewNumberfield_2.getValue();
				
					storeFindSoct.removeAll();
					stocksFindSoct.clear();
					greetingService.findtEntreprise(nif+"", asyncCallbackFind);
			
				
			}
		});
		
		nmbrfldNewNumberfield_2.addListener(Events.Change, new Listener<FieldEvent>() {
			public void handleEvent(FieldEvent e) {
			
				
					greetingService.findtEntreprise(nif+"", asyncCallbackFind);
				
			}
		});


	}
}
