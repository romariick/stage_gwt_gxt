package com.romaric.project.client;

import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import com.extjs.gxt.ui.client.widget.layout.AbsoluteLayout;
import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Grid;
import com.extjs.gxt.ui.client.widget.layout.AbsoluteData;
import com.extjs.gxt.ui.client.Style;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import java.util.Collections;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import java.util.List;
import java.util.ArrayList;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.form.NumberField;
import com.google.gwt.user.client.ui.ListBox;
import com.romaric.project.Visa.MonService;
import com.romaric.project.Visa.MonServiceAsync;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.event.ButtonEvent;

public class StatistiqueDemandeVisa extends Window {
	final MonServiceAsync monServ = GWT.create(MonService.class);
	public StatistiqueDemandeVisa() {
		setModal(true);
		setOnEsc(false);
		setWidth(585);
		setHeight(485);
		setBlinkModal(true);
		setResizable(false);
		setHeading("Accueil > Statistique demande VISA");
		setLayout(new AbsoluteLayout());
		List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
		
		LabelField lblfldDbut = new LabelField("Date d\u00E9but:");
		add(lblfldDbut, new AbsoluteData(16, 15));
		
		final DateField dtfldNewDatefield = new DateField();
		add(dtfldNewDatefield, new AbsoluteData(92, 15));
		dtfldNewDatefield.setSize("159px", "22px");
		dtfldNewDatefield.setFieldLabel("New DateField");
		
		LabelField lblfldFin = new LabelField("Date fin:");
		add(lblfldFin, new AbsoluteData(296, 18));
		
		final DateField dtfldNewDatefield_1 = new DateField();
		add(dtfldNewDatefield_1, new AbsoluteData(354, 15));
		dtfldNewDatefield_1.setSize("159px", "22");
		dtfldNewDatefield_1.setFieldLabel("New DateField");
		
		Button btnOk = new Button("OK");

		add(btnOk, new AbsoluteData(538, 13));
		
		ContentPanel cntntpnlStatistiqueGnral = new ContentPanel();
		cntntpnlStatistiqueGnral.setHeading("Statistiques g\u00E9n\u00E9raux");
		cntntpnlStatistiqueGnral.setLayout(new AbsoluteLayout());
		
		LabelField lblfldNewLabelfield = new LabelField("R\u00E9\u00E7ues \u00E0 l'EDBM:");
		lblfldNewLabelfield.setStyleName("statVisa");
		cntntpnlStatistiqueGnral.add(lblfldNewLabelfield, new AbsoluteData(6, 25));
		
		LabelField lblfldEnvoyAnosy = new LabelField("Envoy\u00E9 \u00E0 Anosy pour d\u00E9c.:");
		lblfldEnvoyAnosy.setStyleName("statVisa");
		cntntpnlStatistiqueGnral.add(lblfldEnvoyAnosy, new AbsoluteData(6, 100));
		
		LabelField lblfldEnvoyAnosy_1 = new LabelField("Envoy\u00E9 \u00E0 Anosy avec d\u00E9c.:");
		lblfldEnvoyAnosy_1.setStyleName("statVisa");
		cntntpnlStatistiqueGnral.add(lblfldEnvoyAnosy_1, new AbsoluteData(6, 137));
		
		LabelField lblfldPasseportEnv = new LabelField("Passeport env. \u00E0 Anosy");
		lblfldPasseportEnv.setStyleName("statVisa");
		cntntpnlStatistiqueGnral.add(lblfldPasseportEnv, new AbsoluteData(6, 174));
		
		LabelField lblfldPasseportArrive = new LabelField("Passeport arriv\u00E9e \u00E0 Anosy:");
		lblfldPasseportArrive.setStyleName("statVisa");
		cntntpnlStatistiqueGnral.add(lblfldPasseportArrive, new AbsoluteData(6, 213));
		
		LabelField lblfldCarteDeRsident = new LabelField("Carte de r\u00E9sident env. Anosy");
		lblfldCarteDeRsident.setStyleName("statVisa");
		cntntpnlStatistiqueGnral.add(lblfldCarteDeRsident, new AbsoluteData(6, 250));
		
		ToolBar toolBar = new ToolBar();
		
		Button btnExporter = new Button("Exporter...");
	
		toolBar.add(btnExporter);
		cntntpnlStatistiqueGnral.add(toolBar, new AbsoluteData(0, 319));
		toolBar.setSize("553px", "30px");
		
		final LabelField labelField = new LabelField("0");
		labelField.setStyleName("statVisa");
		cntntpnlStatistiqueGnral.add(labelField, new AbsoluteData(262, 30));
		labelField.setSize("43px", "14px");
		
		final LabelField labelField_1 = new LabelField("0");
		labelField_1.setStyleName("statVisa");
		cntntpnlStatistiqueGnral.add(labelField_1, new AbsoluteData(259, 100));
		labelField_1.setSize("46px", "14px");
		
		final LabelField labelField_2 = new LabelField("0");
		labelField_2.setStyleName("statVisa");
		cntntpnlStatistiqueGnral.add(labelField_2, new AbsoluteData(256, 137));
		labelField_2.setSize("49px", "14px");
		
		final LabelField labelField_3 = new LabelField("0");
		labelField_3.setStyleName("statVisa");
		cntntpnlStatistiqueGnral.add(labelField_3, new AbsoluteData(254, 174));
		labelField_3.setSize("51px", "9px");
		
		final LabelField labelField_4 = new LabelField("0");
		labelField_4.setStyleName("statVisa");
		cntntpnlStatistiqueGnral.add(labelField_4, new AbsoluteData(265, 213));
		labelField_4.setSize("40px", "14px");
		
		final LabelField labelField_5 = new LabelField("0");
		labelField_5.setStyleName("statVisa");
		cntntpnlStatistiqueGnral.add(labelField_5, new AbsoluteData(265, 250));
		labelField_5.setSize("40px", "14px");
		
		LabelField lblfldNombreRcepisses = new LabelField("Nombre r\u00E9cepisses:");
		lblfldNombreRcepisses.setStyleName("statVisa");
		cntntpnlStatistiqueGnral.add(lblfldNombreRcepisses, new AbsoluteData(6, 61));
		
		final LabelField labelField_6 = new LabelField("0");
		labelField_6.setStyleName("statVisa");
		labelField_6.setStyleName("statVisa");
		cntntpnlStatistiqueGnral.add(labelField_6, new AbsoluteData(265, 66));
		labelField_6.setSize("40px", "14px");
		add(cntntpnlStatistiqueGnral, new AbsoluteData(6, 73));
		cntntpnlStatistiqueGnral.setSize("559px", "374px");
		
		
		final AsyncCallback<String> AffichageListeStat = new AsyncCallback<String>() {
			@Override
			public void onFailure(Throwable caught) {
				MessageBox.info("Affichage d'erreur", "Erreur d'enregistrement!", null);		
			}
 
			@Override
			public void onSuccess(String result) {
				labelField.setText(result);	
				
			}
		};
		
		final AsyncCallback<String> AffichageEnvAnosPourDec = new AsyncCallback<String>() {
			@Override
			public void onFailure(Throwable caught) {
				MessageBox.info("Affichage d'erreur", "Erreur d'enregistrement!", null);		
			}
 
			@Override
			public void onSuccess(String result) {
				
				labelField_1.setText(result);
				labelField_6.setText(result);
			}
		};
		
		final AsyncCallback<String> AffichageEnvAnosAvecDec = new AsyncCallback<String>() {
			@Override
			public void onFailure(Throwable caught) {
				MessageBox.info("Affichage d'erreur", "Erreur d'enregistrement!", null);		
			}
 
			@Override
			public void onSuccess(String result) {
				
				labelField_2.setText(result);
			}
		};
		
		final AsyncCallback<String> PasseportEnvoyeAnosy = new AsyncCallback<String>() {
			@Override
			public void onFailure(Throwable caught) {
				MessageBox.info("Affichage d'erreur", "Erreur d'enregistrement!", null);		
			}
 
			@Override
			public void onSuccess(String result) {
				
				labelField_3.setText(result);
			}
		};
		
		final AsyncCallback<String> PasseportArriveAnosy = new AsyncCallback<String>() {
			@Override
			public void onFailure(Throwable caught) {
				MessageBox.info("Affichage d'erreur", "Erreur d'enregistrement!", null);		
			}
 
			@Override
			public void onSuccess(String result) {
				
				labelField_4.setText(result);
			}
		};
		
		final AsyncCallback<String> CarteDeResidentEnvoyeAnosy = new AsyncCallback<String>() {
			@Override
			public void onFailure(Throwable caught) {
				MessageBox.info("Affichage d'erreur", "Erreur d'enregistrement!", null);		
			}
 
			@Override
			public void onSuccess(String result) {
				
				labelField_5.setText(result);
			}
		};
		btnOk.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {
				
				
				String dates = DateTimeFormat.getFormat("dd/MM/yyyy").format(dtfldNewDatefield.getValue());
				String dates2 = DateTimeFormat.getFormat("dd/MM/yyyy").format(dtfldNewDatefield_1.getValue());
				
				monServ.RecupererNombreDossierRecueUDBM(dates, dates2, AffichageListeStat);
				monServ.EnvoyeAAnosyPourDecision(dates, dates2, AffichageEnvAnosPourDec);
				monServ.EnvoyeAAnosyAvecDecision(dates, dates2, AffichageEnvAnosAvecDec);
				monServ.PasseportEnvoyeAnosy(dates, dates2, PasseportEnvoyeAnosy);
				monServ.PasseportArriveAnosy(dates, dates2, PasseportArriveAnosy);
				monServ.CarteDeResidentEnvAnosy(dates, dates2, CarteDeResidentEnvoyeAnosy);
				
			}
		});
		
		
		
		
		final AsyncCallback<String> RecuprStatPDF = new AsyncCallback<String>() {
			@Override
			public void onFailure(Throwable caught) {
				MessageBox.info("Affichage d'erreur", "Erreur d'enregistrement!", null);		
			}
 
			@Override
			public void onSuccess(String result) {
				ExportationPDFStatVisa statVisa = new ExportationPDFStatVisa();
				statVisa.show();
				
			}
		};
		btnExporter.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {
				
				String a = (String) labelField.getValue();
				String b = (String) labelField_6.getValue();
				String c = (String) labelField_1.getValue();
				String d = (String) labelField_2.getValue();
				String e = (String) labelField_3.getValue();
				String f = (String) labelField_4.getValue();
				String g = (String) labelField_5.getValue();
				
				monServ.ExportationPDFStatVisaTous(a, b, c, d, e, f, g, RecuprStatPDF);
			}
		});
		
	}
}
