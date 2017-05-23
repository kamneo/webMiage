package com.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Evenement.Evenement;
import com.model.Evenement.Musique;
import com.model.Evenement.Sport;

/**
 * Servlet implementation class Stade
 */
@WebServlet("/EvenementServ")
public class EvenementServ extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom = request.getParameter("nomEvent");
		String date = request.getParameter("DateEvent");
		String type = request.getParameter("TypeEvent");
		Evenement evnt = null;
		HashMap<String, Double> tarif = new HashMap<String, Double>();
		if (type == "Match") {
			try {
				evnt = new Sport(nom, date, tarif);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			try {
				evnt = new Musique(nom, date, tarif);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		request.setAttribute("evnt", evnt);
		this.getServletContext().getRequestDispatcher("/afficherEvnt.jsp").forward(request, response);
	}
}
