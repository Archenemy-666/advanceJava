package com.ts.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ts.dao.EmployeeDAO;
import com.ts.dto.Employee;


@WebServlet("/DisplayServlet") //annotation
public class DisplayServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int empId = Integer.parseInt(request.getParameter("empId"));
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		EmployeeDAO employeeDAO = new EmployeeDAO();
		Employee employee = employeeDAO.getEmployee(empId);
		
		if(employee != null){
			request.setAttribute("employee", employee);
			RequestDispatcher rd = request.getRequestDispatcher("Display.jsp");
			rd.include(request, response);

			
			
		} else {
			out.print("<html>");
			out.print("<body bgcolor=yellow text=red>");
			out.print("<h3>No Data Found..</h3>");
			RequestDispatcher rd = request.getRequestDispatcher("HrHomePage");
			rd.include(request, response);
			out.print("</body>");
			out.print("</html>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
