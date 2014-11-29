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
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.romaric.project.Visa.MonService;
import com.romaric.project.Visa.MonServiceAsync;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.event.ButtonEvent;

public class OutilDAdministration extends Window {

	final MonServiceAsync monServ = GWT.create(MonService.class);
	
	public OutilDAdministration() {
		setModal(true);
		setOnEsc(false);
		setResizable(false);
		setWidth(400);
		setHeight(500);
		setHeading("Info.Users");
		setLayout(new AbsoluteLayout());
		
		ContentPanel cntntpnlInfoanciens = new ContentPanel();
		cntntpnlInfoanciens.setHeading("Info.Anciens");
		cntntpnlInfoanciens.setLayout(new AbsoluteLayout());
		
		Label lblLogin = new Label("Login:");
		cntntpnlInfoanciens.add(lblLogin, new AbsoluteData(6, 18));
		
		final TextField<String> txtfldNewTextfield = new TextField<String>();
		cntntpnlInfoanciens.add(txtfldNewTextfield, new AbsoluteData(82, 18));
		txtfldNewTextfield.setFieldLabel("New TextField");
		
		Label lblMotDePasse = new Label("Mot de passe:");
		cntntpnlInfoanciens.add(lblMotDePasse, new AbsoluteData(6, 67));
		
		final PasswordTextBox passwordTextBox = new PasswordTextBox();
		cntntpnlInfoanciens.add(passwordTextBox, new AbsoluteData(82, 56));
		add(cntntpnlInfoanciens, new AbsoluteData(45, 23));
		cntntpnlInfoanciens.setSize("300px", "132px");
		
		ContentPanel cntntpnlNouveau = new ContentPanel();
		cntntpnlNouveau.setHeading("Nouveau");
		cntntpnlNouveau.setLayout(new AbsoluteLayout());
		
		Label lblLogin_1 = new Label("Login:");
		cntntpnlNouveau.add(lblLogin_1, new AbsoluteData(24, 19));
		
		final TextField<String> txtfldNewTextfield_1 = new TextField<String>();
		cntntpnlNouveau.add(txtfldNewTextfield_1, new AbsoluteData(89, 10));
		txtfldNewTextfield_1.setFieldLabel("New TextField");
		
		Label lblMotDePasse_1 = new Label("Mot de passe:");
		cntntpnlNouveau.add(lblMotDePasse_1, new AbsoluteData(18, 65));
		
		final PasswordTextBox passwordTextBox_1 = new PasswordTextBox();
		cntntpnlNouveau.add(passwordTextBox_1, new AbsoluteData(89, 64));
		
		Label lblConfirmation = new Label("Confirmation:");
		cntntpnlNouveau.add(lblConfirmation, new AbsoluteData(18, 111));
		
		final PasswordTextBox passwordTextBox_2 = new PasswordTextBox();
		cntntpnlNouveau.add(passwordTextBox_2, new AbsoluteData(89, 111));
		add(cntntpnlNouveau, new AbsoluteData(45, 186));
		cntntpnlNouveau.setSize("300px", "200px");
		
		Button btnOk = new Button("OK");
		
		final AsyncCallback<String> callback2 = new AsyncCallback<String>() {
			@Override
			public void onFailure(Throwable caught) {
				MessageBox.info("Affichage d'erreur", "Erreur d'enregistrement!", null);		
			}
 
			@Override
			public void onSuccess(String result) {
	
			MessageBox.info("Information", result, null);

				
			}
		};		
		
		
		btnOk.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {
				String encienlogin = txtfldNewTextfield.getValue();
				String encienmotdepasse = passwordTextBox.getValue();
				
				String nouveaulogin = txtfldNewTextfield_1.getValue();
				String nouveaumotdepasse = passwordTextBox_1.getValue();
				String confirmation = passwordTextBox_2.getValue();
				
				if(nouveaumotdepasse.equals(confirmation))
				{
					monServ.modifierMotDePass(nouveaulogin, nouveaumotdepasse, encienlogin, encienmotdepasse, callback2);
				}
				else
					com.google.gwt.user.client.Window.alert("Mot de passe incorrecte!!");
			}
		});
		add(btnOk, new AbsoluteData(45, 421));
		btnOk.setSize("79px", "24px");
		
		Button btnAnnuler = new Button("Annuler");
		btnAnnuler.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {
				close();
			}
		});
		add(btnAnnuler, new AbsoluteData(258, 421));
		btnAnnuler.setSize("87px", "24px");
	}
}
