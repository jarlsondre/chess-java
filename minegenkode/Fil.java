package minegenkode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import mineSweeper.Person;

public class Fil {
	public static String readFromFile(String filNavn) throws Exception {
		File file = new File(filNavn);
		BufferedReader br = new BufferedReader(new FileReader(file));
		String s;
		String a = "";
		
		while ((s = br.readLine()) != null) {
			a += s;
		}
		return a;
	}
	
	public static void writeToFile(String text, String filNavn) throws IOException {
		FileWriter myWriter = new FileWriter(filNavn);
	      myWriter.write(text);
	      myWriter.close();
	}
	
	public static void serializeObject(Object o, String filNavn) throws Exception {
		FileOutputStream fileOut = new FileOutputStream(filNavn);
		ObjectOutputStream out = new ObjectOutputStream(fileOut);
		out.writeObject(o);
		out.close();
		fileOut.close();
		System.out.println("Serialisert til fil");
	}
	
	public static ArrayList<Person> deSerializePerson(String filNavn) throws Exception {
		ArrayList<Person> o = null;
		FileInputStream fileIn = new FileInputStream(filNavn);
		ObjectInputStream in = new ObjectInputStream(fileIn);
		o = (ArrayList<Person>) in.readObject();
		in.close();
		fileIn.close();
		return o;
		
	}
	
	public static void main(String[] args) throws Exception{
		String jarl = readFromFile("Text.txt");
		System.out.println(jarl);
		writeToFile("Dette er en test", "Text.txt");
		writeToFile("Dette er også en test", "SaveFile.txt");
		jarl = readFromFile("Text.txt");
		System.out.println(jarl);
	}

}
