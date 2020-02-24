package kollokvie3.underveis;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class DepartmentTest {

	@Test
	public void testConstructor() {
		Department department1 = new Department();
		assertNull(department1.getSuperDepartment());
		
		Department department2 = new Department(department1);
		assertEquals(department1, department2.getSuperDepartment());
	}
	
	@Test
	public void testContains() {
		Department department1 = new Department();
		Department department2 = new Department(department1);
		
		assertTrue(department1.contains(department2));
		
		Department department3 = new Department(department2);
		
		assertTrue(department1.contains(department3));
		
		Department department4 = new Department();
		
		assertFalse(department1.contains(department4));
		assertFalse(department3.contains(department1));
	}
	
	@Test
	public void testMoveTo() {
		Department university = new Department();
		Department computerScience = new Department(university);
		Department algorithms = new Department(computerScience);
		Department math = new Department(university);
		
		assertTrue("Algorithms should be a sub department of the CS department", computerScience.contains(algorithms));
		assertFalse("Algorithms should not yet be a sub department of the maths department", math.contains(algorithms));
		assertNotEquals("Algorithms should not yet have maths as its parent department", math, algorithms.getSuperDepartment());
			
		algorithms.moveTo(math);

		assertFalse("Algorithms should no longer be a sub department of the CS department", computerScience.contains(algorithms));
		assertTrue("Algorithms should be a sub department of the maths department", math.contains(algorithms));
		assertEquals("Algorithms should have maths as its parent department", math, algorithms.getSuperDepartment());
	}
	
}
