package sjakk;

import java.util.ArrayList;

public class Knight extends Piece {
	
	private ArrayList<Move> possibleMoves = new ArrayList<Move>();
	
	public Knight(Tile tile, char color) {
		this.setCurrentTile(tile);
		this.setColor(color);
		this.setType("Knight");
	}
	
	@Override
	public ArrayList<Move> getMoves() {
		possibleMoves.clear();

		char color = getColor();
		int x = getCurrentTile().getHorPos();
		int y = getCurrentTile().getVerPos();
		
		// Her må jeg sjekke totalt 8 steder
		// 2 høyre 1 opp
		// 2 høyre 1 ned
		// 2 opp 1 høyre
		// 2 ned 1 høyre
		// 2 venstre 1 opp
		// 2 venstre 1 ned
		// 2 opp 1 venstre
		// 2 ned 1 venstre
		
		// vi skal 2 til høyre og 1 opp: 
		if (x < 7 && y < 8) {
			if (getCurrentTile().getBoard().getPiece(x+2, y+1) == null || getCurrentTile().getBoard().getPiece(x+2, y+1).getColor() != color) {
				possibleMoves.add(new Move(x+2, y+1));
			}
		}
		
		// Vi skal 2 til høyre og 1 ned:
		if (x < 7 && y > 1) {
			if (getCurrentTile().getBoard().getPiece(x+2, y-1) == null || getCurrentTile().getBoard().getPiece(x+2, y-1).getColor() != color) {
				possibleMoves.add(new Move(x+2, y-1));
			}
		}
		
		// Vi skal 2 opp og 1 til høyre: 
		if (x < 8 && y < 7) {
			if (getCurrentTile().getBoard().getPiece(x+1, y+2) == null || getCurrentTile().getBoard().getPiece(x+1, y+2).getColor() != color) {
				possibleMoves.add(new Move(x+1, y+2));
			}
		}
		
		// Vi skal 2 ned og 1 til høyre:
		if (x < 8 && y > 2) {
			if (getCurrentTile().getBoard().getPiece(x+1, y-2) == null || getCurrentTile().getBoard().getPiece(x+1, y-2).getColor() != color) {
				possibleMoves.add(new Move(x+1, y-2));
			}
		}
		
		// vi skal 2 til venstre og 1 opp: 
		if (x > 2 && y < 8) {
			if (getCurrentTile().getBoard().getPiece(x-2, y+1) == null || getCurrentTile().getBoard().getPiece(x-2, y+1).getColor() != color) {
				possibleMoves.add(new Move(x-2, y+1));
			}
		}
		
		// Vi skal 2 til venstre og 1 ned:
		if (x > 2 && y > 1) {
			if (getCurrentTile().getBoard().getPiece(x-2, y-1) == null || getCurrentTile().getBoard().getPiece(x-2, y-1).getColor() != color) {
				possibleMoves.add(new Move(x-2, y-1));
			}
		}
		
		// Vi skal 2 opp og 1 til venstre: 
		if (x > 1 && y < 7) {
			if (getCurrentTile().getBoard().getPiece(x-1, y+2) == null || getCurrentTile().getBoard().getPiece(x-1, y+2).getColor() != color) {
				possibleMoves.add(new Move(x-1, y+2));
			}
		}
		
		// Vi skal 2 ned og 1 til venstre:
		if (x > 1 && y > 2) {
			if (getCurrentTile().getBoard().getPiece(x-1, y-2) == null || getCurrentTile().getBoard().getPiece(x-1, y-2).getColor() != color) {
				possibleMoves.add(new Move(x-1, y-2));
			}
		}
		
		return possibleMoves;
	}

}
