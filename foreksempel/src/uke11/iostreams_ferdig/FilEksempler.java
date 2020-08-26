package uke11.iostreams_ferdig;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class FilEksempler {

	/*
	 * All lesing fra og skriving til fil, og lesing fra nett, vil kunne
	 * utl�se unntak. Her har jeg valgt � ikke legge inn try/catch men heller
	 * la metodene kunne sende unntakene videre.
	 * Det eneste unntaket p� dette er file_
	 */

	public static void file_Reader() throws IOException {
		Reader reader = new FileReader(new File("C:/Users/borgeha/lesmeg.txt"));
		char[] buffer = new char[1000];
		int charCount = 0;
		while ((charCount = reader.read(buffer)) > 0) { 
			System.out.println(buffer);
		}
		reader.close();
	}


	public static void useURL(InputStream input) throws MalformedURLException, IOException {
		int byteVerdi = 0;
		while ((byteVerdi = input.read()) > 0) { // Denne er fin!
			System.out.println(byteVerdi + " er ascii for \t" + Character.toString((char) byteVerdi));
		}
		System.out.println("URL: " + input);
	}


	private static void print_Writer() throws FileNotFoundException {
		PrintWriter writer = new PrintWriter ("C:/Users/borgeha/print_test.txt");
		writer.println("Tror du de skj�nner noe enn�?");
		writer.close();

	}
	
	/* 
	 * PrintStream kan skrive ut objekter ved at den bruker objektenes toString():
	 */
	public static void PrintStream() throws FileNotFoundException {
		OutputStream output = new FileOutputStream("FileOutputStream.bin");

		try(PrintStream printStream =
		    new PrintStream(output)){

		    printStream.println(new Dyr("Ku", "m�", 4));
		    printStream.println(new Dyr("Kenguru", "ingenting", 2));
		}
		System.out.println("Skrevet ut dyr.");
	}

	public static void bufferedInputStream_Reader(InputStream is)  {
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))){
			while (reader.ready()) {
				String line = reader.readLine();
				System.out.println(line);
				// automatisk lukking pga Closable-argument like etter try.
			}

		} catch (IOException e) {
			System.err.println(e);
		}
	}

	/*
	 * Dette eksempelet viser bruk av java.nio.
	 * Disse er veldig gode, og forenkler mye av det som er gjort over.
	 * Hos meg ender denne filen opp i katalogen
	 * C:\Users\borgeha\tdt4100-v2020-master3\git\tdt4100-v2020-students\foreksempel
	 */
	public static void buffered_Writer(String name)  {
		try (BufferedWriter out = Files.newBufferedWriter(Paths.get(name))){ // Closeable-argument, lukkes automatisk
			out.write("Denne strengen\ng�r\nover flere linjer.");
			System.out.println("Fil skrevet");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	private void scanner_read(InputStream is) {
		
		// Absolutt path blir litt mer som dette:
//        File text = new File("C:/temp/fil.txt");
//        Scanner scnr = new Scanner(text);
		
		Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(is)));
		scanner.useDelimiter("\n"); // Ellers splitter den p� komma....
		
		// Hoppe over f�rste linje.
		scanner.next();
		
		while (scanner.hasNext()) {
			String string = (String) scanner.next();
			System.out.println(string);
		}
		scanner.close();
	}
	
	// Denne utl�ser feil - du m� nok h�ndtere dem bedre enn det. Jeg gj�r det for � f� kompakt kode.
	public static void main(String[] args) throws MalformedURLException, IOException, URISyntaxException {
//		FilEksempler.file_Reader();
//		FilEksempler.useURL(new URL("http://www.foad.org/%7Eabigail/").openStream());
//		FilEksempler.print_Writer();
//		FilEksempler.bufferedInputStream_Reader(new URL("https://www.db.no").openStream());
//		FilEksempler.buffered_Writer("filnavnet_tdt4100.txt");
//		FilEksempler.PrintStream();
//		FilEksempler fe = new FilEksempler();
//		fe.scanner_read(fe.getClass().getResourceAsStream("flerkamp.txt"));
	}

}
