package minegenkode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PersonProgram {



	public static void main(String[] args) {
		ArrayList<Person> personList = new ArrayList<Person>(Arrays.asList(
				new Person(12, "Jarl"), 
				new Person(14, "tomas"),
				new Person(18, "karl"), 
				new Person(22, "firkant"),
				new Person(65, "karle")));
		System.out.println(personList);
		ArrayList<Person> filter1 = new ArrayList<Person>();
		List<Person> filter2 = new ArrayList<Person>();
		
		// eksempel med en anonym indre klasse
		filter1 = personList.stream()
				.filter(new Predicate<Person>() {
					public boolean test(Person p) {
						return p.getAge() < 18;
					}
				}).collect(Collectors.toCollection(ArrayList::new));
		System.out.println("Filter 1: " + filter1);
		
		// eksempel med lambda-uttrykk og listetype
		filter2 = personList.stream().filter(p -> p.getAge() < 18).collect(Collectors.toList());
		System.out.println("Filter 2: " + filter2);
		
		// printe alle elementene i en stream: (Merk: her kan jeg ha argumenter i uttrykket)
		personList.stream().forEach(p -> System.out.print(p + ", "));
		
		// printe alle elementene i en stream, kortere:
		personList.stream().forEach(System.out::print);
		
		// endre alderen til alle med 1:
		personList.stream().forEach(p -> p.setAge(p.getAge() + 1));
		System.out.println("\n" + personList);
		
		
		
	} 



}
