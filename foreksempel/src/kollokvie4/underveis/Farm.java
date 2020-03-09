package kollokvie4.underveis;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Farm implements Iterable<Animal> {

	private List<Animal> animals = new ArrayList<>();
	
	public void addAnimal(Animal animal) {
		if (animals.contains(animal)) {
			throw new IllegalStateException("The given animal is already in the farm");
		}
		animals.add(animal);
	}
	
	public List<Animal> getAnimals() {
		return new ArrayList<>(animals);
	}
	
	public Animal getAnimal(int index) {
		return animals.get(index);
	}
	
	public int numberOfAnimals() {
		return animals.size();
	}

	@Override
	public Iterator<Animal> iterator() {
		return new FarmIterator(this);
	}
	
	public static void main(String[] args) {
		Farm farm = new Farm();
		farm.addAnimal(new Dog("Ludo", 12));
		farm.addAnimal(new Dog("Fido", 0));
		farm.addAnimal(new Chicken("Peter", 1));
		farm.addAnimal(new Chicken("Albert", 4));
		
		Iterator<Animal> iterator = new FilterAnimalsIterator(farm, new DogPredicate());
		while (iterator.hasNext()) {
			System.out.println(iterator.next().makeSound());
		}
	}
	
}
