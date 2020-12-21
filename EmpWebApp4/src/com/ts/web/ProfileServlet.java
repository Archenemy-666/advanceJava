package com.ts.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ts.dao.EmployeeDAO;
import com.ts.dto.Employee;


@WebServlet("/ProfileServlet") //annotation
public class ProfileServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		String loginId = (String)session.getAttribute("loginId");
		
		Employee employee = (Employee)session.getAttribute("employee"); 
		
		System.out.println("Inside Profile Servlet....");
		if(employee != null){
			request.setAttribute("employee", employee);
			RequestDispatcher rd = request.getRequestDispatcher("Profile.jsp");
			rd.include(request, response);

			
			
		} else {
			out.print("<html>");
			out.print("<body bgcolor=yellow text=red>");
			out.print("<h3>No Data Found..</h3>");
			RequestDispatcher rd = request.getRequestDispatcher("EmpHomePage.jsp");
			rd.include(request, response);
			out.print("</body>");
			out.print("</html>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
