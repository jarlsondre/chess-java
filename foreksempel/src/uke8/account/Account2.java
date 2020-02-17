package uke8.account;

public class Account2 {

	private int balance;


	public void deposit(int amount) {
		balance += amount;
	}

	public void withdraw(int amount) {
		if (balance - amount < 0)
			System.err.println("Ingen kreditt, Sir.");
		else
			balance -= amount;
	}

	public int getBalance() {
		return balance;
	}

	public void test(boolean resultat, String msg) {
		if (!resultat) {
			System.err.println("Her var der feil: "+msg);
		}
	}

	public Account2() {
		super();
		this.balance = 0;
	}

	public static void main(String[] args) {

		Account2 konto = new Account2();
		if (konto.getBalance() != 0)
			System.err.println("Konstruktør lager Account med feil balance.");
		konto.deposit(1000);
		if (konto.getBalance() != 1000)
			System.err.println("Feil: Forventet 1000, ble "+konto.getBalance());
		
		konto.test(konto.getBalance() == 1000, "Skulle vært 1000 men var "+konto.getBalance());

	}

}
