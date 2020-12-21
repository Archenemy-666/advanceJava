<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"import =  "com.ts.dto.Employee" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor= black text= white>
<% Employee employee = (Employee)request.getAttribute("employee"); %>
	
		
		<h3> employee data  </h3>
		<table border = 2 >
			<tr>
			<th>empId</th>
			<th>empName</th>
			<th>salary</th>
			<th>loginId</th>
			<th>password</th>
			</tr>
			<tr>
			<td>"+employee.getEmpId()+"</td>
			<td>"+employee.getEmpName()+"</td>
			<td>"+employee.getSalary()+"</td>
			<td>"+employee.getLoginId()+"</td>
			<td>"+employee.getPassword()+"</td>
			</tr>
			</table>
		
</body>
</html>