package of4.lf;

public class Operation {

	private final char operation;
	private final double operand;
	
	public Operation(char operation, double operand) {
		if (!isValidOperation(operation)) {
			throw new IllegalArgumentException("Not a valid operation");
		}
		
		this.operation = operation;
		this.operand = operand;
	}
	
	public boolean isValidOperation(char operation) {
		return "+-*/^".indexOf(operation) != -1;
	}
	
	public char getOperation() {
		return operation;
	}
	
	public double getOperand() {
		return operand;
	}
	
	public double perform(double leftOperand) {
		switch(operation) {
			case '+':
				return leftOperand + operand;
			case '-':
				return leftOperand - operand;
			case '*':
				return leftOperand * operand;
			case '/':
				return leftOperand / operand;
			case '^':
				return Math.pow(leftOperand, operand);
			default:
				throw new IllegalStateException("The given operand is not supported");
		}
		
	}
	
	public Operation combineWith(Operation leftOperation) {
		return new Operation(leftOperation.operation, perform(leftOperation.operand));
	}
	
	@Override
	public String toString() {
		return String.format("%c %.2f", operation, operand);
	}
	
}
