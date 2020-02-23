package uke9.account_ferdig;

public class ATMController {

	public static void main(String[] args) {
		// Dette kunne jeg hatt i main i ATM.java, men se for dere at 
		// denne koden ligger og snakker med FXML. Da må ting skrives
		// om så ATM.java returnerer strenger i stedet for å syso dem!
		
		ATM atm = new ATM();
		RegularAccount ra = new RegularAccount();
		atm.deposit(ra,500);
		atm.deposit(ra,500);
		atm.deposit(ra,500);
		atm.withdraw(ra,1200);
		atm.withdraw(ra,1200);
		
		BonusAccount ba = new BonusAccount();
		atm.deposit(ba,  600);
		atm.withdraw(ba, 333);
		atm.withdraw(ba, 1033);
		atm.withdraw(ba, 1333);

		SavingsAccount sa = new SavingsAccount();
		atm.deposit(sa, 300);
		atm.withdraw(sa, 100);
		atm.withdraw(sa, 100);
		atm.withdraw(sa, 100);
	}

}
