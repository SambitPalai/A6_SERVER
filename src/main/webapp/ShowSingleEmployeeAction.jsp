<%@page import="java.sql.ResultSet"%>
<%@page  import="com.repositories.EmployeeRepository"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Employee</title>
</head>
<body>
	<%!
		EmployeeRepository employeeRepository = new EmployeeRepository();
	%>
	<%
		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);
		ResultSet rs = employeeRepository.getEmployee(id);
		if (rs.next()) {
	%>
	<table>
		<thead>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Age</th>
				<th>Address</th>
			</tr>
		</thead>
		<tbody>	
			<tr>
				<td><%= rs.getInt("id")  %></td>
				<td><%= rs.getString("name")  %></td>
				<td><%= rs.getInt("age")  %></td>
				<td><%= rs.getString("address")  %></td>
			</tr>
		</tbody>
	</table>
	<%
		}
		else{
			out.print("<p style='color:red;'>Employee with ID " + id + " does not exist.</p>");
		}
	%>
</body>
</html>