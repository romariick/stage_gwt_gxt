package com.romaric.project.client;

import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import com.extjs.gxt.ui.client.widget.layout.AbsoluteLayout;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Label;
import com.extjs.gxt.ui.client.widget.layout.AbsoluteData;
import com.extjs.gxt.ui.client.Style;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.form.TextArea;
import com.extjs.gxt.ui.client.widget.form.NumberField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.google.gwt.user.client.ui.ListBox;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.google.gwt.user.client.ui.DateLabel;
import com.romaric.project.model.RechercheEntrepriseCode;

public class ModificationSociete extends Window {
	final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);
	String sauvnationalite;
	public ModificationSociete() {
		
		
		
		setMinimizable(true);
		setResizable(false);
		setOnEsc(false);
		
		setWidth(627);
		setBlinkModal(true);
		setHeight(563);
		setHeading("Accueil > Modification soci\u00E9t\u00E9");
		setLayout(new AbsoluteLayout());
		
		Label lblDnomination = new Label("D\u00E9nomination:");
		add(lblDnomination, new AbsoluteData(16, 119));
		
		Label lblSigeSocial = new Label("Si\u00E8ge social:");
		add(lblSigeSocial, new AbsoluteData(16, 166));
		
		final TextArea txtrNewTextarea = new TextArea();
		add(txtrNewTextarea, new AbsoluteData(88, 152));
		txtrNewTextarea.setSize("181px", "51px");
		txtrNewTextarea.setFieldLabel("New TextArea");
		
		Label lblFormeJuridique = new Label("Forme juridique:");
		add(lblFormeJuridique, new AbsoluteData(7, 237));
		
		Label lblCapitalEnAr = new Label("Capital en Ar:");
		add(lblCapitalEnAr, new AbsoluteData(16, 304));
		
		final NumberField nmbrfldNewNumberfield = new NumberField();
		add(nmbrfldNewNumberfield, new AbsoluteData(88, 295));
		nmbrfldNewNumberfield.setFieldLabel("New NumberField");
		
		Label lblActivits = new Label("Activit\u00E9s:");
		add(lblActivits, new AbsoluteData(29, 364));
		
		final TextArea txtrNewTextarea_2 = new TextArea();
		add(txtrNewTextarea_2, new AbsoluteData(87, 337));
		txtrNewTextarea_2.setSize("181px", "51px");
		txtrNewTextarea_2.setFieldLabel("New TextArea");
		
		Label lblGrants = new Label("G\u00E9rants:");
		add(lblGrants, new AbsoluteData(33, 431));
		
		final TextArea txtrNewTextarea_3 = new TextArea();
		add(txtrNewTextarea_3, new AbsoluteData(88, 416));
		txtrNewTextarea_3.setSize("181px", "51px");
		txtrNewTextarea_3.setFieldLabel("New TextArea");
		
		Label lblModification = new Label("Modification:");
		add(lblModification, new AbsoluteData(324, 132));
		
		final TextArea txtrNewTextarea_4 = new TextArea();
		add(txtrNewTextarea_4, new AbsoluteData(405, 110));
		txtrNewTextarea_4.setSize("164px", "51px");
		txtrNewTextarea_4.setFieldLabel("New TextArea");
		
		Label lblRcs = new Label("RCS:");
		add(lblRcs, new AbsoluteData(337, 218));
		
		final TextArea txtrNewTextarea_5 = new TextArea();
		add(txtrNewTextarea_5, new AbsoluteData(405, 202));
		txtrNewTextarea_5.setSize("164px", "51px");
		txtrNewTextarea_5.setFieldLabel("New TextArea");
		
		Label lblInstat = new Label("Instat.:");
		add(lblInstat, new AbsoluteData(324, 304));
		
		final TextArea txtrNewTextarea_6 = new TextArea();
		add(txtrNewTextarea_6, new AbsoluteData(405, 290));
		txtrNewTextarea_6.setSize("164px", "51px");
		txtrNewTextarea_6.setFieldLabel("New TextArea");
		
		Label lblMoisDeModif = new Label("Mois de modif.:");
		add(lblMoisDeModif, new AbsoluteData(324, 394));
		
		final NumberField nmbrfldNewNumberfield_1 = new NumberField();
		add(nmbrfldNewNumberfield_1, new AbsoluteData(405, 394));
		nmbrfldNewNumberfield_1.setFieldLabel("New NumberField");
		
		Label lblAnne = new Label("Ann\u00E9e:");
		add(lblAnne, new AbsoluteData(326, 463));
		

		
		Button btnAjouter = new Button("Ajouter");

		add(btnAjouter, new AbsoluteData(137, 499));
		btnAjouter.setSize("101px", "25px");
		
		Button btnAnnuler = new Button("Annuler");
		btnAnnuler.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {
			}
		});
		add(btnAnnuler, new AbsoluteData(333, 500));
		btnAnnuler.setSize("101px", "24px");
		
		final NumberField nmbrfldNewNumberfield_2 = new NumberField();
		add(nmbrfldNewNumberfield_2, new AbsoluteData(405, 454));
		nmbrfldNewNumberfield_2.setFieldLabel("New NumberField");
		
		FieldSet fldstCritresDeModifications = new FieldSet();
		fldstCritresDeModifications.setLayout(new AbsoluteLayout());
		
		LabelField lblfldNrcs = new LabelField("NIF:");
		fldstCritresDeModifications.add(lblfldNrcs, new AbsoluteData(0, 0));
		
		final TextField txtfldNewTextfield = new TextField();
		fldstCritresDeModifications.add(txtfldNewTextfield, new AbsoluteData(113, 0));
		txtfldNewTextfield.setFieldLabel("New TextField");
		
		Button btnOk = new Button("OK");
		
		fldstCritresDeModifications.add(btnOk, new AbsoluteData(358, -5));
		add(fldstCritresDeModifications, new AbsoluteData(68, 17));
		fldstCritresDeModifications.setSize("487px", "62px");
		fldstCritresDeModifications.setHeading("Crit\u00E8re de modification");
		fldstCritresDeModifications.setCollapsible(true);
		
		final TextField<String> txtfldNewTextfield_1 = new TextField<String>();
		add(txtfldNewTextfield_1, new AbsoluteData(91, 110));
		txtfldNewTextfield_1.setFieldLabel("New TextField");
		
		final TextField<String> txtfldNewTextfield_2 = new TextField<String>();
		add(txtfldNewTextfield_2, new AbsoluteData(91, 231));
		txtfldNewTextfield_2.setFieldLabel("New TextField");
		
		Label lblNationalite = new Label("Nationalite:");
		add(lblNationalite, new AbsoluteData(16, 270));
		
		
		
		final AsyncCallback<RechercheEntrepriseCode[]> asyncCallbackFind = new AsyncCallback<RechercheEntrepriseCode[]>() 
		{
			@Override
			public void onFailure(Throwable caught) {
				
				GWT.log(caught.getMessage(),caught);
			}

			@Override
			public void onSuccess(RechercheEntrepriseCode[] s) {
				int i;
				
				for(i = 0; i < s.length; i++)
				{	
					txtfldNewTextfield_1.setValue(s[i].denomination);
					txtfldNewTextfield_2.setValue(s[i].fj);
					txtrNewTextarea_3.setValue(s[i].gerant);
					txtrNewTextarea.setValue(s[i].siege);
					
					txtrNewTextarea_2.setValue(s[i].activite);
					txtrNewTextarea_5.setValue(s[i].rcs);
					txtrNewTextarea_6.setValue(s[i].stat);
					sauvnationalite = s[i].nationalite;
				}
				
			}
		};
		

		
		
		btnOk.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {
				
				String val = (String) txtfldNewTextfield.getValue();
				
				greetingService.findtEntreprise(val, asyncCallbackFind);
				
				
			}
		});
		
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
				
				String denomination = txtfldNewTextfield_1.getValue();
				String siegesocial = txtrNewTextarea.getValue();
				String fj = txtfldNewTextfield_2.getValue();
				String activite = txtrNewTextarea_2.getValue();
				String gerant = txtrNewTextarea_3.getValue();
				String rcs = txtrNewTextarea_5.getValue();
				String stat = txtrNewTextarea_6.getValue();
				String modification = txtrNewTextarea_4.getValue();
				Number moismodif = nmbrfldNewNumberfield_1.getValue();
				Number anneeModif = nmbrfldNewNumberfield_2.getValue();
				String nif = (String) txtfldNewTextfield.getValue();
				
				//greetingService.ajout_societe(denomination, sauvnationalite, "Antsirabe", "Primaire", 100+"", fj, "capital_soct", "nationalite1", "apport1", "nationalite2", "apport2", gerant, "associes", activite, rcs, stat, "nif", "cp", "datesaisie", "combo", "mois", "annee", callback1);
			    greetingService.modificationSociete(modification, moismodif+"", anneeModif+"", nif, callback1);
				
				//greetingService.ajout_societe(denom_soct, ville, nationalite, secteur, siege_soct, fj_soct, capital_soct, nationalite1, apport1, nationalite2, apport2, gerant, associes, activite, rcs, stat, nif, cp, datesaisie, combo, mois, annee, asyncCallback)
				
			}
		});

	}
}
