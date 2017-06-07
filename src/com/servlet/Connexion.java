package com.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.model.Client;
import com.model.Client_BD;

@WebServlet("/connexion")
public class Connexion extends HttpServlet {
	private Client_BD listeClient = Client_BD.getinstance();
	private Map<String, String> erreurs = new HashMap<String, String>();
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/FormulaireConnexInscrip.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/* Traitement de la requête et récupération du bean en résultant */
		String mail = request.getParameter("mail");
		String mdp = request.getParameter("mdp");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		Client client = new Client(mail, mdp, nom, prenom);
		HashMap<String,Client> liste = listeClient.getClients();
		
		if (liste.containsKey(client.getMail())) {
			if (client.getMdp().equals(liste.get(client.getMail()).getMdp())) {
				request.setAttribute("client", client);
				this.getServletContext().getRequestDispatcher("/evenements").forward(request, response);
			} else {
				erreurs.put("id", "Adresse mail et/ou mot de passe incorect");
				request.setAttribute("erreurs", erreurs);
				doGet(request, response);
			}
		} else {
			erreurs.put("id", "Adresse mail et/ou mot de passe incorect");
			request.setAttribute("erreurs", erreurs);
			doGet(request, response);
		}
	}
}
