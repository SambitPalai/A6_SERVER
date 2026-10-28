package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.repositories.UserRepository;
import com.util.UserAuthentication;

@WebServlet("/save_user")
public class SaveUser extends HttpServlet {

	private UserRepository userRepository = new UserRepository();
	private UserAuthentication userAuthentication = new UserAuthentication();
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		if(!userAuthentication.authenticate(session)) {
			RequestDispatcher rd = req.getRequestDispatcher("login.html");
			rd.forward(req, res);
			return;
		}
		
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String role = req.getParameter("role");
		
		try {
			String reqResponse = userRepository.saveUser(email, password, role);
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
