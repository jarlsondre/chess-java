package uke4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.regex.Pattern;

/**
 * Bilskilt kunne kanskje ha blitt lagret som en variabel i bilen,
 * men dette er mye finere. Får også frem validering av regnr.
 * Viser frem testing med if, men også JUnit. Det er penere.
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
	 * er den samme som står lenger ned i denne kommentaren. For å lage slike,
	 * skriv /** på linjen før en metode, og trykk linjeskift.
	 * Er registreringsnummeret reelt? 2 store bokstaver, 5 siffer.
	 * @param sign - registeringsnummeret som en prøver å lage et skilt av.
	 * @return true dersom regnr er reelt, false ellers.
	 */
	boolean checkSign(String sign) {
		//		boolean ok = true;
		if (sign.length() != 7) return false;
		String chars = sign.substring(0, 2);
		String nums = sign.substring(2);
		// Her bruker jeg regex - ikke akkurat pensum, men bare såååå effektivt.
		// https://en.wikipedia.org/wiki/Regular_expression
		if ((Pattern.matches("[A-Z][A-Z]", chars) == true) &&
				Pattern.matches("[0-9]+", nums) == true && nums.length() == 5) {
			return true;
		}
		return false;
	}

	// Vi kan gjøre om checkSign til en static, med andre ord en funksjon 
	static boolean staticCheckSign(String sign) {
		//		boolean ok = true;
		if (sign.length() != 7) return false;
		String chars = sign.substring(0, 2);
		String nums = sign.substring(2);
		// Her bruker jeg regex - ikke akkurat pensum, men bare såååå effektivt.
		// https://en.wikipedia.org/wiki/Regular_expression
		if ((Pattern.matches("[a-zA-Z]+", chars) == true && chars.length() == 2) &&
				Pattern.matches("[0-9]+", nums) == true && nums.length() == 5) {
			return true;
		}
		return false;
	}

	public PlateOrig(String sign) {
		if (this.checkSign(sign)) { // 2 store bokstaver, 5 siffer
			this.sign = sign;
		}
		else {
			// Her kan vi egentlig utløse et unntak, fordi en prøver å lage
			// et skilt som ikke kan finnes. Det kommer mer om unntak senere.
			throw new IllegalArgumentException(sign+" er ikke et lovlig registreringsnummer.");
		}
	}



	public static void main(String[] args) {
		PlateOrig p1 = new PlateOrig("AA38143");
		System.out.println(p1.getSign());
		if (!p1.getSign().equals("AA38543")) {
			System.out.println("Skulle vært AA38143, var "+p1.getSign());
		}			

		// Alternativ måte å teste - JUnit.
		assertEquals("AA38143", p1.getSign());
//		assertEquals("AA38543", p1.getSign()); // Se hva den sier når koden kjøres!
		
		// En kan sjekke om noe er sant eller ikke:
		assertFalse(PlateOrig.staticCheckSign("A56612"));

		// Hva hvis en forsøker å lage et skilt som ikke har riktig format? 
		//		Plate p2 = new Plate("AAB8143");
		//		System.out.println(p2.getSign());
	}
}
