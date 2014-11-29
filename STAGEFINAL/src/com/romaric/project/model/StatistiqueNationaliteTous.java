package com.romaric.project.model;

import com.extjs.gxt.ui.client.data.BaseModel;

public class StatistiqueNationaliteTous extends BaseModel{
	private static final long serialVersionUID = 1L;  
	
	public String nationalite;
	public String nombreEntreprise;
	public String pourcentage;
	
	
	public String getNationalite() {
		return nationalite;
	}
	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}
	public String getNombreEntreprise() {
		return nombreEntreprise;
	}
	public void setNombreEntreprise(String nombreEntreprise) {
		this.nombreEntreprise = nombreEntreprise;
	}
	public String getPourcentage() {
		return pourcentage;
	}
	public void setPourcentage(String pourcentage) {
		this.pourcentage = pourcentage;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public StatistiqueNationaliteTous(){
		
	}
	public StatistiqueNationaliteTous(String nationalite,
			String nombreEntreprise, String pourcentage) {
		super();
		this.nationalite = nationalite;
		this.nombreEntreprise = nombreEntreprise;
		this.pourcentage = pourcentage;
		
		set("nationalite", nationalite);
		set("nombresociete", nombreEntreprise);
		set("pourcentage", pourcentage);

	}

}
