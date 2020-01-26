package uke5;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Car {

	Person driver;
	Plate plate;
	int seats;

	Collection<Person> hikers = new ArrayList<>();



	public Car(String plate, int seats) {
		super();
		this.plate = new Plate(plate);
		this.seats = seats;
		System.out.println("Bil med regnr "+plate+" og "+ seats+" seter.");
	}



	/**
	 * Jeg har her skissert slik jeg ønsker at en bil skal oppføre seg.
	 * Så er det opp til meg å bestemme hvordan dette skal løses internt
	 * ved oppdeling av objekter og ansvar. 
	 * @param args
	 */
	public static void main(String[] args) {
		Car car1 = new Car("AA43171",5);
		// Car car2 = new Car("A465786",7); // Denne skal utløse et unntak.
		// Det finnes metoder å teste forventede unntak også, men det er ikke
		// pensum! (det er egentlig ikke ekstrem bruk av JUnit heller... Men
		// jeg liker å vise dere smakebiter av hva som er fint ved alt dette.

		Person per= new Person("Per", 23);
		Person ida = new Person("Ida", 14);
		car1.setDriver(ida);
		car1.setDriver(per);

		/*
		 * Jeg sa at jeg skulle få laget en måte jeg kan bruke returverdi på.
		 * Her returnerer addHiker boolean basert på om den faktisk får plass til 
		 * en person eller ikke. Det er derimot ikke en veldig bra måte å gjøre ting
		 * synes jeg. Jeg har lagt inn en ny metode getHikerAmount() som returnerer 
		 * antallet passasjerer. Denne kan en teste mot, se under.
		 * 
		 * Hvis du synes dette ser vanskelig ut, husk at en heller kan skrive ut hva som skjer.
		 */
		assertEquals(0, car1.getHikerAmount()); // System.out.println("Antall passasjerer: "+car1.getHikerAmount());
		assertTrue(car1.addHiker(ida));
		assertEquals(1, car1.getHikerAmount());
		assertTrue(car1.addHiker(new Person("Gunn", 60)));
		assertTrue(car1.addHiker(new Person("Fårjegplass", 2)));
		assertTrue(car1.addHiker(new Person("Fårjegplass2", 35)));
		assertEquals(4, car1.getHikerAmount());
		assertFalse(car1.addHiker(new Person("Fårjegplass3", 101)));
		assertEquals(4, car1.getHikerAmount());
		
		car1.removeHiker(ida);
		car1.addHiker(new Person("Person4", 34));
		System.out.println("\ncar1 ser nå slik ut:");
		System.out.println(car1);
		
		System.out.println("\nSå bare noe jeg vil vise. Denne koden:");
		// Dette er bare en smakebit på hva dere kommer til å lære i løpet av våren. Dette er effektiv koding!
		// HUSK: DERE SKAL IKKE kunne det i løpet av uken, men tenk så kult det blir å kunne!
		car1.hikers.stream() // Lag en 'strøm' av alle objektene som finnes i samlingen car1.hikers.
			.map(p -> p.getAge())         // For hver person, send bare dennes alder videre i strømmen
			.filter(n -> n > 17)          // Bare tall over 17 får bli med videre i strømmen
			.map(a -> a+10)               // Legg på 10 på hvert av tallene og send videre.  
			.sorted((n1, n2) -> Integer.compare(n1, n2)) // Sorter tallene i strømmen etter størrelse
			.forEach(n -> System.out.println(n));// Skriv ut hvert resultat på sin egen linje ETTER sortering
		
		System.out.println("...gir det samme som:");
		// Strømmen over gjør det samme som denne koden fra her...
		List<Integer> liste = new ArrayList<>();
		for (Person person : car1.hikers) {
			int age = person.getAge();
			if (age > 17 ) {
				liste.add(age +10); 
			}
		}
		Collections.sort(liste);
		for (Integer integer : liste) {
			System.out.println(integer);
		}
		// ...til hit. Så kan du avgjøre selv hva som er mest forståelig når kommer til mai og skjønner alt.
		// streams har en drøss andre fordeler også, men det tar vi om en måned eller to!
	}



	@Override
	public String toString() {
		return "Car [driver=" + driver + ", plate=" + plate + ", seats=" + seats + ", hikers=" + hikers + "]";
	}



	void removeHiker(Person person) {
		if (hikers.contains(person)) {
			hikers.remove(person);
			System.out.println(person.getName()+" hoppet av.");			
		}
		else {
			System.out.println(person.getName()+" satt aldri på!");
		}
	}

	/**
	 * Hjelpemetode som ikke ble med på forelesning.
	 * @return antallet passasjerer
	 */
	int getHikerAmount() {
		return this.hikers.size();
	}
	
	
	/*
	 * Jeg kunne endret denne til void, og heller valgt å lage en metode som returnerer
	 * antallet personer som sitter på i bilen, som kan brukes til å sjekke at
	 * tilstanden er korrekt. Denne laget jeg allikevel.
	 * I tillegg vil en gjerne ha sjekker om om Personen p faktisk ER passasjer i bilen, 
	 * og slikt, men eksempelet her er ikke komplett. 
	 */
	boolean addHiker(Person person) {
		if (this.hikers.size() == this.seats -1) {
			System.out.println("Fullt. Vent på neste "+ person.getName());
			return false;
		}
		else {
			this.hikers.add(person);
			System.out.println(person.getName()+" sitter på.");
			return true;
		}
	}


	/* 
	 * Her kan en sløyfe boolean. En kan lage en metode getDriver(), og sjekke at denne
	 * er endret eller ikke. Jeg bruker ikke boolean, men den kan jo brukes i testing... 
	 */
	boolean setDriver(Person person) {
		if (person.getAge() > 17) {
			this.driver = person;
			System.out.println(this.driver.getName()+" kjører nå "+this.plate.getSign());
			return true;
		}
		else {
			System.out.println(person.getName()+" er ikke gammel nok til å kjøre bilen.");
			return false;
		}
	}


	/**
	 * 
	 * @return Om bilen er full eller ikke. Av passasjerer, den sier ikke noe om fører.
	 */
	public boolean isFull() {
		return this.hikers.size() == this.seats -1;
		// Betyr den her at vi kan forenkle innlegging senere? Trenger vi den over? 
		// Hvor skal tilstands
	}
}
