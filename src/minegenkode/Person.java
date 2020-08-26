package minegenkode;

public class Person {
	
	private int age;
	private String name;
	
	public Person(int age, String name) {
		this.age = age;
		this.name = name;
	}
	
	
	@Override
	public String toString() {
		return name + " (" + age + ")";
	}
	



	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public static void main(String[] args) {
		Person jarl = new Person(22, "jarl");
		System.out.println(jarl);
	}
	
	
	
	

}
