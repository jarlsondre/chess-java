package uke10.strings;

import java.util.Iterator;

public class Streng implements Iterable<Character> {

	String s;
	
	public Streng(String s) {
		super();
		this.s = s;
	}

	public static void main(String[] args) {
		Streng s = new Streng("Heisann");
		for (Character character : s) {
			System.out.println(character);
		}
		
	}

	@Override
	public Iterator<Character> iterator() {
		return new StringIterator(s);
	}

}
