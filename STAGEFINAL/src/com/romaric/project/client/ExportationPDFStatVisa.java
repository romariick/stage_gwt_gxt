package com.romaric.project.client;

import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import com.extjs.gxt.ui.client.widget.layout.AbsoluteLayout;
import com.google.gwt.user.client.ui.Frame;
import com.extjs.gxt.ui.client.widget.layout.AbsoluteData;
import com.extjs.gxt.ui.client.Style;

public class ExportationPDFStatVisa extends Window {

	public ExportationPDFStatVisa() {
		setWidth(650);
		setHeight(600);
		setResizable(false);
		setBlinkModal(true);
		setHeading("Exportation Statistique");
		setLayout(new AbsoluteLayout());
		
		Frame frame = new Frame("http://127.0.0.1:8888/resources/pdf/statistiqueGeneral.pdf");
		add(frame, new AbsoluteData(0, 6));
		frame.setSize("626px", "552px");
	}
}
