package com.romaric.project.client;

import java.io.FileNotFoundException;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
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


@RemoteServiceRelativePath("greet")
public interface GreetingService extends RemoteService {
	
	/*Connexion à la base de données*/
	String conBDD();
	
	/*Authentification au sérveur*/
	public String authentifier(String login, String pass);
	
	public Nationalite[] getListeNationalite();
	public StatistiqueMoisAnnnee[] getStatistique_am(String mois, String annee);
	
	/********STATISTIQUE DANS UNE ANNEE **********/
	public StatistiqueMoisAnnnee[] getStatistique_dansUneAnne(String annee);
	
	/******************STATISTIQUE VILLE TOUS*/
	public StatistiqueVilleTous[] getStatistique_villeTous(String ville, String annee);
	
	/*STATISTIQUE NATIONALITE*/
	public StatistiqueNationaliteTous[] getStatistique_NationaliteTous(String nationalite, String annee);
	String greetServer(String name) throws IllegalArgumentException;
	
	/***********STATISTIQUE PAR SECTEUR********************************/
	public StatistiqueParSecteur[] getStatistique_ParSecteur(String secteur, String annee);
	
	/************STATISTIQUE SUR FORME JURIDIQUE***********************/
	
	public StatistiqueFormeJuridique[] getStatistique_FormeJuridique(String fj, String annee);
	
	/**************RECHERCHE ENTREPRISES A PARTIR NIF ********************/
	public RechercheEntrepriseCode[] findtEntreprise(String nif);
	
	/**************RECHERCHE ENTREPRISES A PARTIR NOM ENTREPRISE ********************/
	public RechercheEntrepriseCode[] findtEntrepriseApartirNom(String nomEntre);
	
	/**************RECHERCHE ENTREPRISES A PARTIR NOM ENTREPRISE GLOBAL ********************/
	public RechercheEntrepriseCode[] findtEntrepriseApartirNomGlobal(String nomEntre);
	
	
	/**************RECHERCHE ENTREPRISES AVEC MODIFICATION ********************/
	public RecuperationInfoEntrepriseModif[] findtEntrepriseWihtModif(String nif);

	
	/******************MODIFICATION SOCIETE ***********************************/
	public Entreprise[] getModificationEntreprise(String nif);
	public String modificationSociete(String modif, String moismodif, String annee, String nif);
	
	
	public String ajout_societe(String denom_soct, 
			String siege_soct,
			String nationalite,
			String ville,
			String secteur,
			String fj_soct, 
			String capital_soct, 
			String nationalite1, 
			String apport1,  
			String nationalite2, 
			String apport2, 
			String gerant, 
			String associes,
			String activite,
			String rcs,
			String stat,
			String nif,
			String cp,
			String datesaisie,
			String combo,
			String mois,
			String annee);
	


	public String RecuprPhoto();

	
	
	/********Exportation EXCEL
	 * @throws FileNotFoundException **************/
	
	public String  ExportationExcel();
	public String ExportationNationalite();
	
	public String ExportationVille();
	
	public String ExportationFormeJuridique();
	
	public String ExportationSecteur();
	
	
	public String ExportationPDFEntrepriseRech(String denomination, String siege, String capital, String jf, String gerant, String secteur, String rcs, String nif);
}
