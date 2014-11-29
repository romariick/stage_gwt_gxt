package com.romaric.project.Visa;


import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.romaric.project.model.Client;
import com.romaric.project.model.ModificationClient;
import com.romaric.project.model.Nationalite;




@RemoteServiceRelativePath("MonService")
public interface MonService extends RemoteService{

	public String ajoutClientDemandeVisa(String nomEtPrenom,
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
			String situationMatrimonial,
			String mail,
			String ville,
			String photo
			
			);
	
	public String modifierClientDemandeVisa(String nomEtPrenom,
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
			String mail,
			String ville,
			String photo
			
			);
	
	/****************LISTE NUMERO VISA **********************/
	
	public Nationalite[] getListeNumeroPassport();
	
	/****************RECUPERATION INFORMATION CLIENT VISA **********************************************************/
	
	public Client[] getInformationClientVisa(String numPassport);
	
	
	/**********************AJOUT DANS LA TABLE DEMANDE VISA ***********************************/
	public String ajoutDansDemandeVisa(String numPassport, String idDossier, String dateDepot, String numRecepisse);
	
	/*************************AJOUT DE L'ETAT DE DEMANDE *************************************************/
	
	public String ajoutEtatDemandeVisa(String numDossier, String date);
	
	/**********MISE A JOUR DU DE LA TABLE APPARTENIR(ARRIVEE ANOSY AVEC DECISION ****************************/
	public String miseAjourTableAppartenirAvecDecision(String numDossier, String date);
	
	/****************** AJOUT CARTE DE RESIDENT ARRIVE ANOSY *********/
	public String ajoutCarteResidentEnvoyeAnosy(String numDossier, String date);
	
	/****************RECUPERATION INFORMATION CLIENT VISA **********************************************************/
	

	
	public Client[] getInformationClientVisaNumDoss(String numPassport);

	/*********************AJOUT PASSPORT ENVOYE ANOSY *************************************/
	
	public String ajoutPassportEnvoyeAnosy(String numDossier, String date);
	
	/*********************AJOUT PASSPORT ENVOYE ANOSY *************************************/
	
	public String ajoutPassportArriveAnosy(String numDossier, String date);

	
	/*************************RECHERCHE INFORMATION A PARTIE NUM DOSSIER ***********************************************/

	public Client[] getInformationClientApartirNumDossier(String numDossier);
	
	/**********************RECHERCHE A PARTIR NUM PASSPORT *************************************************************/
	public Client[] getInformationClientApartirNumPassport(String numPassport);
	
	/**********************RECHERCHE A PARTIR NOM ET PRENOM *************************************************************/
	public Client[] getInformationClientApartirNomEtPrenom(String nomEtPrenom);
	
	public String ExportationPDFEtranger(String nom, String dateNais, String numPass, String tel, String soct, String nationalite, String  categorie, String photo);
	
	
	public String ExportationPDFEtrangerDetail(String nom, String dateNais, String numPass, String tel, String soct, String nationalite, String  categorie, String photo);
	/**********************RECHERCHE A PARTIR NOM ET PRENOM GLOBAL *************************************************************/
	public Client[] getInformationClientApartirNomEtPrenomGlobal(String nomEtPrenom);
	
	
	/**STATISTIQUE OU NOMBRES **/
	
	public String RecupererNombreDossierRecueUDBM(String dateDebut, String dateFin);
	
	public String EnvoyeAAnosyPourDecision(String dateDebut, String dateFin);
	public String EnvoyeAAnosyAvecDecision(String dateDebut, String dateFin);
	
	public String PasseportEnvoyeAnosy(String dateDebut, String dateFin);
	public String PasseportArriveAnosy(String dateDebut, String dateFin);
	public String CarteDeResidentEnvAnosy(String dateDebut, String dateFin);
	
	public ModificationClient[] modifierClient(String numPassport);
	
	public String ExportationPDFStatVisaTous(String recu, 
			String pourDec, 
			String avecDecis,
			String envoyAnosy, 
			String arrivAnosy, 
			String carteRsdEnvAnosy, 
			String  carteRsdArriveAnosy);
	
	public String AdresseIPMachine();
	
	
	public String modifierMotDePass(String login, String motdepasse, String encienlogin, String encienmotdepasse);

}