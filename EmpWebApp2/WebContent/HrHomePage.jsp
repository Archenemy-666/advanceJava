<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor= black  text= white>

		<%  String loginId = (String)request.getParameter("loginId"); %>
		
		<h3> Hi : <%=loginId %> <center>Welcome to HR Home Page</center></h3> 
		<h3><center><a href='FindEmployee.html'>Display Employee By Id</a></center></h3>
		<h3><center><a href = 'ListOfEmployees'>Display All Employees</a></center></h3> 
</body>
</html>
