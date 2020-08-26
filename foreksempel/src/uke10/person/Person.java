package uke10.person;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Person implements Iterable<Person>{

	Collection<Person> children = new ArrayList<>();
	@Override
	public String toString() {
		return "Person [children=" + children + ", name=" + name + ", age=" + age + "]";
	}


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
		this.name = name;
		this.age = age;
	}
	
	public void addChild(Person child) {
		children.add(child);
	}
	@Override
	public Iterator<Person> iterator() {
		return children.iterator();
	}
	
	
	public static void main(String[] args) {
		Person p = new Person("B�rge", 46);
		Person j = new Person("J�rn", 13);
		Person h = new Person("H�vard", 11);
		
		p.addChild(j);
		p.addChild(h);
		
		System.out.println(p);
		
		for (Person person : p) {
			System.out.println(person);
		}
	}
}
