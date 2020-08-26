package mineSweeper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Person implements Serializable, Comparable<Person>{

	private String name;
	private List<Integer> topp10 = new ArrayList<Integer>();

	public Person(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void addTime(int time) {
		topp10.add(time);
		Collections.sort(topp10);
		if (topp10.size() > 10) {
			topp10.remove(10);
		}
	}

	public List<Integer> getTopTen() {
		return this.topp10;
	}

	public int getAllTimeBest() {
		if (topp10.size() == 0) {
			return 0;
		}
		else {
			return topp10.get(0);
		}
	}

	public static void main(String[] args) {
		Person jarl = new Person("Jarl");
		jarl.addTime(1);
		jarl.addTime(2);
		jarl.addTime(27);
		jarl.addTime(5);
		jarl.addTime(11);
		jarl.addTime(7);
		jarl.addTime(9);
		jarl.addTime(6);
		jarl.addTime(10);
		jarl.addTime(10);
		jarl.addTime(10);
		jarl.addTime(10);
		jarl.addTime(3);

		System.out.println(jarl.getTopTen());
		System.out.println(jarl.getAllTimeBest());


	}

	@Override
	public int compareTo(Person o) {
		int value = 0; 
		if (this.getAllTimeBest() == 0 && o.getAllTimeBest() == 0) {
			return 0;
		}
		else if (this.getAllTimeBest() == 0 && o.getAllTimeBest() != 0) {
			return 1;
		}
		else if (this.getAllTimeBest() != 0 && o.getAllTimeBest() == 0) {
			return -1;
		}
		else return o.getAllTimeBest() - this.getAllTimeBest();
	}
}
