package of8.lf;

import java.util.ArrayList;
import java.util.List;

public class Farm {

	public List<Animal> animals = new ArrayList<>();
	
	public List<Animal> getAnimals() {
		return new ArrayList<>(animals);
	}
	
	public void addAnimal(Animal animal) {
		if (!animals.contains(animal)) {
			animals.add(animal);
		}
	}
	
	public static void main(String[] args) {
		Farm farm = new Farm();
		Dog dog = new Dog("Ludo", 2);
		Chicken chicken = new Chicken("Albert", 1);
		
		farm.addAnimal(dog);
		farm.addAnimal(chicken);
		
		for (Animal animal : farm.getAnimals()) {
			System.out.println(animal.makeSound());
		}
	}
	
}
