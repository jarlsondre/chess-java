package kollokvie4.underveis;

import java.util.function.Predicate;

public class DogPredicate implements Predicate<Animal> {

	@Override
	public boolean test(Animal animal) {
		return animal instanceof Dog;
	}

}
