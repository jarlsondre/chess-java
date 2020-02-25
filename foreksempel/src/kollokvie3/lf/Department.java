package kollokvie3.lf;

import java.util.ArrayList;
import java.util.List;

public class Department {
	
	private Department parentDepartment;
	private List<Department> subDepartments = new ArrayList<>();
	private List<Employee> employees = new ArrayList<>();
	
	public Department() {
		
	}
	
	public Department(Department parentDepartment) {
		parentDepartment.addDepartment(this);
		this.parentDepartment = parentDepartment;
	}
	
	public Department getParentDepartment() {
		return this.parentDepartment;
	}
	
	private void addDepartment(Department department) {
		if (department == null) {
			throw new IllegalArgumentException("Department is null");
		}
		
		if (department.contains(this) || this.contains(department)) {
			throw new IllegalStateException("Cannot create cyclic dependencies");
		}
		subDepartments.add(department);
	}
	
	private void removeDepartment(Department department) {
		if (!subDepartments.contains(department)) {
			throw new IllegalStateException("The department is not a direct sub department of this department");
		}
		subDepartments.remove(department);
	}
	
	public void moveTo(Department department) {
		if (parentDepartment != null && this.contains(department)) {
			throw new IllegalStateException("This department is already under this department");
		}
		
		if (parentDepartment != null) {
			parentDepartment.removeDepartment(this);
		}
		
		parentDepartment = null;
		
		if (department != null) {
			department.addDepartment(this);
		}
		
		parentDepartment = department;
	}
	
	public boolean contains(Department department) {
		if (subDepartments.contains(department)) {
			return true;
		}
		
		for (Department subDepartment : subDepartments) {
			if (subDepartment.contains(department)) {
				return true;
			}
		}
		
		return false;
	}
	
	public void addEmployee(Employee employee) {
		if (employees.contains(employee)) {
			throw new IllegalStateException("The employee already belongs to this department");
		}
		employees.add(employee);
	}
	
	public void removeEmployee(Employee employee) {
		if (!employees.contains(employee)) {
			throw new IllegalStateException("The employee does not belong to this department");
		}
		employees.remove(employee);		
	}
	
	public List<Employee> getEmployees() {
		List<Employee> allEmployees = new ArrayList<>(employees);
		
		for (Department department : subDepartments) {
			allEmployees.addAll(department.getEmployees());
		}
		
		return allEmployees;
	}
}