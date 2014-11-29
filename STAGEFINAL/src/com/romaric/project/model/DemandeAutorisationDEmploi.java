package com.romaric.project.model;

import com.extjs.gxt.ui.client.data.BaseModel;

public class DemandeAutorisationDEmploi extends BaseModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String numArrive;
	public String dateDemande;
	public String duree;
	public String dateSignature;
	
	
	public String getNumArrive() {
		return numArrive;
	}
	public void setNumArrive(String numArrive) {
		this.numArrive = numArrive;
	}
	public String getDateDemande() {
		return dateDemande;
	}
	public void setDateDemande(String dateDemande) {
		this.dateDemande = dateDemande;
	}
	public String getDuree() {
		return duree;
	}
	public void setDuree(String duree) {
		this.duree = duree;
	}
	public String getDateSignature() {
		return dateSignature;
	}
	public void setDateSignature(String dateSignature) {
		this.dateSignature = dateSignature;
	}
	
	public DemandeAutorisationDEmploi(){
		
	}
	public DemandeAutorisationDEmploi(String numArrive, String dateDemande,
			String duree, String dateSignature) {
		super();
		this.numArrive = numArrive;
		this.dateDemande = dateDemande;
		this.duree = duree;
		this.dateSignature = dateSignature;
		
		set("numArrive", numArrive);
		set("dateDemande", dateDemande);
		set("duree", duree);
		set("dateSignature", dateSignature);
	}
	
	
	

}
