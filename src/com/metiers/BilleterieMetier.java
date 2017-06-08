package com.metiers;

import java.text.ParseException;
import java.util.HashMap;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.model.Billet;
import com.model.Billeterie;
import com.model.Categorie;
import com.model.Escalier;
import com.model.Orientation;
import com.model.Place;
import com.model.Rang;
import com.model.Reservation;
import com.model.Evenement.Evenement;

@Path("/billetterie")
@Produces("application/xml")
public class BilleterieMetier {
	private static Billeterie billeterie;

	/**
	 * Methode qui permet d'instancier la billeterie pour un evenement
	 */
	public BilleterieMetier() {
		billeterie = Billeterie.getInstance();
	}

	/**
	 * Methode pour valider une reservation d'une place
	 * 
	 * @param idEv identifiant de l'evenement
	 * @param nomOr nom de l'orientation souhaité
	 * @param nomEsc nom de l'escalier
	 * @param numRang numéro de rang
	 * @param numPlace numéro de place
	 * @param idReduc type de réduction ({(1 pour 30% de reduc), (2 pour 10%), (3 pour plien tarif)}
	 * @param mail email de l'acheteur
	 * @throws Exception
	 */
	@GET
	@Path("reserver/{idEv}/{nomOr}/{nomEsc}/{numRang}/{numPlace}/{idReduc}/{mail}")
	public static void reserver(@PathParam("idEv") String idEv, @PathParam("nomOr") String nomOr,
			@PathParam("nomEsc") String nomEsc, @PathParam("numRang") String numRang, @PathParam("numPlace") String numPlace,
			@PathParam("idReduc") String idReduc, @PathParam("mail") String mail) throws Exception {
		Billeterie b = Billeterie.getInstance();
		Evenement e = b.getEvenements().get(Integer.parseInt(idEv));
		Orientation or = e.getStade().getOrientations().stream().filter(o -> o.getNom().equals(nomOr)).findFirst()
				.get();

		Escalier esc = or.getEscalier().stream().filter(es -> es.getNomEsc().equals(nomEsc)).findFirst().get();

		Rang rang = esc.getRang().stream().filter(r -> r.getNumeroRang() == Integer.parseInt(numRang)).findFirst()
				.get();

		Place pl = rang.getPlaces().stream().filter(p -> p.getNumero() == Integer.parseInt(numPlace)).findFirst().get();

		String idCat = "categorie 1";
		for (Categorie c : b.getCategoriesDisponibles())
			if(!c.getNomCat().equals("OR"))
				for (String s : c.getEscalier())
					if (s.equals(esc.getNomEsc()))
						idCat = c.getNomCat();

		double prix = b.getReduction().get(Integer.parseInt(idReduc))
				* (or.getNom().equals("Fosse") ? e.getPrixCat("OR") : e.getPrixCat(idCat));

		billeterie.acheterPlace(new Reservation(e.getNomEv(), new Billet(or, esc, rang, pl, prix), mail));
	}

}
