package uke9.account_ferdig;

public interface Account {
	public int getBalance();
	public int deposit(int amount);
	public int withdraw(int amount);
}
