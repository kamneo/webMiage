package com.model;

public class Place {
	private int numero;
	private boolean estLibre;

	public Place(int numero, boolean estAchetee) {
		this.setNumero(numero);
		this.setestLibre(false);
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public boolean isestLibre() {
		return estLibre;
	}

	public void setestLibre(boolean estAchetee) {
		this.estLibre = estAchetee;
	}

}
