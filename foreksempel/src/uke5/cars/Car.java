package uke5.cars;

import java.util.ArrayList;
import java.util.List;

public class Car {

	Person driver;
	Plate plate;
	int seats;

	List<Person> hikers = new ArrayList<>();

	public boolean addHiker(Person person) {
		// M� sjekke seats - 1, siden vi jo har en f�rer. 
		// Eller kanskje vi m� sjekke OM vi har - deres oppgave! 
		if (this.isFull()) {
			System.out.println("Denna bilen er full, "+person.getName()+
					" fikk ikke plass!");
			return false;
		}
		else {
			hikers.add(person);
			System.out.println(person.getName()+
					" fikk plass.");
			return true;
		}
	}

	public boolean removeHiker(Person person) {
		if (hikers.contains(person)) {
			hikers.remove(person);
			System.out.println(person.getName()+
					" hoppet av.");
			return true;
		}
		else {
			System.out.println("Denne personen sitter ikke i bilen.");
			return false;
		}
	}

	public Car(String plate, int seats) {
		super();
		this.plate = new Plate(plate);
		this.seats = seats;
		System.out.println("Bil med regnr "+
		this.plate.getSign()+ " og "+ this.seats + " seter.");
	}

	public Person getDriver() {
		return driver;
	}

	public boolean setDriver(Person driver) {
		// Vi kan sikkert sjekke for om det allerede sitter en sj�f�r der, men...

		// Sjekke om den potensielle f�reren er over 18 �r. Ja, f�rerkort, samma det.
		if (driver.getAge() > 17) {			
			this.driver = driver;
			return true;
		}
		else
			System.out.println(driver.getName()+" er ikke gammel nok til � kj�re!");
		return false;
	}

	public void removeDriver() {
		this.setDriver(null);
	}

	@Override
	public String toString() {
		String tmp = plate + "("+seats+" seter)\n";
		if (driver != null) {
			tmp += "Kj�rer: "+driver+"\n";
		}
		List<String> personinfo = new ArrayList<>();
		for (Person personOrig : hikers) {
			personinfo.add(personOrig.toString());
		}
		tmp += String.join(",", personinfo);
		return tmp;
	}

	public static void main(String[] args) {
		Car car1 = new Car("AA43171",5);
		Car car2 = new Car("AB65786",7);
		Person per= new Person("Per", 23);
		Person ida = new Person("Ida", 14);

		car1.setDriver(ida);
		System.out.println(car1);
		// En kan legge inn eksisterende objekter
		car1.addHiker(per);

		// En kan ogs� legge inn nye objekter direkte.
		car1.addHiker(new Person("Hans", 5));
		car1.addHiker(new Person("Gunn", 60));
		car1.addHiker(new Person("F�rjegplass", 2));
		car1.addHiker(new Person("F�rjegplass2", 35));
		car1.removeHiker(per);
		car1.addHiker(new Person("F�rjegplass2", 35));

		System.out.println("\ncar1 ser n� slik ut:");
		System.out.println(car1);
		
		// Dette er senere pensum - streams. Se s� enkelt en kan skrive ut 
		// passasjerer over 17, sortert med yngst f�rst. Men det KOMMER SENERE! :)
		System.out.println("Eksempel p� hva en skal l�re i kurset: streams med noe ekstra:");
		car1.hikers.stream()
			.filter(p -> p.getAge()>= 18)
			.sorted((p1, p2) -> Integer.compare(p1.getAge(),p2.getAge()))
			.forEach(System.out::println);
	}

	public boolean isFull() {
		return this.seats == this.hikers.size();
	}
	
	public int totalAge() {
		int age = 0;
		if (driver != null)
			age += driver.getAge();
		for (Person personOrig : hikers) {
			age += personOrig.getAge();
		}
		return age;
	}

	public String getPlate() {		
		return this.plate.toString();
	}

	public Person getHiker(String name) {
		for (Person personOrig : hikers) {
			if (personOrig.getName().equals(name))
			return personOrig;
		}
		return null;
	}

}
