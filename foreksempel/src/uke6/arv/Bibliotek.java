package uke6.arv;

public class Bibliotek {

	public static void main(String[] args) {

		// Barnebok 
		Barnebok bb = new Barnebok("Ruffen", "Bringsverd", 45, 100);
		System.out.println(bb);
		
		// Tegneseriealbum
		Tegneseriealbum ts = new Tegneseriealbum("Når halen er god", "Batem, Gregg", 53, "Franquin");		
		System.out.println(ts);
		
		// Vi kan fremdeles lage bare en bok!
		Bok b = new Bok("Bare en god bok", "Børge Haugset", 12);
		System.out.println(b); 
	}

}
