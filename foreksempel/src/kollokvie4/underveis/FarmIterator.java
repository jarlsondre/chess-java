package kollokvie4.underveis;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class FarmIterator implements Iterator<Animal> {
	
	private Farm farm;
	private int index;
	
	public FarmIterator(Farm farm) {
		this.farm = farm;
	}

	@Override
	public boolean hasNext() {
		return farm.numberOfAnimals() > index;
	}

	@Override
	public Animal next() {
		if (!hasNext()) {
			throw new NoSuchElementException("There is no next element");
		}
		return farm.getAnimal(index++);
	}

}
