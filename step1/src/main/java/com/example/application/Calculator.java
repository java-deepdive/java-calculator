package com.example.application;

public class Calculator {

	public String calculate(String expression) {
		String[] strings = expression.split(" ");

		String value1 = strings[0];
		String express = strings[1];
		String value2 = strings[2];

		int result = 0;

		switch (express) {
			case "+":
				result = Integer.parseInt(value1) + Integer.parseInt(value2);
				break;
		}
		return String.valueOf(result);
	}
}
