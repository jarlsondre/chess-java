package kollokvie3.lf;

public class Employee {
	
	private Department department;
	
	public Employee(Department department) {
		moveTo(department);
	}
	
	public void moveTo(Department department) {
		if (this.department != null) {
			this.department.removeEmployee(this);
		}
		
		this.department = department;
		
		if (department != null) {
			department.addEmployee(this);
		}
	}
	
	public void promote() {
		if (department.getParentDepartment() == null) {
			throw new IllegalStateException("There is no department to be promoted to");
		}

		moveTo(department.getParentDepartment());
	}

}