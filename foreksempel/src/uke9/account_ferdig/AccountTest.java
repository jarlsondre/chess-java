package uke9.account_ferdig;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AccountTest {

	Account regular, bonus, savings;

	@Before
	public void setUp() throws Exception {
		regular = new RegularAccount();
		bonus = new BonusAccount();
		savings = new SavingsAccount();
	}

	@Test
	public void testRegular() {
		regular.deposit(1000);
		regular.withdraw(150);
		regular.withdraw(150);
		regular.withdraw(300);
		assertEquals(300, regular.withdraw(300)); // Har ikke penger
		assertEquals(100, regular.getBalance());
	}

	@Test
	public void testBonus() {
		bonus.deposit(1000);
		bonus.withdraw(500);
		assertEquals(800, bonus.withdraw(800)); // Kan gå i minus
		assertEquals(-300, bonus.getBalance());
		}
	
	@Test 
	public void testSavings() {
		savings.deposit(1000);
		savings.withdraw(300);
		savings.withdraw(300);
		// Kan ikke ta ut penger selv med kreditt, maks antall uttak
		try {
			savings.withdraw(800);
		} catch (IllegalArgumentException e) {
			System.out.println("Forventet utløsning av IllegalArgumentException.");
		} catch (Exception e) {
			fail();
		}

		// Har da igjen 400 på konto
		assertEquals(400, savings.getBalance());
	}
}
