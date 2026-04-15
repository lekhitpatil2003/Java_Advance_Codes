package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class PreparedStateDemo {

	public static void main(String[] args) {
		try {
			
			//Step 1: Register driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// Step 2: Create connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb","root","Lekhit@2003");
			
			// Step 3 : Create SQL Statement
			PreparedStatement ps = con.prepareStatement("insert into person values(?, ?, ?)");
			
			// Insert Data
			ps.setInt(1, 104);
			ps.setString(2, "Rohit");
			ps.setInt(3, 46);
			
			// Step 4 : Execute query
			int i = ps.executeUpdate();
			System.out.println(i + "Record Inserted");
			
			// Step 5 : Close Connection
			con.close();		
			
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
