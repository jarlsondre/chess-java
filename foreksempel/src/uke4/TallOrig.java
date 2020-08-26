package uke4;

/**
 * Dette er et eksempel p� at en kan benytte seg av andre m�ter � 
 * lagre verdier enn de en reelt henter ut med get-metoder.
 * Ogs� et eksempel p� at en an lage flere get, og la objektet regne
 * dem ut. Til slutt et eksempel p� hvordan en overskriver 
 * Object-klassen sin toString().
 * @author borgeha
 *
 */
public class TallOrig {

	private String tall;
	
	
	public TallOrig(int tall) {
		super();
		this.tall = Integer.toString(tall);
	}


	public int getTall() {
		return Integer.parseInt(tall);
	}
	

	public int getSquare() {
		int i = this.getTall();
		return i*i;
	}
	
	// Trenger vi noen sjekk p� om vi f�r inn lovlige tall? Nah,
	// metoden kalles kun med faktiske heltall. Da b�r konvertering
	// g� helt fint.
	public void setTall(int tall) {
		this.tall = Integer.toString(tall);
	}
	
	public static void main(String[] args) {
		TallOrig t = new TallOrig(12);
		System.out.println(t.getTall() + " i andre er "+ t.getSquare());
		t.setTall(13);
		System.out.println(t.getTall() + " i andre er "+ t.getSquare());
		
		// Kan vi gj�re noe for � slippe � skrive t.getTall()? Hva om vi
		// kunne la println(t) skrive ut verdien av tall? toString()!
		
	}

}
