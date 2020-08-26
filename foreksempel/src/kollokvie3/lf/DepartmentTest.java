package kollokvie3.lf;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Arrays;

import org.junit.Test;

public class DepartmentTest {

	@Test
	public void testConstructor() {
		Department university = new Department();
		Department computerScience = new Department(university);
		assertEquals("Parent department is not set correctly", university, computerScience.getParentDepartment());
	}
	
	@Test
	public void testContains() {
		Department university = new Department();
		Department computerScience = new Department(university);
		Department ai = new Department(computerScience);
		Department math = new Department(university);
		
		assertTrue("AI should be a sub department of the university", university.contains(ai));
		assertTrue("Math should be a sub department of the university", university.contains(math));
		assertFalse("AI should not be a sub department of math", math.contains(ai));
	}
	
	@Test
	public void testMoveTo() {
		Department university = new Department();
		Department computerScience = new Department(university);
		Department algorithms = new Department(computerScience);
		Department math = new Department(university);
		
		assertTrue("Algorithms should be a sub department of the CS department", computerScience.contains(algorithms));
		assertFalse("Algorithms should not yet be a sub department of the maths department", math.contains(algorithms));
		assertNotEquals("Algorithms should not yet have maths as its parent department", math, algorithms.getParentDepartment());
			
		algorithms.moveTo(math);

		assertFalse("Algorithms should no longer be a sub department of the CS department", computerScience.contains(algorithms));
		assertTrue("Algorithms should be a sub department of the maths department", math.contains(algorithms));
		assertEquals("Algorithms should have maths as its parent department", math, algorithms.getParentDepartment());
	}
	
	@Test
	public void testMoveToCyclic() {
		Department university = new Department();
		Department computerScience = new Department(university);
		
		try {
			university.moveTo(computerScience);
			fail("Cyclic dependencies between departments are not allowed");
		} catch (IllegalStateException e) {
			
		}
	}
	
	@Test
	public void testGetEmployees() {
		Department university = new Department();
		Department computerScience = new Department(university);
		Department algorithms = new Department(computerScience);
		Department math = new Department(university);
		
		Employee employee1 = new Employee(computerScience);
		Employee employee2 = new Employee(math);
		Employee employee3 = new Employee(math);
		Employee employee4 = new Employee(algorithms);
		
		assertEquals(math.getEmployees().size(), 2);
		assertTrue(math.getEmployees().containsAll(Arrays.asList(employee2, employee3)));
		assertFalse(math.getEmployees().contains(employee4));
		assertEquals(computerScience.getEmployees().size(), 2);
		assertTrue(computerScience.getEmployees().containsAll(Arrays.asList(employee1, employee4)));
		assertEquals(university.getEmployees().size(), 4);
		assertTrue(university.getEmployees().containsAll(Arrays.asList(employee1, employee2, employee3, employee4)));
	}
	
}