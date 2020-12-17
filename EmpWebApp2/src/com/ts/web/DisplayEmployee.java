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


@WebServlet("/DisplayEmployee")
public class DisplayEmployee extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	int empId = Integer.parseInt(request.getParameter("empId"));
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();
	EmployeeDAO employeeDAO = new EmployeeDAO();
	Employee employee = employeeDAO.getEmployee(empId);
	if(employee != null) {
		request.setAttribute("employee", employee);
		RequestDispatcher rd = request.getRequestDispatcher("DisplayEmployee.jsp");
		rd.include(request, response);
	}else {
		out.print("<html>");
		out.print("<body>");
		out.print("<a href = Register.html> register the name </a>");
		out.print("<a href = HrHomePage.jsp> HR page </a>");
		out.print("</body>");
		out.print("</html>");
	}
	
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
