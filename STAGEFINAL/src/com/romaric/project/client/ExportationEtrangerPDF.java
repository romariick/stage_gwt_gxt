package com.romaric.project.client;

import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import com.extjs.gxt.ui.client.widget.layout.AbsoluteLayout;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.layout.AbsoluteData;
import com.extjs.gxt.ui.client.Style;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Frame;
import com.romaric.project.Visa.MonService;
import com.romaric.project.Visa.MonServiceAsync;

public class ExportationEtrangerPDF extends Window {

	final MonServiceAsync monServ = GWT.create(MonService.class);
	
	public ExportationEtrangerPDF() {
		setOnEsc(false);
		setModal(true);
		setWidth(600);
		setHeight(480);
		setBlinkModal(true);
		setHeading("Information Etranger");
		setLayout(new AbsoluteLayout());
		
		Frame frame = new Frame("http://127.0.0.1:8888/resources/pdf/EntrangerInfo.pdf");
	

		add(frame, new AbsoluteData(6, 6));
		frame.setSize("573px", "430px");
		
		
		final AsyncCallback<Frame> callback2 = new AsyncCallback<Frame>() {
			@Override
			public void onFailure(Throwable caught) {
				MessageBox.info("Affichage d'erreur", "Erreur d'enregistrement!", null);		
			}
 
			@Override
			public void onSuccess(Frame result) {
				
	
				//MessageBox.info("Adresse Ip machine", result, null);
	
				//

				
			}
		};
		
		//monServ.AdresseIPMachine(callback2);
	}
}
