package com.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {
	   public static String driver = "com.mysql.jdbc.Driver";
	   public static String url = "jdbc:mysql://localhost:3306/bookshop";
	   public static String username = "root";
	   public static String userpwd = "123456";
	   
	   //建立连接
	   public static Connection getconnection(){
		   Connection conn = null;
		   try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, username, userpwd);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   return conn;
	   }
}
