package calculator.gui;

import javafx.fxml.FXML;
import model.AppendableNumber;

public class CalculatorController {
	
	private AppendableNumber displayContent = new AppendableNumber();

	@FXML
	protected void buttonZeroPressed() {
		inputButtonPressed("0");
	}
	
	@FXML
	protected void buttonOnePressed() {
		inputButtonPressed("1");
	}
	
	@FXML
	protected void buttonTwoPressed() {
		inputButtonPressed("2");
	}
	
	@FXML
	protected void buttonThreePressed() {
		inputButtonPressed("3");
	}
	
	@FXML
	protected void buttonFourPressed() {
		inputButtonPressed("4");
	}
	
	@FXML
	protected void buttonFivePressed() {
		inputButtonPressed("5");
	}
	
	@FXML
	protected void buttonSixPressed() {
		inputButtonPressed("6");
	}
	
	@FXML
	protected void buttonSevenPressed() {
		inputButtonPressed("7");
	}
	
	@FXML
	protected void buttonEightPressed() {
		inputButtonPressed("8");
	}
	
	@FXML
	protected void buttonNinePressed() {
		inputButtonPressed("9");
	}

	private void inputButtonPressed(String input) {
		displayContent.append(input);
	}
}
