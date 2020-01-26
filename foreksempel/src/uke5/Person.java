package uke5;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Person {

	String name;
	int age;
	
	
	public String getName() {
		return name;
	}


	public int getAge() {
		return age;
	}


	public Person(String name, int age) {
		super();
//		System.out.println("Inni 2 parameters konstruktør");
		this.name = name;
		this.age = age;
	}


	/**
	 *  Etter timen la jeg til et par konstruktører til for å vise at
	 *  en kan ha flere av dem. Det vanlige er å la EN av dem faktisk lage
	 *  objektet, mens de andre peker til denne ved hjelp av this(). Dette
	 *  kallet 
	 */
	public Person(String name) { // Hvis ikke alder er nevnt, 0 år.
		this(name,0);
//		System.out.println("Inni 1 parameters konstruktør");
	}

	public Person() { // Hvis ikke noe er nevnt, Ola Nordmann.
		this("Ola Nordmann");
//		System.out.println("Inni 1 parameters konstruktør");
	}


	public static void main(String[] args) {
		Person p = new Person("Per",23);
		assertEquals("Per", p.getName());
		System.out.println(p.toString());
		System.out.println(new Person()); // Etter forelesning, men lærerikt læll!
		/* Hvis dere reagerer på at konstruktørene kalles 2 - 1 - 0, så 
		 * må en huske på at FØR println gjør en et kall til en annen konstruktør.
		 * 2 til 1, 1 til 0. Disse gjennomføres før en så returnerer til den forrige.
		 * this() må akkurat som super() være helt først i en konstruktør.
		 */

	}


	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

}
