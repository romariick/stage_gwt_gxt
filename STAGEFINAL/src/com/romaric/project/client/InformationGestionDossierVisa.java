package com.romaric.project.client;

import com.extjs.gxt.charts.client.Chart;
import com.extjs.gxt.charts.client.model.charts.PieChart;
import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.TabPanel;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.layout.RowData;
import com.extjs.gxt.ui.client.Style;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.layout.AbsoluteLayout;
import com.extjs.gxt.ui.client.widget.layout.AbsoluteData;
import com.google.gwt.user.client.ui.Label;
import com.romaric.project.model.Client;

import com.extjs.gxt.ui.client.widget.form.NumberField;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.grid.EditorGrid;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import java.util.Collections;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import java.util.List;
import java.util.ArrayList;

public class InformationGestionDossierVisa extends Window {

	public InformationGestionDossierVisa() {
		setResizable(false);
		setModal(true);

	
		    
		setHeight(600);
		setWidth(610);
		setHeading("Accueil > Information dossier");
		setBlinkModal(true);
		setLayout(new AbsoluteLayout());
		Client recupr = new Client();
		TabPanel tabPanel = new TabPanel();
		
		TabItem tbtmEnvoyAnosy = new TabItem("Envoy\u00E9 Anosy");
		tbtmEnvoyAnosy.setLayout(new AbsoluteLayout());
		
		Label lblNumDossier = new Label("Num. dossier:");
		tbtmEnvoyAnosy.add(lblNumDossier, new AbsoluteData(16, 32));
		
		NumberField nmbrfldNewNumberfield = new NumberField();
		tbtmEnvoyAnosy.add(nmbrfldNewNumberfield, new AbsoluteData(88, 23));
		nmbrfldNewNumberfield.setFieldLabel("New NumberField");
		
		Button btnOk = new Button("OK");
		tbtmEnvoyAnosy.add(btnOk, new AbsoluteData(288, 23));
		btnOk.setSize("80px", "24px");
		
		Button btnDtails_1 = new Button("D\u00E9tails");
		tbtmEnvoyAnosy.add(btnDtails_1, new AbsoluteData(16, 380));
		btnDtails_1.setSize("69px", "24px");
		List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
		
		ColumnConfig clmncnfgNewColumn = new ColumnConfig("id", "New Column", 150);
		configs.add(clmncnfgNewColumn);
		
		ColumnConfig clmncnfgNewColumn_1 = new ColumnConfig("id", "New Column", 150);
		configs.add(clmncnfgNewColumn_1);
		
		EditorGrid editorGrid = new EditorGrid(new ListStore(), new ColumnModel(configs));
		tbtmEnvoyAnosy.add(editorGrid, new AbsoluteData(31, 99));
		editorGrid.setSize("302px", "202px");
		editorGrid.setBorders(true);
		tabPanel.add(tbtmEnvoyAnosy);
		
		TabItem tbtmNewTabitem = new TabItem("Etats globaux");
		tbtmNewTabitem.setLayout(new AbsoluteLayout());
		tabPanel.add(tbtmNewTabitem);
		
		TabItem tbtmEdbm = new TabItem("EDBM");
		tbtmEdbm.setLayout(new AbsoluteLayout());
		
		Label lblNumdossier = new Label("Num.dossier:");
		tbtmEdbm.add(lblNumdossier, new AbsoluteData(19, 27));
		
		TextField txtfldNewTextfield = new TextField();
		tbtmEdbm.add(txtfldNewTextfield, new AbsoluteData(100, 18));
		txtfldNewTextfield.setFieldLabel("New TextField");
		
		Button btnDtails = new Button("D\u00E9tails");
		tbtmEdbm.add(btnDtails, new AbsoluteData(19, 503));
		btnDtails.setSize("76px", "24px");
		tabPanel.add(tbtmEdbm);
		add(tabPanel, new AbsoluteData(0, 0));
		tabPanel.setSize("590px", "562px");
		
		MessageBox.info("", recupr.getNomEtPrenom(), null);
		
	//	String url =    "gxt/chart/open-flash-chart.swf";  
		//PieChart pie = new PieChart();  
		 
		/*    pie.setAlpha(0.5f);  
		    pie.setNoLabels(true);  
		    pie.setTooltip("#label# $#val#M<br>#percent#");  
		    pie.setColours("#ff0000", "#00aa00", "#0000ff", "#ff9900", "#ff00ff");  
		    pie.addSlices(new PieChart.Slice(100, "AU","Australia"));  
		    pie.addSlices(new PieChart.Slice(200, "US", "USA"));  
		    pie.addSlices(new PieChart.Slice(150, "JP", "Japan"));  
		    pie.addSlices(new PieChart.Slice(120, "DE", "Germany"));  
		    pie.addSlices(new PieChart.Slice(60, "UK", "United Kingdom"));
		    
		    
		      
		    final Chart chart = new Chart(url);  
		    chart.setBorders(true);*/  
		    
		  
	}
}
