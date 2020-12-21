<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.ts.dto.Employee,java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		List<Employee> empList = (List<Employee>) request.getAttribute("empList");
	%>
	<jsp:include page="HrHomePage.jsp" /> <!--  Action Tag in JSP -->
	<table border=2 align=center>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Salary</th>
			<th>Login Id</th>
		</tr>
		<% for(Employee employee : empList) { %>
		<tr>
			<td><%= employee.getEmpId()%></td>
			<td><%=employee.getEmpName()%></td>
			<td><%=employee.getSalary()%></td>
			<td><%=employee.getLoginId()%></td>
		</tr>
		<% }%>
	</table>
</body>
</html>