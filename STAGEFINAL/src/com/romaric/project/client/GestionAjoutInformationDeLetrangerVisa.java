package com.romaric.project.client;

import java.util.Date;

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import com.extjs.gxt.ui.client.widget.layout.AbsoluteLayout;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.layout.AbsoluteData;
import com.extjs.gxt.ui.client.Style;
import com.extjs.gxt.ui.client.widget.form.FormPanel.Encoding;
import com.extjs.gxt.ui.client.widget.form.NumberField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.form.TextArea;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.InputElement;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Image;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.google.gwt.user.client.ui.ListBox;

import com.extjs.gxt.ui.client.widget.form.FileUploadField;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.FieldEvent;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.FormPanel.Method;
import com.google.gwt.event.dom.client.LoadHandler;
import com.google.gwt.event.dom.client.LoadEvent;
import com.romaric.project.Visa.MonService;
import com.romaric.project.Visa.MonServiceAsync;
import com.romaric.project.model.ModificationClient;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.google.gwt.user.client.ui.Frame;

public class GestionAjoutInformationDeLetrangerVisa extends Window {
	
	final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);
	final MonServiceAsync monServ = GWT.create(MonService.class);

	final FileUploadField flpldfldNewFileuploadfield = new FileUploadField();
	  final FileUploadField file = new FileUploadField();  
	  final FormPanel panel = new FormPanel();  
	public GestionAjoutInformationDeLetrangerVisa() {
		setModal(true);
		setResizable(false);
		setOnEsc(false);
		setWidth(865);
		setHeight(593);
		setBlinkModal(true);
		setHeading("Accueil > Gestion information \u00E9tranger");
		setLayout(new AbsoluteLayout());
		

		 final TextArea txtrNewTextarea_1 = new TextArea();
		 final TextArea txtrNewTextarea_2 = new TextArea();
		 final TextArea txtrNewTextarea_3 = new TextArea();
		 final TextArea txtrNewTextarea_4 = new TextArea();
		 final TextArea txtrNewTextarea_5 = new TextArea();
		 final TextArea txtrNewTextarea_6 = new TextArea();
		 
		flpldfldNewFileuploadfield.setSelectOnFocus(true);
		flpldfldNewFileuploadfield.addListener(Events.Change, new Listener<FieldEvent>() {
			public void handleEvent(FieldEvent e) {
				
				
			}
		});
		flpldfldNewFileuploadfield.setAllowBlank(false);  
		flpldfldNewFileuploadfield.setName("uploadedfile");  
		flpldfldNewFileuploadfield.setFieldLabel("Chemin");
		

		
		LabelField lblfldNomDeLtranger = new LabelField("Nom de l'\u00E9tranger:");
		add(lblfldNomDeLtranger, new AbsoluteData(18, 18));

		LabelField lblfldDateEtLieu = new LabelField("Date et lieu de naiss.:");
		add(lblfldDateEtLieu, new AbsoluteData(6, 85));
		lblfldDateEtLieu.setSize("106px", "14px");

		LabelField lblfldNPasseport = new LabelField("N\u00B0 Passeport:");
		add(lblfldNPasseport, new AbsoluteData(18, 132));
		
		final TextField<String> txtfldNewTextfield = new TextField<String>();
		txtfldNewTextfield.setAllowBlank(false);
		add(txtfldNewTextfield, new AbsoluteData(133, 18));
		txtfldNewTextfield.setSize("159px", "22px");
		txtfldNewTextfield.setFieldLabel("New TextField");
		
		LabelField lblfldDlivrance = new LabelField("D\u00E9livrance:");
		add(lblfldDlivrance, new AbsoluteData(18, 174));
		
		final DateField dtfldNewDatefield = new DateField();
		add(dtfldNewDatefield, new AbsoluteData(133, 171));
		dtfldNewDatefield.setSize("159px", "22px");
		dtfldNewDatefield.setFieldLabel("New DateField");
		
		LabelField lblfldExpiration = new LabelField("Expiration:");
		add(lblfldExpiration, new AbsoluteData(20, 208));
		
		final DateField dtfldNewDatefield_1 = new DateField();
		add(dtfldNewDatefield_1, new AbsoluteData(133, 205));
		dtfldNewDatefield_1.setSize("159px", "22px");
		dtfldNewDatefield_1.setFieldLabel("New DateField");
		
		LabelField lblfldAdresse = new LabelField("Adresse:");
		add(lblfldAdresse, new AbsoluteData(18, 253));
		
		LabelField lblfldTlphone = new LabelField("T\u00E9l\u00E9phone:");
		add(lblfldTlphone, new AbsoluteData(18, 298));
		
		final NumberField nmbrfldNewNumberfield_2 = new NumberField();
		nmbrfldNewNumberfield_2.setAllowBlank(false);
		add(nmbrfldNewNumberfield_2, new AbsoluteData(133, 295));
		nmbrfldNewNumberfield_2.setSize("159px", "22px");
		nmbrfldNewNumberfield_2.setFieldLabel("New NumberField");
		
		LabelField lblfldProfession = new LabelField("Profession:");
		add(lblfldProfession, new AbsoluteData(18, 334));
		
		LabelField lblfldSociete = new LabelField("Soci\u00E9t\u00E9:");
		add(lblfldSociete, new AbsoluteData(18, 373));
		
		LabelField lblfldActivits = new LabelField("Activit\u00E9s");
		add(lblfldActivits, new AbsoluteData(18, 434));
		lblfldActivits.setSize("59px", "14px");
		
		LabelField lblfldCapitalEnAr = new LabelField("Capital:");
		add(lblfldCapitalEnAr, new AbsoluteData(362, 331));
		
		final NumberField nmbrfldNewNumberfield_3 = new NumberField();
		nmbrfldNewNumberfield_3.setAllowBlank(false);
		add(nmbrfldNewNumberfield_3, new AbsoluteData(477, 321));
		nmbrfldNewNumberfield_3.setSize("159px", "22px");
		nmbrfldNewNumberfield_3.setFieldLabel("New NumberField");
		
		LabelField lblfldSteAdresse = new LabelField("Ste Adresse:");
		add(lblfldSteAdresse, new AbsoluteData(362, 239));
		
		LabelField lblfldRfrenceVisa = new LabelField("R\u00E9f\u00E9rence Visa:");
		add(lblfldRfrenceVisa, new AbsoluteData(362, 283));
		
		LabelField lblfldAvisFavorable = new LabelField("Avis Favorable:");
		add(lblfldAvisFavorable, new AbsoluteData(362, 193));
		
		LabelField lblfldObsEnquteur = new LabelField("Observation:");
		add(lblfldObsEnquteur, new AbsoluteData(362, 376));
		
		final TextArea txtrNewTextarea = new TextArea();
		txtrNewTextarea.setAllowBlank(false);
		add(txtrNewTextarea, new AbsoluteData(477, 359));
		txtrNewTextarea.setSize("159px", "42px");
		txtrNewTextarea.setFieldLabel("New TextArea");
		
		LabelField lblfldTypeDeLtranger = new LabelField("Type de l'\u00E9tranger:");
		add(lblfldTypeDeLtranger, new AbsoluteData(362, 18));
		
		LabelField lblfldNationalit = new LabelField("Nationalit\u00E9:");
		add(lblfldNationalit, new AbsoluteData(362, 55));
		
		LabelField lblfldSituationMat = new LabelField("Situation mat.");
		add(lblfldSituationMat, new AbsoluteData(362, 99));
		
		LabelField lblfldEmail = new LabelField("E-mail:");
		add(lblfldEmail, new AbsoluteData(362, 145));
		
		final TextField<String> txtfldNewTextfield_7 = new TextField<String>();
		txtfldNewTextfield_7.setAllowBlank(false);
		add(txtfldNewTextfield_7, new AbsoluteData(477, 142));
		txtfldNewTextfield_7.setSize("159px", "22px");
		txtfldNewTextfield_7.setFieldLabel("New TextField");
		
		final AsyncCallback<String> callback2 = new AsyncCallback<String>() {
			@Override
			public void onFailure(Throwable caught) {
				MessageBox.info("Affichage d'erreur", "Erreur d'enregistrement!", null);		
			}
 
			@Override
			public void onSuccess(String result) {
				
	
				
				AffichagePDFDetailsVisa aff = new AffichagePDFDetailsVisa();
				aff.show();
	
			

				
			}
		};		
		
		final ListBox comboBox = new ListBox();
		comboBox.addItem("Oui");
		comboBox.addItem("Non");
		add(comboBox, new AbsoluteData(477, 190));
		comboBox.setSize("159px", "22px");
		
		final ListBox comboBox_1 = new ListBox();
		comboBox_1.addItem("Renouvellement");
		comboBox_1.addItem("Demande");
		add(comboBox_1, new AbsoluteData(477, 283));
		comboBox_1.setSize("159px", "22px");
		
		final ListBox comboBox_2 = new ListBox();
		comboBox_2.addItem("Mari\u00E9");
		comboBox_2.addItem("C\u00E9libataire");
		add(comboBox_2, new AbsoluteData(477, 99));
		comboBox_2.setSize("159px", "22px");
		
		final ListBox comboBox_3 = new ListBox();
		comboBox_3.addItem("Fran\u00E7ais");
		comboBox_3.addItem("Anglais");
		comboBox_3.addItem("Malgache");
		add(comboBox_3, new AbsoluteData(477, 52));
		comboBox_3.setSize("159px", "22px");
		
		final ListBox comboBox_4 = new ListBox();
		comboBox_4.addItem("Investisseur");
		comboBox_4.addItem("Travailleur");
		comboBox_4.addItem("Regroupement famial");
		add(comboBox_4, new AbsoluteData(477, 15));
		comboBox_4.setSize("159px", "22px");
		
		final TextField<String> txtfldNewTextfield_8 = new TextField<String>();
		txtfldNewTextfield_8.setAllowBlank(false);
		add(txtfldNewTextfield_8, new AbsoluteData(133, 132));
		txtfldNewTextfield_8.setSize("159px", "22px");
		txtfldNewTextfield_8.setFieldLabel("New TextField");
		
		LabelField lblfldVille = new LabelField("Ville:");
		add(lblfldVille, new AbsoluteData(18, 52));
		
		final ListBox comboBox_5 = new ListBox();
		comboBox_5.addItem("Fianarantsoa");
		comboBox_5.addItem("Antananarivo");
		comboBox_5.addItem("Antsirabe");
		add(comboBox_5, new AbsoluteData(133, 52));
		comboBox_5.setSize("159px", "22px");
		
		FieldSet fldstOptions = new FieldSet();
		fldstOptions.setExpanded(false);
		fldstOptions.setCollapsible(true);
		fldstOptions.setWidth(300);
		fldstOptions.setHeight(200);
		fldstOptions.setLayout(new AbsoluteLayout());
		
		LabelField lblfldInsrezNumPassport = new LabelField("Ins\u00E9rez num. Passeport pour modiefier  un \u00E9tranger.");
		fldstOptions.add(lblfldInsrezNumPassport, new AbsoluteData(18, 0));
		
		final TextField<String> txtfldNewTextfield_9 = new TextField<String>();
		fldstOptions.add(txtfldNewTextfield_9, new AbsoluteData(18, 53));
		txtfldNewTextfield_9.setFieldLabel("New TextField");
		
		Button btnOk = new Button("OK");

		fldstOptions.add(btnOk, new AbsoluteData(59, 81));
		btnOk.setSize("60px", "24px");
		add(fldstOptions, new AbsoluteData(651, 15));
		fldstOptions.setSize("190px", "145px");
		fldstOptions.setHeading("Option:");
		
		FieldSet fldstActions = new FieldSet();
		fldstActions.setWidth(200);
		fldstActions.setHeight(400);
		fldstActions.setLayout(new AbsoluteLayout());
		
				
				Button btnAfficherDtails = new Button("Afficher d\u00E9tails");
				fldstActions.add(btnAfficherDtails, new AbsoluteData(387, 0));
				btnAfficherDtails.setSize("86px", "25px");
				
				Button btnNouveau = new Button("Nouveau");
				fldstActions.add(btnNouveau, new AbsoluteData(248, 0));
				btnNouveau.addSelectionListener(new SelectionListener<ButtonEvent>() {
					public void componentSelected(ButtonEvent ce) {
						
					//	frmpnlPhoto.submit();
		
						txtfldNewTextfield.setValue("");
						comboBox_5.setValue(0, "");
						txtrNewTextarea_1.setValue("");
						txtfldNewTextfield_8.setValue("");
						dtfldNewDatefield.setRawValue("");
						dtfldNewDatefield_1.setRawValue("");
						txtrNewTextarea_2.setValue("");
						nmbrfldNewNumberfield_2.setRawValue("");
						txtrNewTextarea_3.setValue("");
						txtrNewTextarea_4.setValue("");
						
						txtrNewTextarea_5.setValue("");
						nmbrfldNewNumberfield_3.setRawValue("");
						 txtrNewTextarea_6.setValue("");
						txtrNewTextarea.setValue("");
						txtfldNewTextfield_7.setValue("");
						
						
					}
				});
				btnNouveau.setSize("86px", "25px");
				
				Button btnModifier = new Button("Modifier");
				fldstActions.add(btnModifier, new AbsoluteData(121, 0));

				btnModifier.setSize("86px", "25px");
				
				Button btnEnregistrer = new Button("Enregistrer");
				
				
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
				
				fldstActions.add(btnEnregistrer, new AbsoluteData(0, 0));
				btnEnregistrer.setSize("86px", "25px");
				
						btnEnregistrer.addSelectionListener(new SelectionListener<ButtonEvent>() {
							public void componentSelected(ButtonEvent ce) {
								 panel.submit();  

									
									
								//Nom et prénom de l'étranger
								String nomEtPrenom = (String) txtfldNewTextfield.getValue();
								
								 
								
								//Date et lieu de naisssance de l'étranger
								String dateEtLieuxNaiss = (String) txtrNewTextarea_1.getValue();
								
								
								//Numéro Passport
								String numPassport = (String) txtfldNewTextfield_8.getValue();
								
								//Délivrance
								String delivrance = DateTimeFormat.getFormat("yyyy-MM-dd").format(dtfldNewDatefield.getValue());
								//String delivrance = DateTimeFormat.getFormat("dd/MM/yyyy").format(dtfldNewDatefield.getValue());
								
								
								//Expération
								String expiration = DateTimeFormat.getFormat("yyyy-MM-dd").format(dtfldNewDatefield_1.getValue());
								
								
								
								//Adresse
								String adresse = (String) txtrNewTextarea_2.getValue();
								
								//Téléphone
								Number telephone = nmbrfldNewNumberfield_2.getValue();
								
								//Profession
								String profession = (String) txtrNewTextarea_3.getValue();
								
								//Société
								String societe = (String) txtrNewTextarea_4.getValue();
								
								//Activités
								
								String activite = (String) txtrNewTextarea_5.getValue();
								
								//Capital
								Number capital = nmbrfldNewNumberfield_3.getValue();
								
								//Societe adresse
								
								String adresseSociete = (String)  txtrNewTextarea_6.getValue();
								
								//Réference visa
								int a =  comboBox_1.getSelectedIndex();
								String renouvellement = comboBox_1.getItemText(a);
								
								
								//Avis favorable
								int b = comboBox.getSelectedIndex();
								String avis = comboBox.getItemText(b);
								
								
								//Observation enquêteur
								
								String observation = txtrNewTextarea.getValue();
								
							//Type de l'etranger
								int c = comboBox_4.getSelectedIndex();
								String typeetrange = comboBox_4.getItemText(c);
								
								//Nationalite
								int d = comboBox_3.getSelectedIndex();
								String nationalite = comboBox_3.getItemText(d);
								
								//Situationn matrimoniale
								int e = comboBox_2.getSelectedIndex();
								String situationmatrimonial = comboBox_2.getItemText(e);
								
							
								//Mail
								String mail = (String) txtfldNewTextfield_7.getValue();
								
								//ajout ville
								
								int vil = comboBox_5.getSelectedIndex();
								String ville = comboBox_5.getItemText(vil);
								
								String fich = file.getValue();
								
								if(com.google.gwt.user.client.Window.confirm("Voulez-vous vraiment ajouter ces informations?") == true)
								{
								//monServ.exempleMethode(callback1);
								monServ.ajoutClientDemandeVisa(typeetrange, avis,
										situationmatrimonial,
										nationalite,
										renouvellement,
										nomEtPrenom, 
										dateEtLieuxNaiss,
										numPassport, 
										delivrance+"", 
										expiration+"", 
										adresseSociete, 
										telephone+"", 
										profession, 
										adresse, 
										activite, 
										capital+"", 
										adresseSociete, 				 
										observation,
										mail, ville, fich, callback1);
								}
								
								
							}
						});
				
				btnAfficherDtails.addSelectionListener(new SelectionListener<ButtonEvent>() {
					public void componentSelected(ButtonEvent ce) {
						
						String nomEtPrenom = (String) txtfldNewTextfield.getValue();
						String dateEtLieuxNaiss = (String) txtrNewTextarea_1.getValue();
						
						
						//Numéro Passport
						String numPassport = (String) txtfldNewTextfield_8.getValue();
						
						//Délivrance
						String delivrance = DateTimeFormat.getFormat("yyyy-MM-dd").format(dtfldNewDatefield.getValue());
						
						
						//Expération
						String expiration = DateTimeFormat.getFormat("yyyy-MM-dd").format(dtfldNewDatefield_1.getValue());
						
						
						
						//Adresse
						String adresse = (String) txtrNewTextarea_2.getValue();
						
						//Téléphone
						Number telephone = nmbrfldNewNumberfield_2.getValue();
						
						//Societe adresse
						
						String adresseSociete = (String)  txtrNewTextarea_6.getValue();
						
						//Réference visa
						int a =  comboBox_1.getSelectedIndex();
						String renouvellement = comboBox_1.getItemText(a);
						
						
						//Avis favorable
						int b = comboBox.getSelectedIndex();
						String avis = comboBox.getItemText(b);
						
						
						//Observation enquêteur
						
						String observation = txtrNewTextarea.getValue();
						
					//Type de l'etranger
						int c = comboBox_4.getSelectedIndex();
						String typeetrange = comboBox_4.getItemText(c);
						
						//Nationalite
						int d = comboBox_3.getSelectedIndex();
						String nationalite = comboBox_3.getItemText(d);
						
						//Situationn matrimoniale
						int e = comboBox_2.getSelectedIndex();
						String situationmatrimonial = comboBox_2.getItemText(e);
						
					
						//Mail
						String mail = (String) txtfldNewTextfield_7.getValue();
						
						monServ.ExportationPDFEtrangerDetail(nomEtPrenom, dateEtLieuxNaiss, numPassport, telephone+"", adresseSociete, nationalite, typeetrange, file.getValue(), callback2);
						greetingService.RecuprPhoto(callback2);
					}
				});
				
				final AsyncCallback<ModificationClient[]> callbackListe = new AsyncCallback<ModificationClient[]>() 
				{
					@Override
					public void onFailure(Throwable caught) {
						
						GWT.log(caught.getMessage(),caught);
					}

					@Override
					public void onSuccess(ModificationClient[] s) {
						txtfldNewTextfield.setValue(s[0].getNomEtPrenom());
						txtrNewTextarea_1.setValue(s[0].getDateNaiss());
						txtfldNewTextfield_8.setValue(s[0].getNumPassport());
						dtfldNewDatefield.setRawValue(s[0].getDelivrance());
						dtfldNewDatefield_1.setRawValue(s[0].getExpiration());
						txtrNewTextarea_2.setValue(s[0].getAdresse());						
						nmbrfldNewNumberfield_2.setValue(Integer.parseInt(s[0].getTel()));
						txtrNewTextarea_3.setValue(s[0].getProfession());		
						txtrNewTextarea_4.setValue(s[0].getSociete());
						txtrNewTextarea_5.setValue(s[0].getActivite());		
						nmbrfldNewNumberfield_3.setRawValue(s[0].getCapital());
						 txtrNewTextarea_6.setValue(s[0].getSctAdresse());
						txtrNewTextarea.setValue(s[0].getObservation());
						txtfldNewTextfield_7.setValue(s[0].getMail());
						
						
					}
				};
				
				btnOk.addSelectionListener(new SelectionListener<ButtonEvent>() {
					public void componentSelected(ButtonEvent ce) {
						
						if(com.google.gwt.user.client.Window.confirm("Voulez-vous vraiment afficher ces informations") == true)
						{
							String val = txtfldNewTextfield_9.getValue();
							monServ.modifierClient(val, callbackListe);
						}
					}
				});
				
				
				final AsyncCallback<String> callback3 = new AsyncCallback<String>() {
					@Override
					public void onFailure(Throwable caught) {
						MessageBox.info("Affichage d'erreur", "Erreur de modification!", null);		
					}
		 
					@Override
					public void onSuccess(String result) {
						MessageBox.info("Affichage d'information", result, null);
					
						
					}
				};
				
			
				
				btnModifier.addSelectionListener(new SelectionListener<ButtonEvent>() {
					public void componentSelected(ButtonEvent ce) {

						String nomEtPrenom = (String) txtfldNewTextfield.getValue();
						
						
						
						//Date et lieu de naisssance de l'étranger
						String dateEtLieuxNaiss = (String) txtrNewTextarea_1.getValue();
						
						
						//Numéro Passport
						String numPassport = (String) txtfldNewTextfield_8.getValue();
						
						//Délivrance
						String delivrance = DateTimeFormat.getFormat("yyyy-MM-dd").format(dtfldNewDatefield.getValue());
						
						
						//Expération
						String expiration = DateTimeFormat.getFormat("yyyy-MM-dd").format(dtfldNewDatefield_1.getValue());
						
						
						
						//Adresse
						String adresse = (String) txtrNewTextarea_2.getValue();
						
						//Téléphone
						Number telephone = nmbrfldNewNumberfield_2.getValue();
						
						//Profession
						String profession = (String) txtrNewTextarea_3.getValue();
						
						//Société
						String societe = (String) txtrNewTextarea_4.getValue();
						
						//Activités
						
						String activite = (String) txtrNewTextarea_5.getValue();
						
						//Capital
						Number capital = nmbrfldNewNumberfield_3.getValue();
						
						//Societe adresse
						
						String adresseSociete = (String)txtrNewTextarea_6.getValue();
						
						//Réference visa
						int a =  comboBox_1.getSelectedIndex();
						String renouvellement = comboBox_1.getItemText(a);
						
						

						
						//Observation enquêteur
						
						String observation = txtrNewTextarea.getValue();
						
						
						//Situationn matrimoniale
						int e = comboBox_2.getSelectedIndex();
						String situationmatrimonial = comboBox_2.getItemText(e);
						
						
						//Mail
						String mail = (String) txtfldNewTextfield_7.getValue();
						
						//ajout ville
						
						int vil = comboBox_5.getSelectedIndex();
						String ville = comboBox_5.getItemText(vil);
						
						if(com.google.gwt.user.client.Window.confirm("Voulez-vous vraiment modifier ces informations?") == true)
						{
					
						//monServ.exempleMethode(callback1);
						monServ.modifierClientDemandeVisa(
								nomEtPrenom, 
								dateEtLieuxNaiss,
								numPassport, 
								delivrance+"", 
								expiration+"", 
								adresseSociete, 
								telephone+"", 
								profession, 
								adresse, 
								activite, 
								capital+"", 
								adresseSociete, 				 
								observation,
								mail, ville, file.getValue(), callback3);
						}

						
					}
				});
		add(fldstActions, new AbsoluteData(18, 480));
		fldstActions.setSize("500px", "60px");
		fldstActions.setHeading("Actions");
	    panel.setHeaderVisible(false);
		
	  
	    panel.setHeading("Envoie image");  
	    panel.setFrame(true);  
	    panel.setAction(GWT.getModuleBaseURL()+ "upload");  
	    panel.setEncoding(Encoding.MULTIPART);  
	    panel.setMethod(Method.POST);  
	   // panel.setButtonAlign(HorizontalAlignment.CENTER);  
	    panel.setWidth(350);  
	    panel.setLayout(new AbsoluteLayout());
	  
	  
	    file.setAllowBlank(false);  
	    file.setName("uploadedfile");  
	    file.setFieldLabel("Chemin");  
	    panel.add(file, new AbsoluteData(6, 6));  
	    file.setSize("156px", "22px");
	  
	    add(panel, new AbsoluteData(477, 413));  
	    panel.setSize("170px", "43px");
	    
	    LabelField lblfldPhoto = new LabelField("Photo:");
	    add(lblfldPhoto, new AbsoluteData(362, 423));
	    
	   
	    add(txtrNewTextarea_1, new AbsoluteData(133, 85));
	    txtrNewTextarea_1.setSize("159px", "42px");
	    txtrNewTextarea_1.setFieldLabel("New TextArea");
	    
	    
	    add(txtrNewTextarea_2, new AbsoluteData(133, 247));
	    txtrNewTextarea_2.setSize("159px", "42px");
	    txtrNewTextarea_2.setFieldLabel("New TextArea");
	    
	    
	    add(txtrNewTextarea_3, new AbsoluteData(133, 321));
	    txtrNewTextarea_3.setSize("159px", "42px");
	    txtrNewTextarea_3.setFieldLabel("New TextArea");
	    
	   
	    add(txtrNewTextarea_4, new AbsoluteData(133, 373));
	    txtrNewTextarea_4.setSize("159px", "42px");
	    txtrNewTextarea_4.setFieldLabel("New TextArea");
	    
	   
	    add(txtrNewTextarea_5, new AbsoluteData(133, 424));
	    txtrNewTextarea_5.setSize("159px", "42px");
	    txtrNewTextarea_5.setFieldLabel("New TextArea");
	    
	   
	    add(txtrNewTextarea_6, new AbsoluteData(477, 230));
	    txtrNewTextarea_6.setSize("159px", "42px");
	    txtrNewTextarea_6.setFieldLabel("New TextArea");
	    
	    LabelField lblfldar = new LabelField("[Ar]");
	    add(lblfldar, new AbsoluteData(651, 321));

	}
}
