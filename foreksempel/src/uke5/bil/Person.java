package uke5.bil;

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



	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

}
