package com.romaric.project.model;

import com.extjs.gxt.ui.client.data.BaseModel;
import com.google.gwt.core.client.GWT;

public class Entreprise extends BaseModel{
	
	private static final long serialVersionUID = 1L;
	
	public String denomination;
	public String siegesocial;
	public String fj;
	public String capital;
	public String activites;
	public String gerants;
	public String modification;
	public String rcs;
	public String stat;
	public String moismodif;
	public String anneemodif;
	public String getDenomination() {
		return denomination;
	}
	public void setDenomination(String denomination) {
		this.denomination = denomination;
	}
	public String getSiegesocial() {
		return siegesocial;
	}
	public void setSiegesocial(String siegesocial) {
		this.siegesocial = siegesocial;
	}
	public String getFj() {
		return fj;
	}
	public void setFj(String fj) {
		this.fj = fj;
	}
	public String getCapital() {
		return capital;
	}
	public void setCapital(String capital) {
		this.capital = capital;
	}
	public String getActivites() {
		return activites;
	}
	public void setActivites(String activites) {
		this.activites = activites;
	}
	public String getGerants() {
		return gerants;
	}
	public void setGerants(String gerants) {
		this.gerants = gerants;
	}
	public String getModification() {
		return modification;
	}
	public void setModification(String modification) {
		this.modification = modification;
	}
	public String getRcs() {
		return rcs;
	}
	public void setRcs(String rcs) {
		this.rcs = rcs;
	}
	public String getStat() {
		return stat;
	}
	public void setStat(String stat) {
		this.stat = stat;
	}
	public String getMoismodif() {
		return moismodif;
	}
	public void setMoismodif(String moismodif) {
		this.moismodif = moismodif;
	}
	public String getAnneemodif() {
		return anneemodif;
	}
	public void setAnneemodif(String anneemodif) {
		this.anneemodif = anneemodif;
	}
	
	public Entreprise(){
		
	}
	public Entreprise(String denomination, String siegesocial,
			String fj, String capital, String activites, String gerants,
			String modification, String rcs, String stat, String moismodif,
			String anneemodif) {
		super();
		this.denomination = denomination;
		this.siegesocial = siegesocial;
		this.fj = fj;
		this.capital = capital;
		this.activites = activites;
		this.gerants = gerants;
		this.modification = modification;
		this.rcs = rcs;
		this.stat = stat;
		this.moismodif = moismodif;
		this.anneemodif = anneemodif;
	}
	
}
