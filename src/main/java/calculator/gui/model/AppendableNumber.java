package calculator.gui.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class AppendableNumber {
	private String text = "";
	private BigDecimal number = new BigDecimal(0);
	private List<AppendableNumberObserver> observers = new ArrayList<>();

	public String getAsText() {
		return text;
	}

	public BigDecimal getAsNumber() {
		return number;
	}

	public boolean append(String s) {
		String intermediateText = text + s;
		try {
			BigDecimal intermediateNumber = new BigDecimal(intermediateText);
			text = intermediateText;
			number = intermediateNumber;
			updateAll();
			return true;
		} catch (NumberFormatException ex) {
			return false;
		}		
	}

	public void setNumber(BigDecimal number) {
		this.number = number;
		this.text = number.toString();
		updateAll();
	}
	
	public void clear() {
		text = "";
		number = new BigDecimal(0);
		updateAll();
	}
	
	public void register(AppendableNumberObserver observer) {
		observers.add(observer);
	}
	
	private void updateAll() {
		observers.forEach(observer -> observer.update(this));
	}
}
