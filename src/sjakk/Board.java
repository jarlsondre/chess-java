package sjakk;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Board implements Iterable<Tile> {

	private ArrayList<Tile> tileList = new ArrayList<Tile>();
	private Main main;

	public Board(Main main) {
		for (int y = 8; y > 0; y--) {
			for (int x = 1; x < 9; x++) {
				tileList.add(new Tile(x, y, this)); 
			}
		}
		this.main = main;
	}

	public Main getMain() {
		return main;
	}

	public ArrayList<Tile> getTileList() {
		ArrayList<Tile> newList = tileList;
		return newList;
	}

	public Piece getPiece(int x, int y) {
		try {
			return tileList.stream().filter(p -> (p.getHorPos() == x && p.getVerPos() == y)).collect(Collectors.toList()).get(0).getPiece();
		}
		catch (Exception e){
			return null;
		}
	}

	public Tile getTile(int x, int y) {
		try {
			return tileList.stream().filter(p -> (p.getHorPos() == x && p.getVerPos() == y)).collect(Collectors.toList()).get(0);
		}
		catch (Exception e){
			System.out.println("Hei det feilet :)-----------------------------------");
			return null;
		}
	}

	public void setPiece(int x, int y, Piece piece) {
		tileList.stream().filter(p -> (p.getHorPos() == x && p.getVerPos() == y)).forEach(p -> p.setPiece(piece));
	}

	// fyller opp brettet med brikker
	public void initializeBoard() {

		for (Tile tile : this) {
			char color = 'W';
			if (tile.getVerPos() == 7 || tile.getVerPos() == 8) {
				color = 'B';
			}
			if (tile.getVerPos() == 1 || tile.getVerPos() == 8) {
				if (tile.getHorPos() == 1 || tile.getHorPos() == 8) {
					tile.setPiece(new Rook(tile, color));
				}
				else if (tile.getHorPos() == 2 || tile.getHorPos() == 7) {
					tile.setPiece(new Knight(tile, color));
				}
				else if (tile.getHorPos() == 3 || tile.getHorPos() == 6) {
					tile.setPiece(new Bishop(tile, color));
				}
				else if (tile.getHorPos() == 4) {
					tile.setPiece(new Queen(tile, color));
				}
				else {
					tile.setPiece(new King(tile, color));
				}
			}
			else if (tile.getVerPos() == 2) {
				tile.setPiece(new Pawn(tile, color));
			}
			else if (tile.getVerPos() == 7) {
				tile.setPiece(new Pawn(tile, color));
			}
			else {
				tile.setPiece(null);
			}
		}
	}

	// funksjon for � kunne flytte en brikke
	public boolean movePiece(Piece piece, int newX, int newY, boolean test) {
		boolean rookMove = false; 
		boolean kingMove = false; 
		boolean enPassant = false; 
		boolean castled = false; 
		Move move = new Move(newX, newY);
		Piece prevPiece = getPiece(newX, newY);

		int orgX = piece.getCurrentTile().getHorPos();
		int orgY = piece.getCurrentTile().getVerPos();
		int prevPieceYCor = 0;

		if (piece.getMoves().contains(move)) {
			// vil sjekke om det er en bonde som skal flytte seg to fremover:
			if (piece.getType().equals("Pawn") && (piece.getCurrentTile().getVerPos() == 2 || piece.getCurrentTile().getVerPos() == 7)) {
				if (newY == piece.getCurrentTile().getVerPos() + 2 || newY == piece.getCurrentTile().getVerPos() - 2) {
					// Dette betyr at denne brikken pr�ver � flytte seg 2 frem for f�rste gang. 
					((Pawn) piece).setMadeDoubleForward(main.getMovesMade());
				}
			}

			// Hvis trekket er en passant s� er det en bonde som flytter seg p� skr� selv om det ikke st�r en brikke der. 
			if (piece.getType().equals("Pawn")) {
				if (newX != piece.getCurrentTile().getHorPos() && this.getPiece(newX, newY) == null) {

					// Hvis dette skjer s� m� trekket v�re en passant. I s� fall m� jeg fjerne brikken som st�r bak bonden v�r der den ender opp
					enPassant = true; 
					if (piece.getColor() == 'W') {
						prevPiece = this.getPiece(newX, newY-1);
						prevPieceYCor = newY - 1;
					}
					else {
						prevPiece = this.getPiece(newX, newY+1);
						prevPieceYCor = newY + 1;
					}
				}
			}
			// her vil jeg sjekke om brikken er en konge som skal gjennomf�re rokade: 
			else if (piece.getType().equals("King")) {
				
				// vil deretter sjekke om kongen skal flytte seg to ruter til h�yre eller venstre
				if (newX == orgX - 2) {
					
					// Vil flytte t�rnet som st�r helt til venstre til xpos 4
					Piece secondPiece = this.getPiece(1, orgY);
					secondPiece.getCurrentTile().setPiece(null);
					this.getTile(4, orgY).setPiece(secondPiece);
					castled = true; 
				}
				else if (newX == orgX + 2) {
					
					// Vil n� flytte t�rnet som st�r til h�yre til xpos 6
					Piece secondPiece = this.getPiece(8, orgY);
					secondPiece.getCurrentTile().setPiece(null);
					this.getTile(6, orgY).setPiece(secondPiece);
					castled = true; 
				}
			}
			
			// her skjer selve flyttingen
			piece.getCurrentTile().setPiece(null);
			if((piece.getType().equals("Pawn") && newY == 1) || (piece.getType().equals("Pawn") && newY == 8)) {
				Piece promoted = new Queen(this.getTile(newX,newY), piece.getColor());
				this.getTile(newX, newY).setPiece(promoted);
				piece = promoted;
			}
			else {
				this.getTile(newX, newY).setPiece(piece);
			}
			main.setLastMoveEnPassant(enPassant);
			main.setLastMoveCastled(castled);
			
			// Jeg m� sjekke om brikken som flyttes er en konge eller et t�rn:
			if (piece.getType().equals("Rook")) {
				
				// sjekke om den ikke har blitt flyttet f�r
				if (!((Rook) piece).getHasMoved()) {
					rookMove = true;
					kingMove = false; 
					((Rook) piece).setHasMoved(true);
				}
			}
			else if (piece.getType().equals("King")) {
				
				// sjekke om den ikke har blitt flytter f�r
				if (!((King) piece).getHasMoved()) {
					rookMove = false;
					kingMove = true;
					((King) piece).setHasMoved(true);
				}
			}

			// Her m� jeg sjekke om kongen har endt opp i sjakk. Hvis dette er tilfellet s� m� jeg flytte tilbake. 
			boolean returnValue = true; 
			
			if (kingCheck(piece.getColor())) {
				returnValue = false; 
			}
			
			if ((kingCheck(piece.getColor()) || test) && !enPassant) {
				piece.getCurrentTile().setPiece(prevPiece);
				this.getTile(orgX, orgY).setPiece(piece);
				if (rookMove) {
					((Rook) piece).setHasMoved(false);
				}
				else if (kingMove) {
					((King) piece).setHasMoved(false);
				}
			}
			else if ((kingCheck(piece.getColor()) || test) && enPassant) {
				this.getTile(piece.getCurrentTile().getHorPos(), prevPieceYCor).setPiece(prevPiece);
				this.getTile(piece.getCurrentTile().getHorPos(), piece.getCurrentTile().getVerPos()).setPiece(null);
				this.getTile(orgX, orgY).setPiece(piece);
				main.setLastMoveEnPassant(false);
				if (rookMove) {
					((Rook) piece).setHasMoved(false);
				}
				else if (kingMove) {
					((King) piece).setHasMoved(false);
				}

			}
			return returnValue; 

		}
		else {
			System.out.println("Illegal Move");
			return false; 
		}
	}

	// funksjon for � sjekke om en av kongene st�r i sjakk
	public boolean kingCheck(char color) {
		Move kingPos = findKing(color);
		for (Tile tile : this) {
			if (tile.getPiece() != null) {
				if (tile.getPiece().getColor() != color) {
					// m� samle opp alle trekkene som er mulige
					ArrayList<Move> tmp = tile.getPiece().getMoves();
					if (tmp.contains(kingPos)) {
						return true;
					}
				}
			}
		}
		return false; 
	}

	// funksjon for � sjekke om det er sjakkmatt
	public boolean checkMate() {
		if (kingCheck('W')) {
			return checkPossibleMoves('W');
		}
		else if (kingCheck('B')) {
			return checkPossibleMoves('B');
		}
		return false; 
	}

	// funksjon for � utf�re trekk og sjekke om kongen fortsatt st�r i sjakk
	private boolean checkPossibleMoves(char color) {
		BoardIterator boardIterator = new BoardIterator(this);
		while (boardIterator.hasNext()) {

			Tile tile = boardIterator.next();
			if (tile.getPiece() != null) {
				if (tile.getPiece().getColor() == color) {

					// m� g� gjennom hvert trekk: 
					PieceIterator pieceIterator = new PieceIterator(tile.getPiece());
					while (pieceIterator.hasNext()) {

						Move move = pieceIterator.next();

						if (this.movePiece(tile.getPiece(), move.getX(), move.getY(), true)) {
							return false; 
						}
					}
				}
			}
		}
		// ingen mulige trekk returner true
		return true; 
	}

	//funksjon for � finne kongen med en viss farge
	public Move findKing(char color) {
		List<Tile> kingList = new ArrayList<Tile>();
		kingList = tileList.stream().filter(p -> p.getPiece() != null).filter(p -> p.getPiece().getType().equals("King") && p.getPiece().getColor() == color).collect(Collectors.toList());
		Tile kingTile = kingList.get(0);
		return new Move(kingTile.getHorPos(), kingTile.getVerPos());

	}

	@Override
	public Iterator<Tile> iterator() {
		return new BoardIterator(this);
	}

	// Funksjon for � kunne printe ut brettet: 

	public void printBoard() {
		int i = 0;
		System.out.println("\n-----------B------------");
		for (Tile tile : this) {

			if (tile.getPiece() != null) {
				if (tile.getPiece().getType().equals("Knight")) {
					System.out.print(Character.toString(tile.getPiece().getColor()) + "N ");
				}
				else {
					System.out.print(Character.toString(tile.getPiece().getColor()) + tile.getPiece().toString().substring(0,1) + " ");
				}
			}
			else {
				System.out.print("n  ");
			}
			i++;
			if (i%8 == 0) {
				System.out.println("");
			}
		}
		System.out.println("-----------W------------ \n");
	}

	// Main metode for � pr�ve ut litt :)
	public static void main(String[] args) {

		System.out.println('B' == 'w');
		System.out.println('B' != 'w');

	}


}
