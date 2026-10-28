package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/exception")
public class ExceptionHandlingServlet extends HttpServlet{
	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String errorMessage = (String) req.getAttribute("error");
		PrintWriter pw = resp.getWriter();
		pw.print("<H1>"+ errorMessage +"</H1>");
	}
}
