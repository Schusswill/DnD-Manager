package userInterface;

import java.awt.EventQueue;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class mainUi extends Application{

	static Stage window;
	static Scene mainScene;

	public static void main(String[]args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainUi.launch(args);
				}catch(Exception e) {e.printStackTrace();}
			}
		});
	}
	
	public static void launch(String[]args) {
		Application.launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		
		window = stage;
		window.setHeight(600);
		window.setWidth(800);
		
		mainScene = new Scene(new WelcomView(),800, 600);
		
		window.setScene(mainScene);
		window.show();
		window.setOnCloseRequest((WindowEvent event1)->{
			System.exit(0);
		});
		
	}
	
	public static void setScene(Scene newScene) {
		window.setScene(newScene);
	}
	
	public static void returnToMain() {
		window.setScene(mainScene);
	}

}
