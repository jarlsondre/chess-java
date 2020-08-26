package uke6.kino_full;

public class Film {
	public int alder;
	public String filmtittel;
	public String nasjonalitet;
	
	@Override
	public String toString() {
		return "Film [alder=" + alder + ", filmtittel=" + filmtittel + ", nasjonalitet=" + nasjonalitet + "]";
	}
	
	public Film(String filmtittel, int alder, String nasjonalitet) {
		this.alder = alder;
		this.filmtittel = filmtittel;
		this.nasjonalitet = nasjonalitet;
	}

	public int getAlder() {
		return alder;
	}

	public String getFilmtittel() {
		return filmtittel;
	}

	public String getNasjonalitet() {
		return nasjonalitet;
	}
	
	public static void main(String[] args) {
		Film f1 = new Film("Alexander",15,"USA");
		Film f2 = new Film("Bad Santa",11,"USA");
		System.out.println(f1);
		System.out.println(f2);
	}
}