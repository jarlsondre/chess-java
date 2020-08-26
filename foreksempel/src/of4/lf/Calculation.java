package of4.lf;

import java.util.ArrayList;
import java.util.List;

public class Calculation {
	
	private final double initialValue;
	private ArrayList<Operation> operations;
	
	public Calculation(double initialValue) {
		this.initialValue = initialValue;
		operations = new ArrayList<>();
	}
	
	public Calculation(double initialValue, List<Operation> operations) {
		this.initialValue = initialValue;
		this.operations = new ArrayList<>(operations);
	}
	
	public double getInitialValue() {
		return initialValue;
	}
	
	public void addOperation(Operation operation) {
		if (operation == null) {
			throw new IllegalArgumentException("Operation cannot be null");
		}
		operations.add(operation);
	}
	
	public List<Operation> getOperations() {
		return new ArrayList<>(operations);
	}
	
	@Override
	public String toString() {
		String representation = String.format("%.2f", initialValue);
		for (Operation operation : operations) {
			representation = representation + " " + operation.toString();
		}
		return representation;
	}

}