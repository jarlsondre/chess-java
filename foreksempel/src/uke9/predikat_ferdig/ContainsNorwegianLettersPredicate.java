package uke9.predikat_ferdig;

import java.util.function.Predicate;

public class ContainsNorwegianLettersPredicate implements Predicate<String> {

	@Override
	public boolean test(String t) {
		return t.contains("å") || t.contains("æ") || t.contains("ø");
		
	}

}
