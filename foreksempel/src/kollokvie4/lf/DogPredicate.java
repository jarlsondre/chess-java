package kollokvie4.lf;

import java.util.function.Predicate;

public class DogPredicate implements Predicate<Animal>{

	@Override
	public boolean test(Animal animal) {
		return animal instanceof Dog;
	}

}
