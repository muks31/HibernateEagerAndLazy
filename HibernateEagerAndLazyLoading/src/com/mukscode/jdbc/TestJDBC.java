package com.mukscode.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {
	
	public static void main(String[] args) {
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb-03-one-to-many?useSSL=false&serverTimeZone=UTC";
		String user = "hbstudent";
		String pass  = "hbstudent";
		try {
			System.out.println("Connecting to Database "+jdbcUrl);
			Connection conn = DriverManager.getConnection(jdbcUrl,user,pass);
			
			System.out.println("Connection Successful");
			
			
		}
		catch(Exception ex) {
			System.out.println(ex);
		}
	}

}
