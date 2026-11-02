<%@page import="java.sql.ResultSet"%>
<%@page import="com.repositories.EmployeeRepository"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete Employee</title>
</head>
<body>

	<%! EmployeeRepository er = new EmployeeRepository(); %>
	<%	
		int id = Integer.parseInt(request.getParameter("id")); 
		ResultSet rs = er.getEmployee(id);
		rs.next();
	%>
	
	<h1>Employee Update Form</h1>
	<form action="deleteempaction" method="delete">
		Enter id <input type="number" name="id" value="<%= rs.getInt("id") %>"> <br>
		<input type="submit" name="delete" value="Delete <%= rs.getInt("id") %>">
	</form>
	
</body>
</html>