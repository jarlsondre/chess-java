package uke3;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CounterTest {

	
	
	/*
	 * Vi har ikke forelest om dette enn�, men her kan dere se
	 * hvordan man kan bruke et testrammeverk for � verifisere
	 * at koden oppf�rer seg som forventet. 
	 * AssertEquals sammenlikner to verdier som er forventet �
	 * � v�re like, testen feiler ellers. AssertFalse og AssertTrue
	 * forventer at parameteren skal evalueres til false, hhv true,
	 * og testen feiler ellers. 
	 * 
	 * Det som skjer her er at vi endrer tilstanden til ett Count-
	 * objekt, og verifiserer at dette oppf�rer seg som forventet.
	 */
	@Test
	public void testCount() {
		Counter co = new Counter(5);
		assertEquals(1, co.getCounter());
		System.out.println(co.getCounter());
		co.count(); // N� skal den v�re 2
		assertEquals(2, co.getCounter());
		co.count(); // N� skal den v�re 3
		assertEquals(3, co.getCounter());
		assertFalse(co.count()); // 4
		assertFalse(co.count()); // 5
		assertEquals(5, co.getCounter());
		assertTrue(co.count());
		assertEquals(5, co.getCounter());
	}

}
