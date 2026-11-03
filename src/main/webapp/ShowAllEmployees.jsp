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
                <th>Update</th>
                <th>Direct Delete</th>
                <th>Delete by Permission</th>
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
                <td><a href="UpdateEmp.jsp?id=<%= rs.getInt("id") %>"><%= "Update "+rs.getString("name") %></a></td>
                
                <!--This deletes the data by directly taking the id to the servlet we can't 
                give raw java file here or it will give STATUS 404 : Resource not avaliable-->
                <td><a href="deleteempaction?id=<%= rs.getInt("id") %>"><%= "Delete "+rs.getInt("id") %></a></td>
                
                <!--It directly takes the id from input to DeleteEmp.jsp -->
                <td><a href="DeleteEmp.jsp?id=<%= rs.getInt("id") %>"><%= "Delete "+rs.getInt("id") %></a></td> 
            </tr>
        
        <% 
            }
        %>
        
        </tbody>
    </table>
	
	<h1><a href="home.html">Back To Home</a></h1>
	
</body>
</html>