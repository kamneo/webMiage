package com.model;

import java.util.ArrayList;
import java.util.HashMap;
import com.model.Rang;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Escalier")
public class Escalier {
	private String nomEsc;
	private ArrayList<Rang> rang;

	/**
	 * constructeur par défaut
	 */
	public Escalier() {
		rang = new ArrayList<Rang>();
	}

	/**
	 * Constructeur
	 * 
	 * @param nom
	 *            - nom de l'escalier
	 * @param escaliers
	 *            - Liste des rangs qui compose l'escalier Construit l'objet
	 *            Escalier du nom du premier paramètre et crée des couples
	 *            id/escalier
	 */
	public Escalier(String nomEsc, Rang[] rangs) {
		this.nomEsc = nomEsc;
		this.rang = new ArrayList<>();
		for (int i = 0; i < rangs.length; i++) {
			this.rang.add(rangs[i]);
		}
	}

	public Escalier(String nomEsc, ArrayList<Rang> rangs) {
		this.nomEsc=nomEsc ;
		this.rang=new ArrayList<>();
		for(Rang r: rangs) {
			this.rang.add(r);
		}
	}
	

	/**
	 * Getter nom de l'escalier
	 * 
	 * @return nomEsc - nom de l'escalier getNom renvoi le nom de l'escaliler
	 */
	@XmlAttribute
	public String getNomEsc() {
		return nomEsc;
	}

	/**
	 * Setter nom de l'escalier
	 * 
	 * @param nomEsc
	 *            - Le nom à affecter à l'escalier setNom permet de changer le
	 *            nom de l'escalier
	 */
	public void setNomEsc(String nomEsc) {
		this.nomEsc = nomEsc;
	}

	/**
	 * Getter liste des rangs de l'escalier
	 * 
	 * @return rang- liste des rangs getRang renvoi la liste des rang et de leur
	 *         id
	 */
	@XmlElement(name = "rang")
	public ArrayList<Rang> getRang() {
		return rang;
	}

	/**
	 * Setter liste des rangs de l'escalier
	 * 
	 * @param rangs
	 *            - Les couple id/rang à affecter à l'orientation setRang permet
	 *            de remplacer la liste des couples id/rang pour une autre liste
	 *            de couple
	 */
	public void setRang(ArrayList<Rang> rangs) {
		this.rang = rangs;
	}

	/**
	 * Methode pour cloner pour les escaliers
	 */
	public Object clone() {
		@SuppressWarnings("unchecked")
		ArrayList<Rang> pc = (ArrayList<Rang>) rang.clone();

		Escalier e = new Escalier(nomEsc, (Rang[]) pc.toArray());

		return e;
	}
}