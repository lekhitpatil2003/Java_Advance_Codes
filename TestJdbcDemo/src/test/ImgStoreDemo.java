package test;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class ImgStoreDemo {

	public static void main(String[] args) {
		try {
			// register driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// create connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb","root","Lekhit@2003");
			
			PreparedStatement ps = con.prepareStatement("insert into imgtable(name, profile_pic) values(?, ?)");
			
			ps.setString(1, "User");
						
			FileInputStream fis = new FileInputStream(new File("D:\\ImgTest\\Untitled.jpg"));
			
			ps.setBinaryStream(2, fis);
			
			// Execute SQL query
			int rs = ps.executeUpdate();
			
			// display result
			if (rs > 0) {
				System.out.println("Data inserted Successfully");
			}
			
			// close connection
			fis.close();
			ps.close();
			con.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
