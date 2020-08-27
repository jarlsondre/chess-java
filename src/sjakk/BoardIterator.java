package sjakk;

import java.util.Iterator;
import java.util.stream.Collectors;

public class BoardIterator implements Iterator<Tile> {

	int currentX = 1;
	int currentY = 8; 
	Board board;
	
	public BoardIterator(Board board) {
		super();
		this.board = board;
	}
	
	@Override
	public boolean hasNext() {
		return (currentX < 9 && currentY > 0); 
	}

	@Override
	public Tile next() {
		Tile thisTile;
		thisTile = board.getTileList().stream().filter(p -> (p.getHorPos() == currentX && p.getVerPos() == currentY))
				.collect(Collectors.toList()).get(0);
		if (currentX < 8) currentX++;
		else {
			currentX = 1;
			currentY--;
		}
		return thisTile;
	}
}
