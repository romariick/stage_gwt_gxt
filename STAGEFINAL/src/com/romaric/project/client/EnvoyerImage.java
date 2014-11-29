package com.romaric.project.client;

import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import java.util.List;  

 
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;  
import com.extjs.gxt.ui.client.event.ButtonEvent;  
import com.extjs.gxt.ui.client.event.SelectionListener;  
import com.extjs.gxt.ui.client.store.ListStore;  
import com.extjs.gxt.ui.client.widget.LayoutContainer;  
import com.extjs.gxt.ui.client.widget.MessageBox;  
import com.extjs.gxt.ui.client.widget.button.Button;  
import com.extjs.gxt.ui.client.widget.form.ComboBox;  
import com.extjs.gxt.ui.client.widget.form.FileUploadField;  
import com.extjs.gxt.ui.client.widget.form.FormPanel;  
import com.extjs.gxt.ui.client.widget.form.TextField;  
import com.extjs.gxt.ui.client.widget.form.ComboBox.TriggerAction;  
import com.extjs.gxt.ui.client.widget.form.FormPanel.Encoding;  
import com.extjs.gxt.ui.client.widget.form.FormPanel.Method;  
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Element;  
public class EnvoyerImage extends Window {

	public EnvoyerImage() {
		setWidth(370);
		setHeight(180);
		setHeading("Enregistrer Image");
		setLayout(new RowLayout(Orientation.VERTICAL));
	    setStyleAttribute("margin", "10px");  
	  
	    final FormPanel panel = new FormPanel();  
	    panel.setHeading("Envoie image");  
	    panel.setFrame(true);  
	    panel.setAction(GWT.getModuleBaseURL()+ "upload");  
	    panel.setEncoding(Encoding.MULTIPART);  
	    panel.setMethod(Method.POST);  
	    panel.setButtonAlign(HorizontalAlignment.CENTER);  
	    panel.setWidth(350);  
	  
	    TextField<String> name = new TextField<String>();  
	    name.setFieldLabel("Nom");  
	    panel.add(name);  
	  
	    final FileUploadField file = new FileUploadField();  
	    file.setAllowBlank(false);  
	    file.setName("uploadedfile");  
	    file.setFieldLabel("Chemin");  
	    panel.add(file);  
	  
	
	    Button btn = new Button("Annuler");  
	    btn.addSelectionListener(new SelectionListener<ButtonEvent>() {  
	      @Override  
	      public void componentSelected(ButtonEvent ce) {  
	        panel.reset();  
	      }  
	    });  
	    panel.addButton(btn);  
	  
	    btn = new Button("Envoyer");  
	    btn.addSelectionListener(new SelectionListener<ButtonEvent>() {  
	      @Override  
	      public void componentSelected(ButtonEvent ce) {  
	        if (!panel.isValid()) {  
	          return;  
	        }  
	        // normally would submit the form but for example no server set up to  
	        // handle the post  
	        panel.submit();  
	        MessageBox.info("Action", "You file was uploaded"+file.getValue(), null); 
	        
	      }  
	    });  
	    panel.addButton(btn);  
	  
	    add(panel);  
	  }  



}
