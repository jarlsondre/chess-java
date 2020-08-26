package uke10.functional_ferdig;

import java.util.function.Predicate;

public class NameStartsWithPredicate implements Predicate<Person> {

	private final String name;

	public NameStartsWithPredicate(final String name) {
		this.name = name;
	}

	@Override
	public boolean test(final Person p) {
		return p.getName().startsWith(name);
	}
}
