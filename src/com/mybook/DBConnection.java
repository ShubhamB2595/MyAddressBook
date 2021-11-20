package com.mybook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private final static String DB_DRIVER_CLASS = "com.mysql.jdbc.Driver";
	private final static String DB_URL = "jdbc:mysql://localhost:3306/addressbook_service?autoReconnect=true&useSSL=false";
	private final static String DB_USERNAME = "root";
	private final static String DB_PASSWORD = "Shubham@2595";

	public static Connection getConnection() {
		Connection con = null;
		try {
			// load the Driver Class
			Class.forName(DB_DRIVER_CLASS);

			// create the connection now
			con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		System.out.println("DB Connection created successfully");
		return con;
	}
}
