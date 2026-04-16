package test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class CallableStateDemo3 {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb","root","Lekhit@2003");
			
			CallableStatement cs = con.prepareCall("{call factorial_proc(?, ?)}");
			
			cs.setInt(1, 7);
			
			cs.registerOutParameter(2, Types.BIGINT);
			
			cs.execute();
			
			System.out.println("Factorial of 7 is: " + cs.getInt(2));
			
			con.close();
		} catch (Exception e) {
			
		}
	}

}