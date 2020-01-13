package uke3;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CounterOrigTest {

	@Test
	public void testCount() {
		CounterOrig co = new CounterOrig(5);
		assertEquals(1, co.getCounter());
		co.count();
		assertEquals(2, co.getCounter());
		co.count();
		assertEquals(3, co.getCounter());
		assertTrue(co.count());
		assertTrue(co.count());
		assertEquals(5, co.getCounter());
		assertFalse(co.count());
		assertEquals(5, co.getCounter());
	}

}
