package com.romaric.project.client;

import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import com.extjs.gxt.ui.client.widget.layout.AbsoluteLayout;
import com.google.gwt.user.client.ui.Frame;
import com.extjs.gxt.ui.client.widget.layout.AbsoluteData;
import com.extjs.gxt.ui.client.Style;

public class AffichageAE extends Window {

	public AffichageAE() {
		setOnEsc(false);
		setWidth(650);
		setHeight(600);
		setHeading("Aper\u00E7u PDF AE");
		setLayout(new AbsoluteLayout());
		
		Frame frame = new Frame("http://127.0.0.1:8888/resources/pdf/AE.pdf");
		add(frame, new AbsoluteData(6, 0));
		frame.setSize("620px", "558px");
	}
}
