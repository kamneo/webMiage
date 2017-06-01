package com.servlet;

import java.io.IOException;
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
		doGet(request, response);
	}

}
