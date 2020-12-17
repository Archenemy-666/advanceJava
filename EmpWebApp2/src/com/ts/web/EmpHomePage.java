package com.ts.web;

import java.io.IOException; 
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ts.dao.EmployeeDAO;
import com.ts.dto.Employee;


@WebServlet("/EmpHomePage")
public class EmpHomePage extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		EmployeeDAO employeeDAO = new EmployeeDAO();
		
		
		String loginId = request.getParameter("loginId");
		
		Employee employee = employeeDAO.getEmployee(loginId);
		
		out.print("<html>");
		out.print("<body bgcolor=black text=white>");
		out.print("<h3>Hi : "+loginId+"<center>Welcome to Employee Home Page</center></h3>");
		out.print("<a href = EmployeeProfile> Display Profile </a> ");
		out.print("</body>");
		out.print("</html>");
		
		request.setAttribute("employee", employee);
		RequestDispatcher rd = request.getRequestDispatcher("DisplayEmployee.jsp");
		rd.include(request, response);
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
