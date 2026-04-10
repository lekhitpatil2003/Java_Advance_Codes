package task;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Employee {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb","root","Lekhit@2003");
			
			Statement st = con.createStatement();
			
			ResultSet rs = st.executeQuery("select * from Employee");
			
			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getDouble(3) + " " + 
			rs.getInt(4) + " " + rs.getString(5));
			}
			
			con.close();
		} catch (Exception e) {
			System.out.println();
		}
	}
}