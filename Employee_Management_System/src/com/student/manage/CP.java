package com.student.manage;

import java.sql.Connection;
import java.sql.DriverManager;

public class CP {
	
	static Connection con;
	public static Connection createConnection()  {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		     con =	DriverManager .getConnection("jdbc:mysql://localhost:3306/employee_information", "root", "prasad@8767");	    
		    
		}catch (Exception e) {
			System.out.println(e);
		}
		return con;
		
	    
	 
	}
}
