package kollokvie4.underveis;

public class Chicken implements Animal {

	private String name;
	private int age;
	
	public Chicken(String name, int age) {
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
		return name + " says Kluk!";
	}

}
