package com.example.application;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class OperatorTest {
	
	@DisplayName("더하기 테스트")
	@ParameterizedTest(name = "{0} + {1} = {2} 합산 테스트")
	@CsvSource(value = {"1, 2, 3", "2, 5, 7"})
	void testCase1(Operand operand, Operand operand2, double sum) {
		double actual = OperationProcessor.of("+").calculate(operand, operand2);
		assertThat(actual).isEqualTo(sum);
	}
	
	@DisplayName("연산 테스트")
	@MethodSource(value = "sampleOperators")
	@ParameterizedTest
	void testCase3(OperationProcessor op, int left, int right, double expected) {
		Operator operator = new Operator(op);
		
		double actual = operator.calculate(new Operand(left), new Operand(right));
		
		assertThat(actual).isEqualTo(expected);
	}
	
	public static Stream<Arguments> sampleOperators() {
		return Stream.of(
			Arguments.of(OperationProcessor.DIVIDE, 5, 3, 1.67),
			Arguments.of(OperationProcessor.PLUS, 5, 5, 10),
			Arguments.of(OperationProcessor.SUBTRACT, 12, 3, 9),
			Arguments.of(OperationProcessor.MULTIPLY, 6, 7, 42)
		);
	}
}