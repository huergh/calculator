package model;

import java.math.BigDecimal;

public class AppendableNumber {
	private String text = "";
	private BigDecimal number = new BigDecimal(0);

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
			return true;
		} catch (NumberFormatException ex) {
			return false;
		}
	}
}
