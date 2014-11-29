package com.romaric.project.server;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import com.romaric.project.Visa.MonService;
import com.romaric.project.model.Client;
import com.romaric.project.model.ModificationClient;
import com.romaric.project.model.Nationalite;
@SuppressWarnings("serial")
public class MonServiceImpl extends RemoteServiceServlet implements MonService {
	
	public Nationalite[] getListeNumeroPassport() {
		String rqt = "SELECT * from client";
		Nationalite[] liste = null;
		
		//Recuperer numéro dossier	
		conBDD connexion = new conBDD();
		
	    try {
	 	   
	    	ResultSet result  = connexion.st.executeQuery(rqt);

	    	liste = new Nationalite[10];
	        
	        int i = 0;
	        
	        while (result.next()) {
	        	liste[i] = new Nationalite(result.getString("numpassport"));
	        	
	            i++;
	        }     
	    } catch(Exception e) {
	    	
	    	System.err.println("Mysql Statement Error: " + rqt);
	    	e.printStackTrace();	
	    }
		
		return liste;
	}
	
	public Client[] getInformationClientVisa(
			String numPassport) {
		
		Client[] liste = null;
		
		String rqt = "SELECT * from client where numpassport = "+"'"+numPassport+"'";
		
		
		conBDD connexion = new conBDD();
		
	    try {
	 	   
	    	ResultSet result  = connexion.st.executeQuery(rqt);

	    	liste = new Client[100];
	        
	        int i = 0;
	        
	        while (result.next()) {	
	        	liste[i] = new Client(result.getString("nomclient"), result.getString("datelieunaissance"), result.getString("adresse"), result.getString("numpassport"), result.getString("typecategorie"), result.getString("typesituation"), result.getString("typeavisfavorabel"), result.getString("delivrancepassport"), result.getString("expirationpassport"), result.getString("nationalite"));
	            i++;
	        }
	    } catch(Exception e) {
	    	
	    	System.err.println("Mysql Statement Error: " + rqt);
	    	e.printStackTrace(); 	
	    }

		return liste;
	}

	public String ajoutClientDemandeVisa(String typeetrange, String avis, String situationmatrimonial,
			String nationalite,
			String renouvellement,	
			String nomEtPrenom, 
			String dateEtLieuxNaiss,
			String numPassPort, 
			String delivrance, 
			String expiration, 
			String adresseSociete, 
			String telephone, 
			String profession, 
			String adresse, 
			String activite, 
			String capital, 
			String adresseSociete1,	 
			String observation, 
			String mail, 
			String ville, String photo){	
		
		String msg = "";
		conBDD connexion = new conBDD();
		
		System.out.println("Ok eto a");
	int id = RecupererNumeroDossier() + 1;
			
		//String rqt = "INSERT INTO client VALUES("+id+","+"'"+ville+"'"+","+"'"+typeetrange+"'"+","+"'"+avis+"'"+","+"'"+situationmatrimonial+"'"+","+"'"+nationalite+"'"+","+"'"+renouvellement+"'"+","+"'"+nomEtPrenom+"'"+","+"'"+dateEtLieuxNaiss+"'"+","+"'"+numPassPort+"'"+","+"'"+delivrance+"'"+","+"'"+expiration+"'"+","+"'"+adresse+"'"+","+"'"+telephone+"'"+","+"'"+" "+"'"+","+"'"+mail+"'"+","+"'"+profession+"'"+","+"'"+adresseSociete+"'"+","+"'"+activite+"'"+","+"'"+capital+"'"+","+"'"+adresseSociete1+"'"+","+"'"+observation+"'"+")";
		String rqt = "INSERT INTO client VALUES("+id+","+"'"+ville+"'"+","+"'"+typeetrange+"'"+","+"'"+avis+"'"+","+"'"+situationmatrimonial+"'"+","+"'"+nationalite+"'"+","+"'"+renouvellement+"'"+","+"'"+nomEtPrenom+"'"+","+"'"+dateEtLieuxNaiss+"'"+","+"'"+numPassPort+"'"+","+"'"+delivrance+"'"+","+"'"+expiration+"'"+","+"'"+adresse+"'"+","+"'"+telephone+"'"+","+"'"+mail+"'"+","+"'"+profession+"'"+","+"'"+adresseSociete+"'"+","+"'"+activite+"'"+","+"'"+capital+"'"+","+"'"+adresseSociete1+"'"+","+"'"+observation+"'"+","+"'"+photo+"'"+")";
		
		
		try {
			connexion.st.executeUpdate(rqt);
			
			msg = "Ajout réussi!";
			
		} catch (SQLException e) {
			e.printStackTrace();
			msg = "Ajout échoué!";
		}
		 
		return msg;
		
	}
	
	
	
	
	public String modifierClientDemandeVisa(
			String nomEtPrenom, 
			String dateEtLieuxNaiss,
			String numPassPort, 
			String delivrance, 
			String expiration, 
			String adresseSociete, 
			String telephone, 
			String profession, 
			String adresse, 
			String activite, 
			String capital, 
			String adresseSociete1,	 
			String observation, 
			String mail, 
			String ville,
			String photo){	
		
		String msg = "";
		conBDD connexion = new conBDD();

	
		String rqt = "UPDATE client SET nomclient = "+"'"+nomEtPrenom+"'" +", datelieunaissance = "+"'"+dateEtLieuxNaiss+"'"+", numpassport ="+"'"+numPassPort+"'"+", delivrancepassport = "+"'"+delivrance+"'"+", expirationpassport ="+"'"+expiration+"'"+", adresse ="+"'"+adresse+"'"+", telephone ="+"'"+telephone+"'"+", profession ="+"'"+profession+"'"+", societe = "+"'"+adresseSociete1+"'"+", activites = "+"'"+activite+"'"+", capital = "+"'"+capital+"'"+", steadresse = "+"'"+adresseSociete+"'"+", observation = "+"'"+observation+"'"+", mail ="+"'"+mail+"'"+", photo ="+"'"+photo+"'"+ "where numpassport ="+"'"+numPassPort+"'";	
	
		
		
		try {
			connexion.st.executeUpdate(rqt);
			
			msg = "Modification réussi!";
			
		} catch (SQLException e) {
			e.printStackTrace();
			msg = "Modification échoué!";
		}
		 
		return msg;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public int RecupererNumeroDossier()
	{

		conBDD connexion = new conBDD();
		
		
		int vil = 0;
		 
		//String rqt = "select MAX(iddossier) AS Nombre from demandedevisa;";
		String rqt = "select MAX(refclient) AS Nombre from client";
		
		
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
	
	/*Ajouter dans la table de*/
	public String ajoutDansDemandeVisa(String numPassport, String idDossier, String dateDepot, String numRecepisse) {
		
		String refClient = RecupererRefClient(numPassport);
		conBDD connexion = new conBDD();
		
		String rqt = "INSERT INTO demandedevisa VALUES('"+idDossier+"'"+","+"'"+refClient+"'"+","+"'"+dateDepot+"'"+","+"'"+numRecepisse+"'"+","+"'"+"Duree"+"'"+")";
		
		System.out.println(rqt);
		String msg = "";
		
		try {
			connexion.st.executeUpdate(rqt);
			msg = "Ajout réussi!";
			
		} catch (SQLException e) {
			e.printStackTrace();
			msg = "Ajout échoué!";
		}
		
		 
		return msg;
	}

	public String RecupererRefClient(String numPassport)
	{
		String ret = null;
		conBDD connexion = new conBDD();
		 
		String rqt = "SELECT * from client where numpassport = "+"'"+numPassport+"'";
		
		try {
			ResultSet rs = connexion.st.executeQuery(rqt);
			
			while (rs.next())
			{		
				ret = rs.getString("refclient");

			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ret;
		
	}
	 
	
/*Ajout etat de demande envoyé Anosy*/
	
	public String ajoutEtatDemandeVisa(String numDossier, String date)
	{
		
		conBDD connexion = new conBDD();
		
		String rqt = "INSERT INTO appartenir VALUES('"+numDossier+"'"+","+"'"+"Envoyé à Anosy pour décision"+"'"+","+"'"+date+"'"+")";
		
		System.out.println(rqt);
		String msg = "";
		
		try {
			connexion.st.executeUpdate(rqt);
			msg = "Ajout réussi!";
			
		} catch (SQLException e) {
			e.printStackTrace();
			msg = "Ajout échoué!";
		}
		 
		return msg;
	}
	
	public Client[] getInformationClientVisaNumDoss(
			String numPassport) {
		
		Client[] liste = null;
		
		
		String rqt = "select * from client, demandedevisa where (client.refclient = demandedevisa.refclient AND iddossier =" +"'"+numPassport+"'"+")"; 
		
		conBDD connexion = new conBDD();
		
	    try {
	 	   
	    	ResultSet result  = connexion.st.executeQuery(rqt);

	    	liste = new Client[100];
	        
	        int i = 0;
	        
	        while (result.next()) {	
	        	liste[i] = new Client(result.getString("nomclient"), result.getString("datelieunaissance"), result.getString("adresse"), result.getString("numpassport"), result.getString("typecategorie"), result.getString("typesituation"), result.getString("typeavisfavorabel"),  result.getString("delivrancepassport"), result.getString("expirationpassport"), result.getString("nationalite"));
	            i++;
	        }
	    } catch(Exception e) {
	    	
	    	System.err.println("Mysql Statement Error: " + rqt);
	    	e.printStackTrace(); 	
	    }

		return liste;
	}

	public String miseAjourTableAppartenirAvecDecision(String numDossier, String date){
		
		conBDD connexion = new conBDD();
		//String rqt = " UPDATE appartenir SET refetat = '"+"Arrivé Anosy avec décision"+"', date='"+date+"' where iddossier='"+numDossier+"'";
		String rqt = "INSERT INTO appartenir VALUES('"+numDossier+"'"+","+"'"+"Arrivé Anosy avec décision"+"'"+","+"'"+date+"'"+")";
		String msg="";
		
		try {
			connexion.st.executeUpdate(rqt);
			
			msg = "Ajout avec succès!";
		} catch (SQLException e) {
			e.printStackTrace();
			msg = "Ajout échouée!";
		}
		return msg;
		
		
	}
	
	/******************** PASSPORT ENVOYE A ANOSY *******************************/

	public String ajoutPassportEnvoyeAnosy(String numDossier, String date) {
		
		conBDD connexion = new conBDD();
		//String rqt = " UPDATE appartenir SET refetat = '"+"Arrivé Anosy avec décision"+"', date='"+date+"' where iddossier='"+numDossier+"'";
		String rqt = "INSERT INTO appartenir VALUES('"+numDossier+"'"+","+"'"+"Passport envoyé à Anosy"+"'"+","+"'"+date+"'"+")";
		String msg="";
		
		try {
			connexion.st.executeUpdate(rqt);
			
			msg = "Ajout avec succès!";
		} catch (SQLException e) {
			e.printStackTrace();
			msg = "échouée!";
		}
		return msg;
	}
	
	/**************************** AJOUT PASSPORT ARRIVEE A ANOSY *************************************/
	public String ajoutPassportArriveAnosy(String numDossier, String date) {
		
		conBDD connexion = new conBDD();
		String rqt = "INSERT INTO appartenir VALUES('"+numDossier+"'"+","+"'"+"Passport arrivé à Anosy"+"'"+","+"'"+date+"'"+")";
		String msg="";
		
		try {
			connexion.st.executeUpdate(rqt);
			
			msg = "Ajout avec succès!";
			
		} catch (SQLException e) {
			e.printStackTrace();
			msg = "échouée!";
		}
		return msg;
	}

	/**************************** AJOUT CARTE DE RESIDENT ENVOYE A ANOSY *************************************/
	public String ajoutCarteResidentEnvoyeAnosy(String numDossier, String date) {
		
		conBDD connexion = new conBDD();
		
		String rqt = "INSERT INTO appartenir VALUES('"+numDossier+"'"+","+"'"+"Carte résident envoyé à Anosy"+"'"+","+"'"+date+"'"+")";
		String msg="";
		
		try {
			connexion.st.executeUpdate(rqt);
			
			msg = "Ajout avec succès!";
			
		} catch (SQLException e) {
			e.printStackTrace();
			msg = "échouée!";
		}
		return msg;
	}

	
	/*************************RECHERCHE INFORMATION A PARTIE NUM DOSSIER ***********************************************/
	public Client[] getInformationClientApartirNumDossier(
			String numDossier) {
		Client[] liste = null;
		
		
		//String rqt = "select  nomclient, delivrancepassport, expirationpassport, adresse, demandedevisa.iddossier, nationalite, datelieunaissance, client.typecategorie, numpassport, refetat, date from client, demandedevisa, appartenir where(client.refclient = demandedevisa.refclient AND appartenir.iddossier = "+"'"+numDossier+"'"+")" ;
		String rqt = "select  nomclient, delivrancepassport, expirationpassport, adresse, demandedevisa.iddossier, nationalite, datelieunaissance, client.typecategorie, numpassport, refetat, date from (demandedevisa join client on client.refclient = demandedevisa.refclient) join appartenir on appartenir.iddossier = demandedevisa.iddossier where demandedevisa.iddossier = "+"'"+numDossier+"'" ; ;
		
		
		System.out.println("Mandeha eto a!");
		conBDD connexion = new conBDD();
		
	    try {
	 	   
	    	ResultSet result  = connexion.st.executeQuery(rqt);

	    	liste = new Client[100];
	        
	        int i = 0;
	        
	        while (result.next()) {	
	        	liste[i] = new Client(result.getString("nomclient"), result.getString("datelieunaissance"), result.getString("adresse"), result.getString("numpassport"), result.getString("typecategorie"), result.getString("refetat"), result.getString("date"), result.getString("delivrancepassport"), result.getString("expirationpassport"), result.getString("nationalite"));
	        	System.out.println("Res"+liste[i].nomEtPrenom);
	            i++;
	        }
	    } catch(Exception e) {
	    	
	    	System.err.println("Mysql Statement Error: " + rqt);
	    	e.printStackTrace(); 	
	    }

		return liste;

	}
	/***************************RECUPERER INFORMATION CLIENT A PARTIR NUM PASSPORT ************************************/
	public Client[] getInformationClientApartirNumPassport(
			String numPassport) {

		Client[] liste = null;
		
		
		String rqt = "select * from client where numpassport ="+"'"+numPassport+"'";  
		
		conBDD connexion = new conBDD();
		
	    try {
	 	   
	    	ResultSet result  = connexion.st.executeQuery(rqt);

	    	liste = new Client[100];
	        
	        int i = 0;
	        
	        while (result.next()) {	
	        	liste[i] = new Client(result.getString("nomclient"), result.getString("datelieunaissance"), result.getString("adresse"), result.getString("numpassport"), result.getString("typecategorie"), result.getString("delivrancepassport"), result.getString("expirationpassport"), result.getString("delivrancepassport"), result.getString("expirationpassport"), result.getString("nationalite"));
	            i++;
	        }
	    } catch(Exception e) {
	    	
	    	System.err.println("Mysql Statement Error: " + rqt);
	    	e.printStackTrace(); 	
	    }

		return liste;
	}
	/*******************RECUPERER INFORMATION A PARTIR NOM ET PRENOM **************************************/
	public Client[] getInformationClientApartirNomEtPrenom(
			String nomEtPrenom) {
		Client[] liste = null;
		
		
		String rqt = "select * from client where nomclient ="+"'"+nomEtPrenom+"'";  
		
		conBDD connexion = new conBDD();
		
	    try {
	 	   
	    	ResultSet result  = connexion.st.executeQuery(rqt);

	    	liste = new Client[100];
	        
	        int i = 0;
	        
	        while (result.next()) {	
	        	liste[i] = new Client(result.getString("nomclient"), result.getString("datelieunaissance"), result.getString("adresse"), result.getString("numpassport"), result.getString("typecategorie"), result.getString("delivrancepassport"), result.getString("expirationpassport"), result.getString("delivrancepassport"), result.getString("expirationpassport"), result.getString("nationalite"));
	        	
	        	ExportationPDFEtranger(result.getString("nomclient"), result.getString("datelieunaissance"), result.getString("numpassport"), result.getString("expirationpassport"), result.getString("delivrancepassport"), result.getString("nationalite"), result.getString("typecategorie"), result.getString("photo"));
	        	
	            i++;
	        }
	    } catch(Exception e) {
	    	
	    	System.err.println("Mysql Statement Error: " + rqt);
	    	e.printStackTrace(); 	
	    }

		return liste;
	}
	
	
	
	/*******************RECUPERER INFORMATION A PARTIR NOM ET PRENOM GLOBAL**************************************/
	public Client[] getInformationClientApartirNomEtPrenomGlobal(
			String nomEtPrenom) {
		Client[] liste = null;
		
		
		String rqt = "select * from client where nomclient LIKE '"+"%"+nomEtPrenom+"%"+"'";  
		
		conBDD connexion = new conBDD();
		
	    try {
	 	   
	    	ResultSet result  = connexion.st.executeQuery(rqt);

	    	liste = new Client[100];
	        
	        int i = 0;
	        
	        while (result.next()) {	
	        	liste[i] = new Client(result.getString("nomclient"), result.getString("datelieunaissance"), result.getString("adresse"), result.getString("numpassport"), result.getString("typecategorie"), result.getString("delivrancepassport"), result.getString("expirationpassport"), result.getString("delivrancepassport"), result.getString("expirationpassport"), result.getString("nationalite"));
	        	
	        	ExportationPDFEtranger(result.getString("nomclient"), result.getString("datelieunaissance"), result.getString("numpassport"), result.getString("expirationpassport"), result.getString("delivrancepassport"), result.getString("nationalite"), result.getString("typecategorie"), result.getString("photo"));
	            i++;
	        }
	    } catch(Exception e) {
	    	
	    	System.err.println("Mysql Statement Error: " + rqt);
	    	e.printStackTrace(); 	
	    }

		return liste;
	}
	
	public String ExportationPDFEtranger(String nom, String dateNais, String numPass, String tel, String soct, String nationalite, String  categorie, String photo) {
		 
        Document document = new Document(PageSize.A4);
        String ret = null;
        Font catFont = new Font(Font.TIMES_ROMAN, 13, Font.BOLD);
      
      
        try {
			PdfWriter.getInstance(document,new FileOutputStream("resources/pdf/EntrangerInfo.pdf"));
			
			
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
    	   try {
			Image image = Image.getInstance ("resources/pdf/"+photo);
	           image.setAbsolutePosition(400f, 650f);
	           image.scalePercent(60f);
	            document.add(image);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	document.add(new Paragraph("						                                                    INFORMATION ETRANGER", catFont));
    	document.add(new Paragraph("                        "));
		document.add(new Paragraph("- Nom et Prénom: "+nom));
		document.add(new Paragraph("                                "));
		
		document.add(new Paragraph("- Date et lieu de naissance: "+dateNais));
		document.add(new Paragraph("                                 "));
		
		document.add(new Paragraph("- N° Passeport: "+numPass));
		document.add(new Paragraph("                  "));
		
		document.add(new Paragraph("- Délivrance passeport: "+soct));
		document.add(new Paragraph("                           "));
		
		document.add(new Paragraph("- Expiration passeport: "+tel));
		document.add(new Paragraph("                                 "));

		
		document.add(new Paragraph("- Nationalité: "+nationalite));
		document.add(new Paragraph("                               "));
		
		document.add(new Paragraph("- Catégorie: "+categorie));
		document.add(new Paragraph("                               "));
		
	} catch (DocumentException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
       document.close(); 
       return ret;
	
}
	
	
	
	public String ExportationPDFEtrangerDetail(String nom, String dateNais, String numPass, String tel, String soct, String nationalite, String  categorie, String photo) {
		 
        Document document = new Document(PageSize.A4);
        String ret = null;
        Font catFont = new Font(Font.TIMES_ROMAN, 13, Font.BOLD);
      
      
        try {
			PdfWriter.getInstance(document,new FileOutputStream("resources/pdf/EntrangerInfoDetails.pdf"));
			
			
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
    	   try {
			Image image = Image.getInstance ("resources/pdf/"+photo);
	           image.setAbsolutePosition(400f, 650f);
	           image.scalePercent(60f);
	            document.add(image);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	document.add(new Paragraph("						                                                    INFORMATION ETRANGER", catFont));
    	document.add(new Paragraph("                        "));
		document.add(new Paragraph("- Nom et Prénom: "+nom));
		document.add(new Paragraph("                                "));
		
		document.add(new Paragraph("- Date et lieu de naissance: "+dateNais));
		document.add(new Paragraph("                                 "));
		
		document.add(new Paragraph("- N° Passeport: "+numPass));
		document.add(new Paragraph("                  "));
		
		document.add(new Paragraph("- Délivrance passeport: "+soct));
		document.add(new Paragraph("                           "));
		
		document.add(new Paragraph("- Expiration passeport: "+tel));
		document.add(new Paragraph(""));

		
		document.add(new Paragraph("- Nationalité: "+nationalite));
		document.add(new Paragraph("                               "));
		
		document.add(new Paragraph("- Catégorie: "+categorie));
		document.add(new Paragraph("                               "));
		
	} catch (DocumentException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
       document.close(); 
       return ret;
	
}	
	public String RecupererNombreDossierRecueUDBM(String dateDebut, String dateFin)
	{
		String ret = null;
		
		String rqt = "SELECT COUNT(*) total from demandedevisa  WHERE  (datededepot between "+"'"+dateDebut+"'"+ " AND " + "'"+dateFin+"'"+")";
		conBDD connexion = new conBDD();
		ResultSet result;
		
		try {
			
				
			System.out.println(rqt);
			result = connexion.st.executeQuery(rqt);
		  
			while(result.next())
			{
				ret = result.getString("total");

		    }
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ret;
		
	}
	
	
	public String EnvoyeAAnosyPourDecision(String dateDebut, String dateFin)
	{
		String ret = null;
		
		String rqt = "SELECT COUNT(*) total from appartenir  WHERE  (date between "+"'"+dateDebut+"'"+ " AND " + "'"+dateFin+"'"+" AND refetat = "+"'Envoyé à Anosy pour décision'"+")" ;
		conBDD connexion = new conBDD();
		ResultSet result;
		
		try {
			
				
			System.out.println(rqt);
			result = connexion.st.executeQuery(rqt);
		  
			while(result.next())
			{
				ret = result.getString("total");

		    }
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ret;
		
	}
	public String EnvoyeAAnosyAvecDecision(String dateDebut, String dateFin)
	{
		String ret = null;
		
		String rqt = "SELECT COUNT(*) total from appartenir  WHERE  (date between "+"'"+dateDebut+"'"+ " AND " + "'"+dateFin+"'"+" AND refetat = "+"'Arrivé Anosy avec décision'"+")" ;
		conBDD connexion = new conBDD();
		ResultSet result;
		
		try {
			
				
			System.out.println(rqt);
			result = connexion.st.executeQuery(rqt);
		  
			while(result.next())
			{
				ret = result.getString("total");

		    }
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ret;
		
	}
	public String PasseportEnvoyeAnosy(String dateDebut, String dateFin)
	{
		String ret = null;
		
		String rqt = "SELECT COUNT(*) total from appartenir  WHERE  (date between "+"'"+dateDebut+"'"+ " AND " + "'"+dateFin+"'"+" AND refetat = "+"'Passport envoyé à Anosy'"+")" ;
		conBDD connexion = new conBDD();
		ResultSet result;
		
		try {
			
				
			System.out.println(rqt);
			result = connexion.st.executeQuery(rqt);
		  
			while(result.next())
			{
				ret = result.getString("total");

		    }
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ret;
		
	}
	
	public String PasseportArriveAnosy(String dateDebut, String dateFin)
	{
		String ret = null;
		
		String rqt = "SELECT COUNT(*) total from appartenir  WHERE  (date between "+"'"+dateDebut+"'"+ " AND " + "'"+dateFin+"'"+" AND refetat = "+"'Passport arrivé à Anosy'"+")" ;
		conBDD connexion = new conBDD();
		ResultSet result;
		
		try {
			
				
			System.out.println(rqt);
			result = connexion.st.executeQuery(rqt);
		  
			while(result.next())
			{
				ret = result.getString("total");

		    }
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ret;
		
	}
	
	public String CarteDeResidentEnvAnosy(String dateDebut, String dateFin)
	{
		String ret = null;
		
		String rqt = "SELECT COUNT(*) total from appartenir  WHERE  (date between "+"'"+dateDebut+"'"+ " AND " + "'"+dateFin+"'"+" AND refetat = "+"'Carte résident envoyé à Anosy'"+")" ;
		conBDD connexion = new conBDD();
		ResultSet result;
		
		try {
			
				
			System.out.println(rqt);
			result = connexion.st.executeQuery(rqt);
		  
			while(result.next())
			{
				ret = result.getString("total");

		    }
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ret;
		
	}
	
	//Modification étranger
	public ModificationClient[] modifierClient(String numPassport)
	{
		ModificationClient[] modif = null;
		
		conBDD connexion = new conBDD();
		String rqt = "Select * from client where numpassport ="+"'"+numPassport+"'";
	    try {
	 	   
	    	ResultSet result  = connexion.st.executeQuery(rqt);

	    	modif = new ModificationClient[10];
	        
	        int i = 0;
	        
	        while (result.next()) {
	        	modif[i] = new ModificationClient(result.getString("nomclient"), 
	        			result.getString("datelieunaissance"),
	        			result.getString("numpassport"),
	        			result.getString("delivrancepassport"),
	        			result.getString("expirationpassport"),
	        			result.getString("adresse"),
	        			result.getString("telephone"),
	        			result.getString("profession"),
	        			result.getString("societe"),
	        			result.getString("activites"),
	        			result.getString("capital"),
	        			result.getString("steadresse"),
	        			result.getString("observation"),	
	        			result.getString("mail"));	
	            i++;
	        }     
	    } catch(Exception e) {
	    	
	    	System.err.println("Mysql Statement Error: " + rqt);
	    	e.printStackTrace();	
	    }
		return modif;
	}
	/*Apina 1 ftsn rà ilaina fa mfanaraka tsara io; avy any afara*/
	public String ExportationPDFStatVisaTous(String recu, String pourDec, String avecDecis, String envoyAnosy, String arrivAnosy, String carteRsdEnvAnosy, String  carteRsdArriveAnosy)
	{
		String ret = null;
		
		Font catFont = new Font(Font.TIMES_ROMAN, 13, Font.BOLD);
		Font catFont2 = new Font(Font.TIMES_ROMAN, 12, Font.BOLD);
	        Document document = new Document(PageSize.A4);
	        try {
				PdfWriter.getInstance(document,new FileOutputStream("resources/pdf/statistiqueGeneral.pdf"));
				
				
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
			
	    	document.add(new Paragraph("						                                                    STATISTIQUES GENERALS", catFont));
	    	document.add(new Paragraph("                                                           "));

	    	
			document.add(new Paragraph("- Réçu à l'EDBM  "+recu, catFont2));
			
			document.add(new Paragraph("                                                           "));
			
			document.add(new Paragraph("- Nombre récepisses: "+pourDec, catFont2));
			document.add(new Paragraph("                                                           "));
			
			document.add(new Paragraph("- Envoyé à Anosy pour déc.: "+avecDecis, catFont2));
			document.add(new Paragraph("                                                           "));
			
			document.add(new Paragraph("- Envoyé à Anosy avec déc.: "+envoyAnosy, catFont2));
			document.add(new Paragraph("                                                           "));
			
			document.add(new Paragraph("- Passeport env. à Anosy "+arrivAnosy, catFont2));
			document.add(new Paragraph("                                                           "));
			
			document.add(new Paragraph("- Passeport arrivée à Anosy: "+carteRsdEnvAnosy,catFont2));
			document.add(new Paragraph("                                                           "));
			
			document.add(new Paragraph("- Carte de résident env. Anosy "+carteRsdArriveAnosy, catFont2));
			document.add(new Paragraph("                                                           "));

			
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	       document.close();
	       
	       
	       
		return  ret;
	}
	
	public String AdresseIPMachine()
	{
		String address = null;
		try {
			address = InetAddress.getLocalHost().getHostAddress();
			
			System.out.println("adresse IP machine:"+ address);
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return address;
	}
	
	
	public String modifierMotDePass(String login, String motdepasse, String encienlogin, String encienmotdepasse){	
		
		String msg = "";
		conBDD connexion = new conBDD();

	
		String rqt = "UPDATE utilisateur SET login = "+"'"+login+"'" +", motdepasse = "+"'"+motdepasse+"'"+ "where login ="+"'"+encienlogin+"'"+" and " +"motdepasse = "+"'"+encienmotdepasse+"'";	
	
		
		try {
			connexion.st.executeUpdate(rqt);
			
			msg = "Modification réussi!";
			
		} catch (SQLException e) {
			e.printStackTrace();
			msg = "Modification échoué!";
		}
		 
		return msg;
		
	}

}
