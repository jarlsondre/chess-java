package mineSweeper;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MSRun extends Application{
	@Override
	public void start(final Stage primaryStage) throws Exception {
		primaryStage.setTitle("JarlSweeper");
		primaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("MSGUI.fxml"))));
		primaryStage.show();
	}
	
	public static void main(final String[] args) {
		Application.launch(args);
	}
}
