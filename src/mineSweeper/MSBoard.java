package mineSweeper;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class MSBoard {
	int boardSize;

	// Lager en 2D-liste som skal inneholde alle tiles
	ArrayList<List<MSTile>> listen2d = new ArrayList<List<MSTile>>();

	// Konstruktør hvor man kan bestemme størrelsen på brettet
	public MSBoard(int boardSize) {
		this.boardSize = boardSize;
		for (int y = 0; y < boardSize; y++) {
			List<MSTile> liste1d = new ArrayList<MSTile>();
			for (int x = 0; x < boardSize; x++) {
				liste1d.add(new MSTile(x+1, y+1));
			}
			listen2d.add(liste1d);
		}
	}

	// Lage en liste med tilfeldige tall av lengde n
	public List<Integer> randList(int listSize, int randBound) {
		Random random = new Random();
		int num;
		List<Integer> theList = new ArrayList<Integer>();
		while (theList.size() < listSize) {
			num = random.nextInt(randBound);
			theList.add(num);
		}
		return theList;
	}


	// Velge bomber
	public void pickBombs(int n) {
		if (n < boardSize*boardSize && n > 0) {
			List<Integer> liste1 = randList(n, listen2d.size());
			List<Integer> liste2 = randList(n, listen2d.size());
			for (int i = 0; i < n; i++) {
				listen2d.get(liste1.get(i)).get(liste2.get(i)).setBomb(true);
			}
		}
		else throw new IllegalArgumentException("Illegal number of bombs");
	}

	// Sjekke antall bomber i nærheten
	public int getBombAmount(int x, int y) {
		int bomber = 0;
		if (x != boardSize-1) {
			if (listen2d.get(y).get(x+1).getBomb()) {
				bomber++;
			}
		}
		if (x != boardSize-1 && y != boardSize-1) {
			if (listen2d.get(y+1).get(x+1).getBomb()) {
				bomber++;
			}
		}
		if (y != boardSize-1) {
			if (listen2d.get(y+1).get(x).getBomb()) {
				bomber++;
			}
		}
		if (y != boardSize-1 && x != 0) {
			if (listen2d.get(y+1).get(x-1).getBomb()) {
				bomber++;
			}
		}
		if (x != 0) {
			if (listen2d.get(y).get(x-1).getBomb()) {
				bomber++;
			}
		}
		if (x != 0 && y != 0) {
			if (listen2d.get(y-1).get(x-1).getBomb()) {
				bomber++;
			}
		}
		if (y != 0) {
			if (listen2d.get(y-1).get(x).getBomb()) {
				bomber++;
			}
		}
		if (y != 0 && x != boardSize-1) {
			if (listen2d.get(y-1).get(x+1).getBomb()) {
				bomber++;
			}
		}
		return bomber;
	}

}
