package kollokvie4.underveis;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class FilterAnimalsIterator implements Iterator<Animal> {

	private Farm farm;
	private int index;
	private Predicate<Animal> predicate;
	
	public FilterAnimalsIterator(Farm farm, Predicate<Animal> predicate) {
		this.farm = farm;
		this.predicate = predicate;
	}

	@Override
	public boolean hasNext() {
		while (index < farm.numberOfAnimals()) {
			if (predicate.test(farm.getAnimal(index))) {
			//if (farm.getAnimal(index).getAge() < 2) {
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
