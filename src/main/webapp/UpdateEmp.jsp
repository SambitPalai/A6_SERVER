<%@page import="java.sql.ResultSet"%>
<%@page import="com.repositories.EmployeeRepository"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Employee</title>
</head>
<body>

	<%! EmployeeRepository er = new EmployeeRepository(); %>
	<%	
		int id = Integer.parseInt(request.getParameter("id")); 
		ResultSet rs = er.getEmployee(id);
		rs.next();
	%>
	
	<h1>Employee Update Form</h1>
	<form action="updateempaction" method="post">
		<input type="hidden" value="<%= id %>" name="id">
		Enter new name <input type="text" name="name" value="<%= rs.getString("name") %>"> <br>
		Enter new age <input type="number" name="age" value="<%= rs.getInt("age") %>"> <br>
		Enter new address <input type="text" name="address" value="<%= rs.getString("address") %>"> <br>
		<input type="submit" name="update" value="Update <%= rs.getString("name") %>">
	</form>
	
</body>
</html>