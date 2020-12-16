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
		for(Employee emp : employeeList) {
			out.print("<html>");
			out.print("<body bgcolor=black text=white>");
			out.print("<table>");
			out.print("<tr>");
			out.print("<th>empId</th>");
			out.print("<th>empName</th>");
			out.print("<th>salary</th>");
			out.print("<th>loginId</th>");
			out.print("<th>password</th>");
			out.print("</tr>");
			out.print("<tr>");
			out.print("<th>"+ emp.getEmpId()+"</th>");
			out.print("<th>"+ emp.getEmpName()+"</th>");
			out.print("<th>"+ emp.getSalary()+"</th>");
			out.print("<th>"+ emp.getLoginId()+"</th>");
			out.print("<th>"+ emp.getPassword()+"</th>");
			out.print("</tr>");
			out.print("</table>");
			out.print("</body>");
			out.print("</html>");


		
		}

		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
