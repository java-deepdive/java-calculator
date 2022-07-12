package com.example.application;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OperandTest {
	@DisplayName("정수형 값을 인자로한 피연산자 생성")
	@Test
	void testCase1() {
		Operand operand = new Operand(5);
		assertThat(operand.value()).isEqualTo(5);
	}
	
	@DisplayName("문자열을 인자로한 피연산자 생성")
	@Test
	void testCase2() {
		Operand operand = new Operand("5");
		assertThat(operand.value()).isEqualTo(5);
	}
}