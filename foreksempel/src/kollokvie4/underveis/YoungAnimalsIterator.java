package kollokvie4.underveis;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class YoungAnimalsIterator implements Iterator<Animal> {

	private Farm farm;
	private int index;
	
	public YoungAnimalsIterator(Farm farm) {
		this.farm = farm;
	}

	@Override
	public boolean hasNext() {
		while (index < farm.numberOfAnimals()) {
			if (farm.getAnimal(index).getAge() < 2) {
				return true;
			}
			
			index++;
		}
		
		return false;
	}

	@Override
	public Animal next() {
		if (!hasNext()) {
			throw new NoSuchElementException("There is no next element");
		}
		return farm.getAnimal(index++);
	}
	
}
