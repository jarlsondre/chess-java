package uke5.car_forelesning;

/**
 * En superenkel Personklasse som vi skal stappe inn i biler.
 * Dersom det er plass.
 * @author borgeha
 *
 */
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
		this.name = name;
		this.age = age;
	}


	public static void main(String[] args) {
		Person p = new Person("Kåre",23);
		System.out.println(p);
	}
	
	@Override
	public String toString() {
		return name + " (" + age + ")";
	}

}
