package calculator.gui;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import calculator.backend.Calculator;
import calculator.backend.MathOp;
import calculator.backend.MathematicalObject;
import calculator.backend.Numbers;
import calculator.backend.Operator;
import calculator.gui.model.AppendableNumber;
import calculator.gui.model.AppendableNumberObserver;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class CalculatorController implements AppendableNumberObserver {
	
	private AppendableNumber displayContent = new AppendableNumber();
	
	private List<MathematicalObject> mathematicalObjects = new ArrayList<>();
	
	public CalculatorController() {
		displayContent.register(this);
	}
	
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
		mathematicalObjects.add(new Operator(MathOp.PLUS));
	}
	
	@FXML
	protected void buttonMinusPressed() {
		saveAndClearDisplayContent();
		mathematicalObjects.add(new Operator(MathOp.MINUS));
	}
	
	@FXML
	protected void buttonStarPressed() {
		saveAndClearDisplayContent();
		mathematicalObjects.add(new Operator(MathOp.STAR));
	}
	
	@FXML
	protected void buttonSlashPressed() {
		saveAndClearDisplayContent();
		mathematicalObjects.add(new Operator(MathOp.SLASH));
	}
	
	@FXML
	protected void buttonEqualsPressed() {
		saveAndClearDisplayContent();
		BigDecimal result = new Calculator(mathematicalObjects).evaluate();
		displayContent.setNumber(result);
	}
	
	@Override
	public void update(AppendableNumber number) {
		textDisplay.setText(displayContent.getAsText());
	}

	private void inputButtonPressed(String input) {
		displayContent.append(input);		
	}
	
	private void saveAndClearDisplayContent() {
		mathematicalObjects.add(new Numbers(displayContent.getAsNumber()));
		displayContent.clear();
	}
}
