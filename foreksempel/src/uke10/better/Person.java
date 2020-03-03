package uke10.better;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Person implements Comparable<Person>{

	String name;
	int alder;

	public int getAlder() {
		return alder;
	}

	public Person(String name, int alder) {
		super();
		this.name = name;
		this.alder = alder;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + "]";
	}

	public Person(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public static void main(String[] args) {
		
	}

	@Override
	public int compareTo(Person o) {
		return this.getName().compareTo(o.getName());
	}
}
