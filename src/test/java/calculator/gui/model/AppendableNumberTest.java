package calculator.gui.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class AppendableNumberTest {
	
	@Test
	public void appendSingleDigitMultipleTimes() {
		AppendableNumber number = new AppendableNumber();
		number.append("4");
		number.append("5");
		number.append("3");
		
		assertEquals("should be 453", 453L, number.getAsNumber().longValue());
	}
	
	@Test
	public void appendMultipleDigits() {
		AppendableNumber number = new AppendableNumber();
		number.append("4");
		number.append("100");
		
		assertEquals("should be 4100", 4100L, number.getAsNumber().longValue());
	}

}
