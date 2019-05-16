package ux;

import dataBase.DataBasePlayer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import model.Player;

public class PlayerCatalogView extends VBox{
	
	
	public PlayerCatalogView(){
		try {
			Player[] players = DataBasePlayer.getPlayers();
			
			
			ObservableList<Player> playersList = FXCollections.observableArrayList();
			for(Player player : players) {
				System.out.println(player.toString());
				playersList.add(player);
			}
			StackPane pane = new StackPane();
			pane.getChildren().add(setUpTable(playersList));
			this.getChildren().addAll(pane);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private TableView<Player> setUpTable(ObservableList<Player> playersList) {
		
		TableView<Player> playerTable = new TableView<>();
		
		//name
		TableColumn<Player, String> nameColumn = new TableColumn<>("name");
		nameColumn.setMinWidth(200);
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
		
		//level
		TableColumn<Player, Integer> levelColumn = new TableColumn<>("level");
		levelColumn.setMinWidth(100);
		levelColumn.setCellValueFactory(new PropertyValueFactory<>("level"));
				
		return playerTable;
	}

}
