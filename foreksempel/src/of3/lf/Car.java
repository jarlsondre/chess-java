package of3.lf;

public class Car {
	
	private String model;
	private String brand;
	private String regNum;
	private int productionYear;
	private double kmDriven;
	private double weight;
	private double velocity = 0.0;

	public Car(String model, String brand, String regNum, int productionYear, double kmDriven, double weight) {
		this.model = model;
		this.brand = brand;
		this.regNum = regNum;
		this.productionYear = productionYear;
		this.kmDriven = kmDriven;
		this.weight = weight;
	}
	
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public void setRegNum(String regNum) {
		this.regNum = regNum;
	}
	
	public double getVelocity() {
		return velocity;
	}

	public String getModel() {
		return model;
	}

	public String getBrand() {
		return brand;
	}

	public String getRegNum() {
		return regNum;
	}

	public int getProductionYear() {
		return productionYear;
	}

	public double getKmDriven() {
		return kmDriven;
	}

	public double getWeight() {
		return weight;
	}
	
	public void drive(double km) {
		if (km < 0) {
			throw new IllegalArgumentException();
		}
		
		this.kmDriven += km;
	}
	
	public void accelerate(double velocityChange) {
		if (velocityChange < 0) {
			throw new IllegalArgumentException();
		}
		
		velocity += velocityChange;
	}
	
	public void brake(double velocityChange) {
		if (velocityChange > 0) {
			throw new IllegalArgumentException();
		}
		
		if (velocity + velocityChange >= 0) {
			throw new IllegalArgumentException();
		}
		
		velocity += velocityChange;
	}
	
	@Override
	public String toString() {
		return "Bilen er laget av " + brand + " i " + productionYear;
	}
	 
	public static void main(String[] args) {
		Car car = new Car("", "Volvo", "", 2010, 0, 0);
		System.out.println(car);
		
		car.drive(10);
		System.out.println(car.getKmDriven());
		
		car.drive(-10);
	}

}
