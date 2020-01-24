package uke5;

public class Person {

	String name;
	int age;
	static String type = "Menneske";
	
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
		type = "ork";
	}


	public String getName() {
		return this.name;
	}


	public int getAge() {
		return age;
	}
	
	static public String getType() {
		return type;
		
	}
	public String toString() {
		return name + " er " + age + " år gammel!";
	}
	
	public void printInfo() {
		System.out.println(name + " er " + age + " år gammel.");
	}
	
	public static void main(String[] args) {
//		System.out.println(getType());
		Person p1 = new Person("Åge", 23);
		System.out.println(p1.getType());
		Person p2 = new Person("Per", 33);
		Person p3 = new Person("Ida", 43);
		p1.printInfo();
		p2.printInfo();
		p3.printInfo();
	}
	
}
