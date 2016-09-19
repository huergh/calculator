package calculator.backend;

public class Operator implements MathematicalObject {
	private MathOp mathOp;

	public Operator(MathOp mathOp) {
		this.mathOp = mathOp;
		}

	public MathOp getMathOp() {
		return mathOp;
	}
	
	

}
