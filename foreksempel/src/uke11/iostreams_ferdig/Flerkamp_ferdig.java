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

		try { // Påkrevd try siden en leser fra fil.
			Path path = Paths.get(classUrl.toURI());
			System.out.println("Path (URI): "+path);			

			// Lese fra denne filen som en strøm.
			deltakere = Files.lines(path)

			// Nå er hvert objekt en String, linje fra filen.
			.skip(1) // Den første linjen er overskrift, dropper den.

			// n er linjen, n settes til kall på fromCols med en liste av strenger
			.map(n -> fromCols(n.split(",\\s*"))) // Splitter på "," og valgfritt antall mellomrom. (søk opp regexp)

			// fromCols lager Personer. La oss samle disse i en liste og returnere alle:
			.collect(Collectors.toList()); 
		} catch (IOException e) {
			// Har ikke gjort noe spesielt med feilhåndteringen.
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
	// Dette mates tilbake i strømmen.
	private Deltaker fromCols(String...cols) {
		return new Deltaker(cols[0], Integer.parseInt(cols[1]), 
				Double.parseDouble(cols[2]), Integer.parseInt(cols[3]), 
				Integer.parseInt(cols[4]), cols[5]);
	}

	public static void main(String[] args) throws URISyntaxException {
		Flerkamp_ferdig fk = new Flerkamp_ferdig();
		fk.readFile(); // Leser via stream og legger Deltakere inn i fk!

		// Nå skal alle deltakerne ha blitt lagt inn i listen. Så en enkel stream-måte å skrive dem ut på,
		// println kaller toString i hvert Deltakerobjekt på veien.
		fk.deltakere.stream().forEach(System.out::println);

		// Hva med å skrive ut alle navnene til deltakerne? Tenk at data flyter fra venstre mot høyre og endres.
		System.out.println("Deltakere: "+fk.deltakere.stream()
		.map(x -> x.getName()).collect( Collectors.joining( ", " )));

		// Hva med å finne deltakerne som fikk minst 10 poeng på ballongskyting og poker?
		fk.deltakere.stream()  // Enhver Collection kan streames!
		.filter(x -> x.getBalloonshooting() >= 10 && x.getPoker() >= 10)
		.forEach(p -> System.out.println("\nMinst ti poeng i poker og ballongskyting: "+p.getName()));		

		// Så, for syns skyld lesing av filen på en av de gamle måtene:
		fk.deltakere.clear();
		fk.readFile_old("C:\\Users\\borgeha\\tdt4100-v2020-master3\\git\\tdt4100-v2020-students\\foreksempel\\target\\test-classes\\uke11\\iostreams_ferdig\\flerkamp.txt");
		
		for (Deltaker deltaker : fk.deltakere) {
			System.out.println(deltaker.getName() + "\t" + deltaker.getBalloonshooting());
		}
	}


	@Override
	public String toString() {
		return "Flerkamp [deltakere=" + deltakere + "]";
	}
}
