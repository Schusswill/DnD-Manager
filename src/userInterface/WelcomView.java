package userInterface;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class WelcomView extends VBox{

	Button playerCatalogBtn;
	
	public WelcomView() {
		this.setPrefSize(800, 600);
		
		setDisplay();
	}
	
	private void setDisplay() {
		
		StackPane pane = new StackPane();
		
		playerCatalogBtn = new Button("PlayerCatalog");
		playerCatalogBtn.setPrefSize(100, 160);
		playerCatalogBtn.setOnAction(e -> playerCatalogOpen());
		
		pane.getChildren().add(playerCatalogBtn);
		this.getChildren().add(pane);
		
	}
	
	private void playerCatalogOpen() {
		System.out.println("clicked");
		mainUi.setScene(new Scene(new PlayerCatalogView()));
	}
}
