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
	Button driverButton;
	@FXML
	Button hikerButton;
	@FXML
	Label carLabel;
	
	Car car;
	
	@FXML
	public void onHikerClick() {
		int tmpage = Integer.parseInt(age.getText());
		Person p = new Person(name.getText(),tmpage);
		car.addHiker(p);
		carLabel.setText(car.toString());
		
		// Jeg har lyst til å sette knappen til uvirksom dersom det er fullt i bilen.
		if (car.isFull()) {
			hikerButton.setDisable(true);
			carLabel.setText("Bilen er full!\n"+carLabel.getText());
		}
	}


	@FXML

	public void onDriverClick() {
		int tmpage = Integer.parseInt(driverAge.getText());
		Person p = new Person(driverName.getText(),tmpage);
		if (car.setDriver(p))
			carLabel.setText(car.toString());
		else {
			carLabel.setText(p.getName() + " er for ung til å kjøre!\n"+car);
		}
			
	}

	/**
	 * initialize kalles etter at GUIen er satt opp. Her kan vi 
	 * sette opp de objektene vi har behov for i den tilstanden
	 * de skal være. Når navnet på metoden er initialize() vil 
	 * den automatisk kalles, en trenger ikke gjøre noe med
	 * FXML-dokumentet.
	 */
	@FXML
	void initialize() {
		System.out.println("Initialiserer....");
		System.out.println("car før vi lager den: "+car);
		car = new Car("MX34323",3);
		System.out.println("car etter at den er laget: "+car);
	}
	
	public static void main(String[] args) {
		Car c = new Car("AA34533", 4);
		System.out.println(c);
	}

}
