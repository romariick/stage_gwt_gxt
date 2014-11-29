package com.romaric.project.model;

import com.extjs.gxt.ui.client.data.BaseModel;

public class StatistiqueFormeJuridique extends BaseModel{
	
	private static final long serialVersionUID = 1L;  
	
	private String formejuridique;
	private String nombresociete;
	public String pourcentage;
	
	public String getFormejuridique() {
		return formejuridique;
	}
	public void setFormejuridique(String formejuridique) {
		this.formejuridique = formejuridique;
	}
	public String getNombresociete() {
		return nombresociete;
	}
	public void setNombresociete(String nombresociete) {
		this.nombresociete = nombresociete;
	}
	public String getPourcentage() {
		return pourcentage;
	}
	public void setPourcentage(String pourcentage) {
		this.pourcentage = pourcentage;
	}
	
	public StatistiqueFormeJuridique()
	{
		
	}
	public StatistiqueFormeJuridique(String formejuridique,
			String nombresociete, String pourcentage) {
		super();
	this.formejuridique = formejuridique;
	this.nombresociete = nombresociete;
	this.pourcentage = pourcentage;
	
	set("formejuridique", formejuridique);
	set("nombresociete", nombresociete);
	set("pourcentage", pourcentage);
	}
	
	

}
