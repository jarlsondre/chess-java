package kollokvie4.lf;

public interface Animal extends Comparable<Animal> {
	
	String getName();
	int getAge();
	String makeSound();
	void incrementAge();

}
