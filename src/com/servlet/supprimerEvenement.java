package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Billeterie;

/**
 * Servlet implementation class supprimerEvenement
 */
@WebServlet("/supprimer")
public class supprimerEvenement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public supprimerEvenement() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Si l'identifiant n'est pas présent on retourne une erreur
		if(request.getParameter("id") == null || request.getParameter("id") .equals("")){
			request.setAttribute("erreur", "Erreur de transmission de l'indentifiant de l'envenement");
			this.getServletContext().getRequestDispatcher("/erreurDeSuppression.jsp").forward(request, response);
			return;
		}
		
		long id = Long.parseLong(request.getParameter("id"));
		Billeterie.getInstance().getEvenements().forEach(k -> {
			if(k.getDate().getTime() == id)
				request.setAttribute("evenementSupp", k.getNomEv());
		});
		
		// Si on a supprimer aucun evenement on retourne une erreur
		if(request.getAttribute("evenementSupp") == null){
			request.setAttribute("erreur", "Evenement inconu");
			this.getServletContext().getRequestDispatcher("/erreurDeSuppression.jsp").forward(request, response);
			return;
		}
		
		Billeterie.getInstance().supprimerEvenement(id);
		this.getServletContext().getRequestDispatcher("/evenements").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
