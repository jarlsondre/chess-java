package of11.delegation.lf;

public class Employee {

	private String name;
	private String role;
	private int numberOfTasksPerformed;
	
	public Employee(String name, String role) {
		this.name = name;
		this.role = role;
	}
	
	public void performTask(String task) {
		System.out.println("[" + name + ":" + role + "] Performed task " + task);
		numberOfTasksPerformed++;
	}
	
	public String getRole() {
		return role;
	}
	
	public int getNumberOfTasksPerformed() {
		return numberOfTasksPerformed;
	}
	
}
