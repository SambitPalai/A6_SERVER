package com.repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserRepository {

	private String url = "jdbc:mysql://localhost:3306/a6_servlet";
	private String user = "root";
	private String pass = "tiger";

	public String saveUser(String email, String password, String role) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, user, pass);
		String sql = "insert into user_details values(?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, email);
		ps.setString(2, password);
		ps.setString(3, role);
		ps.executeUpdate();
		conn.close();
		return "User " + email + " signed up successfully";
	}
	
	public boolean verifyUser(String email, String password, HttpServletResponse res, HttpServletRequest req) throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, user, pass);
		String sql = "select * from user_details where email=? and password=? ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, email);
		ps.setString(2, password);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			Cookie cookie1 = new Cookie("status", "valid");
			Cookie cookie2 = new Cookie("user", rs.getString("email"));
			cookie1.setMaxAge(300);
			cookie2.setMaxAge(300);
			res.addCookie(cookie1);
			res.addCookie(cookie2);
			HttpSession session = req.getSession();
			session.setAttribute("status", "valid");
			session.setAttribute("user", rs.getString("email"));
			return true;
		}
		return false;
	}
	
	
	
}
