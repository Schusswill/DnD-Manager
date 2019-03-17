package dataBase;
import java.sql.*;
public class DataBase {

	public static void main(String[]args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3310/dnd","root","77798956");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from players");
			while(rs.next())
				System.out.println(rs.getInt(1) + " " + rs.getString(3));
			con.close();
		}catch(Exception e) {System.out.println(e);}
	}
}
