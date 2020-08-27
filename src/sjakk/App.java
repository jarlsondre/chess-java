package sjakk;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
	
		public void start(final Stage primaryStage) throws Exception {
			primaryStage.setTitle("Sjakk");
			primaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("SjakkGUI.fxml"))));
			primaryStage.show();
			primaryStage.getScene().getStylesheets().add("sjakk/gui.css");
		}

		public static void main(final String[] args) {
			Application.launch(args);
		}

}
