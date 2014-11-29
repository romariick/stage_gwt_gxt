package com.romaric.project.client;

import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import com.extjs.gxt.ui.client.widget.layout.AbsoluteLayout;
import com.google.gwt.user.client.ui.Frame;
import com.extjs.gxt.ui.client.widget.layout.AbsoluteData;
import com.extjs.gxt.ui.client.Style;

public class AffichagePDFDetailsVisa extends Window {

	public AffichagePDFDetailsVisa() {
		setOnEsc(false);
		setResizable(false);
		setWidth(650);
		setHeight(600);
		setBlinkModal(true);
		setHeading("Aper\u00E7u PDF");
		setLayout(new AbsoluteLayout());
		
		Frame frame = new Frame("http://127.0.0.1:8888/resources/pdf/EntrangerInfoDetails.pdf");
		add(frame, new AbsoluteData(-12, 0));
		frame.setSize("654px", "564px");
	}
}
