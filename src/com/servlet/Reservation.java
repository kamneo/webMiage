package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.metiers.BilleterieMetier;
import com.model.Billeterie;
import com.model.Escalier;
import com.model.Orientation;
import com.model.Place;
import com.model.Rang;
import com.utils.UtilsResa;

@WebServlet("/reservation")
public class Reservation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UtilsResa UR = new UtilsResa();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		String strid = request.getParameter( "idEvent" );
		long id = Long.valueOf(strid);
		request.setAttribute("orientations", UR.getOrientation(id));
		
		request.setAttribute("idEvent", strid);
		this.getServletContext().getRequestDispatcher("/nouvelleReservation.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		String idEv = request.getParameter("idEv");
		String orientation = request.getParameter("orientation");
		String escalier = request.getParameter("escalier");
		String rang = request.getParameter("rang");
		String place = request.getParameter("place");
		String mail = request.getParameter("mail");
		String idReduc = request.getParameter("idReduc");
		
		try {
			BilleterieMetier.reserver(idEv, orientation, escalier, rang, place, idReduc, mail);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
