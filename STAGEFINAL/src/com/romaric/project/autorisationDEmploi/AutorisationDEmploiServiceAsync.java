package com.romaric.project.autorisationDEmploi;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.romaric.project.model.DemandeAutorisationDEmploi;

public interface  AutorisationDEmploiServiceAsync {
	void ajout_demandeAutorisationEmploie(String refAutorisation, String nif,String numpassport, String numArrive, String dateDemande,
			String duree, String date_Effet, String date_Expiration,
			String date_Signature, String resultat,
			AsyncCallback<String> callback);
	
	public abstract void AutorisationEmploiePdf(String nomEtPrenom, String nomEtablissemt, AsyncCallback<String> asyncCallback);
	
	public abstract void  getInformationAutorisationAE(String dateDebut, String dateFin, AsyncCallback<DemandeAutorisationDEmploi[]> asyncCallback);
	
	
}
