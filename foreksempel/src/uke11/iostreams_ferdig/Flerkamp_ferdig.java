package uke11.iostreams_ferdig;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Flerkamp_ferdig {

	
	List<Deltaker> deltakere = new ArrayList<>();

	private void readFile()  {
		// Setter den sammen av folderen til classfilene og pakkenavnet.
		URL classUrl = getClass().getResource("flerkamp.txt");
		System.out.println("URL: "+classUrl);
		System.out.println("Pakkenavn: "+getClass().getPackageName());

		try { // P�krevd try siden en leser fra fil.
			Path path = Paths.get(classUrl.toURI());
			System.out.println("Path (URI): "+path);			

			// Lese fra denne filen som en str�m.
			deltakere = Files.lines(path)
					
			// N� er hvert objekt en String, linje fra filen.
			.skip(1) // Den f�rste linjen er overskrift, dropper den.
			// n er linjen, n settes til kall p� fromCols med en liste av strenger
			.map(n -> fromCols(n.split(",\\s*"))) // Splitter p� "," og valgfritt antall mellomrom. (s�k opp regexp)

			// fromCols lager Personer. La oss samle disse i en liste og returnere alle:
			.collect(Collectors.toList()); 
		} catch (IOException e) {
			// Har ikke gjort noe spesielt med feilh�ndteringen.
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} finally {
		}
	}


	private void readFile_old(String fil) {
		File file = new File(fil); 

		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(file));
			br.readLine();
			String str; 
			while ((str = br.readLine()) != null) 
				deltakere.add(fromCols(str.split(",\\s*")));
			br.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	} 



	// Denne brukes av readFile. Den parser en streng (linje fra filen) og oppretter et Deltakerobjekt.
	// Dette mates tilbake i str�mmen.
	private Deltaker fromCols(String...cols) {
		return new Deltaker(cols[0], Integer.parseInt(cols[1]), 
				Double.parseDouble(cols[2]), Integer.parseInt(cols[3]), 
				Integer.parseInt(cols[4]), cols[5]);
	}

	public static void main(String[] args) throws URISyntaxException {
		Flerkamp_ferdig fk = new Flerkamp_ferdig();
		fk.readFile(); // Leser via stream og legger Deltakere inn i fk!

		// N� skal alle deltakerne ha blitt lagt inn i listen. S� en enkel stream-m�te � skrive dem ut p�,
		// println kaller toString i hvert Deltakerobjekt p� veien.
		fk.deltakere.stream().forEach(System.out::println);

		// Hva med � skrive ut alle navnene til deltakerne? Tenk at data flyter fra venstre mot h�yre og endres.
		System.out.println("Deltakere: "+fk.deltakere.stream()
		.map(x -> x.getName()).collect( Collectors.joining( ", " )));

		// Hva med � finne deltakerne som fikk minst 10 poeng p� ballongskyting og poker?
		fk.deltakere.stream()  // Enhver Collection kan streames!
		.filter(x -> x.getBalloonshooting() >= 10 && x.getPoker() >= 10)
		.forEach(p -> System.out.println("\nMinst ti poeng i poker og ballongskyting: "+p.getName()));		

		// S�, for syns skyld lesing av filen p� en av de gamle m�tene:
		fk.deltakere.clear();
		fk.readFile_old("C:\\Users\\borgeha\\tdt4100-v2020-master3\\git\\tdt4100-v2020-students\\foreksempel\\target\\test-classes\\uke11\\iostreams_ferdig\\flerkamp.txt");
		
		for (Deltaker deltaker : fk.deltakere) {
			System.out.println(deltaker.getName() + "\t" + deltaker.getBalloonshooting());
		}
		
		fk.deltakere.stream()
		.forEach(System.out::println);
	}


	@Override
	public String toString() {
		return "Flerkamp [deltakere=" + deltakere + "]";
	}
}
