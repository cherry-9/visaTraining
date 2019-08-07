package com.visa.training.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionHelper {
	public static Connection getConnection() {
		Connection c=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			c= DriverManager.getConnection("jdbc:mysql://localhost:3306/visa", "visa","secret");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return c;
		
	}

}
