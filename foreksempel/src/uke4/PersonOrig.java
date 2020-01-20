package uke4;

public class PersonOrig {

	String name;
	int age;
	
	
	
	public String getName() {
		return name;
	}



	public int getAge() {
		return age;
	}



	public PersonOrig(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}



	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

}
