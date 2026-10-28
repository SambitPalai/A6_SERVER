package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.repositories.EmployeeRepository;
import com.util.UserAuthentication;

@WebServlet("/save_employee")
public class SaveEmployee extends HttpServlet {

	private EmployeeRepository employeeRepository = new EmployeeRepository();
	private UserAuthentication userAuthentication = new UserAuthentication();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		Cookie[] cookies = req.getCookies();
		if(!userAuthentication.authenticate(cookies)) {
			RequestDispatcher rd = req.getRequestDispatcher("login.html");
			rd.forward(req, res);
			return;
		}
		
		System.out.println("Request came from empsave html file");
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));
		String address = req.getParameter("address");

		try {
			String reqResponse = employeeRepository.saveEmployee(id, name, age, address);
			PrintWriter pw = res.getWriter();
			pw.print("<H1> " + reqResponse + " </H1>");
			return;
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", "Current application facing some issue\nFixing soon");
			RequestDispatcher rd = req.getRequestDispatcher("/exception");
			rd.forward(req, res);
			return;
		}

	}

}
