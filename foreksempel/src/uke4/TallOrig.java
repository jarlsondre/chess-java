package uke4;

/**
 * Dette er et eksempel på at en kan benytte seg av andre måter å 
 * lagre verdier enn de en reelt henter ut med get-metoder.
 * Også et eksempel på at en an lage flere get, og la objektet regne
 * dem ut. Til slutt et eksempel på hvordan en overskriver 
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
	
	// Trenger vi noen sjekk på om vi får inn lovlige tall? Nah,
	// metoden kalles kun med faktiske heltall. Da bør konvertering
	// gå helt fint.
	public void setTall(int tall) {
		this.tall = Integer.toString(tall);
	}
	
	public static void main(String[] args) {
		TallOrig t = new TallOrig(12);
		System.out.println(t.getTall() + " i andre er "+ t.getSquare());
		t.setTall(13);
		System.out.println(t.getTall() + " i andre er "+ t.getSquare());
		
		// Kan vi gjøre noe for å slippe å skrive t.getTall()? Hva om vi
		// kunne la println(t) skrive ut verdien av tall? toString()!
		
	}

}
