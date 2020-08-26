package uke12.exceptions;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * M�let her er � lage en klasse som kan oversette norske tall i tekstform
 * 'femtini' til dets faktiske heltall.
 * Vi m� dermed sjekke strengen for en dr�ss med verdier. 
 * Tallene kan v�re enten p� 'entallsform' ('ni'), p� 'titallsform' ('femti')
 * eller begge deler ('femtini'). 
 * @author borgeha
 *
 */
public class Tall {

	private int value, tenvalue, onevalue;

	List<String> validTens = new ArrayList<>(Arrays.asList("tjue","tretti","f�rti","femti","seksti","sytti","�tti","nitti","hundre"));
	List<String> validOnes = new ArrayList<>(Arrays.asList("null","en","to","tre","fire","fem","seks","sju","�tte","ni"));
	List<String> validSpecial = new ArrayList<>(Arrays.asList("ti","elleve","tolv","tretten","fjorten","femten","seksten","sytten","atten","nitten"));


	public int getValue() {
		return value;
	}

	private void parseInput(String streng) {

		// Sjekker for tall mellom 11 og 19 f�rst
		if (validSpecial.contains(streng)) {
			value = validSpecial.indexOf(streng) + 10;
			return;
		}

		// Sjekker for tall under 10, dvs 0 - 9
		if (validOnes.contains(streng)) {
			value = validOnes.indexOf(streng);
			return; // trenger ikke sjekke mer hvis strengen bare er '�tte'.
		}

		// Sjekker for hele tiere
		if (validTens.contains(streng)) {
			// Grunnen til +2*)10: tjue har index 0, men verdien skal bli 20...
			value = (validTens.indexOf(streng)+2)*10;
			return; // Trenger ikke sjekke mer hvis strengen bare er 'femti'.
		}

		// S� kommer det vanskelige: sjekke substrenger med tiere og enere (og feil)
		// Det vi vet: strengen M� inneholde en valid ener og en valid tier.
		// Vi m� ogs� sjekke for om strengen inneholder noe mer enn bare det...

		parseTensAndOnes(streng);
	}


	private void parseTensAndOnes(String streng) {
		// Sjekke f�rst for tiere
//		System.out.println("Sjekker "+streng);
		for (int i = 0; i < validTens.size(); i++) {
			if (streng.contains(validTens.get(i)))  {// har tieren
//				System.out.println("Funnet tier: "+(i*10+20));
				tenvalue = i*10+20;

				// S� m� vi fjerne substring av tiere fra hele strengen, 
				// hvis ikke utl�ses femtito av sjekk p� fem.
				streng = streng.replace(validTens.get(i), "");
				break;
			}
		}

		// s� sjekker vi enerne, de m� passe perfekt
		for (int i = 0; i < validOnes.size(); i++) {
			if (streng.equals(validOnes.get(i)))  {// har eneren
//				System.out.println("Funnet ener: "+i);
				onevalue = i;
				break;
			}
		}

		if (onevalue == 0 && tenvalue == 0)
			throw new NorskeTallException("Feil med tiere og enere: "+streng);
		else if (onevalue == 0)
			throw new NorskeTallException("Feil med enere: "+streng);
		else if (tenvalue == 0)
			throw new NorskeTallException("Feil med tiere: "+streng);

		// Oppdatere der det er funnet b�de tiere og ener:
		value = tenvalue+onevalue;
	}



	public void sjekkTall(String streng) {
		this.parseInput(streng);
	}


	/*
	 * Parsing av streng til tallverdi skjer i konstrukt�ren.
	 */
	public Tall(String streng) {
		parseInput(streng);
	}

	public static void main(String[] args) {
//		assertEquals(17, new Tall("s�tten").getValue());
		assertEquals(8, new Tall("�tte").getValue());
		assertEquals(20, new Tall("tjue").getValue());
		assertEquals(97, new Tall("nittisju").getValue());
		assertEquals(23, new Tall("tjuetre").getValue());
		try {
			assertEquals(44, new Tall("fj�rtifire").getValue());			
		} catch (NorskeTallException e) {
			System.out.println(e);
		}

		try {
			assertEquals(55, new Tall("f�rtisytten").getValue());			
		} catch (NorskeTallException e) {
			System.out.println(e);
		}
		
		try {
			assertEquals(44, new Tall("fj�rtifjire").getValue());			
		} catch (NorskeTallException e) {
			System.out.println(e);
		}

	}

}
