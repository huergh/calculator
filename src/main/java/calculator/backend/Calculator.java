package calculator.backend;

import java.util.List;
import java.math.BigDecimal;

public class Calculator {
	private List<MathematicalObject> inPut;
	// private ArrayList<MathematicalObject> inPut1;

	public Calculator(List<MathematicalObject> inPut) {
		this.inPut = inPut;
		// this.inPut1 = null;
	}

	public BigDecimal evaluate() {
		for (int i = 0; i < inPut.size(); i++) {
			//System.out.println("wieder if"+i);
			if (inPut.get(i) instanceof Operator) {
				//System.out.println("wieder if");
				Operator a1 = (Operator) inPut.get(i);
				MathOp a2 = a1.getMathOp();

				switch (a2) {
				case SLASH: {
					//System.out.println(inPut.size());
					Numbers a3 = (Numbers) inPut.get(i - 1);
					Numbers a4 = (Numbers) inPut.get(i + 1);

					BigDecimal a31 = a3.getNum();
					BigDecimal a41 = a4.getNum();
					inPut.set(i - 1, new Numbers(a31.divide(a41)));
					//System.out.println(inPut.size());
					//System.out.println(inPut.get(i-1));
					inPut.remove(i);
					inPut.remove(i);
					//System.out.println(inPut.size());
					i=i-1;
					break;
				}

				case STAR: {
					Numbers a3 = (Numbers) inPut.get(i - 1);
					Numbers a4 = (Numbers) inPut.get(i + 1);

					BigDecimal a31 = a3.getNum();
					BigDecimal a41 = a4.getNum();
					inPut.set(i - 1, new Numbers(a31.multiply(a41)));
					inPut.remove(i);
					inPut.remove(i);
					i=i-1;
					break;
				}

				case PLUS:
					break;
				case MINUS:
					break;
				}
			
			}
		//System.out.println("class"+inPut.get(i).getClass());	
		}

		for (int i = 0; i < inPut.size(); i++) {
			//System.out.println("second loop");
			if (inPut.get(i) instanceof Operator) {

				Operator b1 = (Operator) inPut.get(i);
				MathOp b2 = b1.getMathOp();

				switch (b2) {
				case PLUS: {
					Numbers b3 = (Numbers) inPut.get(i - 1);
					Numbers b4 = (Numbers) inPut.get(i + 1);

					BigDecimal b31 = b3.getNum();
					BigDecimal b41 = b4.getNum();
					inPut.set(i - 1, new Numbers(b31.add(b41)));
					inPut.remove(i);
					inPut.remove(i);
					i=i-1;
					break;
				}

				case MINUS: {
					Numbers b3 = (Numbers) inPut.get(i - 1);
					Numbers b4 = (Numbers) inPut.get(i + 1);

					BigDecimal b31 = b3.getNum();
					BigDecimal b41 = b4.getNum();
					inPut.set(i - 1, new Numbers(b31.subtract(b41)));
					inPut.remove(i);
					inPut.remove(i);
					i=i-1;
					break;
				}
				
				}
				
			}
		}
		//System.out.println("out loop");
		Numbers c = (Numbers) inPut.get(0);

		BigDecimal c1 = c.getNum();
		return c1;
	}
}
