package com.model;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.construction.ConstructionStade;
import com.model.Evenement.*;
import com.utils.Utilitaire;

@XmlRootElement
public class Billeterie {
	private static ArrayList<Evenement> evenements;
	private HashMap<Integer, Double> reduction;
	private ArrayList<Categorie> categoriesDisponibles;
	private static Billeterie instance = null;

	/**
	 * Constructeur d'evenement et des reductions
	 */
	private Billeterie() {
		evenements = new ArrayList<Evenement>();
		reduction = new HashMap<Integer, Double>();
		reduction.put(1, 0.7);
		reduction.put(2, 0.9);
		reduction.put(3, 1.);
		setCategoriesDisponibles(ConstructionStade.getCategorie());
	}

	/**
	 * 
	 * Point d'accÃ¨s pour l'instance unique du singleton
	 */
	public static synchronized Billeterie getInstance() {
		if (instance == null) {
			instance = new Billeterie();
		}
		return instance;
	}

	/**
	 * 
	 * @return
	 */
	public ArrayList<Evenement> getAllEvenements() {
		ArrayList<Evenement> events = new ArrayList<Evenement>();
		for (Evenement ev : evenements)
			events.add(ev);

		return events;
	}

	/**
	 * Getter d'evenement
	 * 
	 * @return
	 */
	@XmlElement(name = "evenements")
	public ArrayList<Evenement> getEvenements() {
		return evenements;
	}
	

	/**
	 * Getter sur un evenement en fonction de sont nom
	 * @param nomEv
	 *            nom de l'evenement
	 * @return l'evenement s'il a été trouvé sinon null
	 */
	public Evenement getEvenement(String nomEv) {
		for(Evenement e : evenements)
			if(e.getNomEv().equals(nomEv))
				return e;
		return null;
	}

	public Evenement getEvenement(long idEvent) {
		for(Evenement e : evenements)
			if(e.getDate().getTime() == idEvent)
				return e;
		return null;
	}

	/**
	 * Getter du nombre de places disponibles pour un evenement
	 * 
	 * @param ev
	 *            Objet evenement
	 * @return
	 */
	public long getNbPlaceLibre(Evenement ev) {
		return getPlacesLibre(ev).size();
	}

	/**
	 * Getter d'une liste des places libres pour l'evenement
	 * 
	 * @param ev
	 *            Objet evenement
	 * @return
	 */
	public ArrayList<Place> getPlacesLibre(Evenement ev) {
		return ev.getPlacesLibre();
	}

	/**
	 * Getter des places libres pour les orientations
	 * 
	 * @param ev
	 *            Objet evenement
	 * @param idOrientation
	 *            differentes orientations disponibles
	 * @return
	 */
	public ArrayList<Place> getPlacesLibre(Evenement ev, int idOrientation) {
		return ev.getPlacesLibre(idOrientation);
	}

	/**
	 * Getter des places libres pour les escalier
	 * 
	 * @param ev
	 *            Objet evenement
	 * @param idOrientation
	 *            differentes orientations disponibles
	 * @param idEscalier
	 *            differents escaliers disponibles
	 * @return
	 */
	public ArrayList<Place> getPlacesLibre(Evenement ev, int idOrientation, int idEscalier) {
		return ev.getPlacesLibre(idOrientation, idEscalier);
	}

	/**
	 * Getter des places libres pour les rangs
	 * 
	 * @param ev
	 *            Objet evenement
	 * @param idOrientation
	 *            differentes orientations disponibles
	 * @param idEscalier
	 *            differents escaliers disponibles
	 * @param idRang
	 *            differents rangs disponibles
	 * @return
	 */
	public ArrayList<Place> getPlacesLibre(Evenement ev, int idOrientation, int idEscalier, int idRang) {
		return ev.getPlacesLibre(idOrientation, idEscalier, idRang);
	}

	/**
	 * Getter des categories disponibles
	 * 
	 * @return
	 */
	@XmlElement(name = "categories")
	public ArrayList<Categorie> getCategoriesDisponibles() {
		return categoriesDisponibles;
	}

	/**
	 * Setter des categories disponibles
	 * 
	 * @param categoriesDisponibles
	 */
	private void setCategoriesDisponibles(ArrayList<Categorie> categoriesDisponibles) {
		this.categoriesDisponibles = categoriesDisponibles;
	}

	/**
	 * Methode pour creer un evenement sportif
	 * 
	 * @param nomEv
	 *            Nom de l'evenement
	 * @param date
	 *            Date de l'evenement
	 * @param tarif
	 *            Objet contenant les tarifs applicables
	 * @param equipe1
	 *            Equipe domicile
	 * @param equipe2
	 *            Equipe exterieure
	 * @param description
	 *            Commentaires sur l'evenement
	 * @throws ParseException
	 */
	public void creerSport(String nomEv, String date, HashMap<String, Double> tarif, String equipe1, String equipe2,
			String description) throws ParseException {
		evenements.add(new Sport(nomEv, date, tarif, equipe1, equipe2, description));
	}

	/**
	 * Methode pour creer un evenement musical
	 * 
	 * @param nomEv
	 *            Nom de l'evenement
	 * @param date
	 *            Date de l'evenement
	 * @param tarif
	 *            Objet contenant les tarifs applicables
	 * @param description
	 *            Commentaires sur l'evenement
	 * @throws ParseException
	 */
	public void creerMusique(String nomEv, String date, HashMap<String, Double> tarif, String description)
			throws ParseException {
		evenements.add(new Musique(nomEv, date, tarif, description));
	}

	/**
	 * Methode pour verifier que l'evenement a supprimer existe
	 * 
	 * @param nomEv
	 *            Nom de l'evenement que l'on cherche a supprimer
	 */
	public void supprimerEvenement(String nomEv) {
		for (Evenement e : evenements)
			if (e.getNomEv().equals(nomEv)) {
				evenements.remove(e);
				return;
			}
	}

	/**
	 * Methode pour supprimer un evenement de la liste
	 * 
	 * @param idEv
	 *            identifiant de l'evenement
	 */
	public void supprimerEvenement(long idEv) {
		for (Evenement e : evenements)
			if (e.getDate().getTime() == idEv) {
				evenements.remove(e);
				return;
			}
	}

	/**
	 * Getter des reductions
	 * 
	 * @return
	 */
	public HashMap<Integer, Double> getReduction() {
		return reduction;
	}

	/**
	 * Setter des reduction
	 * 
	 * @param reduction
	 *            objet contenant les coefficients a appliquer pour les
	 *            reductions
	 */
	public void setReduction(HashMap<Integer, Double> reduction) {
		this.reduction = reduction;
	}

	/**
	 * Methode pour ajouter un evenement a la liste
	 * 
	 * @param ev
	 *            Objet evenement
	 */
	public void ajouterEvenement(Evenement ev) {
		evenements.add(ev);
	}

	/**
	 * Methode pour acheter un place
	 * 
	 * @param reservation
	 *            Objet contenant les places selectionnees
	 * @throws Exception
	 */
	public void acheterPlace(Reservation reservation)  {
		/*
		 * if(!reservation.validerReservation()) throw new
		 * Exception("Reservation non valide");
		 */
		//Reservation_BD rBD = Reservation_BD.getInstance();
		//rBD.ajouterResa(reservation);
System.out.println("toto");
		// Changement Ã  faux de la balise de disponibilitÃ© pour chaque place
		// rÃ©servÃ©e
		for (Billet b : reservation.getBillets().values()) {
			b.getPl().setEstLibre(false);
		}
	}

	/**
	 * Methode pour charger une nouvelle instance de la billeterie
	 * 
	 * @param op
	 *            nouvelle instance de la billeterie
	 */
	@SuppressWarnings("static-access")
	public void load(Billeterie op) {
		instance = op.getInstance();
	}

	/**
	 * Methode pour sortir les evenements dont la date est echue de la liste des
	 * evenements a venir
	 * 
	 * @return
	 */
	public ArrayList<String> supprimerEvenementPasses() {
		ArrayList<String> evenementSupp = new ArrayList<>();
		for (Evenement ev : evenements) {
			if (ev.getDate().before(new Date())) { // Si la date est inferieure
													// ï¿½ vla date dujour on
													// supprime l'ï¿½vï¿½nement
				evenementSupp.add(ev.getNomEv());
				evenements.remove(ev);
			}
		}
		return evenementSupp;
	}
}
