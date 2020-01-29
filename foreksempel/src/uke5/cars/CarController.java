package uke5.cars;

import java.util.ArrayList;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CarController {

	Car	car;
	List<Car> cars = new ArrayList<>();
	
	@FXML TextField carPlate;
	@FXML TextField carSeats;
	@FXML TextField driverName;
	@FXML TextField driverAge;
	@FXML TextField hikerName;
	@FXML TextField hikerAge;
	@FXML TextField removeHiker;
	@FXML Label carInfo;
	@FXML Label ageInfo;
	@FXML Button setDriver;
	@FXML Button addHiker;
	@FXML Button setCar;
	@FXML Button removeHikerButton;
	
	
	@FXML void handleSetCar() {
		String plate = carPlate.getText();
		
		Car tmpcar = this.getCar(plate);
		if (tmpcar != null) {
			car = tmpcar; // Den finnes
		}
		else {
			System.out.println("Ny bil!");
			car = new Car(carPlate.getText(),Integer.parseInt(carSeats.getText()));
			cars.add(car);
		}
		carInfo.setText(car.toString());
		ageInfo.setText(Integer.toString(car.totalAge()));
	}

	private Car getCar(String plate) {
		for (Car carOrig : cars) {
			System.out.println(carOrig.getPlate().toString()+" : "+plate);
			if (carOrig.getPlate().toString().equals(plate)) {
				System.out.println("Funnet: "+carOrig);
				return carOrig;
			}
		}
		return null;
	}
	

	@FXML void handleRemoveHiker() {
		car.removeHiker(this.getHiker(removeHiker.getText()));
		car.setDriver(new Person(driverName.getText(), Integer.parseInt(driverAge.getText())));
		carInfo.setText(car.toString());
		ageInfo.setText(Integer.toString(car.totalAge()));
	}

	
	private Person getHiker(String name) {
		return car.getHiker(name);
	}

	@FXML void handleSetDriver() {
		car.setDriver(new Person(driverName.getText(), Integer.parseInt(driverAge.getText())));
		carInfo.setText(car.toString());
		ageInfo.setText(Integer.toString(car.totalAge()));
	}

	@FXML void handleAddHiker() {
		car.addHiker(new Person(hikerName.getText(), Integer.parseInt(hikerAge.getText())));
		carInfo.setText(car.toString());
		if (car.isFull())
			addHiker.setDisable(true);
		ageInfo.setText(Integer.toString(car.totalAge()));
	}

}
