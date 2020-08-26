package uke5.matte;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MatteApp extends Application{
	@Override
	public void start(final Stage primaryStage) throws Exception {
		primaryStage.setTitle("DownCounter");
		primaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("MatteGUI.fxml"))));
		primaryStage.show();
	}

	public static void main(final String[] args) {
		Application.launch(args);
	}

}
