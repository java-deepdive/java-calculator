package com.example.application;

import com.example.exception.NotSupportedOperationException;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

public enum ArithmeticOperators {
	PLUS("+", (left, right) -> left + right),
	SUBTRACT("-", (left, right) -> (left - right)),
	MULTIPLY("*", (left, right) -> (left * right)),
	DIVIDE("/", (left, right) -> {
		double result = left / right;
		if (Double.isInfinite(result)) {
			throw new ArithmeticException("0으로는 나눌 수 없습니다.");
		}
		return result;
	});

	private static final String OPERATOR_VALUE = "^[\\+\\-\\*\\/]$";
	private final String operator;
	private final BiFunction<Double, Double, Double> expression;

	ArithmeticOperators(String operator, BinaryOperator<Double> expression) {
		this.operator = operator;
		this.expression = expression;
	}

	public static ArithmeticOperators of(String operator) {
		return Arrays.stream(values())
				.filter(op -> op.operator.equals(operator))
				.findFirst()
				.orElseThrow(() -> new NotSupportedOperationException(operator));
	}

	public static boolean isOperator(String userInput) {
		return userInput.matches(OPERATOR_VALUE);
	}

	public double calculate(Operand left, Operand right) {
		return expression.apply(left.value(), right.value());
	}
}