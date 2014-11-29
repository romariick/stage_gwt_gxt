package com.romaric.project.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.romaric.project.model.Nationalite;
import com.romaric.project.model.Entreprise;
import com.romaric.project.model.RechercheEntrepriseCode;
import com.romaric.project.model.Client;
import com.romaric.project.model.RecuperationInfoEntrepriseModif;
import com.romaric.project.model.DemandeAutorisationDEmploi;
import com.romaric.project.model.StatistiqueFormeJuridique;
import com.romaric.project.model.StatistiqueMoisAnnnee;
import com.romaric.project.model.StatistiqueNationaliteTous;
import com.romaric.project.model.StatistiqueParSecteur;
import com.romaric.project.model.StatistiqueVilleTous;


public interface GreetingServiceAsync {

	/*Connexion au base de données*/
	void conBDD(AsyncCallback<String> callback)	throws IllegalArgumentException;
	
	/*Authentification au serveur*/
	public void authentifier(String login, String pass, AsyncCallback<String> asyncCallback);
	
	
	void greetServer(String input, AsyncCallback<String> callback)
	throws IllegalArgumentException;
	
	public abstract void  getListeNationalite(AsyncCallback<Nationalite[]> asyncCallback);
	public void ajout_societe(String denom_soct, String ville, String nationalite, String secteur, String siege_soct, String fj_soct, String capital_soct, String nationalite1, String apport1,  String nationalite2, String apport2, String gerant, String associes, String activite, String rcs, String stat, String nif, String cp, String datesaisie,String combo, String mois, String annee, AsyncCallback<String> asyncCallback);

	public abstract void getStatistique_am(String mois, String annee, AsyncCallback<StatistiqueMoisAnnnee[]> asyncCallback);
	
	/********STATISTIQUE DANS UNE ANNEE **********/
	public abstract void getStatistique_dansUneAnne(String annee, AsyncCallback<StatistiqueMoisAnnnee[]> asyncCallback);
	
	public abstract void getStatistique_villeTous(String ville, String annnee, AsyncCallback<StatistiqueVilleTous[]> asyncCallback);
	public abstract void getStatistique_NationaliteTous(String nationalite, String annee, AsyncCallback<StatistiqueNationaliteTous[]> asyncCallback);
	
	/********STATISTIQUE PAR SECTEUR*********************************/
	public abstract void getStatistique_ParSecteur(String secteurs, String annee, AsyncCallback<StatistiqueParSecteur[]> asyncCallback);
	
	/************STATISTIQUE SUR FORME JURIDIQUE***********************************/
	public abstract void getStatistique_FormeJuridique(String secteurs, String annee, AsyncCallback<StatistiqueFormeJuridique[]> asyncCallback);
	
	/**************FIND ENTREPRISE *********************************/
	public abstract void findtEntreprise(String nif, AsyncCallback<RechercheEntrepriseCode[]> asyncCallback);
	
	/**************RECHERCHE ENTREPRISES A PARTIR NOM ENTREPRISE ********************/
	public abstract void  findtEntrepriseApartirNom(String nomEntre, AsyncCallback<RechercheEntrepriseCode[]> asyncCallback);
	
	/**************RECHERCHE ENTREPRISES A PARTIR NOM ENTREPRISE GLOBAL ********************/
	public abstract void findtEntrepriseApartirNomGlobal(String nomEntre, AsyncCallback<RechercheEntrepriseCode[]> asyncCallback);

	/************* RECHERCHER ENTREPRISE AVEC MODIFICATIO *******************/
	public abstract void findtEntrepriseWihtModif(String nif, AsyncCallback<RecuperationInfoEntrepriseModif[]> asyncCallback);
	
	/***************MODIFICATION ENTREPRISE **********************************************/
	public abstract void getModificationEntreprise(String nif, AsyncCallback<Entreprise[]> asyncCallback);
	public void modificationSociete(String modif, String moismodif, String annee, String nif, AsyncCallback<String> asyncCallback);
	
	/*****************AJOUT CLIENT VISA DANS LA BASE DE DONNEE **********************/
	
	/****************** AJOUT CARTE DE RESIDENT ARRIVE ANOSY *********/
	

	void RecuprPhoto(AsyncCallback<String> callback);


	void ExportationExcel(AsyncCallback<String> callback);
	
	void ExportationNationalite(AsyncCallback<String> callback);
	 
	void  ExportationVille(AsyncCallback<String> callback);
	void ExportationFormeJuridique(AsyncCallback<String> callback);
    void ExportationSecteur(AsyncCallback<String> callback);
    
    
    public void ExportationPDFEntrepriseRech(String denomination, String siege, String capital, String jf, String gerant, String secteur, String rcs, String nif, AsyncCallback<String> callback);

}
