package com.construction;

import java.util.ArrayList;

import com.model.*;
import com.utils.Utilitaire;

public class ConstructionStade {
	private Stade_Impl stade;

	public ConstructionStade() {
		Orientation[] o = new Orientation[Utilitaire.getAllOrientation().size()];
		for (int i = 0; i < o.length; i++) {
				o[i] = new Orientation(Utilitaire.getAllOrientation().get(i), creerEscaliers(30, 30, 20));
		}

		stade = new Stade_Impl("le plus beau", o);
	}

	public Stade_Impl getStade() {
		return stade;
	}

	private Place[] creerPlaces(int nbPlace) {
		Place[] p = new Place[nbPlace];
		for (int i = 0; i < nbPlace; i++)
			p[i] = new Place(i);
		return p;
	}

	public Rang[] creerRangs(int nbRang, int nbPlace) {
		Rang[] r = new Rang[nbRang];
		for (int i = 0; i < nbRang; i++)
			r[i] = new Rang(i, creerPlaces(nbPlace));
		return r;
	}

	public Escalier[] creerEscaliers(int nbEscalier, int nbRang, int nbPlace) {
		Escalier[] e = new Escalier[nbEscalier];
		for (int i = 0; i < nbEscalier; i++)
			e[i] = new Escalier("esc" + i, creerRangs(nbPlace, nbRang));
		return e;
	}

	/**
	 * Cette fonction retourne les différentes catégories qui existe dans le stade
	 * @return - ArrayList de Categorie ainsi que les escaliers associés
	 */
	public static ArrayList<Categorie> getCategorie() {
		ArrayList<Categorie> res = new ArrayList<Categorie>();
		
		ConstructionStade cs = new ConstructionStade();
		Categorie c1 = new Categorie();
		c1.setNom("categorie 1");
		ArrayList<String> h1 = new ArrayList<String>();
		Categorie c2 = new Categorie();
		c2.setNom("categorie 2");
		ArrayList<String> h2 = new ArrayList<String>();
		Categorie c3 = new Categorie();
		c3.setNom("categorie 3");
		ArrayList<String> h3 = new ArrayList<String>();
		Categorie c4 = new Categorie();
		
		long compteur = 0;
		
		for(Orientation o : cs.getStade().getOrientations()){
			if(o.getNom().equals(Utilitaire.CATEGORIE_FOSSE)){
				ArrayList<String> h4 = new ArrayList<String>();
				c4.setNom("OR");
				// Por chaque escalier contenu dans l'orientation on l'ajoute à la catégorie OR
				for(Escalier e : o.getEscalier().values())
					h4.add(e.getNomEsc());
				c4.setEscalier(h4);
			}else{
				// Si ce n'est pas l'orientation "FOSSE" qui est a elle seule une catégorie
				// les n/3 premiers escalier appartiennent à la catégorie 1, les n/3 suivant à la deuxieme catégorie et ainsi dessuite
				for(Escalier e: o.getEscalier().values()){
					if(compteur < 1/3*o.getEscalier().values().size())
						h1.add(e.getNomEsc());
					else if(compteur < 1/3*o.getEscalier().values().size())
						h2.add(e.getNomEsc());
					else
						h3.add(e.getNomEsc());
				}
			}
		}

		c1.setEscalier(h1);
		c2.setEscalier(h2);
		c3.setEscalier(h3);

		res.add(c1);
		res.add(c2);
		res.add(c3);
		res.add(c4);
		
		return res;
	}

}
