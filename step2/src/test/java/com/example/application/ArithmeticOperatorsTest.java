package com.example.application;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class ArithmeticOperatorsTest {

	@DisplayName("더하기 테스트")
	@ParameterizedTest(name = "{0} + {1} = {2} 합산 테스트")
	@CsvSource(value = {"1, 2, 3", "2, 5, 7"})
	void testCase1(Operand operand, Operand operand2, double sum) {
		double actual = ArithmeticOperators.of("+").calculate(operand, operand2);
		assertThat(actual).isEqualTo(sum);
	}

	@DisplayName("연산자 검증 테스트")
	@ParameterizedTest(name = "{0} 산술 연산 가능한 연산자 테스트")
	@ValueSource(strings = {"+", "*", "/", "-"})
	void testCase2(String operator) {
		boolean actual = ArithmeticOperators.isOperator(operator);
		assertThat(actual).isTrue();
	}
	
}