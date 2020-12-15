package com.ts.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HelloServlet extends GenericServlet {

	public void init() {
		System.out.println("inside.. init.. method");
	}
	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<body bgcolor = black text = white>");
		out.print("<h1> <center> welcome to hello servlet </center> </h1>");
		out.print("</body>");
		out.print("</html>");
		System.out.println("Inside Service... called ...");
		
		
	}
	public void destroy() {
		System.out.println("Inside... destroy ");
	}
	

}
