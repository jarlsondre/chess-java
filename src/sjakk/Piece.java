package sjakk;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;

public abstract class Piece implements Iterable<Move> {
	
	protected ArrayList<Move> possibleMoves = new ArrayList<Move>();
	private Tile currentTile;
	private char color;
	private String type;
	private Board board;
	BinaryOperator<Integer> add = (a, b) -> a + b;
	BinaryOperator<Integer> subtract = (a, b) -> a - b;
	BinaryOperator<Integer>	nothing = (a, b) -> a;
	
	
	public Iterator<Move> iterator() {
		return new PieceIterator(this);
		
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getType() {
		return type;
	}
	public void checkColor(char c) {
		if (c != 'B' && c != 'W') throw new IllegalArgumentException("A piece must be either white or black");
	}
	
	public abstract ArrayList<Move> getMoves();
	
	public void setColor(char c) {
		checkColor(c);
		color = c; 
	}
	
	public char getColor() {
		return color;
	}
	
	public void setCurrentTile(Tile tile) {
		this.currentTile = tile;
		if (currentTile.getPiece() != this) {
			currentTile.setPiece(this);
		}
	}
	
	public Tile getCurrentTile() {
		return currentTile;
	}
	
	public void setBoard(Board board) {
		this.board = board;
	}
	
	public Board getBoard() {
		return board;
	}
	
	public void loopFunc(Predicate<Integer> pred, int x, int y, char color, BinaryOperator<Integer> bin1, BinaryOperator<Integer> bin2, ArrayList<Move> possibleMoves) {

		for (int i = 1; pred.test(i); i++) {
			if (getCurrentTile().getBoard().getPiece(bin1.apply(x, i), bin2.apply(y, i)) == null) {
				possibleMoves.add(new Move(bin1.apply(x, i), bin2.apply(y, i)));
			}
			// hvis brikken har en annen farge skal man kunne legge til trekket, men må deretter avslutte løkken
			else if (getCurrentTile().getBoard().getPiece(bin1.apply(x, i), bin2.apply(y, i)).getColor() != color) {
				possibleMoves.add(new Move(bin1.apply(x, i), bin2.apply(y, i)));
				break;
			}
			else break; 
		}
	}
	
	@Override
	public String toString() {
		return type + " (" +  getCurrentTile().getHorPos() + ", " + getCurrentTile().getVerPos() + ") " + Character.toString(getColor());
	}
	
	public static void main(String[] args) {
		
		
	}
}
