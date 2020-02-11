package uke6.arv;

public class Tegneseriealbum extends Bok {

	String tegner;
	
	public Tegneseriealbum(String tittel, String forfatter, int sideantall, String tegner) {
		super(tittel, forfatter, sideantall);
		this.tegner = tegner;
	}

	public static void main(String[] args) {
		Tegneseriealbum t = new Tegneseriealbum("Donald", "Han derre", 36, "Arild Midtun");
		System.out.println(t);

	}

}
