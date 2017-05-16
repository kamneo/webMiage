package com.model;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Place")
public class Place {
	private int numero;
	private boolean estLibre;

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
	public int getNumero() {
		return numero;
	}

	/**
	 * 
	 * @param numero
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}

	/**
	 * 
	 * @return
	 */
	public boolean isestLibre() {
		return estLibre;
	}

	/**
	 * 
	 * @param estAchetee
	 */
	public void setestLibre(boolean estAchetee) {
		this.estLibre = estAchetee;
	}

}
