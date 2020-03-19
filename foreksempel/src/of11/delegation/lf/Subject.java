package of11.delegation.lf;

import java.util.ArrayList;
import java.util.List;

public class Subject {

	private List<Employee> employees = new ArrayList<Employee>();
	
	public void addEmployee(Employee employee) {
		if (!employees.contains(employee)) {
			employees.add(employee);
		}
	}
	
	public Employee getEmployeeForTask(String role) {
		return employees.stream()
				.filter((employee) -> employee.getRole() == role)
				.min((employee1, employee2) -> employee1.getNumberOfTasksPerformed() - employee2.getNumberOfTasksPerformed())
				.get();
	}
	
	public void newTask(String task) {
		switch (task) {
		case "godkjenne øving":
		case "veilede student":
			getEmployeeForTask("Studass").performTask(task);
			break;
		case "svare på mail":
		case "fikse øving":
		case "eclipse problemer":
			getEmployeeForTask("Undass").performTask(task);
			break;
		default:
			getEmployeeForTask("Vitass").performTask(task);
		}
	}
	
	public static void main(String[] args) {
		Subject subject = new Subject();
		
		Employee magnus = new Employee("Magnus", "Vitass");
		Employee halvard = new Employee("Halvard", "Vitass");
		
		subject.addEmployee(magnus);
		subject.addEmployee(halvard);
		
		Employee martin = new Employee("Martin", "Undass");
		
		subject.addEmployee(martin);
		
		subject.newTask("holde øvingsforelesning");
		subject.newTask("holde øvingsforelesning");
		subject.newTask("lage digital undervisning");
		
		subject.newTask("svare på mail");
	}
	
}
