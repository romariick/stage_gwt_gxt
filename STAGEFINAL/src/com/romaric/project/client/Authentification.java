package com.romaric.project.client;







import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.widget.Component;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import com.extjs.gxt.ui.client.widget.layout.AbsoluteLayout;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.layout.AbsoluteData;
import com.extjs.gxt.ui.client.widget.tips.ToolTipConfig;
import com.extjs.gxt.ui.client.Style;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.KeyEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Image;
import com.extjs.gxt.ui.client.widget.form.SimpleComboBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;

public class Authentification extends Window {
	
	public final GreetingServiceAsync greetingService = GWT
	.create(GreetingService.class);

	public Authentification() {
		setResizable(false);
		setClosable(false);
		setOnEsc(false);
		setModal(true);
		setBlinkModal(true);
		setWidth(404);
		setHeight(259);
		setHeading("Authentification");
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
		add(btnOk, new AbsoluteData(85, 185));
		btnOk.setSize("90px", "24px");
		
		Button btnAnnuler = new Button("Annuler");
		btnAnnuler.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {

				close();
				
			}
		});
		add(btnAnnuler, new AbsoluteData(264, 185));
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
					if(s.equals("Administrateur"))
					{
						MessageBox.info("Connexion", "Admin", null);		
						close();
					}
	
						
					
			}
		};

		btnOk.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {

				String loginUser = txtfldNewTextfield.getValue();

				   greetingService.authentifier(loginUser, motDePasse.getText(), authentification);
	
			  
				  
			}
		});

		btnOk.addListener(Events.KeyDown, new Listener<BaseEvent>() {
	        public void handleEvent(BaseEvent be) {
	            KeyEvent ce = (KeyEvent)be;
	          
	                if (ce.getKeyCode() == 13) {


	                	Info.display("enter", "enter", "");
	                    
	                  
	                }
	            
	        };
		});

	}
}
