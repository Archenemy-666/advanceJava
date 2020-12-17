<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.ts.dto.Employee" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor = "black" text = "white" align = "center">
<% Employee employee = (Employee)request.getAttribute("employee"); %>
	<table>
	<tr>
		<td><%=employee.getEmpId() %></td>
		<td><%=employee.getEmpName() %></td>
		<td><%=employee.getSalary() %></td>
		<td><%=employee.getLoginId() %></td>

	</tr>
	
	</table>

</body>
</html>