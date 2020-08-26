package uke9.timeinterval123;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TimeIntervalsTest {

	TimeInterval1 ti1;
	TimeInterval2 ti2;
	TimeInterval3 ti3;

	@Before
	public void setUp() throws Exception {
		ti1 = new TimeInterval1(14, 15, 16, 00);
		ti2 = new TimeInterval2(14, 15, 16, 00);
		ti3 = new TimeInterval3(14, 15, 16, 00);
	}

	
	@Test
	public void testCorrectTimeInterval() {
		assertEquals("14:15-16:00", ti1.toString());
		assertEquals("14:15-16:00", ti2.toString());
		assertEquals("14:15-16:00", ti3.toString());
	}

	@Test
	public void testCorrectDuration() {
		assertEquals(105, ti1.getDuration());
		assertEquals(105, ti2.getDuration());
		assertEquals(105, ti3.getDuration());
	}

	@Test (expected=IllegalArgumentException.class)
	public void testFailsWhenAfterisBeforeBefore1() {
		ti1 = new TimeInterval1(14, 15, 14, 00);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testFailsWhenAfterisBeforeBefore2() {
		ti2 = new TimeInterval2(14, 15, 14, 00);
	}

	@Test (expected=IllegalArgumentException.class)
	public void testFailsWhenAfterisBeforeBefore3() {
		ti3 = new TimeInterval3(14, 15, 14, 00);
	}

}
