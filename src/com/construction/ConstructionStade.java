package com.construction;

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

}
