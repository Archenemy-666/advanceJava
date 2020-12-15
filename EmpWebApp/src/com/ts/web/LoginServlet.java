package com.ts.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String loginId = request.getParameter("loginId");
		String password = request.getParameter("password");
		
		// prepare output page
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		if(loginId.equalsIgnoreCase("hr") && password.equalsIgnoreCase("hr")) {
			
			// navigate to other servlet 
			
			RequestDispatcher rd = request.getRequestDispatcher("HrHomePage");
			rd.forward(request, response);

			
		}
		else {
			out.print("<html>");
			out.print("<body bgcolor = red text = white>");
			out.print("<h1> wrong creds !! </h1>");
			out.print("</body>");
			out.print("</html>");
			RequestDispatcher rd = request.getRequestDispatcher("login.html");
			rd.include(request, response);
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
