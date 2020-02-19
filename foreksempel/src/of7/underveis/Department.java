package of7.underveis;

public class Department {

	private Department superDepartment;
	
	public Department() {
		
	}
	
	public Department(Department superDepartment) {
		this.superDepartment = superDepartment;
	}
	
}
