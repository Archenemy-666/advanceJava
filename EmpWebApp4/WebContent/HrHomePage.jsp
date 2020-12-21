<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor=yellow text=green>
<%
		String loginId = (String)session.getAttribute("loginId");
%>
		<h3>Hi : <%= loginId %> <center>Welcome to HR Home Page</center></h3>
		<h3><center><a href='Display.html'>Display Employee By Id</a></center></h3>
		<h3><center><a href='DisplayAllServlet'>Display All Employees</a></center></h3>
</body>
</html>