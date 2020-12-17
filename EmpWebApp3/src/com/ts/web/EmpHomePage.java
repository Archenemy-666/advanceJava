package com.ts.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/EmpHomePage")
public class EmpHomePage extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		//String loginId = request.getParameter("loginId");
		HttpSession session = request.getSession();
		String loginId = (String)session.getAttribute("loginId");
		
		out.print("<html>");
		out.print("<body bgcolor=yellow text=green>");
		out.print("<h3>Hi : "+loginId+"<center>Welcome to Employee Home Page</center></h3>");
		out.print("<h3><center><a href=''>View Profile</a></center></h3>");
		out.print("</body>");
		out.print("</html>");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
