package com.romaric.project.model;

import com.extjs.gxt.ui.client.data.BaseModel;

public class RechercheEntrepriseCode extends BaseModel{
	
	private static final long serialVersionUID = 1L;  
	
	public String denomination;
	public String siege;
	public String capital;
	public String fj;
	public String rcs;
	public String activite;
	public String gerant;
	public String stat;
	public String nationalite;
	public String modification;
	public String datemodif;
	public String valeur;
	
	
	
	public String getDenomination() {
		return denomination;
	}
	public void setDenomination(String denomination) {
		this.denomination = denomination;
	}
	public String getSiege() {
		return siege;
	}
	public void setSiege(String siege) {
		this.siege = siege;
	}
	public String getCapital() {
		return capital;
	}
	public void setCapital(String capital) {
		this.capital = capital;
	}
	public String getFj() {
		return fj;
	}
	public void setFj(String fj) {
		this.fj = fj;
	}
	
	public String getRcs() {
		return rcs;
	}
	public void setRcs(String rcs) {
		this.rcs = rcs;
	}
	
	public String getActivite() {
		return activite;
	}
	public void setActivite(String activite) {
		this.activite = activite;
	}
	
	public String getGerant() {
		return gerant;
	}
	public void setGerant(String gerant) {
		this.gerant = gerant;
	}
	
	
	public String getStat() {
		return stat;
	}
	public void setStat(String stat) {
		this.stat = stat;
	}
	
	
	public String getNationalite() {
		return nationalite;
	}
	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}
	
	public String getModification() {
		return modification;
	}
	public void setModification(String modification) {
		this.modification = modification;
	}
	public String getDatemodif() {
		return datemodif;
	}
	public void setDatemodif(String datemodif) {
		this.datemodif = datemodif;
	}
	public String getValeur() {
		return valeur;
	}
	public void setValeur(String valeur) {
		this.valeur = valeur;
	}
	public RechercheEntrepriseCode(){
		
	}
	
	public RechercheEntrepriseCode(String denomination, String siege, String capital,
			String fj, String rcs, String activite, String gerant, String stat, String nationalite, String modification, String datemodif, String valeur) {
		super();
		this.denomination = denomination;
		this.siege = siege;
		this.capital = capital;
		this.fj = fj;
		this.rcs = rcs;
		this.activite = activite;
		this.gerant = gerant;
		this.stat = stat;
		this.nationalite = nationalite;
		this.modification = modification;
		this.datemodif = datemodif;
		this.valeur = valeur;
		
			
		set("denomination", denomination);
		set("siege", siege);
		set("capital", capital);
		set("fj", fj);
		set("gerant", gerant);
		set("modification", modification);
		set("datemodif", datemodif);
		set("valeur", valeur);
		

	}
	
	

}
