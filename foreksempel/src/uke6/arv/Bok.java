package uke6.arv;

public class Bok {

	String tittel;
	String forfatter;
	int sideantall;

	public Bok(String tittel, String forfatter, int sideantall) {
		super();
		this.tittel = tittel;
		this.forfatter = forfatter;
		this.sideantall = sideantall;
	}

	
	
	public String getTittel() {
		return tittel;
	}



	public String getForfatter() {
		return forfatter;
	}



	public int getSideantall() {
		return sideantall;
	}



	public static void main(String[] args) {
		Bok bok = new Bok("Das Kapital","Karl Marx",500);
		System.out.println(bok);
	}

	@Override
	public String toString() {
		return "Bok [tittel=" + tittel + ", forfatter=" + forfatter + ", sideantall=" + sideantall + "]";
	}

}
