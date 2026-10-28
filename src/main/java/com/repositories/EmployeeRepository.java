package com.repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
}
