package com.example;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCFactory {
	
	public static ResultSet getResultset(String query) throws ClassNotFoundException, SQLException {
		
			//step1 load the driver class 
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//step2 create  the connection object  
			Connection con=DriverManager.getConnection(  
			"jdbc:oracle:thin:@localhost:1521:orcl","shobha","shobha100");  
			  
			//step3 create the statement object  
			Statement stmt=con.createStatement();  
			
			
		/*
		 * DatabaseMetaData meta = con.getMetaData();
		 * System.out.println(meta.getDatabaseProductName());
		 * System.out.println(meta.getDatabaseProductVersion());
		 * System.out.println(meta.getDriverName());
		 * System.out.println(meta.getDriverVersion());
		 */
			
			ResultSet rs=stmt.executeQuery(query);
			return rs;
	}

}
