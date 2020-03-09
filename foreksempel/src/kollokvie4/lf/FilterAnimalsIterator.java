package kollokvie4.lf;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class FilterAnimalsIterator implements Iterator<Animal> {

	private Farm farm;
	private Predicate<Animal> filter;
	private int index;
	
	public FilterAnimalsIterator(Farm farm, Predicate<Animal> filter) {
		this.farm = farm;
		this.filter = filter;
	}
	
	@Override
	public boolean hasNext() {
		while (index < farm.numberOfAnimals()) {
			if (filter.test(farm.getAnimal(index))) {
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