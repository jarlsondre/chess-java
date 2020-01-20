package uke4;


/*
 * Denne klassen ligger bare her for å gis til en kar som lurte på litt ting
 * etter forelesning. Jeg har forsøkt å beskrive litt mer om hva metodene
 * gjør, så andre også kan få noe ut av det.
 * -Børge 
 */
public class Bok {

	/**
	 * Vi har tre variable som lagrer tilstanden. Legg merke til at
	 * man ikke kan endre navn på boken eller antall sider etter at
	 * Boken er opprettet. Man kan derimot endre hvor langt man har kommet.
	 * Dette gjøres gjennom en set-metode (lest(int mengde)) som sjekker om
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
	 * Utløs unntak hvis en hevder å ha lest flere sider av boken
	 * enn det er igjen av boken. Oppdaterer ellers hvilken side
	 * en nå er på i boken.
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
	 * om endringen jeg tenker på å gjøre faktisk er lovlig eller ikke.
	 * Men den problemstillingen synes jeg er mer passende å vise i
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
//		b.lest(545654); // Bør utløse unntak
		System.out.println(b);
	}

	// Det er så kjipt med toString() fra Object-klassen, så la oss overskrive den med en egen variant.
	// Les dere opp på toString, dette er en fin beskrivelse: https://stackoverflow.com/review/late-answers/10049440
	@Override
	public String toString() {
		return "Bok [tittel=" + tittel + ", sider=" + sider + ", hvor=" + hvor + "]";
	}


	// Konstruktøren.
	public Bok(String tittel, int sider) {
		super();
		System.out.println("Her er jeg"); // dette skrives ut to ganger!
		this.tittel = tittel;
		this.sider = sider;
	}

	// Den tomme konstruktøren kaller rett og slett bare den andre med et sett standardverdier.
	// Teit med tanke på at det er bøker, men finn på noe bedre selv! ;)
	public Bok() {
		this("Java for dummies", 345);
	}
	
	
	
	
}
