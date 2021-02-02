package sjakk;

import java.util.ArrayList;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;

public class Pawn extends Piece {


	// Vil vite p� hvilket trekk bonden flyttet seg to frem. Dette er for � sjekke en passant
	private int madeDoubleForward = 0; 

	public Pawn(Tile tile, char color) {
		this.setCurrentTile(tile);
		this.setColor(color);
		this.setType("Pawn");
		setBoard(tile.getBoard());
	}

	@Override
	public ArrayList<Move> getMoves() {
		possibleMoves.clear();

		// legger inn x og y pos: 
		int x = getCurrentTile().getHorPos();
		int y = getCurrentTile().getVerPos();

		// m� sjekke hvilke trekk bonden kan gj�re:
		// M� f�rst se p� fargen, deretter p� hvilken rad den st�r p�
		// deretter hvilke brikker som st�r foran eller p� skr�, og fargen
		// p� disse

		// sjekker om brikken er hvit: 
		if (getColor() == 'W') {

			// sjekker om bonden st�r p� rad 2
			if (y == 2) {

				// m� sjekke om posisjonen over er ledig: 
				if (getBoard().getPiece(x, 3) == null) {

					// sjekker posisjonen to over:
					if (getBoard().getPiece(x, 4) == null) {
						possibleMoves.add(new Move(x, 4));
					}
				}
			}

			// Vil sjekke om posisjonen over er ledig:
			if (getBoard().getPiece(x, y + 1) == null) {
				possibleMoves.add(new Move(x, y+1));
			}

			// Vil sjekke om det st�r en motstanders brikke p� skr�: 
			if (x > 1 && y < 8 && getBoard().getPiece(x-1, y+1) != null) {
				if (getBoard().getPiece(x-1, y+1).getColor() == 'B') {
					possibleMoves.add(new Move(x-1, y+1));
				}
			}
			if (x < 8 && y < 8 && getBoard().getPiece(x+1, y+1) != null) {
				if (getBoard().getPiece(x+1, y+1).getColor() == 'B') {
					possibleMoves.add(new Move(x+1, y+1));
				}
			}
		}

		// Hvis brikken er svart: 
		else {

			// sjekker om brikken st�r p� rad 7
			if (y == 7) {

				// sjekker posisjonen under
				if (getBoard().getPiece(x, y-1) == null) {

					// sjekker posisjonen to under
					if (getBoard().getPiece(x, y-2) == null) {
						possibleMoves.add(new Move(x, y-2));
					}
				}
			}

			// sjekker om posisjonen under er ledig:
			if (getBoard().getPiece(x, y-1) == null) {
				possibleMoves.add(new Move(x, y-1));
			}

			// sjekker posisjonene p� skr�: 
			if (x > 1 && y > 1 && getBoard().getPiece(x-1, y-1) != null) {
				if (getBoard().getPiece(x-1, y-1).getColor() == 'W') {
					possibleMoves.add(new Move(x-1, y-1));
				}
			}
			if (x < 8 && y > 1 && getBoard().getPiece(x+1, y-1) != null) {
				if (getBoard().getPiece(x+1, y-1).getColor() == 'W') {
					possibleMoves.add(new Move(x+1, y-1));
				}
			}
		}

		// sjekker en passant: 
		checkEnPassant(p -> p.getCurrentTile().getVerPos() == 5 && p.getColor() == 'W', add, add);
		checkEnPassant(p -> p.getCurrentTile().getVerPos() == 5 && p.getColor() == 'W', subtract, add);
		checkEnPassant(p -> p.getCurrentTile().getVerPos() == 4 && p.getColor() == 'B', add, subtract);
		checkEnPassant(p -> p.getCurrentTile().getVerPos() == 4 && p.getColor() == 'B', subtract, subtract);
		return possibleMoves;	
	}

	public void setMoves(ArrayList<Move> moveList) {
		possibleMoves = moveList;
	}

	public void checkEnPassant(Predicate<Pawn> pred1, BinaryOperator<Integer> bin1, BinaryOperator<Integer> bin2) {
		int x = getCurrentTile().getHorPos();
		int y = getCurrentTile().getVerPos();

		if (pred1.test(this)) {
			if (bin1.apply(x, 1) > 0 && bin1.apply(x, 1) < 9 && getBoard().getTile(bin1.apply(x, 1), y).getPiece() != null) {
				if (getBoard().getTile(bin1.apply(x, 1), y).getPiece().getType().equals("Pawn") 
						&& getBoard().getTile(bin1.apply(x, 1), y).getPiece().getColor() != getColor()) {
					if (((Pawn) getBoard().getTile(bin1.apply(x, 1), y).getPiece()).getMadeDoubleForward() == 
							getBoard().getMain().getMovesMade() - 1) {
						possibleMoves.add(new Move(bin1.apply(x, 1), bin2.apply(y, 1)));
					}
				}
			}
		}
	}

	public void setMadeDoubleForward(int n) {
		this.madeDoubleForward = n;
	}

	public int getMadeDoubleForward() {
		return this.madeDoubleForward;
	}

}
