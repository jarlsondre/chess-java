package uke9.personinterface_ferdig;

import static org.junit.Assert.*;
import org.junit.Test;

public class PersonTest {

	@Test
	public void testPerson1() {
		Person p = new Person1();
		p.setFulltnavn("Ada Lovelace");
		assertEquals("Ada", p.getFornavn());
		assertEquals("Lovelace", p.getEtternavn());
		assertEquals("Ada Lovelace", p.getFulltnavn());
		p.setFornavn("Johnny");
		assertEquals("Johnny Lovelace", p.getFulltnavn());
	}

	@Test
	public void testPerson2() {
		Person p = new Person2();
		p.setFulltnavn("Ada Lovelace");
		assertEquals("Ada", p.getFornavn());
		assertEquals("Lovelace", p.getEtternavn());
		assertEquals("Ada Lovelace", p.getFulltnavn());
		p.setFornavn("Johnny");
		assertEquals("Johnny Lovelace", p.getFulltnavn());
		
	}

}
