package com.model;

public class Place {
	private static int numero;
	private static boolean estAchetee;

	public Place(int numero, boolean estAchetee) {
		this.setNumero(numero);
		this.setEstAchetee(false);
	}

	public static int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		Place.numero = numero;
	}

	public static boolean isEstAchetee() {
		return estAchetee;
	}

	public void setEstAchetee(boolean estAchetee) {
		Place.estAchetee = estAchetee;
	}

}
