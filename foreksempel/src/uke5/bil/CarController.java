package uke5.bil;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CarController {

	Car car = new Car("MX45345",5);
	
	@FXML TextField carPlate;
	@FXML TextField carSeats;
	@FXML Button registerCar;
	@FXML TextField driverName;
	@FXML TextField driverAge;
	@FXML Button registerDriver;
	@FXML TextField hikerName;
	@FXML TextField hikerAge;
	@FXML Button registerHiker;

	@FXML Label carInfo;
	
	@FXML void handleCar() {
		System.out.println("Hallo???");
		String regnr = carPlate.getText();
		int plasser = Integer.parseInt(carSeats.getText());
		car = new Car(regnr,plasser);
		carInfo.setText(car.toString());
	}
	@FXML void handleDriver() {
		System.out.println("Hallo???");
		String tmpnavn = driverName.getText();
		int tmpalder = Integer.parseInt(driverAge.getText());
		Person tmpdriver = new Person(tmpnavn,tmpalder);
		car.setDriver(tmpdriver);
		carInfo.setText("DriverPressed"+car.toString());
		System.out.println(car);
	}
	@FXML void handleHiker() {
//		System.out.println("Hallo???");
//		String regnr = carPlate.getText();
//		int plasser = Integer.parseInt(carSeats.getText());
//		car = new Car(regnr,plasser);
		carInfo.setText("HikerPressed"+car.toString());
	}
	
}
