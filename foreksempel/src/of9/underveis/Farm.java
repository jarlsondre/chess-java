package of9.underveis;

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
		
		List<Animal> animals = farm.getAnimals();
		animals.sort(new AnimalComparator());
		animals.sort((o1, o2) -> o1.getAge() - o2.getAge());
		
		for (Animal animal : animals) {
			System.out.println(animal.makeSound());
		}
	}
	
}
