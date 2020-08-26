package of7.underveis;

import java.util.ArrayList;
import java.util.List;

public class Department {

	private Department superDepartment;
	private List<Department> childDepartments = new ArrayList<>();
	
	public Department() {
		
	}
	
	public Department(Department superDepartment) {
		this.superDepartment = superDepartment;
		superDepartment.addDepartment(this);
	}
	
	public Department getSuperDepartment() {
		return superDepartment;
	}
	
	private void addDepartment(Department department) {
		if (!childDepartments.contains(department)) {
			childDepartments.add(department);
		}
	}
	
}
