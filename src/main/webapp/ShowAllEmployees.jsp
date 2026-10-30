<%@page import="java.sql.ResultSet"%>
<%@page import="com.repositories.EmployeeRepository"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List of all employees</title>
</head>
<body>
	
	<%!
		EmployeeRepository empRep = new EmployeeRepository();
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
         
        <%
            ResultSet rs = empRep.getEmployees();
            while(rs.next()){
        %>
        
            <tr>
                <td><%= rs.getInt("id")  %></td>
                <td><%= rs.getString("name")  %></td>
                <td><%= rs.getInt("age")  %></td>
                <td><%= rs.getString("address")  %></td>
            </tr>
        
        <% 
            }
        %>
        
        </tbody>
    </table>
	
</body>
</html>