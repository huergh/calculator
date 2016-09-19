package calculator.backend;

import java.math.BigDecimal;

public class Numbers implements MathematicalObject{
	private BigDecimal num;

	public Numbers(BigDecimal num) {
		this.num = num;
	}

	public BigDecimal getNum() {
		return num;
	}
	
	

}
