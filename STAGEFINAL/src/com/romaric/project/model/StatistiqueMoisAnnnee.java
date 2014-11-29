package com.romaric.project.model;

import java.io.Serializable;

import com.extjs.gxt.ui.client.data.BaseModel;

public class StatistiqueMoisAnnnee extends BaseModel {
	private static final long serialVersionUID = 1L;  
	
	 public String denomination;
	 public String activite;
	 public String siegesociale;

	 
	public String getDenomination() {
		return denomination;
	}
	public void setDenomination(String denomination) {
		this.denomination = denomination;
	}
	public String getActivite() {
		return activite;
	}
	public void setActivite(String activite) {
		this.activite = activite;
	}
	public String getSiegesociale() {
		return siegesociale;
	}
	public void setSiegesociale(String siegesociale) {
		this.siegesociale = siegesociale;
	}

	public StatistiqueMoisAnnnee(){
		
	}
	public StatistiqueMoisAnnnee(String denomination, String activite,
			String siegesociale) {
		super();
		this.denomination = denomination;
		this.activite = activite;
		this.siegesociale = siegesociale;

		
		set("denomination", denomination);
		set("activites", activite);
		set("siegesociale", siegesociale);

		
		
		
	}
	 
		 
 
}
