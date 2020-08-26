package uke6.arv;

public class Barnebok extends Bok {

	int maksalder;
	
	public Barnebok(String tittel, String forfatter, int sideantall, int maksalder) {
		super(tittel, forfatter, sideantall);
		this.maksalder = maksalder;
	}

	

	// Legg merke til at vi kan kalle super sin toString() for å skrive ut de variablene som
	// Barnebok har arvet fra Bok! Super kjenner ikke til maksalder.
	@Override
	public String toString() {
		return "Barnebok [maksalder=" + maksalder + ", toString()=" + super.toString() + "]";
	}


	public static void main(String[] args) {
		Barnebok bb = new Barnebok("Ruffen", "Bringsværd", 44, 100);
		System.out.println(bb);
		
	}

}
