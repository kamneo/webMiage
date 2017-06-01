package com.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Billeterie;
import com.utils.Utilitaire;

/**
 * Servlet implementation class AjouterEvenement
 */
@WebServlet("/ajouterEvenement")
public class AjouterEvenement extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Billeterie billeterie = Billeterie.getInstance();
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjouterEvenement() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("categories", Utilitaire.getAllCategories());
		request.setAttribute("orientations", Utilitaire.getAllOrientation());
		this.getServletContext().getRequestDispatcher("/AjouterEvenement.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Map<String, String> erreurs = new HashMap<String, String>();

		String type = request.getParameter("typeEvenement");
		String nom = request.getParameter("nom");
		String prixCat2 = request.getParameter(Utilitaire.getAllCategories().get(2));
		String prixCat3 = request.getParameter(Utilitaire.getAllCategories().get(3));
		String prixCat1 = request.getParameter(Utilitaire.getAllCategories().get(1));
		String prixOR = request.getParameter(Utilitaire.getAllCategories().get(4));
		String date = request.getParameter("date");
		String heure = request.getParameter("time");
		String description = request.getParameter("description");
		String equipe2 = request.getParameter("equipe2");
		String equipe1 = request.getParameter("equipe1");
		
		
		
		// Controls sur les champs
		if(type == null)
			erreurs.put("type", "Vous devez séléctionner le type d'événement !");
		
		request.setAttribute("erreurs", erreurs);
		doGet(request, response);
	}

}
