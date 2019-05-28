package dataBase;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Item;
import model.Player;
import ux.mainUi;

public class DataBasePlayer {
		
	public static Player[] getPlayers(ConPool con){
		ResultSet rsPlayer = con.reqest("select * from dnd.player;");
		try {
			int size = 0;
			if (rsPlayer.last()) {
				size = rsPlayer.getRow();
				System.out.println(size);
				rsPlayer.beforeFirst();
			}
			Player[] players = new Player[size];
			int index = 0;
		
			while(rsPlayer.next()) {
				players[index++] = new Player(rsPlayer.getInt(1),rsPlayer.getString(2), rsPlayer.getString(3), rsPlayer.getInt(4), rsPlayer.getInt(5));
			}
			return players;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static ArrayList<Item> populateItems(ConPool con, Player pc) {
		ArrayList<Item> items = new ArrayList<Item>();
		String query = "select * from item"
				+ "join player_has_item on player_has_item.item_iditem = item.iditem"
				+ "where player_has_item.player_idplayer = ?";
		try {
			PreparedStatement stmt = mainUi.getConnection().prepareStatement(query);
			stmt.setInt(1, pc.getId());
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				items.add(new Item(rs.getInt("iditem"),rs.getString("name")));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return items;
		
	}

	public static void updatePlayer(Player editPlayer) {
		String query = "update dnd.player set name = ? "
				+ "where (idplayer = ?);";
		try {
			PreparedStatement stmt = mainUi.getConnection().prepareStatement(query);
			stmt.setString(1, editPlayer.getName());
			stmt.setInt(2, editPlayer.getId());
			stmt.execute();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public static void addPlayer(Player newPlayer) {
		String query = "insert into player (name, class, max_health, level)" +
				"values (?,?,?,?)";
		try {
		PreparedStatement stmt = mainUi.getConnection().prepareStatement(query);
		stmt.setString(1, newPlayer.getName());
		stmt.setString(2, newPlayer.getPcClassName());
		stmt.setInt(3, newPlayer.getMaxHealth());
		stmt.setInt(4, newPlayer.getLevel());
		stmt.execute();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
