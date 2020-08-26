package uke11.lambdastreams_ferdig;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.String;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class StreamExamples {

	public static void main(String[] args) throws IOException {



		List<Integer> liste = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

		// Fjerne oddetall:
		System.out.print("\nListe av partall:");
		System.out.println(liste.stream()
				.filter(i -> i%2 == 0)
				.collect(Collectors.toList()));

		// Summer tall:
		System.out.print("\nSum av tall: ");
		System.out.println(liste.stream()
				.reduce(0, (sum, i) -> sum + i));

		List<String> people = Arrays.asList("Al", "Skybert", "Farfar", "Farmor", "H�vard", "J�rn", "Andrea", "B�rge");
		// Liste med lengde av Stringobjekter:
		System.out.print("\nNavnelengder: ");
		System.out.println(people.stream()
				.map(s -> s.length())
				//		.distinct()
				//		.sorted()
				.collect(Collectors.toList()));


		// Sum av lengder av Stringobjekter:
		System.out.print("\nSum av navnelengder: ");
		System.out.println(people.stream()
				.map(s -> s.length())
				.reduce(0, (sum, i) -> sum+i));


		// Fjerne de f�rste seks elementene i en intstream fra 0 til 10, og telle elementer:
		System.out.print("\nHopper over noen elementer: ");
		System.out.println(IntStream
				.range(0, 10)
				//				.peek(System.out::println)
				.skip(6)
				.count());

		// Legge sammen alle tall opp til 200 som g�r opp i tre og sju
		System.out.print("\nLegge sammen elementer fra 0-200 som g�r opp i 3 og 7: ");
		System.out.println(IntStream
				.range(0, 200)
				.filter(t -> t%3 == 0)
				.filter(t -> t%7 == 0)
				.reduce(0, (sum,i) -> sum+i));



		// Lage en kontinuerlig str�m av heltall som deles p� et annet tall, og s� skrive ut de f�rste 100:
		// H�vard sitt forslag
		System.out.println("\nBare et skrudd eksempel p� hva en kan. Limit er bra, ellers ville den fortsatt...");
		IntStream
		.range(0,99999)
//		.range(0,999999999)
		//		.mapToDouble(n -> Double.valueOf(n)) // Er det samme, men mer tungvinte enn
		.mapToDouble(Double::valueOf)
		.map( n -> n/2978)
		.filter(n -> n % 2978 == 0) // Denne linjen var ikke H�vard som kom p�. Jeg ville bare ikke vente s��� lenge:)
		.limit(10)
		.forEach(System.out::println);


		List<String> folk = Arrays.asList("Al", "Skybert", "Farfarharetlangtnavn", "Farmor", "H�vard", "J�rn", "Andrea", "B�rge");

		System.out.println("\nPersoner med navn lenger enn fem tegn, p� en fin m�te:");
		// Skrive ut alle navn i listen som er mer enn fem tegn, og hvor mange tegn de er.
		folk.stream()
		//		.peek(System.out::println)
		.filter(p -> p.length() > 5)
		.map(p -> p+"\t"+p.length())
		.forEach(System.out::println);

		// Lage en samling som inneholder alle personene som starter med "A" og lengde over fire.
		System.out.print("\nNavn som starter med F og lengde over 6: ");
		System.out.println(folk.stream()
				.filter(p -> p.startsWith("F"))
				.filter(p -> p.length() > 6)
				.collect(Collectors.toList()));


		// Lese fra fil og legge inn i objekter: se Flerkamp.java

		System.out.println("\nLese fra fil:");
		// Lese fra fil:
		// Hvis det ikke hadde v�rt i main kune en brukt getClass.getResource 
		// Merk spesialtilfelle. P� denne m�ten MŅ en ikke innkapsle i try. Det m� en uten streams.
		System.out.println(new BufferedReader(new InputStreamReader(StreamExamples.class.getResourceAsStream("bands.txt"))).lines()
				// Over: hvis du bruker linjen over i en annen metode enn main, bytt ut klassenavn.class med getClass()
				.filter(p -> p.length() > 8) // Alle bandnavn lenger enn 8 tegn
				.sorted((a, b) -> a.charAt(1) - b.charAt(1)) // sortert p� andre bokstav i navnet
				//					.peek(System.out::println) // Lurkikk
				.map(n -> n.charAt(1)) // hent bare ut andre bokstav
				.collect(Collectors.toList())); // Samle til en liste

		
		// BinaryOperator:
		/*
		 *  Reduce bruker denne. Reduce tar inn to tall og returnerer summen. Det kule er at man 
		 *  husker sum til neste gang den kj�res! F�rste parameter i reduce bestemmer hva sum
		 *  skal v�re f�rste gang reduce kalles. Neste gang kj�res den n�v�rende verdien av sum inn.
		 *  P� denne m�ten kan en legge sammen alle verdiene i rekken.
		 */
		System.out.println("BinaryOperator: " + IntStream.range(0,100).reduce(0, (sum, i) -> (sum + i)));
        // Eller penere:
		System.out.println("BinaryOperator: " + IntStream.range(0,100).reduce(0, Integer::sum));
		
		
		// UnaryOperator:
		// Interface som tar inn et element, og gj�r noe med det. map bruker UnaryOperator!
		UnaryOperator<String> uo = s -> "[" + s + "]"; // Utvider bare strengen foran og bak
		System.out.println("UnaryOperator: " + uo.apply("Verdi"));
		System.out.print("UnaryOperator i stream, ved bruk av map: (kvadrere tall)");
		IntStream.range(1, 10).map(i -> i*i).forEach(d -> System.out.print(" " + d));
 	}
}
