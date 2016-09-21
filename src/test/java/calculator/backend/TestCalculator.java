package calculator.backend;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.junit.Test;

public class TestCalculator {
	
	@Test
	public void testJunit(){
		assertEquals(3,3);
	}
	
	@Test
	public void testEvaluate(){
		ArrayList<MathematicalObject> testInput = new ArrayList<MathematicalObject>();
		//BigDecimal.valueOf(12.3)
		testInput.add(new Numbers(BigDecimal.valueOf(12)));
		testInput.add(new Operator(MathOp.SLASH));
		testInput.add(new Numbers(BigDecimal.valueOf(4)));
		testInput.add(new Operator(MathOp.SLASH));
		testInput.add(new Numbers(BigDecimal.valueOf(2)));
		testInput.add(new Operator(MathOp.SLASH));
		testInput.add(new Numbers(BigDecimal.valueOf(3)));
		testInput.add(new Operator(MathOp.STAR));
		testInput.add(new Numbers(BigDecimal.valueOf(3)));
		testInput.add(new Operator(MathOp.MINUS));
		testInput.add(new Numbers(BigDecimal.valueOf(2)));
		testInput.add(new Operator(MathOp.PLUS));
		testInput.add(new Numbers(BigDecimal.valueOf(10)));
		
		Calculator a = new Calculator(testInput);
		BigDecimal a1 = a.evaluate();
		
		
		assertEquals(9.5, a1.doubleValue(),0.00001);
	}

}
