package uke7.folder;

import java.util.ArrayList;
import java.util.List;

public class Folder {
	
	String name;
	Folder parent;
	List<Folder> folders;
	// List<File> files;
	
	public static void main(String[] args) {
		Folder home = new Folder("home",null);
		Folder borgeh = new Folder("borgeh",home);
		Folder hal = new Folder("hal",home);
		Folder div = new Folder("div",borgeh);
		borgeh.setName("kari");
		borgeh.move(hal);
//		System.out.println(home);
//		System.out.println(borgeh);
//		System.out.println(div);
//		System.out.println(hal);
		borgeh.printTree();
		
		//		File homefil = new File("tmpfil.txt",home);
//		File egenfil1 = new File("egenfil.txt", borgeh);
//		File egenfil2 = new File("egenfil2.txt", borgeh);
//		root.printContent();
//		users.move(borgeh);
//		root.printContent();

	}
	
	
	/*
	 *  Hvordan fungerer contains?
	 *  Hvis en skal sjekke om this inneholder destination, så
	 *  kan en sjekke alle parents til destination helt til parent
	 *  er null for om den aktuelle Folder (dest, dest.parent, 
	 *  dest.parent.parent etc, men dette skjer rekursivt) er lik this.
	 *  Hvis den er lik this, så må en returnere True siden destination da
	 *  ligger i en subfolder til this, eller dypere. 
	 *  Hvis en kommer helt dit og ender opp med null, da 
	 *  returnerer en false - destination er ikke en subfolder.
	 */
	boolean contains(Folder destination) {
		if (destination == this) {
			return true;
		}
		else if (destination == null) {
			return false;
		}
		else return this.contains(destination.parent);
	}
	
	private void move(Folder destination) {
		System.out.println("Skal flytte " + this.getName() + 
				" til " + destination.getName());
		if (destination != null && this.contains(destination)) {
			throw new IllegalStateException("Uendelig løkke...");
		}
		
		// parent må ha beskjed før vi endrer parent til en ny Folder.
		parent.removeFolder(this);
		
		// Selv
		this.parent = destination;
		
		// ny parent må få beskjed
		parent.addFolder(this);
		
	}

	private void removeFolder(Folder folder) {
		folders.remove(folder);
	}

	private void printTree() {
		System.out.println(this);
		
		for (Folder folder : folders) {
			folder.printTree();
		}
		
	}
	@Override
	public String toString() {
		String tmp = "/" + name;
		if (parent != null)
			tmp = parent.toString() + tmp;
		return tmp;
	}
	public Folder(String name, Folder parent) {
		super();
		folders = new ArrayList<>();
//		files = new ArrayList<>();
		this.name = name;
//		this.parent = parent; // Denne strykes, brukes igjen etterpå.
		if (parent != null) {
			setParent(parent);
			parent.addFolder(this);
		}
		
	}
	void addFolder(Folder folder) {
		folders.add(folder);
	}
		
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name == null) {
			throw new IllegalStateException("Name cannot be null.");
		}
		if (name.length() == 0)
			throw new IllegalStateException("Name cannot be of zero length.");
		this.name = name;
	}
	
	public Folder getParent() {
		return parent;
	}
	public void setParent(Folder parent) {
		this.parent = parent;
	}


}
