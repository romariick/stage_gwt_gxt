package com.romaric.project.autorisationDEmploi;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.romaric.project.model.DemandeAutorisationDEmploi;

@RemoteServiceRelativePath("AutorisationDEmploiService")
public interface AutorisationDEmploiService extends RemoteService {
	
	/** DEMANDE D'AUTORISATION D'EMPOLOIE **/
	
	public String ajout_demandeAutorisationEmploie(String refAutorisation,
			String nif,
			String numpassport,
			String numArrive,
			String dateDemande,
			String duree,
			String date_Effet, 
			String date_Expiration, 
			String date_Signature, 
			String resultat);
	
	public DemandeAutorisationDEmploi[] getInformationAutorisationAE(String dateDebut, String dateFin);
	
	/*autorisation d'emploie **/
	public String AutorisationEmploiePdf(String nomEtPrenom, String nomEtablissemt);
	
	
}
