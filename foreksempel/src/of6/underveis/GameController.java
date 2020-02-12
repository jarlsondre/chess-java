package of6.underveis;

import java.util.Arrays;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

public class GameController {

	Game game;
	
	@FXML
	Pane board;
	
	@FXML
	public void initialize() {
		game = new Game(16, 12);
		game.getTile(6, 11).setGround();
		game.getTile(7, 11).setGround();
		game.getTile(8, 11).setGround();
		game.getTile(6, 10).setGround();
		game.getTile(7, 10).setGround();
		game.getTile(8, 10).setGround();
		game.getTile(9, 10).setGround();
		game.getTile(6, 9).setGround();
		game.getTile(7, 9).setGround();
		game.getTile(8, 9).setGround();
		game.getTile(9, 9).setGround();
		game.getTile(6, 8).setGround();
		game.getTile(8, 6).setGround();
		game.getTile(10, 6).setGround();
		game.getTile(5, 5).setGround();
		game.getTile(5, 6).setFruit();
		game.getTile(9, 6).setFruit();
		game.getTile(8, 3).setGoal();

		game.createSnake(Arrays.asList(game.getTile(9, 8), game.getTile(8, 8)));
		
		createBoard();
	}
	
	public String getTileColor(Tile tile) {
		if (tile.isSnake()) {
			return "#24d628";
		} else if (tile.isGround()) {
			return "#a26f42";
		} else if (tile.isFruit()) {
			return "#e5303a";
		} else if (tile.isGoal()) {
			return "#f6ec5a";
		}
		
		return "#7bcaf2";
	}
	
	public void createBoard() {
		for (int y = 0; y < game.getHeight(); y++) {
			for (int x = 0; x < game.getWidth(); x++) {
				Pane pane = new Pane();
				pane.setTranslateX(x * 20);
				pane.setTranslateY(y * 20);
				pane.setPrefHeight(20);
				pane.setPrefWidth(20);
				board.getChildren().add(pane);
			}
		}
	}
	
}
