package com.student.manage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;


public class StudentDao {
	public static boolean insertStudentToDB(Student st) {
		Scanner sc = new Scanner(System.in);
		boolean f = false;
		try {
			
			// jdbc code ...
			Connection con = CP.createC();
			String q = "insert into studentd(sname, sphone,scity) values(?,?,?)";
			
			// preparedStatement
			PreparedStatement pstmt = con.prepareStatement(q);
			// set the values of the parameters 
			pstmt.setString(1, st.getSname());
			pstmt.setString(2, st.getSphone());
			pstmt.setString(3, st.getScity());
			
			//execute
			pstmt.executeUpdate();
			f = true;
			
			//
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return f;
	}

	public static boolean deleteStudent(int userId) {
		// TODO Auto-generated method stub
		boolean f = false;
		try {
			
			// jdbc code ...
			Connection con = CP.createC();
			String q = "delete from studentd where sid=?";
			
			// preparedStatement
			PreparedStatement pstmt = con.prepareStatement(q);
			// set the values of the parameters 
			pstmt.setInt(1, userId);
			
			
			//execute
			pstmt.executeUpdate();
			f = true;
			
			//
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return f;
		
	}
	public static void displayStudents() {
		// TODO Auto-generated method stub
		boolean f = false;
		try {
			
			// jdbc code ...
			Connection con = CP.createC();
			String q = "select * from studentd";
			
			// preparedStatement
			Statement stmt = con.createStatement();
			
			
			//execute
			ResultSet set = stmt.executeQuery(q);
			
			while(set.next()) {
				int id = set.getInt(1);
				String name = set.getString(2);
				String phone = set.getString(3);
				String city = set.getString(4);
				System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
				System.out.println("Printing Students detail : ");
				System.out.println("ID : "+ id);
				System.out.println("Name : "+ name);
				System.out.println("Phone : "+ phone);
				System.out.println("City : "+ city);
				System.out.println("++++++++++++++++++++++++++++++++++++++++++");
				
			}
			
			//
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public static boolean updateStudent(int userId, String name, String city) {
		// TODO Auto-generated method stub
		boolean f = false;
		
		try {
			
			// jdbc code ...
			Connection con = CP.createC();
			String q = "update studentd set sname=?, scity=?";
			
			// preparedStatement
			PreparedStatement pstmt = con.prepareStatement(q);
			// set the values of the parameters 
			pstmt.setString(1, name);
			pstmt.setString(2, city);
			
			//execute
			pstmt.executeUpdate();
			f = true;
			
			//
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return f;
		
	}
}
