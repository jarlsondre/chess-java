package uke5;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MatteController {

	Matte matte = new Matte();
	
	@FXML TextField a;
	@FXML TextField b;
	@FXML Label svarFelt;
	
	@FXML void onPlus() {
		getFieldValues();
		svarFelt.setText(Double.toString(matte.pluss()));
		
//		System.out.println("Pluss trykket.");
//		svarFelt.setText("Pluss trykket. a = "+a.getText());
	}

	private void getFieldValues() {
		matte.setA(Double.parseDouble(a.getText()));
		matte.setB(Double.parseDouble(b.getText()));
	}
	
	@FXML void onMinus() {
		getFieldValues();
		svarFelt.setText(Double.toString(matte.minus()));
	}
	
	@FXML void onDivide() {
		getFieldValues();
		svarFelt.setText(Double.toString(matte.dele()));

		
	}
	
}
