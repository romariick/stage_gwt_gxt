package com.romaric.project.client;

import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import com.extjs.gxt.ui.client.widget.layout.AbsoluteLayout;
import com.extjs.gxt.ui.client.widget.TabPanel;
import com.extjs.gxt.ui.client.widget.layout.AbsoluteData;
import com.extjs.gxt.ui.client.Style;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.ListBox;
import com.romaric.project.autorisationDEmploi.AutorisationDEmploiService;
import com.romaric.project.autorisationDEmploi.AutorisationDEmploiServiceAsync;
import com.romaric.project.model.DemandeAutorisationDEmploi;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import java.util.Collections;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import java.util.List;
import java.util.ArrayList;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.event.ButtonEvent;

public class StatistiqueAutorisationDEmploi extends Window {

	
	final AutorisationDEmploiServiceAsync monServAE = GWT.create(AutorisationDEmploiService.class);
	final ListStore<DemandeAutorisationDEmploi> storeClientNumPass = new ListStore<DemandeAutorisationDEmploi>();
	final List<DemandeAutorisationDEmploi> stocksClientNumPass = new ArrayList<DemandeAutorisationDEmploi>();

	public StatistiqueAutorisationDEmploi() {
		setModal(true);
		setResizable(false);
		setOnEsc(false);
		setWidth(733);
		setBlinkModal(true);
		setHeight(400);
		setHeading("Accueil > Statistique Autorisation d'emploi");
		setLayout(new AbsoluteLayout());
		
		TabPanel tabPanel = new TabPanel();
		
		TabItem tbtmMois = new TabItem("Mois");
		tbtmMois.setLayout(new AbsoluteLayout());
		
		LabelField lblfldDbut = new LabelField("D\u00E9but:");
		tbtmMois.add(lblfldDbut, new AbsoluteData(25, 26));
		
		final DateField dtfldNewDatefield = new DateField();
		tbtmMois.add(dtfldNewDatefield, new AbsoluteData(69, 23));
		dtfldNewDatefield.setSize("159px", "22px");
		dtfldNewDatefield.setFieldLabel("New DateField");
		
		LabelField lblfldFin = new LabelField("Fin:");
		tbtmMois.add(lblfldFin, new AbsoluteData(259, 26));
		
		final DateField dtfldNewDatefield_1 = new DateField();
		tbtmMois.add(dtfldNewDatefield_1, new AbsoluteData(312, 23));
		dtfldNewDatefield_1.setSize("159px", "22px");
		dtfldNewDatefield_1.setFieldLabel("New DateField");
		
		Button btnOk = new Button("OK");
		tbtmMois.add(btnOk, new AbsoluteData(500, 23));
		btnOk.setSize("100px", "26px");
		List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
		
		ColumnConfig clmncnfgNumarriv = new ColumnConfig("numArrive", "Num.Arriv\u00E9", 150);
		configs.add(clmncnfgNumarriv);
		
		ColumnConfig clmncnfgDateDemande = new ColumnConfig("dateDemande", "Date demande", 150);
		configs.add(clmncnfgDateDemande);
		
		ColumnConfig clmncnfgDure = new ColumnConfig("duree", "Dur\u00E9e", 150);
		configs.add(clmncnfgDure);
		
		ColumnConfig clmncnfgDateSignature = new ColumnConfig("dateSignature", "Date signature", 150);
		configs.add(clmncnfgDateSignature);
		
		final Grid<DemandeAutorisationDEmploi> grid = new Grid<DemandeAutorisationDEmploi>(storeClientNumPass, new ColumnModel(configs));
		tbtmMois.add(grid, new AbsoluteData(25, 76));
		grid.setSize("645px", "192px");
		grid.setBorders(true);
		
		LabelField lblfldNombresTotaux = new LabelField("Nombres Totaux:");
		tbtmMois.add(lblfldNombresTotaux, new AbsoluteData(24, 296));
		
		final LabelField lblfldNewLabelfield = new LabelField("0");
		tbtmMois.add(lblfldNewLabelfield, new AbsoluteData(128, 296));
		tabPanel.add(tbtmMois);
		add(tabPanel, new AbsoluteData(0, 0));
		tabPanel.setSize("713px", "362px");
		
		
		final AsyncCallback<DemandeAutorisationDEmploi[]> asyncCallbackFj = new AsyncCallback<DemandeAutorisationDEmploi[]>() 
		{
			@Override
			public void onFailure(Throwable caught) {
				
				GWT.log(caught.getMessage(),caught);
			}

			@Override
			public void onSuccess(DemandeAutorisationDEmploi[] s) {
				int i;
				
				for(i = 0; i < s.length; i++)
				{	
					stocksClientNumPass.add(s[i]);

								       
				}
				storeClientNumPass.add(stocksClientNumPass);
				
				int nombres = storeClientNumPass.getCount();
				
				lblfldNewLabelfield.setText(nombres+"");
				
			}
		};
		
		btnOk.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {
				
			
				  
					String dateDebut = DateTimeFormat.getFormat("dd/MM/yyyy").format(dtfldNewDatefield.getValue());
					String dateFin = DateTimeFormat.getFormat("dd/MM/yyyy").format(dtfldNewDatefield_1.getValue());
					
					stocksClientNumPass.clear();
					storeClientNumPass.removeAll();
						
					monServAE.getInformationAutorisationAE(dateDebut, dateFin, asyncCallbackFj);
				  

				
			}
		});

		

	}
}
