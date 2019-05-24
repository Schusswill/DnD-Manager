package dataBase;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Item;
import model.Player;

public class DataBasePlayer {
	
	public static String[] getPlayersName(Connect connect) throws SQLException {
		ResultSet rs = connect.reqest("select * from players");
		int fetchSize = 0;
		if(rs.last()) {
			fetchSize = rs.getRow();
			rs.beforeFirst();
		}
		String[] names = new String[fetchSize];
		int i = 0;
		while(rs.next()) {
			String name = rs.getString(3);
			System.out.println(name);
			
			names[i] = name;
			i++;
//			System.out.println(names[i-1]);
		}
		rs.close();
		return names;
	}
	
	public static Player[] getPlayers(Connect connect){
		ResultSet rsPlayer = connect.reqest("select * from dnd.player;");
		try {
			int size = 0;
			if (rsPlayer.last()) {
				size = rsPlayer.getRow();
				rsPlayer.beforeFirst();
			}
			Player[] players = new Player[size];
			int index = 0;
		
			while(rsPlayer.next()) {
				players[index] = new Player(rsPlayer.getInt(1),rsPlayer.getString(2), rsPlayer.getString(3), rsPlayer.getInt(4), rsPlayer.getInt(5));
			}
			return players;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static ArrayList<Item> populateItems(String name) {
		Connect connect = new Connect();
		ArrayList<Item> items = new ArrayList<Item>();
		ResultSet rsItems = connect.reqest("SELECT items.* from player "
									+ "JOIN player_items "
									+ "on player_items.id_player = player.idplayers "
									+ "JOIN items "
									+ "on items.id_items = player_items.id_items "
									+ "Where players.name = \"" + name + "\";");
		connect.close();
		
		try {
			while(rsItems.next()) {
				items.add(new Item(rsItems.getInt(1), rsItems.getString(2)));
			}
			return items;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
}
