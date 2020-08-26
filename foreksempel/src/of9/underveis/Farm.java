package of9.underveis;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Farm implements Iterable<Animal> {

	public List<Animal> animals = new ArrayList<>();
	
	public List<Animal> getAnimals() {
		return new ArrayList<>(animals);
	}
	
	public void addAnimal(Animal animal) {
		if (!animals.contains(animal)) {
			animals.add(animal);
		}
	}
	
	public int numberOfAnimals() {
		return animals.size();
	}
	
	public Animal getAnimal(int index) {
		return animals.get(index);
	}
	
	public static void main(String[] args) {
		Farm farm = new Farm();
		Dog dog = new Dog("Ludo", 2);
		Chicken chicken = new Chicken("Albert", 1);
		
		farm.addAnimal(dog);
		farm.addAnimal(chicken);
		
		for (Animal animal : farm) {
			System.out.println(animal.makeSound());
		}
	}

	@Override
	public Iterator<Animal> iterator() {
		return new FarmIterator(this);
		//return animals.iterator();
	}
	
}
