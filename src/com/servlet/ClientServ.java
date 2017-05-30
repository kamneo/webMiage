package com.servlet;

import java.io.IOException;

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
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mail = request.getParameter("mail");
		String mdp = request.getParameter("mdp");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		Client client = new Client(mail,mdp,nom,prenom);
		/* to do : /!\ passer une rèquête pour savoir si admin*/
		
		request.setAttribute("client", client);
		this.getServletContext().getRequestDispatcher("/afficherClient.jsp").forward(request, response);
	}
}
