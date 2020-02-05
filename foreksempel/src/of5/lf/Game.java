package of5.lf;

public class Game {

	private Tile[][] board;

	public Game(int width, int height) {
		board = new Tile[height][width];
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				board[y][x] = new Tile(x, y);
			}
		}
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
				representation = representation + getTile(x, y).toString();
			}
			representation = representation + "\n";
		}
		return representation;
	}

}
