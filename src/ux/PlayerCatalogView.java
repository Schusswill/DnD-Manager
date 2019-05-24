package ux;

import dataBase.Connect;
import dataBase.DataBasePlayer;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import model.Player;

public class PlayerCatalogView extends VBox{
	
	
	public PlayerCatalogView(){
		try {
			Connect con = new Connect();
			Player[] players = DataBasePlayer.getPlayers(con);
			con.close();
			
			ObservableList<SimplePlayer> playersList = FXCollections.observableArrayList();
			for(Player player : players) {
				System.out.println(player.toString());
				playersList.add(new SimplePlayer(player));
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
				System.out.println("start Edit player view");
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
			}
		});
		return addButton;
	}

	private TableView<SimplePlayer> setUpTable(ObservableList<SimplePlayer> playersList) {
		TableView<SimplePlayer> playerTable = new TableView<SimplePlayer>();
		
		TableColumn<SimplePlayer, String> nameCol = new TableColumn<SimplePlayer, String>("Name");
		nameCol.setMinWidth(100);
		nameCol.setCellValueFactory(
				new PropertyValueFactory<SimplePlayer, String>("name"));
		
		TableColumn<SimplePlayer, Integer> levelCol = new TableColumn<SimplePlayer, Integer>("level");
		levelCol.setMinWidth(100);
		levelCol.setCellValueFactory(
				new PropertyValueFactory<SimplePlayer, Integer>("level"));
		
		TableColumn<SimplePlayer, String> classCol = new TableColumn<SimplePlayer, String>("Class");
		classCol.setMinWidth(100);
		classCol.setCellValueFactory(
				new PropertyValueFactory<SimplePlayer, String>("pcClass"));
		
		playerTable.setItems(playersList);
		playerTable.getColumns().addAll(nameCol, levelCol, classCol);
		return playerTable;
	}
	
	public static class SimplePlayer{
		private final SimpleStringProperty name;
		private final SimpleIntegerProperty level;
		private final SimpleStringProperty pcClass;
		
		private SimplePlayer(Player player) {
			this.name = new SimpleStringProperty(player.getName());
			this.level = new SimpleIntegerProperty(player.getLevel());
			this.pcClass = new SimpleStringProperty(player.getPcclass().getName());
			System.out.println(pcClass.toString());
		}
		
		public String getName() {
			return name.get();
		}
		
		public Integer getLevel() {
			return level.get();
		}
		
		public String getPcClass() {
			return pcClass.get();
		}
		
	}

}
