package uke5;

public class Plate {

	private String plate;


	public void setPlate(String plate) {
		// Sjekke!
		/*
		 * Hvis ikke korrekt:
		 * - Si ifra
		 * ellers:
		 * - legg inn 
		 */

		if (! (Character.isLetter(plate.charAt(0))  &&
				Character.isLetter(plate.charAt(1)) &&
				Character.isDigit(plate.charAt(2)) &&
				Character.isDigit(plate.charAt(3)) &&
				Character.isDigit(plate.charAt(4)) &&
				Character.isDigit(plate.charAt(5)) &&
				Character.isDigit(plate.charAt(6)) &&
				plate.length() == 7)) {
			// Feil!
			throw new IllegalArgumentException("Feil ved skilt: " + plate);
		}
		else {
			this.plate = plate;
		}
			
	}


	public Plate(String plate) {
		setPlate(plate);
	}

	public String getPlate() {
		return plate;
	}


	public static void main(String[] args) {

		Plate foo = new Plate("AX7354H");
		System.out.println(foo.getPlate());
		foo.setPlate("AB34G44");

	}

}
