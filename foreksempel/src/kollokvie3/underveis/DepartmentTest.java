package kollokvie3.underveis;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class DepartmentTest {

	@Test
	public void testConstructor() {
		Department department1 = new Department();
		assertNull(department1.getSuperDepartment());
		
		Department department2 = new Department(department1);
		assertEquals(department1, department2.getSuperDepartment());
	}
	
	
}
