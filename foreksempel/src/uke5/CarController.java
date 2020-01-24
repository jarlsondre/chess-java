package uke5;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CarController {

	@FXML
	TextField name;
	@FXML
	TextField age;
	@FXML
	Button button;
	@FXML
	Label carLabel;
	
	Car2 car2 = new Car2("MX34323",2);
	
	public void handleCLick() {
		int tmpage = Integer.parseInt(age.getText());
		Person p = new Person(name.getText(),tmpage);
		car2.placePerson(p);
		carLabel.setText(car2.toString());
		if (car2.isFull())
			button.setDisable(true);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
