package of6.underveis;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GameApp extends Application{

	@Override
	public void start(final Stage primaryStage) throws Exception {
		primaryStage.setTitle("Snakebird");
		primaryStage.setScene(new Scene(FXMLLoader.load(GameApp.class.getResource("Game.fxml"))));
		primaryStage.show();
	}

	public static void main(final String[] args) {
		GameApp.launch(args);
	}
}