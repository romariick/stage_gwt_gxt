package com.romaric.project.model;

import com.extjs.gxt.ui.client.data.BaseModel;

public class StatistiqueVilleTous extends BaseModel{
	
	private static final long serialVersionUID = 1L;  
	
	public String nomville;
	public String nombreEntreprise;
	public String pourcentage;
	
	public String getNomville() {
		return nomville;
	}
	public void setNomville(String nomville) {
		this.nomville = nomville;
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
	
	public StatistiqueVilleTous()
	{
		
	}
	public StatistiqueVilleTous(String nomville, String nombreEntreprise,
			String pourcentage) {
		super();
		this.nomville = nomville;
		this.nombreEntreprise = nombreEntreprise;
		this.pourcentage = pourcentage;
		
		set("ville", nomville);
		set("nombres", nombreEntreprise);
		set("pourcentage", pourcentage);
		
	}
	
	
	

}
