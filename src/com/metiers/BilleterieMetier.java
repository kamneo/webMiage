package com.metiers;

import java.text.ParseException;
import java.util.HashMap;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.model.Billeterie;
import com.model.Reservation;

@Path("/billetterie")
@Produces("application/xml")
public class BilleterieMetier {
	private static Billeterie billeterie;
	/**
	 * Methode qui permet d'instancier la billeterie pour un evenement
	 */
	public BilleterieMetier(){
		billeterie = Billeterie.getInstance();
	}
/**
 * Methode pour creer un evenment sportif
 * @param nomEv Nom de l'evenement
 * @param date Date de l'evenement
 * @param tarif Objet de type Map contenant les different tarifs applicables
 * @param equipe1 Nom de l'equipe domicile
 * @param equipe2 Nom de l'equipe exterieure
 * @param description Commentaires sur l'evenement
 * @throws ParseException 
 */
	public static void creerSport(String nomEv, String date, HashMap<String, Double> tarif, String equipe1, String equipe2, String description) throws ParseException {
		billeterie.creerSport(nomEv, date, tarif, equipe1, equipe2, description);
	}
/**
 * Methode pour creer un evenement musical
 * @param nomEv Nom de l'evenement
 * @param date Date de l'evenement
 * @param tarif Objet de type Map contenant les different tarifs applicables
 * @param description Commentaires sur l'evenement
 * @throws ParseException
 */
	public static void creerMusique(String nomEv,  String date, HashMap<String, Double> tarif, String description) throws ParseException {
		billeterie.creerMusique(nomEv,  date, tarif, description);
	}
	/**
	 * Methode pour supprimer un evenement
	 * @param nomEv Nom de l'evenement
	 */
	public static void supprimerEvenement(String nomEv) {
		billeterie.supprimerEvenement(nomEv);
	}
	/**
	 * Methode pour valider une reservation de une ou plusieurs places
	 * @param res Objet tableau contenant les places a reserver
	 * @throws Exception
	 */
	public static void validerReservation(Reservation[] res) throws Exception{
		for(int i=0;i<res.length;i++){ 
			billeterie.acheterPlace(res[i]);
		}
	}
}
