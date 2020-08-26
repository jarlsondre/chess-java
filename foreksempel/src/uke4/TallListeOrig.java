package uke4;

import java.util.ArrayList;
import java.util.List;

/**
 * Kunne ikke finne noe mer merkelig eksempel p� at intern lagring
 * kan v�re annerledes enn utseendet p� klassen, enn ved � lagre
 * heltall som lister av chars (tallet 13 blir chars '1' og '3' i liste).
 * @author borgeha
 *
 */
public class TallListeOrig {

	private List<Character> liste; // H�! Ok, det kan gj�res.


	// En kan gjerne passe p� � bare gj�re operasjoner en plass,
	// og s� heller kalle dem de andre stedene de brukes.
	public TallListeOrig(int tall) {
		super();
		this.setTall(tall); // Som her.
	}

	public void setTall(int tall) {
		this.liste = convertToList(tall);
	}
	
	
	/**
	 * Tar inn et heltall, returnerer en liste med chars som er like.
	 * Eksempel: inn 13 gir ut [1,3]
	 * @param tall
	 * @return
	 */
	private List<Character> convertToList(int tall) {
		List<Character> l = new ArrayList<>();
		String tmp = Integer.toString(tall);
		for (int i = 0; i < tmp.length(); i++) {
			char c = tmp.charAt(i);
			l.add(c);
		}
		return l;
	}

	/**
	 * 
	 * @return heltallet i objektet. Lurt frem fra listen med chars.
	 */
	public int getTall() {	
		String tmp = "";
		for (Character character : liste) {
			tmp += character;
		}
		return Integer.parseInt(tmp); 
	}

	public int getSquare() {
		return this.getTall()*this.getTall();
	}


	/**
	 * Her �nsker vi � rett og slett bare returnere strengen av heltallet.
	 * Vi vil alts� omg� den grusomme m�ten vi lagrer det internt som liste.
	 */
	@Override
	public String toString() {
		return Integer.toString(getTall());
	}

	
	public static void main(String[] args) {
		TallListeOrig t = new TallListeOrig(12);
		System.out.println(t + " i andre er "+ t.getSquare());
		t.setTall(1365);
		System.out.println(t + " i andre er "+ t.getSquare());
		System.out.println(t.liste);


	}
}
