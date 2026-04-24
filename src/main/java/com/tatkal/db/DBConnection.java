package com.tatkal.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection 
{
	private static final String URL ="jdbc:mysql://localhost:3306/tatkal_db";
	private static final String USER ="root";
	private static final String PASSWORD ="Mysql@123";
	
	public static Connection getConnection() throws SQLException
	{
		Connection conn = DriverManager.getConnection(URL,USER,PASSWORD);
		System.out.println("Database Connected Successfully!!");
		return conn;
	}

}
