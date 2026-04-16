package test;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

public class DatabaseMetaDataDemo {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb","root","Lekhit@2003");
			
			DatabaseMetaData dm = con.getMetaData();
			
			System.out.println("Driver Name : " + dm.getDriverName());
			System.out.println("Name of Version : " + dm.getDriverVersion());
			System.out.println("Name of Database Varsion : " + dm.getDatabaseProductVersion());
			System.out.println("Database Name : " + dm.getDatabaseProductName());
			System.out.println("URL : " + dm.getURL());
			System.out.println("Database Major Version : " + dm.getDatabaseMajorVersion());
			System.out.println("Database Minor Version : " + dm.getDatabaseMinorVersion());
						
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
