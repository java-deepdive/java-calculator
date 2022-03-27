package com.example.application;

import com.example.exception.NotSupportedOperationException;

public class Calculator {

	public String calculate(String expression) {
		String[] strings = expression.split(" ");

		String value1 = strings[0];
		String express = strings[1];
		String value2 = strings[2];

		double result;

		switch (express) {
			case "+":
				result = Integer.parseInt(value1) + Integer.parseInt(value2);
				break;
			case "-":
				result = Integer.parseInt(value1) - Integer.parseInt(value2);
				break;
			case "*":
				result = Integer.parseInt(value1) * Integer.parseInt(value2);
				break;
			case "/":
				if(Double.parseDouble(value2) == 0) {
					throw new ArithmeticException("0으로 나눌 수 없습니다.");
				}
				result = Integer.parseInt(value1) / Double.parseDouble(value2);
				break;
			default:
				throw new NotSupportedOperationException(express);
		}
		return String.valueOf(result);
	}
}
