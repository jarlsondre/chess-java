package kollokvie3.lf;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

public class EmployeeTest {
	
	@Test
	public void testMoveTo() {
		Department department1 = new Department();
		Department department2 = new Department();
		
		Employee employee = new Employee(department1);
		
		assertTrue("The employee should belong to department 1 before moving", department1.getEmployees().contains(employee));
		assertFalse("The employee should not belong to department 2 before moving", department2.getEmployees().contains(employee));
		
		employee.moveTo(department2);
		
		assertFalse("The employee should not belong to department 1 after moving", department1.getEmployees().contains(employee));
		assertTrue("The employee should belong to department 2 after moving", department2.getEmployees().contains(employee));
	}

	@Test
	public void testPromote() {
		Department university = new Department();
		Department computerScience = new Department(university);
		
		Employee employee = new Employee(computerScience);
		
		assertTrue("Before promoting the employee should belong to the computer science department", computerScience.getEmployees().contains(employee));
		assertTrue("Before promoting the employee should belong to the university", university.getEmployees().contains(employee));
		
		employee.promote();

		assertFalse("After promoting the employee should not belong to the computer science department", computerScience.getEmployees().contains(employee));
		assertTrue("After promoting the employee should belong to the university", university.getEmployees().contains(employee));
		
		try {
			employee.promote();
			fail("Promotion should throw an IllegalStateException when not possible");
		} catch (IllegalStateException e) {
			assertTrue("After a failed promotion the employee should still belong to the university", university.getEmployees().contains(employee));
		} catch (Exception e) {
			fail("Promotion should throw an IllegalStateException when not possible");
		}
	}
	
}
