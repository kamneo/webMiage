package com.model;

public class Place {
	private static int numero;
	private static boolean estLibre;

	public Place(int numero, boolean estAchetee) {
		this.setNumero(numero);
		this.setestLibre(false);
	}

	public static int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		Place.numero = numero;
	}

	public static boolean isestLibre() {
		return estLibre;
	}

	public void setestLibre(boolean estAchetee) {
		Place.estLibre = estAchetee;
	}

}
