package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class BatchProcessingDemo {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb", "root", "Lekhit@2003");
			con.setAutoCommit(false);
			// step 3
			Statement st = con.createStatement();
			
			// Step 4 : prepare a batch processing
			st.addBatch("insert into person(id, name, age) values(106, 'sam', 30)");
			st.addBatch("insert into person(id, name, age) values(107, 'John', 27)");
			st.addBatch("insert into person(id, name, age) values(108, 'Akash', 26)");
			
			// step 5 : execute SQL Statement
			st.executeBatch();
			con.commit();
			System.out.println("Success");
			
			// step 6 : close connection
			con.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
