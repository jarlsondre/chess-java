package uke10.better;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Person implements Comparable<Person>{

	String name;
	int age;

	public int getAge() {
		return age;
	}

	public Person(String name, int alder) {
		super();
		this.name = name;
		this.age = alder;
	}

	@Override
	public String toString() {
		return name + " ("+age+")";
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
