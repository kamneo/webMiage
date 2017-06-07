package com.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import com.model.Client_BD;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Client;

/**
 * Servlet implementation class Client
 */
@WebServlet("/inscription")
public class Inscription extends HttpServlet {
	private Client_BD listeClient = Client_BD.getinstance();
	private Map<String, String> erreurs = new HashMap<String, String>();
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/FormulaireConnexInscrip.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mail = request.getParameter("mail");
		String mdp = request.getParameter("mdp");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		Client client = new Client(mail, mdp, nom, prenom);
		erreurs = new HashMap<String, String>();

		if (!testString(mail)) {
			erreurs.put("mail1", "Veuillez remplir ce champ");
		}
		if (!testString(mdp)) {
			erreurs.put("mdp", "Veuillez remplir ce champ");
		}
		if (!testString(nom)) {
			erreurs.put("nom", "Veuillez remplir ce champ");
		}
		if (!testString(prenom)) {
			erreurs.put("prenom", "Veuillez remplir ce champ");
		}
		try {
			listeClient.ajouterClients(client);
		} catch (Exception e) {
			erreurs.put("mail2", "Adresse mail déjà utilisée.");
		}

		if (erreurs.size() != 0) {
			request.setAttribute("erreurs", erreurs);
			doGet(request, response);
		} else {
			request.setAttribute("client", client);
			this.getServletContext().getRequestDispatcher("/evenements").forward(request, response);
		}
	}

	private boolean testString(String s) {
		return s!=null && s.length() != 0;
	}
	private boolean validationEmail(String mail) {
		return (testString(mail) && !mail.matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)"));
	}
}
