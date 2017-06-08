package com.model;

import java.util.HashMap;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Client_BD {
	private static Client_BD instance = null;
	private static HashMap<String, Client> clients;

	/**
	 * Constructeur privé
	 */
	private Client_BD() {
		clients = new HashMap<String, Client>();
	}

	/**
	 * @return clients - liste des clients
	 */
	public HashMap<String, Client> getClients() {
		return clients;
	}

	/**
	 * @param clients
	 *            - nouvelle liste des clients
	 */
	public void setClients(HashMap<String, Client> clients) {
		this.clients = clients;
	}

	/**
	 * Methode pour ajouter un nouveau client a la liste des clients
	 * 
	 * @param nouvClient
	 *            - client a ajouter a la liste
	 */
	public void ajouterClients(Client nouvClient) throws Exception {
		// test d'unicité du client par rapport à son adresse mail
		if (clients.containsKey(nouvClient.getMail()))
			throw new Exception("Adresse mail déjà utilisée !");
		else
			// creation d'un nouveau client
			this.clients.put(nouvClient.getMail(), nouvClient);
	}

	/**
	 * Point d'accès pour l'instance unique du singleton
	 */
	public static synchronized Client_BD getinstance() {
		if (instance == null) {
			instance = new Client_BD();
		}
		return instance;
	}
}