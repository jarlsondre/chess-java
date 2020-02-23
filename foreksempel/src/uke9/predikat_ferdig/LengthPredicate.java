package uke9.predikat_ferdig;

import java.util.function.Predicate;

public class LengthPredicate implements Predicate<String> {

	@Override
	public boolean test(String t) {
		System.out.println(t);
		return t.length() > 3;
	}

}
