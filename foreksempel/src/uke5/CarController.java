package uke5;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CarController {

	@FXML
	TextField driverName;
	@FXML
	TextField driverAge;
	@FXML
	TextField name;
	@FXML
	TextField age;
	@FXML
	Button button;
	@FXML
	Label carLabel;
	
	Car car = new Car("MX34323",3);
	
	public void handleHCLick() {
		int tmpage = Integer.parseInt(age.getText());
		Person p = new Person(name.getText(),tmpage);
		car.addHiker(p);
		carLabel.setText(car.toString());
		
		// Jeg har lyst til å sette knappen til uvirksom dersom det er fullt i bilen.
		if (car.isFull()) {
			button.setDisable(true);
			carLabel.setText("Bilen er full!\n"+carLabel.getText());
		}
	}

	public void handleDCLick() {
		int tmpage = Integer.parseInt(driverAge.getText());
		Person p = new Person(driverName.getText(),tmpage);
		car.setDriver(p);
		carLabel.setText(car.toString());
		
		// Jeg har lyst til å sette knappen til uvirksom dersom det er fullt i bilen.
		if (car.isFull()) {
			button.setDisable(true);
			carLabel.setText("Bilen er full!\n"+carLabel.getText());
		}
	}

	
	public static void main(String[] args) {
		Car c = new Car("AA34533", 4);
		System.out.println(c);
	}

}
