package uke8.account;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AccountTest {

	Account konto;
	
	@Before
	public void setUp() throws Exception {
		System.out.println("Initialiserer...");
		konto = new Account();
	}

	@Test
	public void constructurZeroBalanceUponCreation() {
		assertEquals(0, konto.getBalance());
	}

	@Test
	public void depositMoney() {
		konto.deposit(1000);
		assertEquals(1000, konto.getBalance());
	}
	
}
