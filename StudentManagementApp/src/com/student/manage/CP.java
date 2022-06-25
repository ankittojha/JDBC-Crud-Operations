package com.student.manage;

import java.sql.Connection;
import java.sql.DriverManager;

public class CP {
	static Connection con;
	
	public static Connection createC() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// creating the connection...
			String user = "root";
			String password = "8090";
			String url = "jdbc:mysql://localhost:3306/student_manage?autoReconnect=true&useSSL=false";
			
			con = DriverManager.getConnection(url,user,password);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return con;
	}
}
