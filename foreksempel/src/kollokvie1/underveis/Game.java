package kollokvie1.underveis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {

	private Tile[][] board;
	private List<Tile> snake;

	public Game(int width, int height) {
		board = new Tile[height][width];
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				board[y][x] = new Tile(x, y);
			}
		}
	}
	
	public void createSnake(List<Tile> snake) {
		if (this.snake != null) {
			throw new IllegalStateException("Snake already created");
		}
		
		for (Tile tile : snake) {
			tile.setSnake();
		}
		
		this.snake = new ArrayList<>(snake);
	}

	public boolean isTile(int x, int y) {
		return 0 <= x && x < getWidth() && 0 <= y && y < getHeight();
	}

	public Tile getTile(int x, int y) {
		if (!isTile(x, y)) {
			throw new IllegalArgumentException("Not a valid tile");
		}

		return board[y][x];
	}

	public int getHeight() {
		return board.length;
	}

	public int getWidth() {
		return board[0].length;
	}

	@Override
	public String toString() {
		String representation = "";

		for (int y = 0; y < getHeight(); y++) {
			for (int x = 0; x < getWidth(); x++) {
				if (getTile(x, y) == snake.get(0)) {
					representation = representation + "8"; 
				} else {
					representation = representation + getTile(x, y).toString();
				}
			}
			representation = representation + "\n";
		}
		return representation;
	}
	
	public static void main(String[] args) {
	    Game game = new Game(16, 12);
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

	    System.out.println(game);
	}

}
