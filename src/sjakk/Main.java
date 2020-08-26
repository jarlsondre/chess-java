package sjakk;


public class Main {

	private int movesMade = 0;
	private Board board;
	private boolean lastMoveEnPassant;
	private boolean check;
	private boolean checkMate;
	private boolean lastMoveCastle;

	public Main() {
		board = new Board(this);
	}
	

	public void setLastMoveEnPassant(boolean bool) {
		lastMoveEnPassant = bool;
	}
	
	public boolean getLastMoveEnPassant() {
		return lastMoveEnPassant;
	}
	
	public void setLastMoveCastled(boolean castle) {
		lastMoveCastle = castle; 
	}
	
	public boolean getLastMoveCastled() {
		return lastMoveCastle;
	}
	
	
	public void setBoard(Board board) {
		this.board = board;
	}

	public Board getBoard() {
		return this.board;
	}

	public int getMovesMade() {
		return movesMade;
	}
	
	public boolean getCheck() {
		return check;
	}
	
	public boolean getCheckMate() {
		return checkMate;
	}
	
	public boolean correctColor(Tile tile) {
		if (movesMade % 2 == 0) {
			return tile.getPiece().getColor() == 'W';
		}
		else return tile.getPiece().getColor() == 'B';
	}

	public boolean makeMove(Piece piece, int newX, int newY) {

		// Flytter brikken
		if (board.movePiece(piece, newX, newY, false)) {
			movesMade++;
			if (board.kingCheck('W')) {
				check = true;
				if (board.checkMate()) {
					checkMate = true;
				}
			}
			else if (board.kingCheck('B')) {
				check = true;
				if (board.checkMate()) {
					checkMate = true;
				}
			}
			else {
				check = false; 
			}
			return true;
		}
		else return false; 


	}

}
