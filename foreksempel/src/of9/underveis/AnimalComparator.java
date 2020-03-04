package of9.underveis;

import java.util.Comparator;

public class AnimalComparator implements Comparator<Animal> {

	@Override
	public int compare(Animal o1, Animal o2) {
		/*if (o1.getAge() > o2.getAge()) {
			return 1;
		}
		
		if (o1.getAge() < o2.getAge()) {
			return -1;
		}
		
		return 0;*/
		
		//return o1.getAge() - o2.getAge();
		return Integer.compare(o1.getAge(), o2.getAge());
	}

}
