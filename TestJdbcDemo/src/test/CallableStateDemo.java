package test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class CallableStateDemo {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb","root","Lekhit@2003");
			
			CallableStatement cs = con.prepareCall("{call id_delete_person(?)}");
			cs.setInt(1, 104);
			
			cs.execute();
			System.out.println("Deletion Successfully");
			
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
