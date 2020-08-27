package sjakk;

import java.util.ArrayList;

public class Rook extends Piece {

	private ArrayList<Move> possibleMoves = new ArrayList<Move>();
	private boolean hasMoved; 

	public Rook(Tile tile, char color) {
		this.setCurrentTile(tile);
		this.setColor(color);
		this.setType("Rook");
	}
	
	public boolean getHasMoved() {
		return hasMoved; 
	}
	
	public void setHasMoved(boolean b) {
		this.hasMoved = b; 
	}

	@Override
	public ArrayList<Move> getMoves() {
		possibleMoves.clear();

		// M� ha fire for-l�kker, m� sjekke om brikkene er null eller motsatt farge

		char color = getColor();
		int x = getCurrentTile().getHorPos();
		int y = getCurrentTile().getVerPos();
		
		// G�r mot h�yre
		loopFunc(p -> p <= (8-x), x, y, color, add, nothing, possibleMoves);
		
		// G�r mot venstre
		loopFunc(p -> p < x, x, y, color, subtract, nothing, possibleMoves);
		
		// G�r oppover
		loopFunc(p -> p <= (8-y), x, y, color, nothing, add, possibleMoves);
		
		// G�r nedover
		loopFunc(p -> p < y, x, y, color, nothing, subtract, possibleMoves);
		
		return possibleMoves;

	}
}
