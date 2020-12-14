package com.ts.web;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HelloServlet extends GenericServlet {

	public void init() {
		System.out.println("inside.. init.. method");
	}
	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Inside Service... called ...");
		
	}
	public void destroy() {
		System.out.println("Inside... destroy ");
	}
	

}
