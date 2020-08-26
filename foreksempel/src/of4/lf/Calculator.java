package of4.lf;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
	
	private ArrayList<String> precedence;
	
	public Calculator(List<String> precedence) {
		this.precedence = new ArrayList<>(precedence);
	}
	
	public double calculate(Calculation calculation) {
		for (String currentOperations : precedence) {
			calculation = performOperations(calculation, currentOperations);
		}
		
		return calculation.getInitialValue();
	}
	
	private Calculation performOperations(Calculation calculation, String operations) {
		double value = calculation.getInitialValue();
		ArrayList<Operation> remainingOperations = new ArrayList<>();
		
		for (Operation operation : calculation.getOperations()) {
			if (operations.indexOf(operation.getOperation()) == -1) {
				remainingOperations.add(operation);
			} else {
				if (remainingOperations.isEmpty()) {
					value = operation.perform(value);
				} else {
					Operation previousOperation = remainingOperations.remove(remainingOperations.size() - 1);
					remainingOperations.add(operation.combineWith(previousOperation));
				}
			}
		}
		
		return new Calculation(value, remainingOperations);
	}
	
	/* Fra e)
	public double calculate(Calculation calculation) {
		double value = calculation.getInitialValue();
		for (var operation : calculation.getOperations()) {
			value = operation.perform(value);
		}
		
		return value;
	}
	*/
	
}
