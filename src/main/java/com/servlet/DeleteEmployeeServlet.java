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

@WebServlet("/deleteempaction")
public class DeleteEmployeeServlet extends HttpServlet{
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		EmployeeRepository er = new EmployeeRepository();
			
			int id = Integer.parseInt(req.getParameter("id"));
			
			try {
				er.deleteEmp(id);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			RequestDispatcher rd = req.getRequestDispatcher("ShowAllEmployees.jsp");
			rd.forward(req, res);
			
		}
		
	}
