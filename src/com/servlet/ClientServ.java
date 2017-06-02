package com.servlet;

import java.io.IOException;

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
@WebServlet("/ClientServ")
public class ClientServ extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher( "/afficherClient.jsp" ).forward( request, response );
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String message =  null;

		String mail = request.getParameter("mail");
		String mdp = request.getParameter("mdp");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		Client client = new Client(mail, mdp, nom, prenom);
		/*
		 * to do : /!\ passer une rèquête pour savoir si admin 
		 * Ajout du client dans liste des client
		 */

		Client_BD listeClient = Client_BD.getinstance();
		try {
			listeClient.ajouterClients(client);
			message = "il y a " + Client_BD.getClients().size() + "Client";
		} catch (Exception e) {
			message = "Erreur - Adresse mail déjà utilisée. <br> <a href=\"FormulaireConnexInscrip.jsp\">Cliquez ici</a> pour accéder au formulaire de connection ou pour vous créer un compte";
		}

		request.setAttribute("client", client);
		request.setAttribute("message", message);
		this.getServletContext().getRequestDispatcher("/afficherClient.jsp").forward(request, response);
	}
}
