package com.romaric.project.server;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import jxl.Sheet;
import jxl.Workbook;
import jxl.format.Border;
import jxl.format.Colour;
import jxl.read.biff.BiffException;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;


import com.romaric.project.client.GreetingService;
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
import com.romaric.project.server.conBDD;


import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;
/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements
		GreetingService{
	
	 int enreg;
	 int res; // Récuperer codeactivité
	 
	 //Statistique par mois pour Excel
	 
	 Vector<String> moisAnnee = new Vector<String>();
	 Vector<String> pourcent = new Vector<String>();
	 Vector<String> denomination = new Vector<String>();
	 
	 //Statistique nationalite
	 Vector<String> StatNationalite = new Vector<String>();
	 Vector<String> StatNombreEseNation = new Vector<String>();
	 Vector<String> StatPourcentageNation = new Vector<String>();
	 
	 
	 //Statistique ville tous
	 Vector<String> StatVille = new Vector<String>();
	 Vector<String> StatNombreEseVille = new Vector<String>();
	 Vector<String> StatPourcentageVille = new Vector<String>();
	 
	 
	 //Statistique Forme juridique
	 Vector<String> StatFJ = new Vector<String>();
	 Vector<String> StatNombreEseFJ = new Vector<String>();
	 Vector<String> StatPourcentageFJ = new Vector<String>();
	 
	 
	 //Statistique par secteur
	 Vector<String> StatSecteur = new Vector<String>();
	 Vector<String> StatNombreEseSecteur = new Vector<String>();
	 Vector<String> StatPourcentageSecteur = new Vector<String>();

/*Connexion à la base de données*/
	
	public String conBDD() {
		 
		String requete = "SELECT login, motdepasse from utilisateur";
		conBDD connexion = new conBDD();
		
		ResultSet resultat=connexion.getData(requete);
		
		if (resultat == null)
		return null;
		try {
			while (resultat.next())
			{
				String p = "";
				
				p = (resultat.getString("login"));
				p = (resultat.getString("motdepasse"));
 
				return p;
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
			
			return "ok";
		}
		return "connexion";
	
	}
	
/***************** Authefication des utilisateurs **********************/
	public String authentifier(String login, String pass)
	{
		String msg = "";
		String rqt = "select login, motdepasse, groupe from utilisateur where login = '"+login+"' and motdepasse = '"+pass+"';";
		
		conBDD connexion = new conBDD();
		
	    try {
	   
	    	ResultSet result  = connexion.st.executeQuery(rqt);	
	    	
	        
	        while(result.next())
	        {	
	        	String a = result.getString("login");
	        	String b = result.getString("motdepasse");
	        	String c = result.getString("groupe");
	        	
	        	System.out.println("login: "+ a +"...p: "+b+"ville:"+c);
	        	
	        	if(b.equals(pass) && (a.equals(login)))
	        	{
	        		msg = c;
	        	}
	        	else
	        		msg = "Echec";
	      	
	        }
	        
	    } 
	    catch(Exception e) {
	    	
	    	System.err.println("Mysql Statement Error: " + rqt);
	    	e.printStackTrace(); 	
	    }
	    

	    return msg; 
	}
	
/*************OBTNENIR LES LISTES DES NATIONALITES ***************/	

	public Nationalite[] getListeNationalite()
	{
		String rqt = "SELECT * from nationalites";
		Nationalite[] liste = null;
		conBDD connexion = new conBDD();
		
	    try {
	 	   
	    	ResultSet result  = connexion.st.executeQuery(rqt);

	    	liste = new Nationalite[10];
	        
	        int i = 0;
	        
	        while (result.next()) {
	        	liste[i] = new Nationalite(result.getString("nationalite"));
	        	System.out.println("Liste nationalite:"+liste[i].nationalite);
	            i++;
	        }     
	    } catch(Exception e) {
	    	
	    	System.err.println("Mysql Statement Error: " + rqt);
	    	e.printStackTrace();	
	    }
		
		return liste;
	}
/**************************AJOUER LES LISTES DES ENTREPRISES AUX BASES DE DONNEES******/
public String ajout_societe(String denom_soct, String ville, String nationalite, String secteur, String siege_soct, String fj_soct, String capital_soct, String nationalite1, String apport1,  String nationalite2, String apport2, String gerant, String associes, String activite, String rcs, String stat, String nif, String cp, String datesaisie, String combo, String mois, String annee)
{		
	conBDD connexion = new conBDD();
	int nombrEnreg = NombreEnregistremen() + 1;
	int codeactivt = RecupererCodeActivite(combo);
	
	String rqt = "INSERT INTO entreprise VALUES("+nombrEnreg+","+"'"+ville+"'"+","+"'"+nationalite+"'"+","+"'"+secteur+"'"+","+codeactivt+","+"'"+fj_soct+"'"+","+"'"+denom_soct+"'"+","+"'"+siege_soct+"'"+","+"'"+capital_soct+"'"+","+"'"+apport1+"'"+","+"'"+apport2+"'"+","+"'"+gerant+"'"+","+"'"+associes+"'"+","+"'"+activite+"'"+","+"'"+rcs+"'"+","+"'"+stat+"'"+","+"'"+nif+"'"+","+"'"+cp+"'"+","+"'"+annee+"'"+","+"'"+mois+"'"+","+"'"+datesaisie+"'"+")";
	
	System.out.println(rqt);
	String msg = "";
	
	try {
		connexion.st.executeUpdate(rqt);
		msg="Ajout réussi!";
		
	} catch (SQLException e) {
		e.printStackTrace();
		msg="Ajout échoué!";
	}
	 
	 
	return msg;
	}

	/***************Récupérer les nombres d'enregistrements des entreprises*/
	public  int NombreEnregistremen()
	{
		int vil = 0;
		
		conBDD connexion = new conBDD();
		
		String rqt = "select MAX(idsociete) AS Nombre from entreprise";
		
		try {
			ResultSet rs = connexion.st.executeQuery(rqt);
			
			while (rs.next())
			{		
				 vil = rs.getInt("Nombre");
		
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return vil;
	}

/*Recuperer le code d'activite du type séléctionner */
	
	public int RecupererCodeActivite(String combo)
	{
		conBDD connexion = new conBDD();
				
		String rqt = "SELECT * from typesociete where typesociete ="+"'"+combo+"'";
		
		try {
			ResultSet result  = connexion.st.executeQuery(rqt);
			
			while (result.next()) 
			{
				 res = result.getInt("codetypesociete");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}

/******************OBTENIR LES STATISTIQUES ANNEE ET MOIS******************/
	@Override
	public StatistiqueMoisAnnnee[] getStatistique_am(String mois, String annee) {
		// TODO Auto-generated method stub
		StatistiqueMoisAnnnee[] liste = null;
		
		int janv[] = NombreEntrepriseJanvier(mois, annee);
		
		
		int sommeEntr = SommeEntrepriseCree();
		String[] listeMois = {"Janvier", "Février", "Mars", "Avril", "Mai", "Juin", "Juillet", "Août", "Septembre", "Octobre", "Novembre", "Decembre"};
		
		String rqt = "SELECT denomination, activities, siegesociale, nomville, typesecteur, annee from entreprise where mois = "+"'"+mois+"'"+" AND annee = "+"'"+annee+"'";
		
    	liste = new StatistiqueMoisAnnnee[100];
        
        int i = 0;
        
        System.out.println("Nombre dans iiii:"+janv.length);
		 moisAnnee.clear();
		 pourcent.clear();
        while (i < janv.length) {
        	
        	double percent1 = (double)(100 * janv[i]) / sommeEntr;

			 liste[i] = new StatistiqueMoisAnnnee(listeMois[i], janv[i]+"", ""+percent1);
	    

			 
			 moisAnnee.add(janv[i]+"");
			 pourcent.add(""+percent1);
	    	 i++;
           
        }
	
		return liste;
	}
	
public int[] NombreEntrepriseJanvier(String mois, String annee)
{
	int janv[] = new int[12];
	int ms = Integer.parseInt(mois);
	int ans = Integer.parseInt(annee);
	
	System.out.println("Mois:"+ms+"Annee:"+ans);
	
	conBDD connexion = new conBDD();
	
	ResultSet result;
	
	try {
		
		for(int i = 0; i < ms; i++)
		{
			
			//if(i == (ms - 1))
			//{
			int buf = i+1;
			
			String rqt = "SELECT COUNT(*) total from entreprise where mois ="+"'"+buf+"'"+" AND annee = "+"'"+ans+"'";
			
			System.out.println(rqt);
			result = connexion.st.executeQuery(rqt);
		  
			while(result.next())
			{
				String resultat = result.getString("total");
			
				
				janv[i] = Integer.parseInt(resultat);
				System.out.println("Resultat beuhhhhhhh:"+i+":"+janv[i]);
		    }
			}
			
		//}
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return janv;
}


/******************OBTENIR LES STATISTIQUES ANNEE ET MOIS******************/

public StatistiqueMoisAnnnee[] getStatistique_dansUneAnne(String annee) {
	// TODO Auto-generated method stub
	StatistiqueMoisAnnnee[] liste = null;
	
	int janv[] = NombreEntrepriseDansUneAnnee(annee);
	
	
	int sommeEntr = SommeEntrepriseCree();
	String[] listeMois = {"Janvier", "Février", "Mars", "Avril", "Mai", "Juin", "Juillet", "Août", "Septembre", "Octobre", "Novembre", "Decembre"};
	
	//String rqt = "SELECT denomination, activities, siegesociale, nomville, typesecteur, annee from entreprise where mois = "+"'"+mois+"'"+" AND annee = "+"'"+annee+"'";
	
	liste = new StatistiqueMoisAnnnee[100];
    
    int i = 0;
    
    System.out.println("Nombre dans iiii:"+janv.length);
    
    while (i < janv.length) {
    	
    	double percent1 = (double)(100 * janv[i]) / sommeEntr;

		 liste[i] = new StatistiqueMoisAnnnee(listeMois[i], janv[i]+"", ""+percent1);
    
    	 i++;
  	       
    	//liste[i] = new StatistiqueMoisAnnnee(janv[i]+"", result.getString("denomination"), result.getString("activities"), result.getString("siegesociale") , result.getString("typesecteur"));
    		
       
    }

	return liste;
}

public int[] NombreEntrepriseDansUneAnnee(String annee)
{
	int janv[] = new int[12];
	
	int ans = Integer.parseInt(annee);
	
	
	
	conBDD connexion = new conBDD();
	
	ResultSet result;
	
	try {
		
		for(int i = 0; i < 12; i++)
		{
			
			int buf = i+1;
			
			String rqt = "SELECT COUNT(*) total from entreprise where mois ="+"'"+buf+"'"+" AND annee = "+"'"+ans+"'";
			
			System.out.println(rqt);
			result = connexion.st.executeQuery(rqt);
		  
			while(result.next())
			{
				String resultat = result.getString("total");
			
				
				janv[i] = Integer.parseInt(resultat);
				System.out.println("Resultat beuhhhhhhh:"+i+":"+janv[i]);
		    }
			
			
		}
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

return janv;
}


/**************************STATISTIQUE DE TOUS LES VILLES*************************/
	
	@Override
	public StatistiqueVilleTous[] getStatistique_villeTous(String ville, String annee) {
		// TODO Auto-generated method stub
		StatistiqueVilleTous[] liste = null;
		int nombreEnregParVille;
		int sommeSctCree;
		String rqtGeneral = null;
		
		if(ville.equals("Tous"))
		{
			String rqt1 = "SELECT DISTINCT nomville, annee from entreprise where annee = '"+annee+"'";
			rqtGeneral = rqt1;
		}
		else
		{
			String rqt2 = "SELECT DISTINCT nomville, annee from entreprise where nomville ="+"'"+ville+"'"+"AND annee ="+"'"+annee+"'";
			rqtGeneral = rqt2;
		}
		//String rqt = "SELECT DISTINCT nomville from entreprise";
		
		conBDD connexion = new conBDD();
		
		
	    try {
		 	   
	    	ResultSet result  = connexion.st.executeQuery(rqtGeneral);

	    	liste = new StatistiqueVilleTous[100];
	        
	        int i = 0;
	        

        	StatVille.clear();
        	StatNombreEseVille.clear();
        	StatPourcentageVille.clear();
        	
        	
	        while (result.next()) {
	        
	        	nombreEnregParVille = NombreEntrepriseParVille(result.getString("nomville"));
	        	sommeSctCree = SommeEntrepriseCree();
	        	
	        	double pourcentage = (double)(100 * nombreEnregParVille) / sommeSctCree;
	        	
	        	liste[i] = new StatistiqueVilleTous(result.getString("nomville"), ""+nombreEnregParVille, ""+pourcentage);

	        	
	        	StatVille.add(result.getString("nomville"));
	        	StatNombreEseVille.add(""+nombreEnregParVille);
	        	StatPourcentageVille.add(""+pourcentage);
	            i++;
	        }
	        
	    } catch(Exception e) {
	    	
	    	System.err.println("Mysql Statement Error: " + rqtGeneral);
	    	e.printStackTrace(); 	
	    }


		return liste;
	}

	
	public int NombreEntrepriseParVille(String ville)
	{
		
		
		conBDD connexion = new conBDD();
		int nombreRess = 0;
		
		ResultSet rs1;
		
		try {
			rs1 = connexion.st.executeQuery("SELECT COUNT(*) total from entreprise where nomville = "+"'"+ville+"'");
			rs1.next();
			nombreRess = rs1.getInt("total");
			rs1.close();
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
		return nombreRess;
	}
	
   public int SommeEntrepriseCree()
   {
	   int ret = 0;
	   
		ResultSet rs2;
		conBDD connexion = new conBDD();
		
		try {
			rs2 = connexion.st.executeQuery("SELECT COUNT(*) totales from entreprise");
			rs2.next();
			ret = rs2.getInt("totales");
			rs2.close();
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	   
	   return ret;
   }
   
/*Statistique nationalite tous*/
   
public StatistiqueNationaliteTous[] getStatistique_NationaliteTous(String nationalite, String annee) {
		// TODO Auto-generated method stub
		StatistiqueNationaliteTous[] liste = null;
		int nombreNationalite;
		int sommeSctCree;
		String rqtGeneral = null;
		
		if(nationalite.equals("Tous"))
		{
			String rqt1 = "SELECT DISTINCT nationalite from entreprise where annee ="+"'"+annee+"'";
			rqtGeneral = rqt1;
		}
		else
		{
			String rqt2 = "SELECT DISTINCT nationalite, annee from entreprise where nationalite ="+"'"+nationalite+"'"+"AND annee ="+"'"+annee+"'";
			rqtGeneral = rqt2;
		}
		conBDD connexion = new conBDD();
		
	    try {
		 	   
	    	ResultSet result  = connexion.st.executeQuery(rqtGeneral);

	    	liste = new StatistiqueNationaliteTous[100];
	        
	        int i = 0;
	        
        	StatNationalite.clear();
        	StatNombreEseNation.clear();
        	StatPourcentageNation.clear();
	        while (result.next()) {
	        
	        	nombreNationalite = NombreNationalite(result.getString("nationalite"));    	
	        	sommeSctCree = SommeEntrepriseCree();
	        	
	        	
	        	System.out.println("Nationalite tous:"+i);
	        	
	        	double pourcentage = (double)(100 * nombreNationalite) / sommeSctCree;
	        	
	        	
	        	liste[i] = new StatistiqueNationaliteTous(result.getString("nationalite"), ""+nombreNationalite, ""+pourcentage);
	        	

	        	
	        	StatNationalite.add(result.getString("nationalite"));
	        	StatNombreEseNation.add(""+nombreNationalite);
	        	StatPourcentageNation.add(""+pourcentage);
	            i++;
	        }
	        
	    } catch(Exception e) {
	    	
	    	System.err.println("Mysql Statement Error: " + rqtGeneral);
	    	e.printStackTrace(); 	
	    }


		return liste;
	}
	
	public int NombreNationalite(String nationalite)
	{	
		int nombreRess = 0;
		conBDD connexion = new conBDD();
		
		ResultSet rs1;
		
		try {
			rs1 = connexion.st.executeQuery("SELECT COUNT(*) total from entreprise where nationalite = "+"'"+nationalite+"'");
			rs1.next();
			nombreRess = rs1.getInt("total");
			rs1.close();
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
		return nombreRess;
	}
	
/****************Statistique par sécteur***************************************/
	
   public StatistiqueParSecteur[] getStatistique_ParSecteur(String secteurs, String annee) {
	
		StatistiqueParSecteur[] liste = null;
		int nombreSecteur;
		int sommeSctCree;
		String rqtGeneral = null;
		
		if(secteurs.equals("Tous"))
		{
			String rqt1 = "SELECT DISTINCT typesecteur from entreprise where annee ="+"'"+annee+"'";
			rqtGeneral = rqt1;
		}
		else
		{
			String rqt2 = "SELECT DISTINCT typesecteur, annee from entreprise where typesecteur ="+"'"+secteurs+"'"+"AND annee ="+"'"+annee+"'";
			rqtGeneral = rqt2;
		}
		conBDD connexion = new conBDD();
		
	    try {
		 	   
	    	ResultSet result  = connexion.st.executeQuery(rqtGeneral);

	    	liste = new StatistiqueParSecteur[100];
	        
	        int i = 0;
	        
        	
        	StatSecteur.clear();
        	StatNombreEseSecteur.clear();
        	StatPourcentageSecteur.clear();
        	
	        while (result.next()) {
	        
	        	nombreSecteur = NombreSecteur(result.getString("typesecteur"));    	
	        	sommeSctCree = SommeEntrepriseCree();
	        	
	        	double pourcentage = (double)(100 * nombreSecteur) / sommeSctCree;
	        	
	        	liste[i] = new StatistiqueParSecteur(result.getString("typesecteur"), ""+nombreSecteur, ""+pourcentage+"%");

	        	
	        	StatSecteur.add(result.getString("typesecteur"));
	        	StatNombreEseSecteur.add(""+nombreSecteur);
	        	StatPourcentageSecteur.add(""+pourcentage);
	            i++;
	        }
	        
	    } catch(Exception e) {
	    	
	    	System.err.println("Mysql Statement Error: " + rqtGeneral);
	    	e.printStackTrace(); 	
	    }


		return liste;
	}
	
 public int NombreSecteur(String secteurs)
 {
		int nombreRess = 0;
		conBDD connexion = new conBDD();
		
		ResultSet rs1;
		
		try {
			rs1 = connexion.st.executeQuery("SELECT COUNT(*) total from entreprise where typesecteur = "+"'"+secteurs+"'");
			rs1.next();
			nombreRess = rs1.getInt("total");
			rs1.close();
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
		return nombreRess;
 }

 /***************************STATISTIQUE SUR FORME JURIDIQUE*************************************************/
 public StatistiqueFormeJuridique[] getStatistique_FormeJuridique(String fj, String annee) {
		// TODO Auto-generated method stub
		StatistiqueFormeJuridique[] liste = null;
		int nombreFj;
		int sommeSctCree;
		String rqtGeneral = null;
		
		if(fj.equals("Tous"))
		{
			String rqt1 = "SELECT DISTINCT typeformejuridique from entreprise where annee ="+"'"+annee+"'";
			rqtGeneral = rqt1;
		}
		else
		{
			String rqt2 = "SELECT DISTINCT typeformejuridique, annee from entreprise where typeformejuridique ="+"'"+fj+"'"+"AND annee ="+"'"+annee+"'";
			rqtGeneral = rqt2;
		}
		conBDD connexion = new conBDD();
		
	    try {
		 	   
	    	ResultSet result  = connexion.st.executeQuery(rqtGeneral);

	    	liste = new StatistiqueFormeJuridique[100];
	        
	        int i = 0;
	        
        	
        	StatFJ.clear();
        	StatNombreEseFJ.clear();
        	StatPourcentageFJ.clear();
        	
	        while (result.next()) {
	        
	        	nombreFj = NombreParFormeJuridique(result.getString("typeformejuridique"));    	
	        	sommeSctCree = SommeEntrepriseCree();
	        	
	        	double pourcentage = (double)(100 * nombreFj) / sommeSctCree;
	        	
	        	liste[i] = new StatistiqueFormeJuridique(result.getString("typeformejuridique"), ""+nombreFj, ""+pourcentage+"%");

	        	
	        	
	        	StatFJ.add(result.getString("typeformejuridique"));
	        	StatNombreEseFJ.add(""+nombreFj);
	        	StatPourcentageFJ.add(""+pourcentage);
	            i++;
	        }
	        
	    } catch(Exception e) {
	    	
	    	System.err.println("Mysql Statement Error: " + rqtGeneral);
	    	e.printStackTrace(); 	
	    }


		return liste;
	}
 
 int NombreParFormeJuridique(String fj)
 {
		int nombreRess = 0;
		conBDD connexion = new conBDD();
		
		ResultSet rs1;
		
		try {
			rs1 = connexion.st.executeQuery("SELECT COUNT(*) total from entreprise where typeformejuridique = "+"'"+fj+"'");
			rs1.next();
			nombreRess = rs1.getInt("total");
			rs1.close();
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
		return nombreRess;
	 
 }
 
 /*************************RECHERCHE ENTREPRISE A PARTIR NIF ***********************************/
 
 public RechercheEntrepriseCode[] findtEntreprise(String nif){
		// TODO Auto-generated method stub
		RechercheEntrepriseCode[] liste = null;
		//String rqt = "select num, nom, adresse from employe where nom like '%"+n1+"%' ";

		String rqt2 = "SELECT Denomination, lesassocies, siegesociale, capital, typeformejuridique, nif, rcs, activities, gerant, instat, nationalite, annee, mois from entreprise where  nif = "+"'"+nif+"'";
		
		conBDD connexion = new conBDD();
		System.out.println(rqt2);
	    try {
		 	   
	    	ResultSet result  = connexion.st.executeQuery(rqt2);

	    	liste = new RechercheEntrepriseCode[100];
	        
	        int i = 0;
	        
	        
	        while (result.next()) {
	        
	        	liste[i] = new RechercheEntrepriseCode(result.getString("denomination"), result.getString("siegesociale"), result.getString("capital"), result.getString("typeformejuridique"), result.getString("rcs"), result.getString("activities"), result.getString("gerant"), result.getString("instat"), result.getString("nationalite"), result.getString("lesassocies"), result.getString("annee"), result.getString("mois"));
	        	System.out.println("RESSSS:"+liste[i].denomination);
	            i++;
	        }
	        
	    } catch(Exception e) {
	    	
	    	System.err.println("Mysql Statement Error: " + rqt2);
	    	e.printStackTrace(); 	
	    }
		return liste;

 }

/*************************RECHERCHE ENTREPRISE A PARTIR NOM ***********************************/
 
 public RechercheEntrepriseCode[]findtEntrepriseApartirNom(String nom){
		// TODO Auto-generated method stub
		RechercheEntrepriseCode[] liste = null;
		//String rqt = "select num, nom, adresse from employe where nom like '%"+n1+"%' ";

		String rqt2 = "SELECT Denomination, typesecteur, rcs, lesassocies, siegesociale, capital, typeformejuridique, nif, rcs, activities, gerant, instat, nationalite, annee, mois from entreprise where  denomination = "+"'"+nom+"'";
		
		conBDD connexion = new conBDD();
		System.out.println(rqt2);
	    try {
		 	   
	    	ResultSet result  = connexion.st.executeQuery(rqt2);

	    	liste = new RechercheEntrepriseCode[100];
	        
	        int i = 0;
	        
	        
	        while (result.next()) {
	        
	        	liste[i] = new RechercheEntrepriseCode(result.getString("denomination"), result.getString("siegesociale"), result.getString("capital"), result.getString("typeformejuridique"), result.getString("rcs"), result.getString("activities"), result.getString("gerant"), result.getString("instat"), result.getString("nationalite"), result.getString("lesassocies"), result.getString("annee"), result.getString("mois"));
	        	
	        	
	        	ExportationPDFEntrepriseRech(result.getString("denomination"), 
	        			result.getString("siegesociale"), 
	        			result.getString("capital"),
	        			result.getString("typeformejuridique"), 
	        			result.getString("gerant"), 
	        			result.getString("typesecteur"), 
	        			result.getString("rcs"), 
	        			result.getString("instat"));
	        	
	        	
	        	System.out.println("Nombre des enregistrements clic"+liste[i].denomination);
	            i++;
	        }
	        
	    } catch(Exception e) {
	    	
	    	System.err.println("Mysql Statement Error: " + rqt2);
	    	e.printStackTrace(); 	
	    }
		return liste;

 }
/*exportation pdf Recherche Entreprise */
 
	public String ExportationPDFEntrepriseRech(String denomination, String siege, String capital, String jf, String gerant, String secteur, String rcs, String nif) {
		 

		Font catFont = new Font(Font.TIMES_ROMAN, 13, Font.BOLD);
        Document document = new Document(PageSize.A4);
        String ret = null;
        try {
			PdfWriter.getInstance(document,new FileOutputStream("resources/pdf/EntrepriseInfo.pdf"));
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       document.open();  
       try {
		
		/* Paragraph paragraph = new Paragraph();
		addEmptyLine(paragraph, 5);*/
		
    	document.add(new Paragraph("						                                                    INFORMATION ENTREPRISE", catFont));

    	document.add(new Paragraph("                           "));
		document.add(new Paragraph("- Denomination: "+denomination));
		document.add(new Paragraph("                          "));
		
		document.add(new Paragraph("- Siège: "+siege));
		document.add(new Paragraph("                             "));
		
		document.add(new Paragraph("- Capital: "+capital));
		document.add(new Paragraph("                                "));
		
		document.add(new Paragraph("- Forme juridique: "+jf));
		document.add(new Paragraph("                                 "));
		
		document.add(new Paragraph("- Gérant: "+gerant));
		document.add(new Paragraph("                                  "));

		document.add(new Paragraph("- Secteur: "+secteur));
		document.add(new Paragraph("                                    "));
		
		document.add(new Paragraph("- Numéro RCS: "+rcs));
		document.add(new Paragraph("                                   "));
		
		document.add(new Paragraph("- NIF: "+nif));
		document.add(new Paragraph("                                      "));
		
	} catch (DocumentException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
       document.close(); 
       
       return ret;
       

}
 
/*************************RECHERCHE ENTREPRISE A PARTIR NOM ***********************************/
 
 public RechercheEntrepriseCode[]findtEntrepriseApartirNomGlobal(String nom){
		// TODO Auto-generated method stub
		RechercheEntrepriseCode[] liste = null;
		//String rqt = "select num, nom, adresse from employe where nom like '%"+n1+"%' ";

		String rqt2 = "SELECT Denomination, lesassocies, siegesociale, capital, typeformejuridique, nif, rcs, activities, gerant, instat, nationalite, annee, mois from entreprise where  denomination LIKE "+"'"+"%"+nom+"%"+"'";
		
		conBDD connexion = new conBDD();
		System.out.println(rqt2);
	    try {
		 	   
	    	ResultSet result  = connexion.st.executeQuery(rqt2);

	    	liste = new RechercheEntrepriseCode[100];
	        
	        int i = 0;
	        
	        
	        while (result.next()) {
	        
	        	liste[i] = new RechercheEntrepriseCode(result.getString("denomination"), result.getString("siegesociale"), result.getString("capital"), result.getString("typeformejuridique"), result.getString("rcs"), result.getString("activities"), result.getString("gerant"), result.getString("instat"), result.getString("nationalite"), result.getString("lesassocies"), result.getString("annee"), result.getString("mois"));
	        	System.out.println("RESSSS:"+liste[i].denomination);
	            i++;
	        }
	        
	    } catch(Exception e) {
	    	
	    	System.err.println("Mysql Statement Error: " + rqt2);
	    	e.printStackTrace(); 	
	    }
		return liste;

 }

 
/******************** MODIFICATION ENTREPRISE************************************************/
 

public Entreprise[] getModificationEntreprise(String nif) {

	Entreprise[] modifcode = null;

	return modifcode;
}

public String modificationSociete(String modif, String moismodif, String annee, String nif) {
	
	conBDD connexion = new conBDD();
	
	int nombrEnreg = RechercheIdentification(nif);
	int nbres = NombreEnregistrementTableModif() + 1;
	
	System.out.println("Nombre enregistrement"+nombrEnreg);
	
	String rqt = "INSERT INTO etatdemodification VALUES("+nbres+","+nombrEnreg+","+"'"+modif+"'"+","+"'"+moismodif+"'"+","+"'"+annee+"'"+")";
	
	
	System.out.println(rqt);
	String msg = "";
	
	try {
		connexion.st.executeUpdate(rqt);
		msg="Ajout réussi!";
		
	} catch (SQLException e) {
		e.printStackTrace();
		msg="Ajout échoué!";
	}
	 
	return msg;
	
} 

public int RechercheIdentification(String nif){
	
	conBDD connexion = new conBDD();
	int vil = 0;
	 
	String rqt = "SELECT * from entreprise where nif = "+"'"+nif+"'";
	
	try {
		ResultSet rs = connexion.st.executeQuery(rqt);
		
		while (rs.next())
		{		
			 vil = rs.getInt("idsociete");
		
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return vil;
	
	
}

public int NombreEnregistrementTableModif()
{
	conBDD connexion = new conBDD();
	int vil = 0;
	String rqt = "select MAX(idmodif) AS Nombre from etatdemodification";	
	
	try {
		ResultSet rs = connexion.st.executeQuery(rqt);
		
		while (rs.next())
		{		
			 vil = rs.getInt("Nombre");
			
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return vil;
	
}







 



/********************MISE A JOUR DE LA TABLE APPARTENIR(ARRIVE ANOSY AVEC DECISION ****************************************/



@Override














/******************* RECHERCHER ENTREPRISE AVEC MODIFICATION ***********************/
public RecuperationInfoEntrepriseModif[] findtEntrepriseWihtModif(String nif) {
	RecuperationInfoEntrepriseModif[] liste = null;

	String rqt2 = "select  denomination, modification, valeur, datemodif, nif from entreprise join etatdemodification on entreprise.idsociete = etatdemodification.idsociete where nif = "+"'"+nif+"'";
	conBDD connexion = new conBDD();
	
    try {
	 	   
    	ResultSet result  = connexion.st.executeQuery(rqt2);

    	liste = new RecuperationInfoEntrepriseModif[100];
        
        int i = 0;
        
        
        while (result.next()) {
        
        	liste[i] = new RecuperationInfoEntrepriseModif(result.getString("denomination"), result.getString("modification"),
        			result.getString("valeur"), result.getString("datemodif"));
            i++;
        }
        
    } catch(Exception e) {
    	
    	System.err.println("Mysql Statement Error: " + rqt2);
    	e.printStackTrace(); 	
    }
	return liste;
	//String rqt = "select num, nom, adresse from employe where nom like '%"+n1+"%' ";
}




	@Override
	public String RecuprPhoto() {
		String a = "OE EO";
		return a;
	}


	public String ExportationExcel()
	{
	
		String ret = null;
	    InputStream xlsRefStream = null;
	    
		try {
			xlsRefStream = new FileInputStream("resources/Excel/StatCreeParMoisModel.xls");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      Workbook refWorkbook = null;
	      
		try {
			refWorkbook = Workbook.getWorkbook(xlsRefStream);
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      
	      File outFile = new File("resources/Excel/StatCreeParMois.xls");
	      WritableWorkbook outWorkbook = null;
		try {
			outWorkbook = Workbook.createWorkbook(outFile, refWorkbook);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      
	      WritableSheet out = outWorkbook.getSheet(0);

	       for(int i = 0; i < 12; i++){
	    	   int a = Integer.parseInt(moisAnnee.get(i));
	    	   
	           Number number = new Number(1, i+1, a);
	           try {
				out.addCell(number);
			} catch (RowsExceededException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (WriteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        }
	       
	       for(int i = 0; i < 12; i++){ 
	    	
	    	   double percent1 = Double.parseDouble(pourcent.get(i));
	    	
	           Number number = new Number(2, i+1, percent1);
	           try {
				out.addCell(number);
			} catch (RowsExceededException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (WriteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	   
	        }

	       try {
			outWorkbook.write();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	       try {
			outWorkbook.close();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	       
	       return ret;
}
	
	public String ExportationNationalite() 
	{
		String ret = null;
		
		//Creates a writable workbook with the given file name
	    WritableWorkbook workbook = null;
		try {
			workbook = Workbook.createWorkbook(new File("resources/Excel/NatinaliteFinal.xls"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    WritableSheet sheet = workbook.createSheet("Statistique", 0);
	    
	    // Create cell font and format
	    WritableFont cellFont = new WritableFont(WritableFont.TIMES, 12);
	    try {
			cellFont.setColour(Colour.BLACK);
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    WritableCellFormat cellFormat = new WritableCellFormat(cellFont);
	    try {
			cellFormat.setBackground(Colour.WHITE);
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 
	    
	    
	    
	    sheet.setColumnView(0, 10);
	    try {
			sheet.addCell(new Label(0, 0, "Nationalité", cellFormat));
			sheet.addCell(new Label(1, 0, "Nombre entreprise", cellFormat));
			sheet.addCell(new Label(2, 0, "Pourcentage", cellFormat));
		} catch (RowsExceededException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (WriteException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		

	    //Set cell width in CHARS
	    int col = 0;
	    int widthInChars = 10;
	    System.out.println("Dans nationalite"+StatNationalite.size());
	    
		 sheet.setColumnView(col, widthInChars);
 		try {
 			for(int i = 0; i < StatNationalite.size(); i++)
 			{
 				sheet.addCell(new Label(col, i + 1, StatNationalite.get(i), cellFormat));
 			}
		} catch (RowsExceededException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (WriteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
    

	       for(int i = 0; i < StatNombreEseNation.size(); i++){
	    	   int a = Integer.parseInt(StatNombreEseNation.get(i));
	    	   
	           Number number = new Number(1, i+1, a);
	           try {
	        	   sheet.addCell(number);
			} catch (RowsExceededException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (WriteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        }
	       
	       
	       for(int i = 0; i < StatPourcentageNation.size(); i++){ 
	    	
	    	   double percent1 = Double.parseDouble(StatPourcentageNation.get(i));
	    	
	           Number number = new Number(2, i+1, percent1);
	           try {
				sheet.addCell(number);
			} catch (RowsExceededException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (WriteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	   
	        }
	    
	    //Writes out the data held in this workbook in Excel format
	    try {
			workbook.write();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	    
	    //Close and free allocated memory 
	    try {
			workbook.close();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    return ret;
	  }
	
	
	public String ExportationVille() 
	{
		String ret = null;
		
		//Creates a writable workbook with the given file name
	    WritableWorkbook workbook = null;
		try {
			workbook = Workbook.createWorkbook(new File("resources/Excel/Ville.xls"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    WritableSheet sheet = workbook.createSheet("Statistique", 0);
	    
	    // Create cell font and format
	    WritableFont cellFont = new WritableFont(WritableFont.TIMES, 12);
	    try {
			cellFont.setColour(Colour.BLACK);
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    WritableCellFormat cellFormat = new WritableCellFormat(cellFont);
	    try {
			cellFormat.setBackground(Colour.WHITE);
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    sheet.setColumnView(0, 10);
	    try {
			sheet.addCell(new Label(0, 0, "Ville", cellFormat));
			sheet.addCell(new Label(1, 0, "Nombre entreprise", cellFormat));
			sheet.addCell(new Label(2, 0, "Pourcentage", cellFormat));
		} catch (RowsExceededException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (WriteException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		

	    //Set cell width in CHARS
	    int col = 0;
	    int widthInChars = 10;
	   
	    
		 sheet.setColumnView(col, widthInChars);
 		try {
 			for(int i = 0; i < StatVille.size(); i++)
 			{
 				sheet.addCell(new Label(col, i + 1, StatVille.get(i), cellFormat));
 			}
		} catch (RowsExceededException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (WriteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
    

	       for(int i = 0; i <  StatNombreEseVille.size(); i++){
	    	   int a = Integer.parseInt( StatNombreEseVille.get(i));
	    	   
	           Number number = new Number(1, i+1, a);
	           try {
	        	   sheet.addCell(number);
			} catch (RowsExceededException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (WriteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        }
	       
	       
	       for(int i = 0; i < StatPourcentageVille.size(); i++){ 
	    	
	    	   double percent1 = Double.parseDouble(StatPourcentageVille.get(i));
	    	
	           Number number = new Number(2, i+1, percent1);
	           try {
				sheet.addCell(number);
			} catch (RowsExceededException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (WriteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	   
	        }
	    
	    //Writes out the data held in this workbook in Excel format
	    try {
			workbook.write();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	    
	    //Close and free allocated memory 
	    try {
			workbook.close();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    return ret;
	  }
	
	public String ExportationFormeJuridique() 
	{
		String ret = null;
		
		//Creates a writable workbook with the given file name
	    WritableWorkbook workbook = null;
		try {
			workbook = Workbook.createWorkbook(new File("resources/Excel/FormeJuridique.xls"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    WritableSheet sheet = workbook.createSheet("Statistique", 0);
	    
	    // Create cell font and format
	    WritableFont cellFont = new WritableFont(WritableFont.TIMES, 12);
	    try {
			cellFont.setColour(Colour.BLACK);
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    WritableCellFormat cellFormat = new WritableCellFormat(cellFont);
	    try {
			cellFormat.setBackground(Colour.WHITE);
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    sheet.setColumnView(0, 10);
	    try {
			sheet.addCell(new Label(0, 0, "Forme juridique", cellFormat));
			sheet.addCell(new Label(1, 0, "Nombre entreprise", cellFormat));
			sheet.addCell(new Label(2, 0, "Pourcentage", cellFormat));
		} catch (RowsExceededException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (WriteException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		

	    //Set cell width in CHARS
	    int col = 0;
	    int widthInChars = 10;
	   
	    
		 sheet.setColumnView(col, widthInChars);
 		try {
 			for(int i = 0; i < StatFJ.size(); i++)
 			{
 				sheet.addCell(new Label(col, i + 1, StatFJ.get(i), cellFormat));
 			}
		} catch (RowsExceededException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (WriteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
    

	       for(int i = 0; i <  StatNombreEseFJ.size(); i++){
	    	   int a = Integer.parseInt(StatNombreEseFJ.get(i));
	    	   
	           Number number = new Number(1, i+1, a);
	           try {
	        	   sheet.addCell(number);
			} catch (RowsExceededException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (WriteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        }
	       
	       
	       for(int i = 0; i < StatPourcentageFJ.size(); i++){ 
	    	
	    	   double percent1 = Double.parseDouble(StatPourcentageFJ.get(i));
	    	
	           Number number = new Number(2, i+1, percent1);
	           try {
				sheet.addCell(number);
			} catch (RowsExceededException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (WriteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	   
	        }
	    
	    //Writes out the data held in this workbook in Excel format
	    try {
			workbook.write();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	    
	    //Close and free allocated memory 
	    try {
			workbook.close();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    return ret;
	  }


	public String ExportationSecteur() 
	{
		String ret = null;
		
		//Creates a writable workbook with the given file name
	    WritableWorkbook workbook = null;
		try {
			workbook = Workbook.createWorkbook(new File("resources/Excel/Secteur.xls"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    WritableSheet sheet = workbook.createSheet("Statistique", 0);
	    
	    // Create cell font and format
	    WritableFont cellFont = new WritableFont(WritableFont.TIMES, 12);
	    try {
			cellFont.setColour(Colour.BLACK);
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    WritableCellFormat cellFormat = new WritableCellFormat(cellFont);
	    try {
			cellFormat.setBackground(Colour.WHITE);
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    sheet.setColumnView(0, 10);
	    try {
			sheet.addCell(new Label(0, 0, "Secteur", cellFormat));
			sheet.addCell(new Label(1, 0, "Nombre entreprise", cellFormat));
			sheet.addCell(new Label(2, 0, "Pourcentage", cellFormat));
		} catch (RowsExceededException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (WriteException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		

	    //Set cell width in CHARS
	    int col = 0;
	    int widthInChars = 10;
	   
	    
		 sheet.setColumnView(col, widthInChars);
 		try {
 			for(int i = 0; i < StatSecteur.size(); i++)
 			{
 				sheet.addCell(new Label(col, i + 1, StatSecteur.get(i), cellFormat));
 			}
		} catch (RowsExceededException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (WriteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
    

	       for(int i = 0; i <  StatNombreEseSecteur.size(); i++){
	    	   int a = Integer.parseInt(StatNombreEseSecteur.get(i));
	    	   
	           Number number = new Number(1, i+1, a);
	           try {
	        	   sheet.addCell(number);
			} catch (RowsExceededException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (WriteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        }
	       
	       
	       for(int i = 0; i < StatPourcentageSecteur.size(); i++){ 
	    	
	    	   double percent1 = Double.parseDouble(StatPourcentageSecteur.get(i));
	    	
	           Number number = new Number(2, i+1, percent1);
	           try {
				sheet.addCell(number);
			} catch (RowsExceededException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (WriteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	   
	        }
	    
	    //Writes out the data held in this workbook in Excel format
	    try {
			workbook.write();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	    
	    //Close and free allocated memory 
	    try {
			workbook.close();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    return ret;
	  }

	@Override
	public String greetServer(String name) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}




}