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


@WebServlet("/LoginServlet") //annotation
public class LoginServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Reading values from Client
		String loginId = request.getParameter("loginId");
		String password = request.getParameter("password");
		
		//Add to Session object so that it can hold for long time (multiple subsequent request)
		HttpSession session = request.getSession();
		session.setAttribute("loginId", loginId);
		session.setAttribute("password", password);
		
		//preparing output page
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		if(loginId.equalsIgnoreCase("HR")&&password.equalsIgnoreCase("HR")){
			//navigate to other servlet
			RequestDispatcher rd = request.getRequestDispatcher("HrHomePage.jsp");
			rd.forward(request, response);
		} else {
			EmployeeDAO employeeDAO = new EmployeeDAO();
			Employee employee = employeeDAO.getEmployee(loginId, password);
			session.setAttribute("employee", employee);			
			if(employee != null){
				RequestDispatcher rd = request.getRequestDispatcher("EmpHomePage.jsp");
				rd.forward(request, response);
			} else {
				out.print("<html>");
				out.print("<body bgcolor=yellow text=red>");
				out.print("<h3>Invalid Credential </h3>");
				RequestDispatcher rd = request.getRequestDispatcher("Login.html");
				rd.include(request, response);
				out.print("</body>");
				out.print("</html>");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
