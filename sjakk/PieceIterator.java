package sjakk;

import java.util.Iterator;

public class PieceIterator implements Iterator<Move> {
	
	Piece piece;
	int pos; 
	
	
	public PieceIterator(Piece piece) {
		super();
		this.piece = piece;
	}

	@Override
	public boolean hasNext() {
		return (pos < piece.getMoves().size());
	}

	@Override
	public Move next() {
		Move currentMove = piece.getMoves().get(pos);
		pos++;
		return currentMove;
	}

}
