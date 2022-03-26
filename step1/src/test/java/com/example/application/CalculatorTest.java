package com.example.application;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

	@DisplayName("문자열 계산기 더하기 테스트")
	@Test
	void testCase1() {
		Calculator calculator = new Calculator();
		String calculate = calculator.calculate("1 + 2");

		assertThat(calculate).isEqualTo("3");
	}
}