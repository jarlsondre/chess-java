package of9.underveis;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class FarmIterator implements Iterator<Animal> {
	
	private Farm farm;
	private int position = 0;
	
	public FarmIterator(Farm farm) {
		this.farm = farm;
	}

	@Override
	public boolean hasNext() {
		return position < farm.numberOfAnimals();
	}

	@Override
	public Animal next() {
		if (!hasNext()) {
			throw new NoSuchElementException();
		}
		Animal animal = farm.getAnimal(position);
		position++;
		return animal;
		
		//return farm.getAnimal(position++);
	}

}
