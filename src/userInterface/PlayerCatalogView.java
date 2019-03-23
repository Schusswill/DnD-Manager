package userInterface;

import java.sql.SQLException;

import dataBase.DataBasePlayer;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class PlayerCatalogView extends VBox{
	
	public PlayerCatalogView(){
		try {
			String[] playerNames = DataBasePlayer.getPlayersName();
			
			StackPane pane = new StackPane();
			
			for(String name : playerNames) {
				pane.getChildren().add(new Label(name));
			}
			this.getChildren().add(pane);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
