package com.model;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;

import com.construction.ConstructionStade;
import com.model.Evenement.*;
import com.utils.Utilitaire;

public class Billeterie {
	private static HashMap<Integer, Evenement> evenements;
	private HashMap<Integer, Double> reduction;
	//private ArrayList<Categorie> categoriesDisponibles;
	private static Billeterie instance = null;

	private Billeterie() {
		evenements = new HashMap<Integer, Evenement>();
		reduction = new HashMap<Integer, Double>();
		
		/*ConstructionStade cs = new ConstructionStade();
		Categorie c1 = new Categorie();
		c1.setNom("categorie 1");
		HashMap<String, Escalier> h1 = new HashMap<>();
		Categorie c2 = new Categorie();
		c2.setNom("categorie 2");
		HashMap<String, Escalier> h2 = new HashMap<>();
		Categorie c3 = new Categorie();
		c3.setNom("categorie 3");
		HashMap<String, Escalier> h3 = new HashMap<>();
		Categorie c4 = new Categorie();
		
		long compteur = 0;
		
		for(Orientation o : cs.getStade().getOrientations()){
			if(o.getNom().equals(Utilitaire.CATEGORIE_FOSSE)){
				c4.setNom("OR");
				c4.setEscalier(o.getEscalier());
			}else{
				for(Escalier e: o.getEscalier().values()){
					if(compteur < 1/3*o.getEscalier().values().size())
						h1.put(e.getNomEsc(), e);
					else if(compteur < 1/3*o.getEscalier().values().size())
						h2.put(e.getNomEsc(), e);
					else
						h3.put(e.getNomEsc(), e);
				}
			}
		}

		c1.setEscalier(h1);
		c2.setEscalier(h2);
		c3.setEscalier(h3);

		categoriesDisponibles.add(c1);
		categoriesDisponibles.add(c2);
		categoriesDisponibles.add(c3);
		categoriesDisponibles.add(c4);*/
	}

	/**
	 * 
	 * Point d'accès pour l'instance unique du singleton
	 */
	public static synchronized Billeterie getInstance() {
		if (instance == null) {
			instance = new Billeterie();
		}
		return instance;
	}
	
	public static ArrayList<Evenement> getAllEvenements() {
		ArrayList<Evenement> events = new ArrayList<Evenement>();
		for (Evenement ev : evenements.values())
			events.add(ev);

		return events;
	}

	public HashMap<Integer, Evenement> getEvenements() {
		return evenements;
	}

	public ArrayList<Place> getPlacesLibre(Evenement ev) {
		return ev.getPlacesLibre();
	}

	public ArrayList<Place> getPlacesLibre(Evenement ev, String idOrientation) {
		return ev.getPlacesLibre(idOrientation);
	}

	public ArrayList<Place> getPlacesLibre(Evenement ev, String idOrientation, String idEscalier) {
		return ev.getPlacesLibre(idOrientation, idEscalier);
	}

	public ArrayList<Place> getPlacesLibre(Evenement ev, String idOrientation, String idEscalier, int idRang) {
		return ev.getPlacesLibre(idOrientation, idEscalier, idRang);
	}

	public void creerSport(String nomEv, String date, HashMap<String, Double> tarif) throws ParseException {
		evenements.put(evenements.size(), new Sport(nomEv, date, tarif));
	}

	public void creerMusique(String nomEv, String date, HashMap<String, Double> tarif) throws ParseException {
		evenements.put(evenements.size(), new Musique(nomEv, date, tarif));
	}

	public void supprimerEvenement(String nomEv) {
		for (Evenement e : evenements.values())
			if (e.getNomEv().equals(nomEv)) {
				evenements.values().remove(e);
				return;
			}
	}

	public void supprimerEvenement(int idEv) {
		evenements.remove(idEv);
	}

	public HashMap<Integer, Double> getReduction() {
		return reduction;
	}

	public void setReduction(HashMap<Integer, Double> reduction) {
		this.reduction = reduction;
	}

	public void ajouterEvenement(Evenement ev) {
		Integer i = 0;
		while (evenements.containsKey(i))
			i++;
		evenements.put(i, ev);
	}
	
	public void acheterPlace(Reservation reservation) throws Exception {
		/*if(!reservation.validerReservation())
			throw new Exception("Reservation non valide");
		*/
		Reservation_BD rBD = Reservation_BD.getInstance();
		rBD.ajouterResa(reservation);

		// Changement à faux de la balise de disponibilité pour chaque place réservée
		for(Billet b : reservation.getBillets().values()){
			/*for(Orientation o :	getEvenement(reservation.getNomEv()).getStade().getOrientations())
				if(o.getNom().equals(b.getOr().getNom()))
						for(Escalier e : o.getEscalier().values())
							if(e.getNomEsc().equals(b.getEsc().getNomEsc()))
								for(Rang r : e.getRang().values())
									if(r.getNumeroRang() == b.getRang().getNumeroRang())
										for(Place p : r.getPlaces().values())
											if(p.getNumero() == b.getPl().getNumero())
												p.setEstLibre(false);*/
			b.getPl().setEstLibre(false);
		}
	}
}
