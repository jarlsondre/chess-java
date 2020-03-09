package kollokvie4.lf;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

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

	public void newYear() {
		// animals.forEach(animal -> animal.incrementAge());
		animals.forEach(Animal::incrementAge);
	}

	public List<String> getAnimalNames() {
		return animals.stream().map(Animal::getName).distinct().collect(Collectors.toList());
	}

	@Override
	public Iterator<Animal> iterator() {
		return new FarmIterator(this);
	}

	/*
	 * public static void main(String[] args) { List<Animal> animals =
	 * Arrays.asList(new Dog("Ludo", 12), new Dog("Fido", 0), new Chicken("Peter",
	 * 1), new Chicken("Albert", 4));
	 * 
	 * //Collections.sort(animals); Collections.sort(animals, (a1, a2) ->
	 * a1.getName().compareTo(a2.getName()));
	 * 
	 * for (Animal animal : animals) { System.out.println(animal.makeSound()); } }
	 */



}
