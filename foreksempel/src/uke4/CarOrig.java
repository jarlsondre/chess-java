package uke4;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import of4.CountingGame;

public class CarOrig {

	PersonOrig driver;
	PlateOrig plate;
	int seats;

	List<PersonOrig> hikers = new ArrayList<>();

	public boolean addHiker(PersonOrig person) {
		// Må sjekke seats - 1, siden vi jo har en fører. 
		// Eller kanskje vi må sjekke OM vi har - deres oppgave! 
		if (hikers.size() == seats -1 ) {
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

	public boolean removeHiker(PersonOrig person) {
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

	public CarOrig(String plate, int seats) {
		super();
		this.plate = new PlateOrig(plate);
		this.seats = seats;
		System.out.println("Bil med regnr "+
		this.plate.getSign()+ " og "+ this.seats + " seter.");
	}

	public PersonOrig getDriver() {
		return driver;
	}

	public boolean setDriver(PersonOrig driver) {
		// Vi kan sikkert sjekke for om det allerede sitter en sjåfør der, men...

		// Sjekke om den potensielle føreren er over 18 år. Ja, førerkort, samma det.
		if (driver.getAge() > 17) {			
			this.driver = driver;
			return true;
		}
		else
			System.out.println(driver.getName()+" er ikke gammel nok til å kjøre.");
		return false;
	}

	public void removeDriver() {
		this.setDriver(null);
	}

	@Override
	public String toString() {
		return "Car [driver=" + driver + ", plate=" + plate + ", seats=" + seats + ", hikers=" + hikers + "]";
	}

	public static void main(String[] args) {
		CarOrig car1 = new CarOrig("AA43171",5);
		CarOrig car2 = new CarOrig("AB65786",7);
		PersonOrig per= new PersonOrig("Per", 23);
		PersonOrig ida = new PersonOrig("Ida", 14);

		car1.setDriver(ida);
		System.out.println(car1);
		// En kan legge inn eksisterende objekter
		car1.addHiker(per);

		// En kan også legge inn nye objekter direkte
		car1.addHiker(new PersonOrig("Hans", 5));
		car1.addHiker(new PersonOrig("Gunn", 60));
		car1.addHiker(new PersonOrig("Fårjegplass", 2));
		car1.addHiker(new PersonOrig("Fårjegplass2", 35));
		car1.removeHiker(per);
		car1.addHiker(new PersonOrig("Fårjegplass2", 35));

		System.out.println("\ncar1 ser nå slik ut:");
		System.out.println(car1);
		
		// Dette er senere pensum - streams. Se så enkelt en kan skrive ut 
		// passasjerer over 17, sortert med yngst først. Men det KOMMER SENERE! :)
		System.out.println("Eksempel på hva en skal lære i kurset: streams med noe ekstra:");
		car1.hikers.stream()
			.filter(p -> p.getAge()>= 18)
			.sorted((p1, p2) -> Integer.compare(p1.getAge(),p2.getAge()))
			.forEach(System.out::println);
	}

}
