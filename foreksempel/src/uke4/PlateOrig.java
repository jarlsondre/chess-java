package uke4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.regex.Pattern;

/**
 * Bilskilt kunne kanskje ha blitt lagret som en variabel i bilen,
 * men dette er mye finere. F�r ogs� frem validering av regnr.
 * Viser frem testing med if, men ogs� JUnit. Det er penere.
 * @author borgeha
 *
 */
public class PlateOrig {

	private String sign;

	@Override
	public String toString() {
		return "Plate [sign=" + sign + "]";
	}


	public String getSign() {
		return sign;
	}


	/**
	 * Hold musen over metodenavnet checkSign. Se at hjelpen som popper opp
	 * er den samme som st�r lenger ned i denne kommentaren. For � lage slike,
	 * skriv /** p� linjen f�r en metode, og trykk linjeskift.
	 * Er registreringsnummeret reelt? 2 store bokstaver, 5 siffer.
	 * @param sign - registeringsnummeret som en pr�ver � lage et skilt av.
	 * @return true dersom regnr er reelt, false ellers.
	 */
	boolean checkSign(String sign) {
		// Her bruker jeg regex - ikke akkurat pensum, men bare s���� effektivt.
		// https://en.wikipedia.org/wiki/Regular_expression
		if (Pattern.matches("[A-Z]{2}[0-9]{5}", sign))
			return true;
		return false;
	}

	// Vi kan gj�re om checkSign til en static, med andre ord en funksjon 
	static boolean staticCheckSign(String sign) {
		// Her bruker jeg regex - ikke akkurat pensum, men bare s���� effektivt.
		// https://en.wikipedia.org/wiki/Regular_expression
		if (Pattern.matches("[A-Z]{2}[0-9]{5}", sign))
			return true;
		return false;
	}

	public PlateOrig(String sign) {
		if (this.checkSign(sign)) { // 2 store bokstaver, 5 siffer
			this.sign = sign;
		}
		else {
			// Her kan vi egentlig utl�se et unntak, fordi en pr�ver � lage
			// et skilt som ikke kan finnes. Det kommer mer om unntak senere.
			throw new IllegalArgumentException(sign+" er ikke et lovlig registreringsnummer.");
		}
	}



	public static void main(String[] args) {
		PlateOrig p1 = new PlateOrig("AA38143");
		System.out.println(p1.getSign());
		if (!p1.getSign().equals("AA38543")) {
			System.out.println("Skulle v�rt AA38143, var "+p1.getSign());
		}			

		// Alternativ m�te � teste - JUnit.
		assertEquals("AA38143", p1.getSign());
//		assertEquals("AA38543", p1.getSign()); // Se hva den sier n�r koden kj�res!
		
		// En kan sjekke om noe er sant eller ikke, med kall p� statisk metode:
		assertFalse(PlateOrig.staticCheckSign("A56612"));
		assertTrue(PlateOrig.staticCheckSign("XX10002"));

		// Hva hvis en fors�ker � lage et skilt som ikke har riktig format? 
		//		Plate p2 = new Plate("AAB8143");
		//		System.out.println(p2.getSign());
	}
}
