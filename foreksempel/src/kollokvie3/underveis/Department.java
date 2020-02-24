package kollokvie3.underveis;

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
	
	private void removeDepartment(Department department) {
		if (childDepartments.contains(department)) {
			childDepartments.remove(department);
		}
	}
	
	public void moveTo(Department newSuperDepartment) {
		if (contains(newSuperDepartment)) {
			throw new IllegalStateException("Kan ikke flytte en avdeling til en underavdeling av seg selv");
		}
		
		
		if (superDepartment != null) {
			superDepartment.removeDepartment(this);
		}
		
		superDepartment = newSuperDepartment;
		
		if (superDepartment != null) {
			superDepartment.addDepartment(this);
		}
	}
	
	public boolean contains(Department department) {
		if (childDepartments.contains(department)) {
			return true;
		}
		
		for (Department childDepartment : childDepartments) {
			if (childDepartment.contains(department)) {
				return true;
			}
		}
		
		return false;
	}
	
}
