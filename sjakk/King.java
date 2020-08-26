package sjakk;

import java.util.ArrayList;
import java.util.function.BinaryOperator;

public class King extends Piece {

	private ArrayList<Move> possibleMoves = new ArrayList<Move>();
	boolean hasMoved;

	public King(Tile tile, char color) {
		this.setCurrentTile(tile);
		this.setColor(color);
		this.setType("King");
	}

	public void setHasMoved(boolean b) {
		hasMoved = b;
	}

	public boolean getHasMoved() {
		return hasMoved;
	}

	@Override
	public ArrayList<Move> getMoves() {
		possibleMoves.clear();

		char color = getColor();
		int x = getCurrentTile().getHorPos();
		int y = getCurrentTile().getVerPos();


		// Går i sirkel rundt kongen (altså fra -1 til 1 begge veier) og sjekker alle brikkene:
		for (int i = -1; i < 2; i++) {
			for (int j = -1; j < 2; j++) {
				// kjører kun koden dersom vi ikke ser på hvor kongen står for øyeblikket
				if ((j != 0 || i != 0) && x + i > 0 && x + i < 9 && y + j > 0 && y + j < 9) {
					if (getCurrentTile().getBoard().getPiece(x + i, y + j) == null || getCurrentTile().getBoard().getPiece(x + i, y + j).getColor() != color) {
						possibleMoves.add(new Move(x+i, y+j));
					}
				}
			}
		}
		// ROKADE:

		// Må først sjekke om denne kongen har flyttet seg før: 
		if (!this.hasMoved) {
			int height = this.getCurrentTile().getVerPos();

			// må deretter se på tårnene
			Piece possibleRook1 = this.getCurrentTile().getBoard().getPiece(1, height);
			Piece possibleRook2 = this.getCurrentTile().getBoard().getPiece(8, height);
			castleFunc(possibleRook1, subtract, height);
			castleFunc(possibleRook2, add, height);
		}

		return possibleMoves;
	}


	public void castleFunc(Piece piece, BinaryOperator<Integer> binOp, int y)  {
		if (piece != null) {
			if (piece.getType().equals("Rook")) {
				if (!((Rook) piece).getHasMoved()) {

					int castleLength;
					if (binOp.apply(5, 5) == 0) {
						castleLength = 3;
					}
					else {
						castleLength = 2;
					}

					// må deretter sjekke om det står noen brikker mellom kongen
					boolean blocked = false;
					for (int i = 1; i < castleLength + 1; i++ ) {
						if (this.getCurrentTile().getBoard().getPiece(binOp.apply(5, i), y) != null) {
							blocked = true;
							break; 
						}
					}

					if (!blocked) {

						// hvis den ikke er blokkert så må jeg sjekke om noen av rutene står i slag
						// altså må jeg gå gjennom alle de motsatte brikkene og se om de 
						// kan flytte til en av de to stedene kongen går gjennom. I tillegg så
						// kan ikke kongen stå i sjakk

						boolean attacked = false; 
						// sjekker de aktuelle rutene
						for (int i = 0; i < castleLength; i++) {

							Move move = new Move(binOp.apply(this.getCurrentTile().getHorPos(), i), y);

							// sjekker alle mulige trekk til motsatt farge: 
							for (Tile tile : this.getCurrentTile().getBoard()) {
								if (tile.getPiece() != null) {
									if (tile.getPiece().getColor() != this.getColor()) {
										if (tile.getPiece().getType().equals("King")) {
											if (((King) tile.getPiece()).hasMoved) {
												if (tile.getPiece().getMoves().contains(move)) {
													attacked = true;
													break; 
												}
											}
										}
										else {
											if (tile.getPiece().getMoves().contains(move)) {
												attacked = true;
												break; 

											}
										}
									}
								}
							}
						}

						if (!attacked) {
							possibleMoves.add(new Move(binOp.apply(5, 2), y));
						}
					}
				}
			}
		}
	}



}
