package dataBase;
//import java.sql.*;
public class DataBaseTest {

//	public static void main(String[]args) {
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			Connection con = DriverManager.getConnection(
//					"jdbc:mysql://localhost:3310/dnd","root","77798956");
//			Statement stmt=con.createStatement();
//			ResultSet rs=stmt.executeQuery("select * from players");
//			while(rs.next()) {
//				System.out.println("Name: " + rs.getString(3));
//			}
//			con.close();
//		}catch(Exception e) {System.out.println(e);}
//	}
	
	
	/*items by player name:
	 * 	select items.* from players
		join player_items
			on player_items.id_player = players.idplayers
		join items
			on items.id_items = player_items.id_items
		where players.name = "%playerName%";
	 */
	
	public static void main(String[]args) {
		try {
			System.out.println(DataBasePlayer.loadPlayer("uras").toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
