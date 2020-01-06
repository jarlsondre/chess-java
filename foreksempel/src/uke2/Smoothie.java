package uke2;

public class Smoothie {

	public static void main(String[] args) {
		Frukt f_1 = new Frukt("Agurk", 0.3);
		Frukt f_2 = new Frukt("Løk", 0.0002);
		Frukt f_3 = new Frukt("Jordbær", 12);
		
		double antall = f_1.getAntall()+f_2.getAntall()+f_3.getAntall();
		System.out.println("Vi har en smoothie med så "+antall+" ting inni.");
	}

}
