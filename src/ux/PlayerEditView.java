package ux;

import dataBase.DataBasePlayer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Player;
import model.PlayerClass;

public class PlayerEditView extends VBox{

	private Boolean newPlayer = false;
	private Player editPlayer;
	
	private Label nameLabel;
	private TextField nameField;
	
	public PlayerEditView() {
		this(new Player());
		this.newPlayer = true;
	}
	public PlayerEditView(Player editPlayer) {
		this.editPlayer = editPlayer;
		nameLabel = new Label("Name: ");
		nameField = new TextField(editPlayer.getName());
		Button saveButton = makeSaveButton();
		HBox hb = new HBox ();
		hb.getChildren().addAll(nameLabel, nameField, saveButton);
		hb.setSpacing(10);
		this.setSpacing(5);
		this.getChildren().addAll(hb);
	}
	
	private Button makeSaveButton() {
		Button button = new Button("Save");
		button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle (ActionEvent e) {
				System.out.println("save button pressed");
				if (newPlayer) {
					Player newPlayer = new Player();
					newPlayer.setName(nameField.getText());
					newPlayer.setLevel(1);
					newPlayer.setPcclass(new PlayerClass("wizard"));
					newPlayer.setMaxHealth(80);
					newPlayer.toString();
					DataBasePlayer.addPlayer(newPlayer);
				}else {
					editPlayer.setName(nameField.getText());
					System.out.println(editPlayer.toString());
					DataBasePlayer.updatePlayer(editPlayer);
				}
				mainUi.setScene(new Scene(new PlayerCatalogView()));
			}
		});
		return button;
	}

}
