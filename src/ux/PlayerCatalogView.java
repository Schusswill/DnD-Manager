package ux;

import dataBase.ConPool;
import dataBase.DataBasePlayer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Player;

public class PlayerCatalogView extends VBox{
	
	TableView<Player> playerTable = new TableView<Player>();
	
	public PlayerCatalogView(){
		try {
			Player[] players = DataBasePlayer.getPlayers(mainUi.getConnection());
			
			ObservableList<Player> playersList = FXCollections.observableArrayList();
			for(Player player : players) {
				System.out.println(player.toString());
				playersList.add(player);
			}
			HBox hb = new HBox();
			hb.getChildren().addAll(setUpEditPlayerButton(),setUpNewPlayerButton());
			this.setSpacing(5);
			this.getChildren().addAll(setUpTable(playersList), hb);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private Button setUpEditPlayerButton() {
		Button addButton = new Button("Edit Player");
		addButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle (ActionEvent e) {
				Player editPlayer = playerTable.getSelectionModel().getSelectedItem();
				System.out.println("start Edit player view for " + editPlayer.getName());
				mainUi.setScene(new Scene(new PlayerEditView(editPlayer)));
			}
		});
		return addButton;
	}
	private Button setUpNewPlayerButton() {
		Button addButton = new Button("New Player");
		addButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle (ActionEvent e) {
				System.out.println("start new player view");
				mainUi.setScene(new Scene(new PlayerEditView()));
			}
		});
		return addButton;
	}

	private TableView<Player> setUpTable(ObservableList<Player> playersList) {
		
		
		TableColumn<Player, String> nameCol = new TableColumn<Player, String>("Name");
		nameCol.setMinWidth(100);
		nameCol.setCellValueFactory(
				new PropertyValueFactory<Player, String>("name"));
		
		TableColumn<Player, Integer> levelCol = new TableColumn<Player, Integer>("level");
		levelCol.setMinWidth(100);
		levelCol.setCellValueFactory(
				new PropertyValueFactory<Player, Integer>("level"));
		
		TableColumn<Player, String> classCol = new TableColumn<Player, String>("Class");
		classCol.setMinWidth(100);
		classCol.setCellValueFactory(
				new PropertyValueFactory<Player, String>("pcClassName"));
		
		playerTable.setItems(playersList);
		playerTable.getColumns().addAll(nameCol, levelCol, classCol);
		return playerTable;
	}
}
