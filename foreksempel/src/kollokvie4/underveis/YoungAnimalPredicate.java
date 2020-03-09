package kollokvie4.underveis;

import java.util.function.Predicate;

public class YoungAnimalPredicate implements Predicate<Animal> {

	@Override
	public boolean test(Animal animal) {
		return animal.getAge() < 2;
	}

}
