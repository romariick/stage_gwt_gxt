package com.romaric.project.client;

import com.extjs.gxt.ui.client.GXT;
import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Frame;
import com.google.gwt.user.client.ui.RootPanel;
import com.extjs.gxt.charts.client.Chart;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.layout.RowData;
import com.extjs.gxt.ui.client.Style;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.layout.AbsoluteLayout;
import com.extjs.gxt.ui.client.widget.layout.AbsoluteData;

public class ExportationEntrepriseRechercherPDF extends Window {
	final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);
	public ExportationEntrepriseRechercherPDF() {
		setModal(true);
		setResizable(false);
		
		
		setOnEsc(false);
		setSize("650px", "496px");
		setHeading("Accueil > Information entreprise");
		setLayout(new AbsoluteLayout());
		setBlinkModal(true);
		
		

		Frame frame = new Frame("http://127.0.0.1:8888/resources/pdf/EntrepriseInfo.pdf");
		
		//frame.setStyleName(style)
		add(frame, new AbsoluteData(6, 6));
		frame.setSize("625px", "448px");
		

		

	}
}
