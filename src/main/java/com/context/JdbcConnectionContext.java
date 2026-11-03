package com.context;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class JdbcConnectionContext implements ServletContextListener{
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext context = sce.getServletContext();
		try {
			String url = "jdbc:mysql://localhost:3306/a6_servlet";
			String user = "root";
			String pass = "tiger";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, user, pass);
			context.setAttribute("connection", conn);
			System.out.println("JDBC MySQL Connection Created");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		ServletContext sc = sce.getServletContext();
		Connection conn = (Connection)sc.getAttribute("connection");
		try {
			conn.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
