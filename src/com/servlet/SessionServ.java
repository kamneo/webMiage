package com.servlet;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.Client;
import com.model.Client_BD;
import com.model.ConnexionForm;

@WebServlet("/SessionServ")
public class SessionServ extends HttpServlet {
	public static final String ATT_USER = "client";
	public static final String ATT_FORM = "form";
	public static final String ATT_MESS = "message";
	public static final String ATT_SESSION_USER = "sessionUtilisateur";
	public static final String VUE = "/afficherConnexion.jsp";

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* Affichage de la page de connexion */
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* Préparation de l'objet formulaire */
		ConnexionForm form = new ConnexionForm();

		/* Traitement de la requête et récupération du bean en résultant */
		String mail = request.getParameter("mail");
		String mdp = request.getParameter("mdp");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		Client client = new Client(mail, mdp, nom, prenom);
	

		/* Récupération de la session depuis la requête */
		HttpSession session = request.getSession();

		Client_BD clientBDD = Client_BD.getinstance();
		HashMap<String, Client> listeClients = clientBDD.getClients();
		String message = "Connexion réussite";
		/**
		 * Si aucune erreur de validation n'a eu lieu, alors ajout du bean
		 * Utilisateur à la session, sinon suppression du bean de la session.
		 */
		if (form.getErreurs().isEmpty()) {
			if (listeClients.containsKey(client.getMail())) {
				if (client.getMdp().equals(listeClients.get(client.getMail()).getMdp())) {
					session.setAttribute(ATT_SESSION_USER, client);
				} else {
					message = "Erreur - Mot de passe incorrect. <br> <a href=\"FormulaireConnexInscrip.jsp\">Cliquez ici</a> pour accéder au formulaire de connection ou pour vous créer un compte";
				}
			} else {
				message = "Erreur - Mail inconnu. <br> <a href=\"FormulaireConnexInscrip.jsp\">Cliquez ici</a> pour accéder au formulaire de connection ou pour vous créer un compte";
			}

		} else {
			session.setAttribute(ATT_SESSION_USER, null);
		}

		/* Stockage du formulaire et du bean dans l'objet request */
		request.setAttribute(ATT_FORM, form);
		request.setAttribute(ATT_USER, client);
		request.setAttribute(ATT_MESS, message);

		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}
}
