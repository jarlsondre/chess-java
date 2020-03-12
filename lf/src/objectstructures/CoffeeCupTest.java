package objectstructures;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;


public class CoffeeCupTest {
	private CoffeeCup cup;
	
	@Before
	public void setup() {
		cup = new CoffeeCup();
	}
	
	@Test
	public void testEmptyConstructor() {
		assertEquals(cup.getCapacity(), 0, 0);
		assertEquals(cup.getCurrentVolume(), 0, 0);
	}
	
	@Test
	public void testConstructor() {
		cup = new CoffeeCup(10, 5);
		assertEquals(cup.getCapacity(), 10, 1e-9);
		assertEquals(cup.getCurrentVolume(), 5, 1e-9);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testInvalidInstantiation() {
		cup = new CoffeeCup(10, 15);
	}
		
	@Test
	public void testIncreaseCupSize() {
		assertEquals(cup.getCapacity(), 0, 1e-9);
		cup.increaseCupSize(-5);
		assertEquals(cup.getCapacity(), 0, 1e-9);
		cup.increaseCupSize(100);
		assertEquals(cup.getCapacity(), 0, 100);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testDrinkNegativeAmount() {
		cup.drinkCoffee(-5);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testDrinkAboveCapacity() {
		cup.increaseCupSize(50);
		cup.drinkCoffee(60);
	}

	@Test
	public void testDrinkReducesCurrentVolume() {
		cup.increaseCupSize(50);
		cup.fillCoffee(45);
		cup.drinkCoffee(10);
		assertEquals(cup.getCurrentVolume(), 35, 1e-9);
	}
	
	@Test
	public void testFillCoffee() {
		cup.increaseCupSize(10);
		cup.fillCoffee(5);
		assertEquals(cup.getCurrentVolume(), 5, 1e-9);
		cup.fillCoffee(5);
		assertEquals(cup.getCurrentVolume(), 10, 1e-9);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSpillCoffee() {
		cup.increaseCupSize(10);
		cup.fillCoffee(20);
	}
}