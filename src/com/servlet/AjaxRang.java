package com.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Rang;
import com.utils.UtilsResa;

@WebServlet("/AjaxRang")
public class AjaxRang extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UtilsResa UR = new UtilsResa();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String orientation = request.getParameter("orientation");
		String strid = request.getParameter( "idEvent" );
		long id = Long.valueOf(strid);
		String escalier = request.getParameter("escalier");
		
		ArrayList<Rang> rangs = UR.getRang(id, orientation, escalier);

		
		StringBuilder sb = new StringBuilder();
		for (Rang r: rangs) {
			sb.append("<option value ='");
			sb.append(r.getNumeroRang());
			sb.append("'> " + r.getNumeroRang() + "</option>");
		}
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(sb.toString());
	}
}