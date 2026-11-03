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
	<form action="deleteempaction" method="post">
		<input type="hidden" name="id" value="<%= id %>">
		Are you sure you want to delete id: <input type="number" name="id" value="<%= rs.getInt("id") %>"> <br>
		<div class="btn-container">
			<!-- Clicking 'Yes' submits the form to your deletion servlet/action page -->
			<input type="submit" name="confirm" value="Yes" >
			<!-- Clicking 'No' takes the user back to the previous page -->
			<a href="ShowAllEmployees.jsp" class="btn-no">No</a>
		</div>
	</form>
	
</body>
</html>