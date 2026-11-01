package com.repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeRepository {
	
	private String url = "jdbc:mysql://localhost:3306/a6_servlet";
	private String user = "root";
	private String pass = "tiger";
	
	public String saveEmployee(int id, String name, int age, String address) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, user, pass);
		String sql = "insert into emp_details values(?, ?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ps.setString(2, name);
		ps.setInt(3, age);
		ps.setString(4, address);
		int row = ps.executeUpdate();
		conn.close();
		return row+ "Row excuted\nUser created with id "+id;
	}
	
	public ResultSet getEmployee(int id) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, user, pass);
		String sql = "select * from emp_details where id=? ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
//		conn.close(); can't use result set after the connection closes
		return rs;
	}
	
	public ResultSet getEmployees() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, user, pass);
		String sql = "select * from emp_details";
		return conn.prepareStatement(sql).executeQuery();
	}

	public void updateEmp(int id, String name, int age, String address) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, user, pass);
		String sql = "update emp_details set name=?, age=?, address=? where id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, name);
		ps.setInt(2, age);
		ps.setString(3, address);
		ps.setInt(4, id);
		ps.executeUpdate();
		conn.close();
	}
	
}
