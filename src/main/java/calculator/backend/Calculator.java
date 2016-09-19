package calculator.backend;

import java.util.ArrayList;
import java.math.BigDecimal;

public class Calculator {
	private ArrayList<MathematicalObject> inPut;
	// private ArrayList<MathematicalObject> inPut1;

	public Calculator(ArrayList<MathematicalObject> inPut) {
		this.inPut = inPut;
		// this.inPut1 = null;
	}

	public BigDecimal evaluate() {
		for (int i = 0; i < inPut.size(); i++) {
			if (inPut.get(i) instanceof Operator) {

				Operator a1 = (Operator) inPut.get(i);
				MathOp a2 = a1.getMathOp();

				switch (a2) {
				case SLASH: {
					Numbers a3 = (Numbers) inPut.get(i - 1);
					Numbers a4 = (Numbers) inPut.get(i + 1);

					BigDecimal a31 = a3.getNum();
					BigDecimal a41 = a4.getNum();
					inPut.set(i - 1, new Numbers(a31.divide(a41)));
					inPut.remove(i);
					inPut.remove(i + 1);
					break;
				}

				case STAR: {
					Numbers a3 = (Numbers) inPut.get(i - 1);
					Numbers a4 = (Numbers) inPut.get(i + 1);

					BigDecimal a31 = a3.getNum();
					BigDecimal a41 = a4.getNum();
					inPut.set(i - 1, new Numbers(a31.multiply(a41)));
					inPut.remove(i);
					inPut.remove(i + 1);
					break;
				}

				case PLUS:
					break;
				case MINUS:
					break;
				}

			}
		}

		for (int i = 0; i < inPut.size(); i++) {
			if (inPut.get(i) instanceof Operator) {

				Operator a1 = (Operator) inPut.get(i);
				MathOp a2 = a1.getMathOp();

				switch (a2) {
				case PLUS: {
					Numbers a3 = (Numbers) inPut.get(i - 1);
					Numbers a4 = (Numbers) inPut.get(i + 1);

					BigDecimal a31 = a3.getNum();
					BigDecimal a41 = a4.getNum();
					inPut.set(i - 1, new Numbers(a31.add(a41)));
					inPut.remove(i);
					inPut.remove(i + 1);
					break;
				}

				case MINUS: {
					Numbers a3 = (Numbers) inPut.get(i - 1);
					Numbers a4 = (Numbers) inPut.get(i + 1);

					BigDecimal a31 = a3.getNum();
					BigDecimal a41 = a4.getNum();
					inPut.set(i - 1, new Numbers(a31.subtract(a41)));
					inPut.remove(i);
					inPut.remove(i + 1);
					break;
				}

				}

			}
		}
		
		Numbers a3 = (Numbers) inPut.get(0);

		BigDecimal a31 = a3.getNum();
		return a31;
	}
}
