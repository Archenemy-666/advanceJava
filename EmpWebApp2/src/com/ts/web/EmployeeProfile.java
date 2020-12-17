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
import javax.servlet.http.HttpSession;

import com.ts.dao.EmployeeDAO;
import com.ts.dto.Employee;

/**
 * Servlet implementation class EmployeeProfile
 */
@WebServlet("/EmployeeProfile")
public class EmployeeProfile extends HttpServlet {

 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
	 	HttpSession session = request.getSession();
	 	String loginId = (String)session.getAttribute("loginId");
	 	
	 	
	 	response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		EmployeeDAO employeeDAO = new EmployeeDAO();
		List<Employee> employeeList = employeeDAO.getEmployees();
		out.print("<h1> employee data  </h1>");
		Employee employee = employeeDAO.getEmployee(loginId);
		if(employee != null) {
			out.print("<html>");
			out.print("<bgcolor= black text= white >");
			out.print("<h3> employee data  </h3>");
			out.print("<table border = 2 >");
			out.print("<tr>");
			out.print("<th>empId</th>");
			out.print("<th>empName</th>");
			out.print("<th>salary</th>");
			out.print("<th>loginId</th>");
			out.print("<th>password</th>");
			out.print("</tr>");
			out.print("<tr>");
			out.print("<th>"+employee.getEmpId()+"</th>");
			out.print("<th>"+employee.getEmpName()+"</th>");
			out.print("<th>"+employee.getSalary()+"</th>");
			out.print("<th>"+employee.getLoginId()+"</th>");
			out.print("<th>"+employee.getPassword()+"</th>");
			out.print("</tr>");
			out.print("</table>");
			out.print("</body>");
			out.print("</html>");
			RequestDispatcher rd = request.getRequestDispatcher("EmpHomePage");
			rd.include(request, response);
	}
 }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
