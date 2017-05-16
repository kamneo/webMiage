package com.construction;

import com.model.*;

public class ConstructionStade {
	public static void main(String[] args) {
		Place[] p = new Place[20];
		for (int i = 0; i < p.length; i++) {
			p[i] = new Place(i, false);
		}

		Rang[] r = new Rang[20];
		for (int i = 0; i < r.length; i++) {
			r[i] = new Rang(i, p.clone());
		}
		
		Escalier[] e = new Escalier[15];
		for (int i = 0; i < e.length; i++) {
			e[i] = new Escalier("esc"+i, r.clone());
		}
		
		Orientation[]  o = new Orientation[5];
		for (int i = 0; i < o.length; i++) {
			if(i == 0)
				o[i] = new Orientation("O", e.clone());
			if(i == 1)
				o[i] = new Orientation("N", e.clone());
			if(i == 2)
				o[i] = new Orientation("S", e.clone());
			if(i == 3)
				o[i] = new Orientation("E", e.clone());
			if(i == 4)
				o[i] = new Orientation("Fosse", e.clone());
		}
		
		Stade_Impl s = new Stade_Impl("le plus beau", o);
		
		System.out.println("nb place stage = " + s.getNbPlace());
	}
}
