package sjakk;

import java.util.ArrayList;

public class Queen extends Piece {

	private ArrayList<Move> possibleMoves = new ArrayList<Move>();
	
	public Queen(Tile tile, char color) {
		this.setCurrentTile(tile);
		this.setColor(color);
		this.setType("Queen");
	}

	@Override
	public ArrayList<Move> getMoves() {
		possibleMoves.clear();

		// Må ha åtte løkker, alle løkkene som tårnet har og alle løkkene som løperne har

		char color = getColor();
		int x = getCurrentTile().getHorPos();
		int y = getCurrentTile().getVerPos();
		
		// Går mot høyre
		loopFunc(p -> p <= (8-x), x, y, color, add, nothing, possibleMoves);
		
		// Går mot venstre
		loopFunc(p -> p < x, x, y, color, subtract, nothing, possibleMoves);
		
		// Går oppover
		loopFunc(p -> p <= (8-y), x, y, color, nothing, add, possibleMoves);
		
		// Går nedover
		loopFunc(p -> p < y, x, y, color, nothing, subtract, possibleMoves);
		
		//Oppover mot høyre
		loopFunc(p -> p <= Math.min(8-x, 8-y), x, y, color, add, add, possibleMoves);
		
		// Nedover mot høyre
		loopFunc(p -> p <= Math.min(8-x, y-1), x, y, color, add, subtract, possibleMoves);
		
		// Nedover mot venstre
		loopFunc(p -> p <= Math.min(x-1, y-1), x, y, color, subtract, subtract, possibleMoves);
		
		// Oppover mot venstre
		loopFunc(p -> p <= Math.min(x-1, 8-y), x, y, color, subtract, add, possibleMoves);
		
		return possibleMoves;

	}
}
