package uke3;

import counter.Counter;

class Counter {

	int end;
	int counter = 1;
	
	// Konstruktøren. Vi måtte ha inn hva end skulle være. counter skulle
	// alltid starte på 1.
	public Counter(int i) {
		end = i;
	}
	
	private int getCounter() {
		return counter;
	}


	// En litt annerledes versjon enn den jeg skrev på forelesning,
	// litt mer forståelig. 
	boolean count() {
		if (counter == end)
			return true;
		else {
			counter++;
			return false;
		}
	}
	
	/**
	 * Her (mener jeg) at kravet som står beskrevet er:
	 * Hvis nåværende status pluss inc til sammen blir mindre enn
	 * eller likt som end, da legger vi til inc og returnerer true. 
	 */
	boolean count(int inc) {
		if (counter == end)
			return true;
		else {
			counter += inc;
			return false;
			// Ser dere hva som blir feil her? Du kan risikere å gå OVER end. 
			// Da vil counter fremdeles være ulik fra en, så koden vil
			// fortsette å snurre. Kan dere fikse feilen selv?
		}
	}
	/*
	 * For øvrig kan en se på kravene slik de er beskrevet i lysarkene og spørre
	 * om det er helt spesifikt beskrevet. Gitt tilstanden
	 * counter = 4, end = 5, og en kaller count(2). Det er nettopp usikkerheten
	 * i beskrivelsen som gjør at det blir litt vanskelig å lage ting uten at
	 * det også kan krasje.
	 */


	public static void main(String[] args) {

		Counter c = new Counter(3);
		System.out.println(c.getCounter());
		System.out.println(c.count(2));
		System.out.println(c.getCounter());
		System.out.println(c.count(2));
		
		// Her kan vi også lage en løkke som gås igjennom helt til vi er ferdige:
		Counter c2 = new Counter(8);
		while (c2.count() == false) {
			System.out.println(c2.count());
			System.out.println(c2.getCounter());
		}
		
		// Følgende kode går til evig tid. Kan dere finne ut hva som er galt, og fikse det?
			Counter c3 = new Counter(8);
//			while (c3.count() == false) {
//				System.out.println(c3.count(3));
//				System.out.println(c3.getCounter());
//			}
	}

}
