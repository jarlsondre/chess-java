package uke9.predikat_ferdig;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Predicate;

public class Strenger {

	Collection<String> strenger = new ArrayList<>();
	
	Collection<String> filtrerStrenger(Predicate<String> pred) {
		Collection<String> tmp = new ArrayList<>();
		for (String string: strenger) {
			if (pred.test(string))
				tmp.add(string);
		}
		return tmp;
	}
	
	public static void main(String[] args) {
		Strenger strenger = new Strenger();
		strenger.add("en");
		strenger.add("to");
		strenger.add("tre");
		strenger.add("fire");
		strenger.add("fem");
		strenger.add("sæks");
		strenger.add("sju");
		strenger.add("åtte");
		
		System.out.println("Minimum tre langt: "+strenger.filtrerStrenger(new LengthPredicate()));
		System.out.println("Norske tegn: "+strenger.filtrerStrenger(new ContainsNorwegianLettersPredicate()));
	}

	private void add(String string) {
		strenger.add(string);
	}
}
