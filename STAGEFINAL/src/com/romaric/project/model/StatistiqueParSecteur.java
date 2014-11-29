package com.romaric.project.model;

import com.extjs.gxt.ui.client.data.BaseModel;

public class StatistiqueParSecteur extends BaseModel{
	
	private static final long serialVersionUID = 1L;  
	
	public String secteurs;
	public String nombres;
	public String pourcentage;
	
	public String getSecteurs() {
		return secteurs;
	}
	public void setSecteurs(String secteurs) {
		this.secteurs = secteurs;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getPourcentage() {
		return pourcentage;
	}
	public void setPourcentage(String pourcentage) {
		this.pourcentage = pourcentage;
	}
	
	public StatistiqueParSecteur(){
		
	}
	public StatistiqueParSecteur(String secteurs, String nombres,
			String pourcentage) {
		super();
		this.secteurs = secteurs;
		this.nombres = nombres;
		this.pourcentage = pourcentage;
		
		set("secteurs", secteurs);
		set("nombres", nombres);
		set("pourcentage", pourcentage);
	}
	
	
	

}
