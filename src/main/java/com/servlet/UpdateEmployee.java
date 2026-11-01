package com.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.repositories.EmployeeRepository;

@WebServlet("/updateempaction")
public class UpdateEmployee extends HttpServlet{
	
	EmployeeRepository er = new EmployeeRepository();
	
	public void doPost(HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		int id = Integer.parseInt(req.getParameter("id"));
		int age = Integer.parseInt(req.getParameter("age"));
		String address = req.getParameter("address");
		
		try {
			er.updateEmp(id, name, age, address);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		RequestDispatcher rd = req.getRequestDispatcher("ShowAllEmployees.jsp");
		rd.forward(req, res);
		
	}
	
}
