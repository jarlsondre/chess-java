package sjakk;


public class Tile {

	private Piece piece = null;
	private Board board = null;
	private int xPos;
	private int yPos; 
	// (1, 1) skal være nederst til venstre hjerne og representere A1 på brettet

	public Tile (int x, int y, Board board) {
		checkInput(x, y);
		xPos = x;
		yPos = y;
		this.board = board;
	}


	public int getHorPos() {
		return xPos;
	}

	public int getVerPos() {
		return yPos;
	}

	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece newPiece) {
		this.piece = newPiece;
		try {
			if (piece.getCurrentTile() != this) {
				piece.setCurrentTile(this);
			}
		}
		catch (Exception e) {
			
		}
	}

	public Board getBoard() {
		return board;
	}
	
	public void setBoard(Board board) {
		this.board = board; 
	}

	private void checkInput(int x, int y) {
		if (x < 1 || x > 8 || y < 1 || y > 8) throw new IllegalArgumentException("Coordinates out of bounds");
	}

	@Override
	public String toString() {
		return piece + " (" + xPos + ", " + yPos + ")";
	}

	public static void main(String[] args) {

	}


}
