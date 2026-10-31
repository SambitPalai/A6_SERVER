package com.servlet;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.repositories.UserRepository;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	
	private UserRepository userRepo = new UserRepository();
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException{
		try {
			String user = req.getParameter("email");
			String password = req.getParameter("pass");
			if(userRepo.verifyUser(user, password, res, req)) {
				PrintWriter pw = res.getWriter();
				pw.print("<H1> Log in complete </H1>");
				RequestDispatcher rd = req.getRequestDispatcher("home.html");
				rd.include(req, res);
				return;
			}
			else {
				PrintWriter pw = res.getWriter();
				pw.print("<H1> Log in failed </H1>");
				RequestDispatcher rd = req.getRequestDispatcher("login.html");
				rd.include(req, res);
				
//				Used to redirect page to login.html without using request dispatcher
//				res.sendRedirect("login.html");
			
//				Used to redirect page to login.html with the help of request dispatcher
//				RequestDispatcher rd = req.getRequestDispatcher("login.html");
//				rd.sendRedirect(req, res);
				return;
			}
		}
		catch(Exception e ) {
			e.printStackTrace();
			req.setAttribute("error", "Current application facing some issue\nFixing soon");
			RequestDispatcher rd = req.getRequestDispatcher("/exception");
		}
	}
}
