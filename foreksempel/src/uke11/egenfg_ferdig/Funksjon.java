package uke11.egenfg_ferdig;

import java.util.function.Function;

public class Funksjon {

	String streng;
	
	public void setStreng(String streng) {
		this.streng = streng;
	}


	/*
	 * Denne har bestemt inntype og uttype. Vi g�r i dette kurset ikke igjennom mye om
	 * T og R og slikt som dere har sett p� eksempler p� nettet og i JavaDoc.
	 */
	public Integer apply(Function<String, Integer> f) {
		return f.apply(streng);
	}
	
	
	public static void main(String[] args) {
		Funksjon f = new Funksjon();
		f.setStreng("Dette er en setning");
		System.out.println(f.apply(s -> s.length()));
		System.out.println(f.apply(s -> s.indexOf('e')));
		
	}
}
