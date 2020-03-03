package uke10.functional_ferdig;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class PersonReg implements Iterable<Person> {

	private final Collection<Person> persons = new ArrayList<>();

	@Override
	public Iterator<Person> iterator() {
		return persons.iterator();
	}

	public void addPersons(final Person...persons) {
		this.persons.addAll(List.of(persons));
	}

	public Person forEachPerson(final Consumer<Person> consumer) {
		for (final Person person : persons) {
			consumer.accept(person);
		}
		return null;
	}

	public Person findFirst(final Predicate<Person> pred) {
		for (final Person person : persons) {
			if (pred.test(person)) {
				return person;
			}
		}
		return null;
	}

	public Collection<Person> findAllPersons(final Predicate<Person> pred) {
		final Collection<Person> result = new ArrayList<>();
		for (final Person person : persons) {
			if (pred.test(person)) {
				result.add(person);
			}
		}
		return result;
	}

	public Collection<String> getPersonProperties(final Function<Person, String> fun) {
		final Collection<String> result = new ArrayList<>();
		for (final Person person : persons) {
			result.add(fun.apply(person));
		}
		return result;
	}

	public static void main(final String[] args) {
		final Person ola = new Person("Ola", 'M');
		final Person tone = new Person("Tone", 'F');
		final Person thorvald = new Person("Thorvald", 'M');
		final Person audun = new Person("Audun", 'M');
		final Person ingeborg = new Person("Ingeborg", 'F');
		ola.addChild(thorvald);
		ola.addChild(audun);
		ola.addChild(ingeborg);
		tone.addChild(thorvald);
		tone.addChild(audun);
		tone.addChild(ingeborg);

		final Person hallvard = new Person("Hallvard", 'M');
		final Person marit = new Person("Marit", 'F');
		final Person jens = new Person("Jens", 'M');
		final Person anne = new Person("Anne", 'F');
		hallvard.addChild(jens);
		hallvard.addChild(anne);
		marit.addChild(jens);
		marit.addChild(anne);

		final PersonReg personReg = new PersonReg();
		personReg.addPersons(ola, tone, thorvald, audun, ingeborg);
		personReg.addPersons(hallvard, marit, jens, anne);

		// finner alle med som begynner på "A"
		System.out.println(personReg.findAllPersons(person -> person.getName().startsWith("A")));
		// finner alle kvinner (gender == 'F')
		System.out.println(personReg.findAllPersons(person -> person.isFemale()));
		// samme som
		System.out.println(personReg.findAllPersons(Person::isFemale));

		// kaller forEachPerson med en Consumer-implementasjon som skriver ut argumentet
		personReg.forEachPerson(new Consumer<Person>() {
			@Override
			public void accept(final Person person) {
				System.out.println(person);
			}
		});
		// samme som
		personReg.forEachPerson(person -> System.out.println(person));
		// samme som
		personReg.forEachPerson(System.out::println);

		System.out.println(personReg.getPersonProperties(person -> person.getName()));
		// samme som
		System.out.println(personReg.getPersonProperties(Person::getName));
		
	}
}
