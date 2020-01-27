package uke5.car;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.regex.Pattern;

public class Plate {

	private String sign;


	/**
	 * Den bruker regex, som er på utsiden av
	 * pensum, jeg har lagt ved en SVÆRT enkel metode som gjør det
	 * annerledes like under.
	 * @param sign regnr vi ønsker å sjekke
	 * @return Statisk metode som returnerer om en streng passer med norske
	 * registreringsnummer
	 */
	private static boolean checkSign(String sign) {
		return Pattern.matches("[A-Z]{2}[0-9]{5}", sign);
	}

	// Samme metode som over, men uten regex. Synes den over er litt mer ok...
	private static boolean checkSignNonRegex(String plate) {
		if (Character.isLetter(plate.charAt(0))  &&
				Character.isLetter(plate.charAt(1)) &&
				Character.isDigit(plate.charAt(2)) &&
				Character.isDigit(plate.charAt(3)) &&
				Character.isDigit(plate.charAt(4)) &&
				Character.isDigit(plate.charAt(5)) &&
				Character.isDigit(plate.charAt(6)) &&
				plate.length() == 7) {
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @param sign regnr som et skilt MÅ lages med.
	 */
	public Plate(String sign) {
		super();
		if (Plate.checkSign(sign)) {
			this.sign = sign;
		}
		else {
			throw new IllegalArgumentException(sign + " er ikke et gyldig regnr.");
		}
	}



	public String getSign() {
		return sign;
	}




	public static void main(String[] args) {
		Plate p = new Plate("AA41381");
		if (!p.getSign().equals("AA41383")) {
			System.out.println("Skulle vært AA41383, var" + p.getSign());
		}
		assertEquals("AA41382", p.getSign());
		assertFalse(Plate.checkSign("23"));
		assertFalse(Plate.checkSign("HG7865354"));	
		assertTrue(Plate.checkSignNonRegex("HG78653"));
		assertFalse(Plate.checkSignNonRegex("HG7865354"));	
	}

	@Override
	public String toString() {
		return this.getSign();
	}

}
