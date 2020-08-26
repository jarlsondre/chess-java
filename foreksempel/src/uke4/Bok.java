package uke4;


/*
 * Denne klassen ligger bare her for � gis til en kar som lurte p� litt ting
 * etter forelesning. Jeg har fors�kt � beskrive litt mer om hva metodene
 * gj�r, s� andre ogs� kan f� noe ut av det.
 * -B�rge 
 */
public class Bok {

	/**
	 * Vi har tre variable som lagrer tilstanden. Legg merke til at
	 * man ikke kan endre navn p� boken eller antall sider etter at
	 * Boken er opprettet. Man kan derimot endre hvor langt man har kommet.
	 * Dette gj�res gjennom en set-metode (lest(int mengde)) som sjekker om
	 * kallet er lovlig eller ikke. 
	 */
	private String tittel;
	private int sider;
	private int hvor = 0;
	
	// Denne er enkel: returnere akkurat det som er tittelen. 
	public String getTittel() {
		return tittel;
	}

	// Hvor mange sider har en lest? 'hvor' vet det.
	public int getHvor() {
		return hvor;
	}

	
	/**
	 * Utl�s unntak hvis en hevder � ha lest flere sider av boken
	 * enn det er igjen av boken. Oppdaterer ellers hvilken side
	 * en n� er p� i boken.
	 * @param mengde er antall sider som er lest denne gangen.
	 */
	public void lest(int mengde) {
		if (hvor + mengde > sider)
			throw new IllegalArgumentException("Nope.");
		hvor += mengde;
	}
	
	/**
	 * En liten sak med denne koden. Koden over burde egentlig bli ytterligere
	 * forbedret. Jeg kunne ha laget en public boolean metode some returnerer
	 * om endringen jeg tenker p� � gj�re faktisk er lovlig eller ikke.
	 * Men den problemstillingen synes jeg er mer passende � vise i
	 * klassen PlateOrig (uke4), metoden staticCheckSign(String sign).
	 */
	
	// Denne gidder jeg ikke forklare.
	public int getSider() {
		return sider;
	}
	
	public static void main(String[] args) {
		Bok b = new Bok("Krig og fred", 4343);
		System.out.println(b);
		b.lest(45);
		b.lest(54);
		System.out.println(b);
		b.lest(54);
//		b.lest(545654); // B�r utl�se unntak
		System.out.println(b);
	}

	// Det er s� kjipt med toString() fra Object-klassen, s� la oss overskrive den med en egen variant.
	// Les dere opp p� toString, dette er en fin beskrivelse: https://stackoverflow.com/review/late-answers/10049440
	@Override
	public String toString() {
		return "Bok [tittel=" + tittel + ", sider=" + sider + ", hvor=" + hvor + "]";
	}


	// Konstrukt�ren. En vet alltid hva tittelen er, og hvor mange sider den har.
	public Bok(String tmptittel, int sider) {
		super();
		System.out.println("Her er jeg"); // dette skrives ut to ganger!
		tittel = tmptittel; // En m�te � separere objektets og Konstrukt�rens tittel
		this.sider = sider; // En annen m�te. Samme navn, men separerer med this for objektet
	}

	// Den tomme konstrukt�ren kaller rett og slett bare den andre med et sett standardverdier.
	// Teit med tanke p� at det er b�ker, men finn p� noe bedre selv! ;)
	// Den tomme konstrukt�ren her er kun til for � vise at man kan ha flere, og kalle en annen.
	public Bok() {
		this("Java for dummies", 345);
	}
	
	
	
	
}
