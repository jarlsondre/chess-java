package uke10.functional_ferdig;

import java.util.function.Predicate;

public class NameMatchPredicate implements Predicate<Person> {

	private final String name;

	public NameMatchPredicate(final String name) {
		this.name = name;
	}

	@Override
	public boolean test(final Person p) {
		return p.getName().equals(name);
	}
}
