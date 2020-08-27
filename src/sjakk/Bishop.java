package sjakk;

import java.util.ArrayList;

public class Bishop extends Piece {
	
	private ArrayList<Move> possibleMoves = new ArrayList<Move>();
	
	
	public Bishop(Tile tile, char color) {
		this.setCurrentTile(tile);
		this.setColor(color);
		this.setType("Bishop");
	}
	
	@Override
	public ArrayList<Move> getMoves() {
		possibleMoves.clear();
		
		char color = getColor();
		int x = getCurrentTile().getHorPos();
		int y = getCurrentTile().getVerPos();
		
		// M� ha fire for-l�kker for � se hvor den kan flytte seg:
	
		//Oppover mot h�yre
		loopFunc(p -> p <= Math.min(8-x, 8-y), x, y, color, add, add, possibleMoves);
		
		// Nedover mot h�yre
		loopFunc(p -> p <= Math.min(8-x, y-1), x, y, color, add, subtract, possibleMoves);
		
		// Nedover mot venstre
		loopFunc(p -> p <= Math.min(x-1, y-1), x, y, color, subtract, subtract, possibleMoves);
		
		// Oppover mot venstre
		loopFunc(p -> p <= Math.min(x-1, 8-y), x, y, color, subtract, add, possibleMoves);
		
		return possibleMoves;
	}

	public static void main(String args[]) {
		System.out.println("Hello");
	}
}
