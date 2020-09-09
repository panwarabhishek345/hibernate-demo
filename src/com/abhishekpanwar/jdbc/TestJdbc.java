package com.abhishekpanwar.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/student_tracker?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
		
		String user = "student";
		String pass = "student";
		
		try {
			Connection myConnection = DriverManager.getConnection(jdbcUrl,user,pass);
			System.out.println("Database connected");
		}catch(Exception exc) {
			exc.printStackTrace();
		}

	}

}
