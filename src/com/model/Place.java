package com.model;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Place")
public class Place {
	private static int numero;
	private static boolean estLibre;

	/**
	 * 
	 * @param numero
	 * @param estAchetee
	 */
	public Place(int numero, boolean estAchetee) {
		this.setNumero(numero);
		this.setestLibre(false);
	}

	/**
	 * 
	 * @return
	 */
	public static int getNumero() {
		return numero;
	}

	/**
	 * 
	 * @param numero
	 */
	public void setNumero(int numero) {
		Place.numero = numero;
	}

	/**
	 * 
	 * @return
	 */
	public static boolean isestLibre() {
		return estLibre;
	}

	/**
	 * 
	 * @param estAchetee
	 */
	public void setestLibre(boolean estAchetee) {
		Place.estLibre = estAchetee;
	}

}
