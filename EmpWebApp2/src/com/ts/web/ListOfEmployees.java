package com.ts.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ts.dao.EmployeeDAO;
import com.ts.dto.Employee;


@WebServlet("/ListOfEmployees")
public class ListOfEmployees extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		EmployeeDAO employeeDAO = new EmployeeDAO();
		List<Employee> employeeList = employeeDAO.getEmployees();
		RequestDispatcher rd = request.getRequestDispatcher("HrHomePage");
		rd.include(request, response);
		out.print("<h1> employee data  </h1>");
		


		
		}

		

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
