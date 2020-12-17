package com.ts.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ts.dao.EmployeeDAO;
import com.ts.dto.Employee;

@WebServlet("/DisplayAllServlet") //annotation
public class DisplayAllServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		EmployeeDAO employeeDAO = new EmployeeDAO();
		List<Employee> empList = employeeDAO.getEmployee();

			RequestDispatcher rd = request.getRequestDispatcher("HrHomePage.jsp");
			rd.include(request, response);
			
			out.print("<table border = 2 align=center>");
			out.print("<tr><th>Id</th><th>Name</th><th>Salary</th><th>Login Id</th></tr>");
			for(Employee employee : empList) {
			out.print("<tr><td>"+employee.getEmpId()+"</td><td>"+employee.getEmpName()+"</td><td>"+employee.getSalary()+"</td><td>"+employee.getLoginId()+"</td></tr>");
			}
			out.print("</table>"); 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
