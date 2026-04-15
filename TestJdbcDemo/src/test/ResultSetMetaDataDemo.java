package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class ResultSetMetaDataDemo {

	public static void main(String[] args) {
		try {
			//Step 1: Register Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Step 2: Create Connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb","root","Lekhit@2003");
			
			//Step 3: Create SQL Statement
			PreparedStatement ps = con.prepareStatement("select * from person");
			
			//Step 4: Execute SQL Statement
			ResultSet rs = ps.executeQuery();
			
			ResultSetMetaData rmd = rs.getMetaData();
			
			System.out.println("Total no. of Columns: " + rmd.getColumnCount());
			System.out.println("Name of 1st Column: " + rmd.getColumnName(1));
			System.out.println("Name of 1st Column: " + rmd.getColumnTypeName(1));
			System.out.println("Name of 2nd Column: " + rmd.getColumnDisplaySize(2));
			
			con.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
