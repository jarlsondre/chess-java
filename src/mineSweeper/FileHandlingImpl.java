package mineSweeper;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FileHandlingImpl implements FileHandling {
	
	public static void saveToFile(Object o, String fileName) throws Exception {
		FileOutputStream fileOut = new FileOutputStream(fileName);
		ObjectOutputStream out = new ObjectOutputStream(fileOut);
		out.writeObject(o);
		out.close();
		fileOut.close();
	}
	
	public static ArrayList<Person> loadFromFile(String fileName) throws Exception {
		ArrayList<Person> o = null;
		FileInputStream fileIn = new FileInputStream(fileName);
		ObjectInputStream in = new ObjectInputStream(fileIn);
		o = (ArrayList<Person>) in.readObject();
		in.close();
		fileIn.close();
		return o;
	}
}
