package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
	
	private static Connection con;
	public static Connection getConnection() {
		String url="jdbc:mysql://localhost:3306/hospital-management-system-servlet";
		String user="root";
		String pass="Harsh@123";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url, user, pass);
			
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		return con;
		
	}

}
