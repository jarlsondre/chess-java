package sjakk;

import java.util.ArrayList;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class SjakkController {


	@FXML Pane pane;
	@FXML Label checkLabel;
	@FXML Label turnLabel;


	Main main = new Main();
	Board board = main.getBoard();


	double orgPosX;
	double orgPosY;
	double orgTranslateX;
	double orgTranslateY;
	double prevPosX;
	double prevPosY;
	double translateX;
	double translateY;

	Tile currentTile;
	ArrayList<Move> possibleMoves = new ArrayList<Move>();


	EventHandler<MouseEvent> pressedOnPiece = new EventHandler<MouseEvent>() {

		@Override
		public void handle(MouseEvent arg0) {
			orgPosX = arg0.getSceneX();
			orgPosY = arg0.getSceneY();
			orgTranslateX = ((ImageView)(arg0.getSource())).getTranslateX();
			orgTranslateY = ((ImageView)(arg0.getSource())).getTranslateY();

			prevPosX = ((ImageView)(arg0.getSource())).getTranslateX();
			prevPosY = ((ImageView)(arg0.getSource())).getTranslateY();

			// her vil jeg sjekke hvor brikken står, deretter finne ut hvilken brikke det er snakk om
			// deretter vil jeg finne ut hvilke trekk denne brikken har og så sørge for at brikken
			// kun kan flytte dit

			// For å gjøre om til x og y koordinater vil jeg bare reversere det jeg har gjort tidligere:
			int x = (int) (orgTranslateX / 50 + 1);
			int y = (int) (orgTranslateY / 50)*(-1) + 8;
			currentTile = board.getTile(x, y);
			
			board.printBoard();

			// Vil deretter finne ut hvilke mulige trekk brikken har: 
			possibleMoves = currentTile.getPiece().getMoves();

			System.out.println("Current Piece: " + currentTile.getPiece().toString());
			System.out.println("Current Tile: " + currentTile.toString());
			System.out.println("Possible moves: " + possibleMoves.toString());
		}
	};

	EventHandler<MouseEvent> draggedPiece = new EventHandler<MouseEvent>() {

		@Override
		public void handle(MouseEvent arg0) {
			double offsetX = arg0.getSceneX() - orgPosX;
			double offsetY = arg0.getSceneY() - orgPosY;
			double newTranslateX = orgTranslateX + offsetX;
			double newTranslateY = orgTranslateY + offsetY;

			((ImageView)arg0.getSource()).setTranslateX(newTranslateX);
			((ImageView)arg0.getSource()).setTranslateY(newTranslateY);
		}
	};

	EventHandler<MouseEvent> releasedPiece = new EventHandler<MouseEvent>() {

		@Override
		public void handle(MouseEvent arg0) {
			orgTranslateX  = ((ImageView)(arg0.getSource())).getTranslateX();
			orgTranslateY  = ((ImageView)(arg0.getSource())).getTranslateY();

			double newTransX = Rounder.round50(orgTranslateX);
			double newTransY = Rounder.round50(orgTranslateY);

			if (newTransX > 350) newTransX = 350;
			if (newTransX < 0) newTransX = 0;
			if (newTransY > 350) newTransY = 350;
			if (newTransY < 0) newTransY = 0;

			boolean validMove = false;

			// Vil sjekke om det er riktig person sin tur. Dette skal skje i main-klassen, funksjonskall skal skje her. 
			if (main.correctColor(currentTile)) {

				// Vil sørge for at hvis det ikke er et mulig trekk så flyttes brikken tilbake til utgangsposisjon:
				for (Move move : possibleMoves) {
					if ((move.getX()-1)*50 == newTransX && (8 - move.getY())*50 == newTransY) {
						validMove = true;
						break;
					}
				}
			}

			char currentColor = currentTile.getPiece().getColor();

			if (validMove && main.makeMove(currentTile.getPiece(), (int) newTransX/50 + 1, (int) (newTransY/50)*(-1) + 8)) {

				// Vil sjekke om det står en brikke her. Hvis det står en brikke her så vil jeg slette ImageView-en som 
				// står her. Evt. hvis en passant var det siste trekket så vil jeg fjerne den tatte brikken
				Node conflictingPiece = null;
				double conflictX;
				double conflictY;
				if (main.getLastMoveEnPassant()) {
					conflictX = newTransX;
					if (currentColor == 'W') {
						conflictY = newTransY + 50;
					}
					else {
						conflictY = newTransY - 50;
					}
				}
				else {
					conflictX = newTransX;
					conflictY = newTransY;
				}
				for (Node imgs : pane.getChildren()) {
					if (imgs.getTranslateX() == conflictX && imgs.getTranslateY() == conflictY) {
						conflictingPiece = imgs;
					}
				}
				if (conflictingPiece != null) {
					pane.getChildren().remove(conflictingPiece);
				}
				
				// Vil sjekke om rokade blir gjort: 
				
				if (main.getLastMoveCastled()) {
					Node theRook = null;
					
					// må finne ut hvilken rokade som ble gjort: 
					if ((int) newTransX/50 + 1 == 3) {
						// Her må jeg finne noden som styrer tårnet:
						for (Node node : pane.getChildren()) {
							if (node.getTranslateX() == 0 && node.getTranslateY() == newTransY) {
								theRook = node; 
								break;
							}
						}
						theRook.setTranslateX(150);
					}
					else {
						// Her må jeg finne noden som styrer tårnet:
						for (Node node : pane.getChildren()) {
							if (node.getTranslateX() == 350 && node.getTranslateY() == newTransY) {
								theRook = node; 
								break;
							}
						}
						theRook.setTranslateX(250);
					}
					
				}

				((ImageView)arg0.getSource()).setTranslateX(Rounder.round50(newTransX));
				((ImageView)arg0.getSource()).setTranslateY(Rounder.round50(newTransY));

				
				// sjekker hvem sin tur det er
				if (main.getMovesMade() % 2 == 0) {
					turnLabel.setText("Hvit sin tur");
				}
				else {
					turnLabel.setText("Sort sin tur");
				}
				
				// sjekker om sjakk eller sjakkmatt gjelder: 
				if (main.getCheck()) {
					checkLabel.setText("Sjakk!");
					if (main.getCheckMate()) {
						checkLabel.setText("Sjakk Matt!");
						if (turnLabel.getText().equals("Hvit sin tur")) {
							turnLabel.setText("Sort vant");
						}
						else {
							turnLabel.setText("Hvit vant");
						}
						
					}
				}
				else {
					checkLabel.setText("");
				}
				
				

			}
			else {
				((ImageView)arg0.getSource()).setTranslateX(Rounder.round50(prevPosX));
				((ImageView)arg0.getSource()).setTranslateY(Rounder.round50(prevPosY));
			}
		}
	};

	public void handleStart() {
		// fjerner gammelt brett
		pane.getChildren().clear();
		main = new Main();

		// Lager et nytt brett
		board = new Board(main);
		main.setBoard(board);
		board.initializeBoard();
		
		//Oppdatere tekst:
		checkLabel.setText("");

		// Vil deretter gå gjennom brettet og for hver tile som har en brikke på seg så vil jeg lage et imageview som 
		// plasseres riktig og får riktige handlers, i tillegg til å få riktig bilde. 

		for (Tile tile : board) {
			//			Vil først velge riktig bilde
			String img = "white";
			if (tile.getPiece() != null) {
				if (tile.getPiece().getColor() == 'B') {
					img = "black";
				}
				img += "_" + tile.getPiece().getType().toLowerCase() + ".gif";
				Image image = new Image(img);

				//				Vil deretter velge posisjon på bildet.
				int x = tile.getHorPos();
				int y = tile.getVerPos();

				//				Vil lage en ny imageview
				ImageView imgView = new ImageView();
				imgView.setTranslateX((x-1)*50);
				imgView.setTranslateY((8-y)*50);
				imgView.setImage(image);
				imgView.addEventHandler(MouseEvent.MOUSE_PRESSED, pressedOnPiece);
				imgView.addEventHandler(MouseEvent.MOUSE_DRAGGED, draggedPiece);
				imgView.addEventHandler(MouseEvent.MOUSE_RELEASED, releasedPiece);
				pane.getChildren().add(imgView);
			}
		}
	}
}
