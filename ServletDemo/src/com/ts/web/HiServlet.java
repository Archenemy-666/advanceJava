package com.ts.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HiServlet extends GenericServlet {
	public void service(ServletRequest request, ServletResponse response) throws ServletException , IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<body bgcolor = red text = white>");
		out.print("<h1> <center> welcome to hi servlet </center> </h1>");
		out.print("</body>");
		out.print("</html>");
		System.out.println("Inside Service... called ...");	
	}


}
