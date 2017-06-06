package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Billeterie;

/**
 * Servlet implementation class Evenements
 */
@WebServlet("/evenements")
public class Evenements extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Billeterie billetterie;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Evenements() {
        super();
        billetterie = Billeterie.getInstance();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("evenementSupprime", billetterie.supprimerEvenementPasses());
		request.setAttribute("evenements", billetterie.getEvenements());
		this.getServletContext().getRequestDispatcher("/afficherEvenements.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
