package test;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class FileStoreDemo {

	public static void main(String[] args) {
		try {
			// register driver
			Class.forName("com.mysql.cj.jdbc.Driver");
						
			// create connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb","root","Lekhit@2003");
			
			String sql = "insert into doctable(file_name, doc_file) values(?, ?)";						
			PreparedStatement ps = con.prepareStatement(sql);
						
			ps.setString(1, "user");
									
			FileInputStream fis = new FileInputStream(new File("D:\\ImgTest\\introduction.txt"));
						
			ps.setBinaryStream(2, fis);
						
			// Execute SQL query
			int rs = ps.executeUpdate();
						
			// display result
			if (rs > 0) {
				System.out.println("File inserted Successfully");
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
