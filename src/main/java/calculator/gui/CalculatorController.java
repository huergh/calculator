package calculator.gui;

import java.util.ArrayList;
import java.util.List;

import calculator.backend.MathematicalObject;
import calculator.backend.Numbers;
import calculator.gui.model.AppendableNumber;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class CalculatorController {
	
	private AppendableNumber displayContent = new AppendableNumber();
	
	private List<MathematicalObject> mathematicalObjects = new ArrayList<>();
	
	@FXML
	TextField textDisplay;

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
	
	@FXML
	protected void buttonPointPressed() {
		inputButtonPressed(".");
	}
	
	@FXML
	protected void buttonPlusPressed() {
		saveAndClearDisplayContent();
	}
	
	@FXML
	protected void buttonMinusPressed() {
		saveAndClearDisplayContent();
	}
	
	@FXML
	protected void buttonStarPressed() {
		saveAndClearDisplayContent();
	}
	
	@FXML
	protected void buttonSlashPressed() {
		saveAndClearDisplayContent();
	}

	private void inputButtonPressed(String input) {
		displayContent.append(input);
		textDisplay.setText(displayContent.getAsText());
	}
	
	private void saveAndClearDisplayContent() {
		mathematicalObjects.add(new Numbers(displayContent.getAsNumber()));
		displayContent.clear();
	}
}
