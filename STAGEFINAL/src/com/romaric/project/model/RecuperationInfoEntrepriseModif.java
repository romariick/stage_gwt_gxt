package com.romaric.project.model;

import com.extjs.gxt.ui.client.data.BaseModel;

public class RecuperationInfoEntrepriseModif extends BaseModel{
	
	private static final long serialVersionUID = 1L;
	
	public String denomination;
	public String modification;
	public String dateModif;
	public String valeur;

	
	public String getDenomination() {
		return denomination;
	}
	public void setDenomination(String denomination) {
		this.denomination = denomination;
	}
	public String getModification() {
		return modification;
	}
	public void setModification(String modification) {
		this.modification = modification;
	}
	public String getDateModif() {
		return dateModif;
	}
	public void setDateModif(String dateModif) {
		this.dateModif = dateModif;
	}
	public String getValeur() {
		return valeur;
	}
	public void setValeur(String valeur) {
		this.valeur = valeur;
	}
	public RecuperationInfoEntrepriseModif(){
	}
	public RecuperationInfoEntrepriseModif(String denomination, String modification,
			String dateModif, String valeur) {
		super();
		this.denomination = denomination;
		this.modification = modification;
		this.dateModif = dateModif;
		this.valeur = valeur;
		

		set("denomination", denomination);
		set("modification", modification);
		set("datemodif", dateModif);
		set("valeur", valeur);
	}
	


}
