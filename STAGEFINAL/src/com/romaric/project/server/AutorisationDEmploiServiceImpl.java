package com.romaric.project.server;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.romaric.project.autorisationDEmploi.AutorisationDEmploiService;
import com.romaric.project.model.DemandeAutorisationDEmploi;

public class AutorisationDEmploiServiceImpl extends RemoteServiceServlet implements AutorisationDEmploiService {
/************  AJOUT AUTORISATION D'EMPLOIE ****************/
	
    
	public String ajout_demandeAutorisationEmploie(String refAutorisation, String nif, String numpassport, String numArrive, String dateDemande,
			String duree, String date_Effet, String date_Expiration,
			String date_Signature, String resultat) {
		
		conBDD connexion = new conBDD();
		
		int nombrEnreg = NombreEnregistrementAutorisationEmploie() + 1;
		int refclient = RechercheRefClient(numpassport);
		
		int idsociete = RechercheIdentification(nif);
	
		
		String rqt = "INSERT INTO demandeautorisationdemploie VALUES("+"'"+nombrEnreg+"'"+","+"'"+idsociete+"'"+","+"'"+refclient+"'"+","+"'"+numArrive+"'"+","+"'"+dateDemande+"'"+","+"'"+duree+"'"+","+"'"+date_Effet+"'"+","+"'"+date_Expiration+"'"+","+"'"+resultat+"'"+","+"'"+date_Signature+"'"+")";
		
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
	
	public  int NombreEnregistrementAutorisationEmploie()
	{
		int vil = 0;
		
		conBDD connexion = new conBDD();
		
		String rqt = "select MAX(idsociete) AS Nombre from demandeautorisationdemploie";
		
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
	public int RechercheRefClient(String numpassport){
		
		conBDD connexion = new conBDD();
		int vil = 0;
		 
		String rqt = "SELECT * from client where numpassport = "+"'"+numpassport+"'";
		
		try {
			ResultSet rs = connexion.st.executeQuery(rqt);
			
			while (rs.next())
			{		
				 vil = rs.getInt("refclient");
			
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return vil;
		
		
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
	/*AUTORISATION D EMPLOIE PDF**/
 
    
    
/**************RECUPERATION STATISTIQUE AUTORISATION D'EMPLOI********************/
	
	
	public DemandeAutorisationDEmploi[] getInformationAutorisationAE(
			String dateDebut, String dateFin) {
		DemandeAutorisationDEmploi[] liste = null;
		
		
		String rqt = "SELECT * FROM   demandeautorisationdemploie WHERE  (datedemande between "+"'"+dateDebut+"'"+" AND "+"'"+dateFin+"'"+")";  
		
		
	//	String rqt = "SELECT * FROM   demandeautorisationdemploie WHERE  (datedemande <= "+"'"+dateDebut+"'"+" AND "+">= "+"'"+dateFin+"'"+")";
		System.out.println("ITO:::::"+rqt);
		conBDD connexion = new conBDD();
		
	    try {
	 	   
	    	ResultSet result  = connexion.st.executeQuery(rqt);

	    	liste = new DemandeAutorisationDEmploi[100];
	        
	        int i = 0;
	        
	        while (result.next()) {	
	        	liste[i] = new DemandeAutorisationDEmploi(result.getString("numarrivee"), 
	        			 result.getString("datedemande"), result.getString("duree"),  result.getString("datesignature"));
	        	System.out.println("ld s "+result.getString("datedemande"));
	            i++;
	        }
	        
	       
	    } catch(Exception e) {
	    	
	    	System.err.println("Mysql Statement Error: " + rqt);
	    	e.printStackTrace(); 	
	    }

		return liste;
	}



	public String AutorisationEmploiePdf(String nomEtPrenom, String nomEtablissemt) {
		 
		String ret = null;

		Font catFont = new Font(Font.TIMES_ROMAN, 13, Font.BOLD);
		
		
	        Document document = new Document(PageSize.A4);
	        try {
				PdfWriter.getInstance(document,new FileOutputStream("resources/pdf/AE.pdf"));
				
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	       document.open();  
	       try {
			document.add(new Paragraph("                                                             REPOBLIKAN'I MADAGASIKARA", catFont));
			document.add(new Paragraph("								                                                 Fitiavana - Tanindrazana - Fandrosoana"));
			document.add(new Paragraph("               								                                                     ----------          "));
			
			/* Paragraph paragraph = new Paragraph();
			addEmptyLine(paragraph, 5);*/
			
			
			document.add(new Paragraph("MINISTRERE DE LA FONCTION"));
			document.add(new Paragraph("PUBLIQUE DU TRAVAIL ET"));
			document.add(new Paragraph("     DES LOI SOCIALES"));			
			document.add(new Paragraph("           ---------"));
			document.add(new Paragraph("            EDBM"));
			document.add(new Paragraph("              ---"));
			
			document.add(new Paragraph("                                                                "));
			
			
			document.add(new Paragraph("N°_______/MFPTLS/SE"));
			document.add(new Paragraph("                                                                 "));
			
			document.add(new Paragraph("Le Technicien Principal auprès de l'EDBM atteste par la présente que la demande d'autorisation d'emploi de:"));
			document.add(new Paragraph("                                                                 "));
			document.add(new Paragraph("Nom et Prénom: "+nomEtPrenom));
			document.add(new Paragraph("                                                                 "));
			document.add(new Paragraph("Nom de l'Etablissement: "+nomEtablissemt));
			document.add(new Paragraph("                                                                 "));
			document.add(new Paragraph("suivant lettre du:"+"12 Janvier 2013"));
			document.add(new Paragraph("enregistrée le"+"24 Janvier 2013"));
			document.add(new Paragraph("est encore en cours d'instruction"));
			document.add(new Paragraph("En fois de quoi, la présente lui est délivrée pour servir et valoir ce que de droit"));
			
			document.add(new Paragraph("Antananarivo le, "+ "Variable date d'aujourd'hui"));
			
			document.add(new Paragraph("                                                                 "));
			
			document.add(new Paragraph("                                                          LE TECHNICIEN PRINCIPAL AUPRES DE L'EDBM"));
		
			document.add(new Paragraph("                                                                 "));
			document.add(new Paragraph("                                                                 "));
			document.add(new Paragraph("                                                                 "));
			document.add(new Paragraph("                                                                 "));
			document.add(new Paragraph("                                                                 "));
			document.add(new Paragraph("                                                                 "));
			document.add(new Paragraph("                                                                 "));
			document.add(new Paragraph("                                                                 "));
			document.add(new Paragraph("                                                                 "));
			document.add(new Paragraph("                                                                 "));
			document.add(new Paragraph("                                                                 "));
			
			
		
			document.add(new Paragraph("_______________________________________________________________________"));
			document.add(new Paragraph("Cette attestion veut dire que le dossier déposé est complet. Ni la délivrance de cette"));
			document.add(new Paragraph("attestion, ni le visa du contrat de travail ne peuvent signifier que le Permis de Travail sera"));
			document.add(new Paragraph("nécessairement délivré"));
			
			
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	       document.close();  
       
       return ret;

}
}
