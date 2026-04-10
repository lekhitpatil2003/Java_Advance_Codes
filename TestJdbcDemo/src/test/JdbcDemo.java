package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcDemo {

	public static void main(String[] args)  {
		
		try {
			//Step 1: Register Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Step 2: Create Connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb","root","Lekhit@2003");
			
			//Step 3: Create SQL Statement
			Statement st = con .createStatement();
			
			//Step 4: Execute SQL Statement
			ResultSet rs = st.executeQuery("select * from person");
			while (rs.next()) {
				System.out.println(rs.getInt(1) +  " " + rs.getString(2) + " " + rs.getInt(3));
			}
			
			//Step 5: Close Connection
			con.close();
		}
		catch (Exception e) {
			System.out.println();
		}
	}
}