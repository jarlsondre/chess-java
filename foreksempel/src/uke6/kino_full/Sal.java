package uke6.kino_full;

public class Sal {

	String navn;
	int plasser;
	
	
	@Override
	public String toString() {
		return "Sal [navn=" + navn + ", plasser=" + plasser + "]";
	}


	public Sal(String navn, int plasser) {
		
		if (navn.length() == 0) {
			throw new IllegalArgumentException("Salen m� ha et navn.");
		}
		if (plasser < 1) {
			throw new IllegalArgumentException("Salen må ha plass til folk. Seriøst..");
		}
		this.navn = navn;
		this.plasser = plasser;
	}
	
	
	
}
