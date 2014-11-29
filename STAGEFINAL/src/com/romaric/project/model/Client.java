package com.romaric.project.model;

import com.extjs.gxt.ui.client.data.BaseModel;

public class Client extends BaseModel{

	private static final long serialVersionUID = 1L; 
	
	public String nomEtPrenom;
	public String dateNaiss;
	public String adresse;
	public String numPassport;
	public String typeEtranger;
	public String etatDossier;
	public String dateEtat;
	public String dateDelivrance;
	public String expiration;
	public String nationalite;

	public String getNomEtPrenom() {
		return nomEtPrenom;
	}
	public void setNomEtPrenom(String nomEtPrenom) {
		this.nomEtPrenom = nomEtPrenom;
	}
	public String getDateNaiss() {
		return dateNaiss;
	}
	public void setDateNaiss(String dateNaiss) {
		this.dateNaiss = dateNaiss;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	public String getNumPassport() {
		return numPassport;
	}
	public void setNumPassport(String numPassport) {
		this.numPassport = numPassport;
	}
	
	public String getTypeEtranger() {
		return typeEtranger;
	}
	public void setTypeEtranger(String typeEtranger) {
		this.typeEtranger = typeEtranger;
	}
	
	
	public String getEtatDossier() {
		return etatDossier;
	}
	public void setEtatDossier(String etatDossier) {
		this.etatDossier = etatDossier;
	}
	
	public String getDateEtat() {
		return dateEtat;
	}
	public void setDateEtat(String dateEtat) {
		this.dateEtat = dateEtat;
	}
	
	public String getDateDelivrance() {
		return dateDelivrance;
	}
	public void setDateDelivrance(String dateDelivrance) {
		this.dateDelivrance = dateDelivrance;
	}
	public String getExpiration() {
		return expiration;
	}
	public void setExpiration(String expiration) {
		this.expiration = expiration;
	}
	
	
	public String getNationalite() {
		return nationalite;
	}
	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}
	public Client(){
		
	}
	public Client(String nomEtPrenom,
			String dateNaiss, String adresse, String numPassport, String typeEtranger, String etatDossier, String dateEtat, String dateDelivrance, String expiration, String nationalite) {
		super();
		this.nomEtPrenom = nomEtPrenom;
		this.dateNaiss = dateNaiss;
		this.adresse = adresse;
		this.numPassport = numPassport;
		this.typeEtranger = typeEtranger;
		this.etatDossier = etatDossier;
		this.dateEtat = dateEtat;
		this.dateDelivrance = dateDelivrance;
		this.expiration = expiration;
		this.nationalite = nationalite;
		
		
		set("nomEtPrenom", nomEtPrenom);
		set("dateNaiss", dateNaiss);
		set("adresse", adresse);
		set("numPassport", numPassport);
		set("typeEtranger", typeEtranger);
		set("etatDossier", etatDossier);
		set("dateEtat", dateEtat);
		set("dateDelivrance", dateDelivrance);
		set("expiration", expiration);
		set("nationalite", nationalite);
	}
	

}
