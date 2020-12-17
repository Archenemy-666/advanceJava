package com.ts.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ts.dao.VibeDAO;
import com.ts.dto.Admin ;

@WebServlet("/VibeLoginServlet")
public class VibeLoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String loginId = request.getParameter("loginId");
		String password = request.getParameter("password");
		// prepare output page
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		VibeDAO vibeDAO = new VibeDAO();
		Admin admin = vibeDAO.getAdmin(loginId, password);
		if(admin != null) {
			
			RequestDispatcher rd = request.getRequestDispatcher("Portal");
			rd.forward(request, response);
		}
		
		else {
			out.print("<html>");
			out.print("<body bgcolor = red text = white align = center>");
			out.print("<h1> wrong creds !! </h1>");
			out.print("</body>");
			out.print("</html>");
			RequestDispatcher rd = request.getRequestDispatcher("login.html");
			rd.include(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
