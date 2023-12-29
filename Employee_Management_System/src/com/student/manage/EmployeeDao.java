package com.student.manage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeDao {
	public static boolean insertEmployeeToDB(Employee obj) {
		
		boolean f = false;
		
		try {
			Connection con = CP.createConnection();
			String q = "insert into employee(name, phone, salary) values(?,?,?)";
			PreparedStatement ps = con.prepareStatement(q);
			
			ps.setString(1, obj.getEmployeeName());
			
			ps.setInt(2, obj.getEmployeePhone());
			ps.setDouble(3, obj.getEmployeeSalary());
			
			ps.executeUpdate();
			f = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public static boolean deleteEmployee(int userId) {

		boolean f = false;
		try {
			Connection con = CP.createConnection();
			String q = "delete from employee where id = ?";
			PreparedStatement ps = con.prepareStatement(q);
			
			ps.setInt(1, userId);
			
			ps.executeUpdate();
			
			if (isTableEmpty(con)) {
	           
	            resetAutoIncrement(con);
	        }
			f = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
		
	}

	private static boolean resetAutoIncrement(Connection con) throws SQLException {
		String q = "SELECT COUNT(*) FROM employee";
	    try (Statement st = con.createStatement(); ResultSet set = st.executeQuery(q)) {
	        if (set.next()) {
	            return set.getInt(1) == 0;
	        }
	    }
	    return false;
		
	}

	private static boolean isTableEmpty(Connection con) throws SQLException {
		String q = "ALTER TABLE employee AUTO_INCREMENT = 1";
	    try (Statement st = con.createStatement()) {
	        st.executeUpdate(q);
	    }
		return false;
	}

	public static void showAllEmployees() {
		boolean f = false;
		try {
			Connection con = CP.createConnection();
			String q = "select * from employee";
			Statement st = con.createStatement();
			ResultSet set = st.executeQuery(q);
			
			while(set.next()){
				int id = set.getInt(1);
				String name = set.getString(2);
				int phoneno = set.getInt(3);
				double salary = set.getDouble(4);
				
				System.out.println("ID : "+id);
				System.out.println("Name : "+name);
				System.out.println("Mobile Number : "+phoneno);
				System.out.println("Salary : "+salary);
				System.out.println("++++++++++++++++++++++++++++++++++");
			}
			f = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public static boolean updateEmployee(int updateUserId, String newName, int newPhoneNumber, double newSalary) {
	    boolean f = false;
	    try {
	        Connection con = CP.createConnection();
	        String q = "UPDATE employee SET name=?, phone=?, salary=? WHERE id=?";
	        PreparedStatement ps = con.prepareStatement(q);

	        ps.setString(1, newName);
	        ps.setInt(2, newPhoneNumber);
	        ps.setDouble(3, newSalary);
	        ps.setInt(4, updateUserId);

	        int rowsAffected = ps.executeUpdate();

	        if (rowsAffected > 0) {
	            f = true;
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return f;
	}
	
	

}