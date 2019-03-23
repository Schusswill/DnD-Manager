package dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import objects.Item;
import objects.Player;

public class DataBasePlayer {

	private static ResultSet connect(String query) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3310/dnd","root","77798956");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			return rs;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static String[] getPlayersName() throws SQLException {
		ResultSet rs = connect("select * from players");
		int fetchSize = rs.getFetchSize() + 1;
		String[] names = new String[fetchSize];
		int i = 0;
		while(rs.next()) {
			String name = rs.getString(3);
			System.out.println(name);
			
			names[i++] = name;
			System.out.println(names[i-1]);
		}
		rs.close();
		return names;
	}
	
	public static Player loadPlayer(String playerName) throws SQLException, Exception{
		ResultSet rspc = connect("SELECT * from players "
									+ "WHERE players.name = \"%" + playerName + "%\";");
		ResultSet rsi = connect("SELECT items.* from players "
									+ "JOIN player_items"
										+ " on player_items.id_player = players.idplayers "
									+ "JOIN items"
										+ " on items.id_items = player_items.id_items"
									+ "Where players.name = \"%" + playerName + "%\";");
		if(rspc.getFetchSize() > 0)
			throw new Exception();
		ArrayList<Item> items = new ArrayList<Item>();
		while(rsi.next()) {
			 items.add(new Item(rsi.getInt(1),rsi.getString(2)));
		}
		Player pc = new Player(rspc.getInt(1), rspc.getString(3),rspc.getInt(4), items);
		return pc;
	}
}
