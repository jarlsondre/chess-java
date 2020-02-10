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
//		System.out.println(home);
//		System.out.println(borgeh);
//		System.out.println(div);
//		System.out.println(hal);
		home.printTree();
//		File homefil = new File("tmpfil.txt",home);
//		File egenfil1 = new File("egenfil.txt", borgeh);
//		File egenfil2 = new File("egenfil2.txt", borgeh);
//		root.printContent();
//		users.move(borgeh);
//		root.printContent();

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
		this.parent = parent;
		if (parent != null) {
			setParent(parent);
			parent.addFolder(this);
		}
		
	}
	private void addFolder(Folder folder) {
		folders.add(folder);
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Folder getParent() {
		return parent;
	}
	public void setParent(Folder parent) {
		this.parent = parent;
	}


}
