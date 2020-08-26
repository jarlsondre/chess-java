package uke4;

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
//		System.out.println("Inni 2 parameters konstrukt�r");
		this.name = name;
		this.age = age;
	}


	/**
	 *  Etter timen la jeg til et par konstrukt�rer til for � vise at
	 *  en kan ha flere av dem. Det vanlige er � la EN av dem faktisk lage
	 *  objektet, mens de andre peker til denne ved hjelp av this(). Dette
	 *  kallet 
	 */
	public Person(String name) { // Hvis ikke alder er nevnt, 0 �r.
		this(name,0);
//		System.out.println("Inni 1 parameters konstrukt�r");
	}

	public Person() { // Hvis ikke noe er nevnt, Ola Nordmann.
		this("Ola Nordmann");
//		System.out.println("Inni 1 parameters konstrukt�r");
	}


	public static void main(String[] args) {
		Person p = new Person("Per",23);
		assertEquals("Per", p.getName());
		System.out.println(p.toString());
		System.out.println(new Person()); // Etter forelesning, men l�rerikt l�ll!
		/* Hvis dere reagerer p� at konstrukt�rene kalles 2 - 1 - 0, s� 
		 * m� en huske p� at F�R println gj�r en et kall til en annen konstrukt�r.
		 * 2 til 1, 1 til 0. Disse gjennomf�res f�r en s� returnerer til den forrige.
		 * this() m� akkurat som super() v�re helt f�rst i en konstrukt�r.
		 */

	}


	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

}
