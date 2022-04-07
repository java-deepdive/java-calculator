package com.example.application;

public class Calculator {
    private static final int ZERO_SIZE = 0;

	private Calculator() {
	}

	public static double calculate(Formula formula) {
        Operand result = formula.operand();
        while(formula.size() > ZERO_SIZE) {
            Operator operator = formula.operator();
            Operand operand = formula.operand();
            result = new Operand(operator.calculate(result, operand));
        }
        return result.value();
    }
}
