package test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class CallableState4 {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb","root","Lekhit@2003");
			
			CallableStatement cs = con.prepareCall("{call circle_area_proc(?, ?)}");

			cs.setDouble(1, 7);
			
			cs.registerOutParameter(2, Types.DOUBLE);

			cs.execute();

			System.out.println("Area: " + cs.getDouble(2));
			
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}