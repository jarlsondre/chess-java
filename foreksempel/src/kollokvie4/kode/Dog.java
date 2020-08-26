package kollokvie4.kode;

public class Dog implements Animal {
	
	private String name;
	private int age;
	
	public Dog(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getAge() {
		return age;
	}
	

	@Override
	public String makeSound() {
		return name + " says Woof!";
	}
	
	@Override
	public int compareTo(Animal other) {
		return Integer.compare(age, other.getAge());
	}
	
}
