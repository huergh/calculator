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
	
	@Test
	public void appendWithPoint() {
		AppendableNumber number = new AppendableNumber();
		number.append("4");
		number.append(".");
		number.append("6");
		
		assertEquals("should be approx. 4.6", 4.6, number.getAsNumber().doubleValue(), 0.0000001);
	}
	
	
	@Test
	public void shouldntAcceptTwoPoints() {
		AppendableNumber number = new AppendableNumber();
		number.append("4");
		number.append(".");
		number.append("6");
		number.append(".");
		number.append("1");
		
		assertEquals("should be approx. 4.61", 4.61, number.getAsNumber().doubleValue(), 0.0000001);
	}
	
	@Test
	public void shouldntAcceptComma() {
		AppendableNumber number = new AppendableNumber();
		number.append("4");
		number.append(",");
		number.append("6");
		
		assertEquals("should be 46", 46L, number.getAsNumber().longValue());
	}
}
