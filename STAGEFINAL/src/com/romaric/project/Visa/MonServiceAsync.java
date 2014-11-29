package com.romaric.project.Visa;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.romaric.project.model.Client;
import com.romaric.project.model.DemandeAutorisationDEmploi;
import com.romaric.project.model.Entreprise;
import com.romaric.project.model.ModificationClient;
import com.romaric.project.model.Nationalite;
import com.romaric.project.model.RechercheEntrepriseCode;
import com.romaric.project.model.RecuperationInfoEntrepriseModif;
import com.romaric.project.model.StatistiqueFormeJuridique;
import com.romaric.project.model.StatistiqueMoisAnnnee;
import com.romaric.project.model.StatistiqueNationaliteTous;
import com.romaric.project.model.StatistiqueParSecteur;
import com.romaric.project.model.StatistiqueVilleTous;

public interface MonServiceAsync {

	
	/***********************LISTE NUMERO PASSORT mapiasa Class ListeNationalite[] ***************************/
	public abstract void  getListeNumeroPassport(AsyncCallback<Nationalite[]> asyncCallback);
	
/****************RECUPERATION INFORMATION CLIENT VISA **********************************************************/
	
	public abstract void getInformationClientVisa(String numPassport, AsyncCallback<Client[]> asyncCallback);
	/****************** AJOUT CARTE DE RESIDENT ARRIVE ANOSY *********/
	public abstract void ajoutCarteResidentEnvoyeAnosy(String numDossier, String date, AsyncCallback<String> asyncCallback);

	
	
	public void ajoutClientDemandeVisa(String nomEtPrenom,
			String dateEtlieuNaiss, 
			String numPassport, 
			String delivrance,
			String expiration,
			String adresse,
			String telephone,
			String profession,
			String societe,
			String activite,
			String capital,
			String adressSocte,
			String refVisa,
			String avisFavorable,
			String obsEnqueteur,
			String typeDeLetranger,
			String nationalite,
			String situationMatrimonial, String mail, String ville, String photo, AsyncCallback<String> asyncCallback);
	
	public void modifierClientDemandeVisa(String nomEtPrenom,
			String dateEtlieuNaiss, 
			String numPassport, 
			String delivrance,
			String expiration,
			String adresse,
			String telephone,
			String profession,
			String societe,
			String activite,
			String capital,
			String adressSocte,
			String obsEnqueteur,
			 String mail, String ville, String photo, AsyncCallback<String> asyncCallback);
	
	/***********************LISTE NUMERO PASSORT mapiasa Class ListeNationalite[] ***************************/
	
	/***************** AJOUT DANS DEMANDE VISA **********************************************/
	
	public abstract void ajoutDansDemandeVisa(String numPassport, String idDossier, String dateDepot, String numRecepisse, AsyncCallback<String> asyncCallback);
	
	/****************** AJOUT DANS ETAT DEMANDE **************************************************/
	
	public abstract void ajoutEtatDemandeVisa(String numDossier, String date, AsyncCallback<String> asyncCallback);
	
	/********************AJOUT DANS TABLE APPARTENIR(ARRIVEE ANOSY AVEC DESICION )*******************************************************/
	
	public abstract void miseAjourTableAppartenirAvecDecision(String numDossier, String date, AsyncCallback<String> asyncCallback);
	
	/****************RECUPERATION INFORMATION CLIENT VISA **********************************************************/
	

	
	public abstract void getInformationClientVisaNumDoss(String numPassport, AsyncCallback<Client[]> asyncCallback);
	
	
/*********************AJOUT PASSPORT ENVOYE ANOSY *************************************/
	
	public abstract void ajoutPassportEnvoyeAnosy(String numDossier, String date, AsyncCallback<String> asyncCallback);
	
/*********************AJOUT PASSPORT ARRIVE ANOSY *************************************/
	
	public abstract void ajoutPassportArriveAnosy(String numDossier, String date, AsyncCallback<String> asyncCallback);
	
	/*************************RECHERCHE INFORMATION A PARTIE NUM DOSSIER ***********************************************/

	public abstract void getInformationClientApartirNumDossier(String numDossier, AsyncCallback<Client[]> asyncCallback);
	
	/**********************RECHERCHE A PARTIR NUM PASSPORT *************************************************************/
	public abstract void getInformationClientApartirNumPassport(String numPassport, AsyncCallback<Client[]> asyncCallback);
	
	/**********************RECHERCHE A PARTIR NOM ET PRENOM *************************************************************/
	public abstract void getInformationClientApartirNomEtPrenom(String nomEtPrenom, AsyncCallback<Client[]> asyncCallback);

	public abstract void ExportationPDFEtranger(String nom, String dateNais, String numPass, String tel, String soct, String nationalite, String  categorie, String photo,AsyncCallback<String> asyncCallback);
	
	public abstract void ExportationPDFEtrangerDetail(String nom, String dateNais, String numPass, String tel, String soct, String nationalite, String  categorie, String photo,AsyncCallback<String> asyncCallback);
	
	public abstract void getInformationClientApartirNomEtPrenomGlobal(String nomEtPrenom, AsyncCallback<Client[]> asyncCallback);
	
	
	/**STATISTIQUE OU NOMBRES **/
	
	public abstract void RecupererNombreDossierRecueUDBM(String dateDebut, String dateFin, AsyncCallback<String> asyncCallback);

	public abstract void EnvoyeAAnosyPourDecision(String dateDebut, String dateFin, AsyncCallback<String> asyncCallback);
	public abstract void EnvoyeAAnosyAvecDecision(String dateDebut, String dateFin, AsyncCallback<String> asyncCallback);
	public abstract void PasseportEnvoyeAnosy(String dateDebut, String dateFin,  AsyncCallback<String> asyncCallback);
	public abstract void PasseportArriveAnosy(String dateDebut, String dateFin, AsyncCallback<String> asyncCallback);
	public abstract void CarteDeResidentEnvAnosy(String dateDebut, String dateFin, AsyncCallback<String> asyncCallback);
	
	public abstract void  modifierClient(String numPassport, AsyncCallback<ModificationClient[]> asyncCallback);
	
	
	public abstract void ExportationPDFStatVisaTous(String recu, String pourDec, String avecDecis, String envoyAnosy, String arrivAnosy, String carteRsdEnvAnosy, String  carteRsdArriveAnosy, AsyncCallback<String> asyncCallback);
	public abstract void AdresseIPMachine(AsyncCallback<String> asyncCallback);
	
	public abstract void modifierMotDePass(String login, String motdepasse, String encienlogin, String encienmotdepasse, AsyncCallback<String> asyncCallback);
}
