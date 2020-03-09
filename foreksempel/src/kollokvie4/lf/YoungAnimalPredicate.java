package kollokvie4.lf;

import java.util.function.Predicate;

public class YoungAnimalPredicate implements Predicate<Animal> {

	@Override
	public boolean test(Animal animal) {
		return animal.getAge() < 2;
	}
	
}
