package com.servlet;

import java.io.IOException;
import java.net.Authenticator.RequestorType;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.util.UserAuthentication;

@WebServlet("/logout")
public class LogOutServlet extends HttpServlet{
	
	private UserAuthentication userAuthentication = new UserAuthentication();
	
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		userAuthentication.logOutService(req, res);
		RequestDispatcher rd = req.getRequestDispatcher("login.html");
		rd.forward(req, res);
	}
	
}
