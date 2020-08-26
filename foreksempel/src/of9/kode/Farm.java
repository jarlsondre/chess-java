package of9.kode;

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

}
