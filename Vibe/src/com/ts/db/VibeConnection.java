package com.ts.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class VibeConnection {
	public static Connection getConnection() {
		Connection con  = null;
		String URL="jdbc:mysql://localhost:3306/vibe_db";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL,"root","Siddharth98");
			if(con!=null) {
				return con;
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}

