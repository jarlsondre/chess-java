package uke9.account_ferdig;

public class ATM {

	public void withdraw(Account account, int amount) {
		
		int money = 0;
		try {
			money = account.withdraw(amount);
			System.out.println("Du fikk tatt ut " + money + " kroner. Kontoinformasjon:\n"+account+"\n");
		}
		catch (Exception e) {
			System.out.println(e);
			// Etter at en forklarer om instanceOf:
// Bare en liten bonus til de med gullkort som vil ta ut mer penger. 
//			if (account instanceof BonusAccount) {
//				System.out.println("Øker kredittgrensen med tusen...");
//				BonusAccount ba2 = (BonusAccount) account;
//				ba2.setCredit(-2000); // Kan gjøre bedre, den økes jo ikke neste gang.
//			}
		}
	}
	
	public void deposit(Account account, int amount) {
		account.deposit(amount);
		System.out.println(amount + " kroner satt inn. Kontoinformasjon:\n"+account+"\n");
	}
	
	public void getBalance(Account account) {
		System.out.println(account);
	}
}
