package mineSweeper;

import java.io.IOException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import minegenkode.Fil;

public class MSController {

	// legge til spiller
	List<Person> players = new ArrayList<Person>();
	List<Person> leaderboardList = new ArrayList<Person>();
	Person currentPlayer;
	@FXML TextField player;
	@FXML Label existingPlayers;
	@FXML Label leaderboard;
	@FXML Label personalBest;
	@FXML Label personalBestTittel;
	@FXML Button velg;
	@FXML Button fortsett;
	@FXML AnchorPane playerPane;
	@FXML Button save;
	@FXML Button load;
	@FXML Button delete;

	// første meny
	@FXML Label velgStr;
	@FXML Button str5;
	@FXML Button str7;
	@FXML Button str10;
	@FXML AnchorPane strPane;

	// andre meny
	@FXML TextField antallBomber;
	@FXML Button startSpill; 
	@FXML Label antallBomberLabel;
	@FXML Label bombInfo;
	@FXML AnchorPane bombPane;

	// selve spillet
	@FXML VBox boardVerticalBox;
	@FXML Label sluttLabel;
	@FXML Label timer;
	@FXML Label playerName;
	@FXML Label bestTime;
	@FXML Button restart;
	@FXML AnchorPane gamePane;

	// objekter og verdier
	MSBoard board;
	int boardSize;
	int totalBombs; 
	int pressed = 0;

	// tidtaking
	long startTime;
	boolean started = false;
	boolean lost = false;
	boolean won = false;

	public void handleSave() throws Exception {
		FileHandlingImpl.saveToFile(players, "SaveFile.txt");
	}

	public void handleLoad() {
		try {
			players = FileHandlingImpl.loadFromFile("SaveFile.txt");
			currentPlayer = players.get(0);
			updatePlayer();
		}
		catch (Exception e) {
			System.out.println("Kunne ikke laste fra fil");
		}
	}

	public boolean personExists(String name) {
		for (Person a: players) {
			if (a.getName().toLowerCase().equals(name.toLowerCase())) {
				currentPlayer = a;
				return true;
			}
		}
		return false; 
	}

	public void handleDeletePlayer() {
		if (!player.getText().equals("")) {
			// sjekker om personen finnes fra før
			if (personExists(player.getText())) {
				players.remove(currentPlayer);
				if (players.size() > 0) {
					currentPlayer = players.get(0);
					updatePlayer();
				}
				else { 
					currentPlayer = null;
					existingPlayers.setText("");
					updateLeaderboards();
					personalBest.setText("");
					personalBestTittel.setText("");
					leaderboard.setText("");
					fortsett.setDisable(true);
					delete.setDisable(true);
				}
			}
		}
	}

	public void handlePlayer() {
		if (!player.getText().equals("")) {
			boolean existing = personExists(player.getText());

			if (!existing) {
				currentPlayer = new Person(player.getText());
				players.add(currentPlayer);
				System.out.println("Eksisterte ikke");
				System.out.println(player.getText());
				System.out.println(currentPlayer);
			}
			fortsett.setDisable(false);
			delete.setDisable(false);
			player.textProperty().addListener((obs, oldText, newText) -> {
				System.out.println(oldText);
			});
			System.out.println(currentPlayer.getName());
			updatePlayer();
		}
	}

	public void handleStart() {
		playerPane.setVisible(false);
		strPane.setVisible(true);
	}


	// Vil lage et brett med valgt størrelse. 
	// Enten 5x5, 7x7 eller 10x10
	public void handleSize(ActionEvent evt) throws IOException {
		Button b = (Button) evt.getTarget();
		boardSize = Integer.parseInt(b.getId().substring(3));
		strPane.setVisible(false);
		bombPane.setVisible(true);
		if (boardSize == 10) {
			bombInfo.setText("Lagring: 10 bomber");
		}
		else if (boardSize == 7) {
			bombInfo.setText("Lagring: 7 bomber");
		}
		else {
			bombInfo.setText("Lagring: 5 bomber");
		}

	}
	// Man skal kunne skrive inn antall bomber man vil ha
	public void handleBombAmount(ActionEvent evt) {
		String text = antallBomber.getText();
		try {
			int antall = Integer.parseInt(text);
			board = new MSBoard(boardSize);
			board.pickBombs(antall);
			bombPane.setVisible(false);
			totalBombs = antall;
			for (int y = 0; y < boardSize; y++) {
				List<Button> buttonList = new ArrayList<Button>();
				HBox h = new HBox();
				for (int x = 0; x < boardSize; x++) {
					Button ny = new Button();
					ny.setId(Integer.toString(x) + "," + Integer.toString(y));
					ny.setText("  ");
					ny.setOnMouseClicked(new EventHandler<MouseEvent>() {
						@Override
						public void handle(MouseEvent e) {
							Object source = e.getSource();
							if (source instanceof Button) {
								Button temp = (Button) source;
								if (e.getButton() == MouseButton.SECONDARY) {
									if (temp.getText().equals("F")) {
										temp.setText("  ");
									}
									else {
										temp.setText("F");
									}
								}
								else {
									handleTile(temp);
								}
							}
						}
					} );
					buttonList.add(ny);
				}
				h.getChildren().addAll(buttonList);
				boardVerticalBox.getChildren().add(h);
			}
			gamePane.setVisible(true);
			boardVerticalBox.setDisable(false);
			playerName.setText(currentPlayer.getName());
			if (boardSize == totalBombs) {
				if (currentPlayer.getAllTimeBest() > 0) {
					bestTime.setText(Integer.toString(currentPlayer.getAllTimeBest()) + " sek");
				}
				else {
					bestTime.setText("(Ingen data)");
				}
			}
			else {
				bestTime.setText("Ugyldig antall bomber");
			}
		}
		catch (Exception e) {
			antallBomberLabel.setText("Ugyldig antall bomber");
		}
	}

	// Hva skjer når man trykker på en tile?
	public void handleTile(Button b) {
		if (!started) {
			startTime = System.currentTimeMillis();
			started = true;
		}
		if (b.getText() != "F") {
			int x = Integer.parseInt(b.getId().substring(0, 1));
			int y = Integer.parseInt(b.getId().substring(2));
			int bombs = board.getBombAmount(x, y);
			board.listen2d.get(y).get(x).setOpen(true);
			b.setDisable(true);
			if (board.listen2d.get(y).get(x).getBomb()) {
				b.setStyle("-fx-background-color: black");
				sluttLabel.setText("Du tapte!");
				boardVerticalBox.setDisable(true);
				lost = true;
			}
			else {
				b.setText(Integer.toString(bombs));
				pressed++;
			}
			if (board.getBombAmount(x, y) == 0) {
				openZero(x, y);
			}
			if (pressed == boardSize*boardSize - totalBombs) {
				sluttLabel.setText("Du vant!");
				boardVerticalBox.setDisable(true);
				won = true;
			}
			if (won) {
				int timePassed = (int) ((System.currentTimeMillis() - startTime)/1000);
				timer.setText("Tid: "+Integer.toString(timePassed));
				if (boardSize == totalBombs) {
					currentPlayer.addTime(timePassed);
					bestTime.setText(Integer.toString(currentPlayer.getAllTimeBest()));
				}

			}
		}
	}

	// Åpner alle felt med 0
	public void openZero(int x, int y) {
		for (int a = -1; a < 2; a++) {
			for (int b = -1; b < 2; b++) {
				if (a != 0 || b != 0) {
					Button nb = (Button) boardVerticalBox.lookup("#"+Integer.toString(x+a)+","+Integer.toString(y+b));
					if (nb != null) {
						if (!board.listen2d.get(y+b).get(x+a).getOpen() && nb.getText() != "F") {
							nb.setText(Integer.toString(board.getBombAmount(x+a, y+b)));
							nb.setDisable(true);
							pressed++;
							board.listen2d.get(y+b).get(x+a).setOpen(true);
							if (board.getBombAmount(x+a, y+b) == 0) {
								openZero(x+a,y+b);
							} 
						}
					}
				}

			}
		}

	}

	public void updatePlayer() {
		int leaderBoardIndex = 0;
		existingPlayers.setText("");
		System.out.println(players);
		for (Person a: players) {
			existingPlayers.setText(existingPlayers.getText() + a.getName() + " (" + a.getAllTimeBest() + ")" + "\n");
			System.out.println(a.getName());
		}
		personalBestTittel.setText(currentPlayer.getName() + " sine beste tider: ");
		personalBest.setText("");
		if (currentPlayer.getTopTen().size() < 1) {
			personalBest.setText("Ingen seiere enda");
		}
		else {
			for (int i = 0; i < currentPlayer.getTopTen().size(); i++) {
				personalBest.setText(personalBest.getText() + Integer.toString(i+1) + ". " + currentPlayer.getTopTen().get(i) + " sek");
			}
		}
		updateLeaderboards();
		leaderboard.setText("");
		for (Person p: leaderboardList) {
			if (leaderBoardIndex < 20) {
				leaderboard.setText(leaderboard.getText() + p.getName() + ": " + p.getAllTimeBest() + " sek \n");
				leaderBoardIndex++;
			}
		}
	}

	public void updateLeaderboards() {
		leaderboardList.clear();
		for (Person a: players) {
			leaderboardList.add(a);
		}
		Collections.sort(leaderboardList);
	}

	public void handleRestart() {
		boardVerticalBox.getChildren().clear();
		gamePane.setVisible(false);
		playerPane.setVisible(true);
		sluttLabel.setText("");
		timer.setText("");
		updatePlayer();

		started = false;
		won = false;
		lost = false;
		pressed = 0;


	}

}
