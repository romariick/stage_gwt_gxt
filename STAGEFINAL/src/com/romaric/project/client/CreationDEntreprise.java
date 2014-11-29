package com.romaric.project.client;


import java.sql.Date;
import java.util.ArrayList;

import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.TabPanel;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.layout.AbsoluteLayout;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.layout.AbsoluteData;
import com.extjs.gxt.ui.client.Style;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.form.TextArea;
import com.extjs.gxt.ui.client.widget.form.NumberField;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.DateTimeFormat.PredefinedFormat;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Label;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.widget.form.SimpleComboBox;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.NumberLabel;
import com.google.gwt.user.client.ui.IntegerBox;
import com.romaric.project.model.Nationalite;
import com.extjs.gxt.ui.client.widget.ContentPanel;


public class CreationDEntreprise extends Window {

	public CreationDEntreprise() {
		setResizable(false);
		setOnEsc(false);
		
		final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);
		
		final ArrayList<String[]> values = new ArrayList<String[]>();
		
		setFiresEvents(true);
		setWidth(939);
		setHeight(537);
		setBlinkModal(true);
		setHeading("Accueil > Ajouter soci\u00E9t\u00E9");
		setLayout(new AbsoluteLayout());
		
		TabPanel tabPanel = new TabPanel();
		
		TabItem tbtmAjoutSocit = new TabItem("Ajout Soci\u00E9t\u00E9");
		tbtmAjoutSocit.setLayout(new AbsoluteLayout());
		
		final FormPanel frmpnlNewFormpanel = new FormPanel();
		frmpnlNewFormpanel.setHeading("Ajout soci\u00E9t\u00E9 > Informations");
		frmpnlNewFormpanel.setLayout(new AbsoluteLayout());
		
		final TextField<String> txtfldNewTextfield_5 = new TextField<String>();
		txtfldNewTextfield_5.setAllowBlank(false);
		frmpnlNewFormpanel.add(txtfldNewTextfield_5, new AbsoluteData(105, 20));
		txtfldNewTextfield_5.setSize("159px", "22px");
		txtfldNewTextfield_5.setFieldLabel("New TextField");
		
		LabelField lblfldDenomination = new LabelField("D\u00E9nomination:");
		frmpnlNewFormpanel.add(lblfldDenomination, new AbsoluteData(6, 20));
		
		final TextArea txtrNewTextarea = new TextArea();
		txtrNewTextarea.setAllowBlank(false);
		frmpnlNewFormpanel.add(txtrNewTextarea, new AbsoluteData(105, 70));
		txtrNewTextarea.setSize("159px", "42px");
		txtrNewTextarea.setFieldLabel("New TextArea");
		
		LabelField lblfldSiegeSocial = new LabelField("Si\u00E8ge social:");
		frmpnlNewFormpanel.add(lblfldSiegeSocial, new AbsoluteData(6, 83));
		
		final ListBox comboBox_5 = new ListBox();
		comboBox_5.addItem("Antananarivo");
		comboBox_5.addItem("Fianarantsoa");
		comboBox_5.addItem("Antsirabe");
		comboBox_5.addItem("Diego");
		comboBox_5.addItem("Fort-Dauphin");
		comboBox_5.addItem("Majunga");
		comboBox_5.addItem("Nosy-Be");
		comboBox_5.addItem("Tamatave");
		comboBox_5.addItem("Tul\u00E9ar");
		frmpnlNewFormpanel.add(comboBox_5, new AbsoluteData(105, 128));
		comboBox_5.setSize("159px", "22px");
		
		LabelField lblfldVille = new LabelField("Ville:");
		frmpnlNewFormpanel.add(lblfldVille, new AbsoluteData(20, 128));
		
		final ListBox comboBox_1 = new ListBox();
		frmpnlNewFormpanel.add(comboBox_1, new AbsoluteData(105, 183));
		
		comboBox_1.addItem("SARL");
		comboBox_1.addItem("SA");
		comboBox_1.addItem("GIE");
		comboBox_1.addItem("EURL");
		comboBox_1.addItem("SAU");
		comboBox_1.addItem("SCI");
		comboBox_1.addItem("SNC");
		comboBox_1.setSize("159px", "22px");
		
		LabelField lblfldFormeJuridique = new LabelField("Forma juridique:");
		frmpnlNewFormpanel.add(lblfldFormeJuridique, new AbsoluteData(13, 186));
		
		final NumberField nmbrfldNewNumberfield = new NumberField();
		nmbrfldNewNumberfield.setAllowBlank(false);
		frmpnlNewFormpanel.add(nmbrfldNewNumberfield, new AbsoluteData(105, 251));
		nmbrfldNewNumberfield.setSize("159px", "22px");
		nmbrfldNewNumberfield.setFieldLabel("New NumberField");
		
		LabelField lblfldCapital = new LabelField("Capital [Ar]:");
		frmpnlNewFormpanel.add(lblfldCapital, new AbsoluteData(19, 254));
		
		final ListBox comboBox = new ListBox();
		frmpnlNewFormpanel.add(comboBox, new AbsoluteData(105, 300));
		comboBox.setSize("159px", "22px");
		
		LabelField lblfldNationalite = new LabelField("Nationalit\u00E9 1:");
		frmpnlNewFormpanel.add(lblfldNationalite, new AbsoluteData(13, 303));
		
		final NumberField nmbrfldNewNumberfield_1 = new NumberField();
		nmbrfldNewNumberfield_1.setAllowBlank(false);
		frmpnlNewFormpanel.add(nmbrfldNewNumberfield_1, new AbsoluteData(105, 349));
		nmbrfldNewNumberfield_1.setSize("159px", "22px");
		nmbrfldNewNumberfield_1.setFieldLabel("New NumberField");
		
		LabelField lblfldApport = new LabelField("Apport 1 [Ar]:");
		frmpnlNewFormpanel.add(lblfldApport, new AbsoluteData(19, 349));
		
		final ListBox comboBox_4 = new ListBox();
		frmpnlNewFormpanel.add(comboBox_4, new AbsoluteData(438, 20));
		comboBox_4.setSize("159px", "22px");
		
		LabelField lblfldNationalite_1 = new LabelField("Nationalit\u00E9 2:");
		frmpnlNewFormpanel.add(lblfldNationalite_1, new AbsoluteData(337, 23));
		
		final NumberField nmbrfldNewNumberfield_2 = new NumberField();
		nmbrfldNewNumberfield_2.setAllowBlank(false);
		frmpnlNewFormpanel.add(nmbrfldNewNumberfield_2, new AbsoluteData(438, 83));
		nmbrfldNewNumberfield_2.setSize("159px", "22px");
		nmbrfldNewNumberfield_2.setFieldLabel("New NumberField");
		
		LabelField lblfldApport_1 = new LabelField("Apport 2[Ar]:");
		frmpnlNewFormpanel.add(lblfldApport_1, new AbsoluteData(334, 83));
		
		final TextArea txtrNewTextarea_1 = new TextArea();
		txtrNewTextarea_1.setAllowBlank(false);
		frmpnlNewFormpanel.add(txtrNewTextarea_1, new AbsoluteData(438, 128));
		txtrNewTextarea_1.setSize("159px", "42px");
		txtrNewTextarea_1.setFieldLabel("New TextArea");
		
		LabelField lblfldLesGerants = new LabelField("Les g\u00E9rants:");
		frmpnlNewFormpanel.add(lblfldLesGerants, new AbsoluteData(337, 142));
		
		final TextArea txtrNewTextarea_2 = new TextArea();
		txtrNewTextarea_2.setAllowBlank(false);
		frmpnlNewFormpanel.add(txtrNewTextarea_2, new AbsoluteData(438, 183));
		txtrNewTextarea_2.setSize("159px", "42px");
		txtrNewTextarea_2.setFieldLabel("New TextArea");
		
		LabelField lblfldLesAssocies = new LabelField("Les associes:");
		frmpnlNewFormpanel.add(lblfldLesAssocies, new AbsoluteData(337, 199));
		
		LabelField lblfldActivites = new LabelField("Activit\u00E9s:");
		frmpnlNewFormpanel.add(lblfldActivites, new AbsoluteData(337, 251));
		
		final TextArea txtrNewTextarea_3 = new TextArea();
		txtrNewTextarea_3.setAllowBlank(false);
		frmpnlNewFormpanel.add(txtrNewTextarea_3, new AbsoluteData(438, 238));
		txtrNewTextarea_3.setSize("159px", "42px");
		txtrNewTextarea_3.setFieldLabel("New TextArea");
		
		LabelField lblfldCodeActivites = new LabelField("Code activit\u00E9s:");
		frmpnlNewFormpanel.add(lblfldCodeActivites, new AbsoluteData(337, 300));
		
		final ListBox comboBox_2 = new ListBox();
		comboBox_2.addItem("Import export");
		comboBox_2.addItem("Elevage - p\u00EAche - agriculture");
		comboBox_2.addItem("Artisanat");
		comboBox_2.addItem("Lapidairerie - mine");
		comboBox_2.addItem("NTIC");
		comboBox_2.addItem("Exploitation mini\u00E8re");
		frmpnlNewFormpanel.add(comboBox_2, new AbsoluteData(438, 300));
		comboBox_2.setSize("159px", "22px");
		
		LabelField lblfldSecteurs = new LabelField("Secteurs:");
		frmpnlNewFormpanel.add(lblfldSecteurs, new AbsoluteData(337, 349));
		
		final ListBox comboBox_3 = new ListBox();
		frmpnlNewFormpanel.add(comboBox_3, new AbsoluteData(438, 349));
		comboBox_3.addItem("Primaire");
		comboBox_3.addItem("Secondaire");
		comboBox_3.addItem("Tertiaire");
		comboBox_3.setSize("159px", "22px");
		
		LabelField lblfldNRcs = new LabelField("N\u00B0 RCS:");
		frmpnlNewFormpanel.add(lblfldNRcs, new AbsoluteData(641, 20));
		
		final TextArea txtrNewTextarea_4 = new TextArea();
		txtrNewTextarea_4.setAllowBlank(false);
		frmpnlNewFormpanel.add(txtrNewTextarea_4, new AbsoluteData(717, 20));
		txtrNewTextarea_4.setSize("159px", "42px");
		txtrNewTextarea_4.setFieldLabel("New TextArea");
		
		LabelField lblfldNStatisitque = new LabelField("N\u00B0 Stat:");
		frmpnlNewFormpanel.add(lblfldNStatisitque, new AbsoluteData(639, 93));
		
		final TextArea txtrNewTextarea_5 = new TextArea();
		txtrNewTextarea_5.setAllowBlank(false);
		frmpnlNewFormpanel.add(txtrNewTextarea_5, new AbsoluteData(717, 77));
		txtrNewTextarea_5.setSize("155px", "42px");
		txtrNewTextarea_5.setFieldLabel("New TextArea");
		
		LabelField lblfldNif = new LabelField("NIF:");
		frmpnlNewFormpanel.add(lblfldNif, new AbsoluteData(646, 142));
		
		final TextArea txtrNewTextarea_6 = new TextArea();
		txtrNewTextarea_6.setAllowBlank(false);
		frmpnlNewFormpanel.add(txtrNewTextarea_6, new AbsoluteData(717, 142));
		txtrNewTextarea_6.setSize("159px", "42px");
		txtrNewTextarea_6.setFieldLabel("New TextArea");
		
		final TextArea txtrNewTextarea_7 = new TextArea();
		txtrNewTextarea_7.setAllowBlank(false);
		frmpnlNewFormpanel.add(txtrNewTextarea_7, new AbsoluteData(717, 209));
		txtrNewTextarea_7.setSize("159px", "42px");
		txtrNewTextarea_7.setFieldLabel("New TextArea");
		
		LabelField lblfldCp = new LabelField("CP");
		frmpnlNewFormpanel.add(lblfldCp, new AbsoluteData(654, 217));
		
		LabelField lblfldDate = new LabelField("Date:");
		frmpnlNewFormpanel.add(lblfldDate, new AbsoluteData(654, 300));
		
		final DateField dtfldNewDatefield = new DateField();
		frmpnlNewFormpanel.add(dtfldNewDatefield, new AbsoluteData(717, 300));
		dtfldNewDatefield.setSize("159px", "22px");
		dtfldNewDatefield.setFieldLabel("New DateField");
		
		Button btnAjouter = new Button("Ajouter");
		frmpnlNewFormpanel.add(btnAjouter, new AbsoluteData(20, 394));
		btnAjouter.setSize("69px", "24px");
		
		Button btnNouveau = new Button("Nouveau");
		frmpnlNewFormpanel.add(btnNouveau, new AbsoluteData(124, 394));
		btnNouveau.setSize("68px", "24px");
		btnNouveau.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {
				
				
					frmpnlNewFormpanel.reset();
				
				
			}
		});
		

		tbtmAjoutSocit.add(frmpnlNewFormpanel, new AbsoluteData(6, 6));
		frmpnlNewFormpanel.setSize("905px", "465px");
		tabPanel.add(tbtmAjoutSocit);
		tbtmAjoutSocit.setSize("904px", "594px");
		add(tabPanel, new AbsoluteData(0, 0));
		tabPanel.setSize("919px", "638px");
		
		final AsyncCallback<Nationalite[]> callbackListe = new AsyncCallback<Nationalite[]>() 
		{
			@Override
			public void onFailure(Throwable caught) {
				
			
				
				GWT.log(caught.getMessage(),caught);
			}

			@Override
			public void onSuccess(Nationalite[] s) {
								
			
				
				for(int i = 0; i < s.length; i++)
				{	
					comboBox.addItem(s[i].nationalite);
					comboBox_4.addItem(s[i].nationalite);
				}
				
			}
		};
		greetingService.getListeNationalite(callbackListe);


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
				
			
				int i = comboBox_1.getSelectedIndex();
				String fj = comboBox_1.getItemText(i);
				
				//Capital
				Number capital = nmbrfldNewNumberfield.getValue();
				String captl = ""+capital;

				//Nationalite
				int indexNat = comboBox.getSelectedIndex();
				String nationl = comboBox.getItemText(indexNat);

				//Apport 1
				Number apprt1 = nmbrfldNewNumberfield_1.getValue();
				String apport1 = ""+apprt1;
				System.out.println("Mandeha eto");
				
				//Nationalité 2
				
				int nt2 = comboBox_4.getSelectedIndex();
				String natinlt2 = comboBox_4.getItemText(nt2);
				
				//Apport 2
				Number apprt2 = nmbrfldNewNumberfield_2.getValue();
				String apt2 = ""+apprt2;
				
				//Code d'activite
				int codAT = comboBox_2.getSelectedIndex();
				String codeActivite = comboBox_2.getItemText(codAT);
				
				//Secteur
				int sect = comboBox_3.getSelectedIndex();
				String sectR = comboBox_3.getItemText(sect);
				
				//Ville
				int vil = comboBox_5.getSelectedIndex();
				String ville = comboBox_5.getItemText(vil);
			
				//Secteur
				int sectr = comboBox_3.getSelectedIndex();
				String secteur = comboBox_3.getItemText(sectr);
				
				// Code activite
				int combo = comboBox_2.getSelectedIndex();
				String txtCombo = comboBox_2.getItemText(combo);
			
				
				
				String result = DateTimeFormat.getFormat("dd/MM/yyyy").format(dtfldNewDatefield.getValue());

				
				String moisRet = result.substring(3, 5);
				
				
				int moisRecupr = Integer.parseInt(moisRet);
				String an = result.substring(6, 10);
				
				//MessageBox.info("formaat Mois:"+mois2 +"annee:"+annee2, result, null);
				if(com.google.gwt.user.client.Window.confirm("Voulez-vous vraiment ajouter ces informations?") == true)
				{

				greetingService.ajout_societe(txtfldNewTextfield_5.getValue(),
						nationl,
						ville,
						secteur,
						txtrNewTextarea.getValue(),						
						fj, 
						captl, 
						nationl, 
						apport1, 
						natinlt2, 
						apt2, 
						txtrNewTextarea_1.getValue(), 
						txtrNewTextarea_2.getValue(),
						txtrNewTextarea_3.getValue(),
						txtrNewTextarea_4.getValue(),
						txtrNewTextarea_5.getValue(), 
						txtrNewTextarea_6.getValue(), 
						txtrNewTextarea_7.getValue(),
						result,
						txtCombo,
						moisRecupr+"",
						an,
						callback1);
				}
				 }
			
			
		});
		
	}
}
