package com.romaric.project.model;

import com.extjs.gxt.ui.client.data.BaseModel;

public class ModificationClient extends BaseModel{

	private static final long serialVersionUID = 1L;
	public String nomEtPrenom;
	public String dateNaiss;
	public String numPassport;
	public String delivrance;
	public String expiration;
	public String adresse;
	public String tel;
	public String profession;
	public String societe;
	public String activite;
	public String capital;
	public String sctAdresse;
	public String observation;
	public String mail;
	

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


	public String getNumPassport() {
		return numPassport;
	}


	public void setNumPassport(String numPassport) {
		this.numPassport = numPassport;
	}


	public String getDelivrance() {
		return delivrance;
	}


	public void setDelivrance(String delivrance) {
		this.delivrance = delivrance;
	}


	public String getExpiration() {
		return expiration;
	}


	public void setExpiration(String expiration) {
		this.expiration = expiration;
	}


	public String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public String getTel() {
		return tel;
	}


	public void setTel(String tel) {
		this.tel = tel;
	}


	public String getProfession() {
		return profession;
	}


	public void setProfession(String profession) {
		this.profession = profession;
	}


	public String getSociete() {
		return societe;
	}


	public void setSociete(String societe) {
		this.societe = societe;
	}


	public String getActivite() {
		return activite;
	}


	public void setActivite(String activite) {
		this.activite = activite;
	}


	public String getCapital() {
		return capital;
	}


	public void setCapital(String capital) {
		this.capital = capital;
	}


	public String getSctAdresse() {
		return sctAdresse;
	}


	public void setSctAdresse(String sctAdresse) {
		this.sctAdresse = sctAdresse;
	}


	public String getObservation() {
		return observation;
	}


	public void setObservation(String observation) {
		this.observation = observation;
	}


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public ModificationClient(){
		
	}


	public ModificationClient(String nomEtPrenom, String dateNaiss,
			String numPassport, String delivrance, String expiration,
			String adresse, String tel, String profession, String societe,
			String activite, String capital, String sctAdresse,
			String observation, String mail) {
		super();
		this.nomEtPrenom = nomEtPrenom;
		this.dateNaiss = dateNaiss;
		this.numPassport = numPassport;
		this.delivrance = delivrance;
		this.expiration = expiration;
		this.adresse = adresse;
		this.tel = tel;
		this.profession = profession;
		this.societe = societe;
		this.activite = activite;
		this.capital = capital;
		this.sctAdresse = sctAdresse;
		this.observation = observation;
		this.mail = mail;
	}
	
	
	
}
