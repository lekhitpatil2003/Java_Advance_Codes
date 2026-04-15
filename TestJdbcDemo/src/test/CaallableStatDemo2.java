package test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class CaallableStatDemo2 {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb","root","Lekhit@2003");
			
			CallableStatement cs = con.prepareCall("{call Squareroot_of_no(?, ?)}");
			cs.setInt(1, 4);
			cs.registerOutParameter(2, Types.DOUBLE);
			
			cs.execute();
			System.out.println("Square of a no: " + cs.getDouble(2));
			System.out.println("Program Run Successfully...");
			
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
