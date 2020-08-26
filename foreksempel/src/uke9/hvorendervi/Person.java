package uke9.hvorendervi;

import java.util.ArrayList;
import java.util.Collection;


/*
 * Ved � ta en vandring gjennom en del spennende tema, og det starter med
 * Interface, vil dere om noen uker kunne forst� hvorfor koden i main her
 * fungerer. Dere vil forst�, og kunne bruke, lambdafunksjoner og streams.
 * Tenk s� mye tid dere sparer p� � kunne skrive slik kode. Ikke bare p� 
 * eksamen, dette brukes masse ute i industrien. Og i andre spr�k!
 * Dette, og myyyyyye mer, kan gj�res.
 */
public class Person {

	String name;
	int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public static void main(String[] args) {
		Collection<Person> persons = new ArrayList<>();
		persons.add(new Person("Per Hansen", 26));
		persons.add(new Person("Ivar Sk�r",3));
		persons.add(new Person("Jenny Hval", 13));
		persons.add(new Person("Metusalem", 969));
		persons.add(new Person("Fersken",1));
		persons.add(new Person("Sistemann", 12));
		// Hvor mange er eldre enn tolv �r?
		System.out.println(persons.stream()
				.filter(p -> p.getAge()> 12)
				.count());
		
		// Hva er summen av alle sine aldere?
		System.out.println(persons.stream()
				.mapToInt(p -> p.getAge())
				.sum());
		
		// Hva er navnet p� den yngste som har et navn med e?
		System.out.println(persons.stream()
				.filter(p -> p.getName().contains("e"))
				.min((o1, o2) -> o1.getAge() - o2.getAge())
				.get());
	}
	
	
	@Override
	public String toString() {
		return name + " (" + age + ")";
	}
}
