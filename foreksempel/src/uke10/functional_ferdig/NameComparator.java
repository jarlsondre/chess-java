package uke10.functional_ferdig;

import java.util.Comparator;

public class NameComparator implements Comparator<Person> {

	@Override
	public int compare(final Person p1, final Person p2) {
		// parameter are of type Object, so we have to downcast it to Employee objects
		return p1.getName().compareTo(p2.getName());
	}
}
