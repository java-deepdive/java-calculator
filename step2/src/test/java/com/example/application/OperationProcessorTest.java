package com.example.application;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class OperationProcessorTest {
	
	@DisplayName("연산자 검증 테스트")
	@ParameterizedTest(name = "{0} 산술 연산 가능한 연산자 테스트")
	@ValueSource(strings = {"+", "*", "/", "-"})
	void testCase1(String operator) {
		boolean actual = OperationProcessor.isOperator(operator);
		assertThat(actual).isTrue();
	}
	
	@DisplayName("연산자 검증 실패 테스트")
	@NullAndEmptySource
	@ParameterizedTest(name = "'{0}' 값 확인 ")
	void testCase2(String operator) {
		boolean actual = OperationProcessor.isOperator(operator);
		assertThat(actual).isFalse();
	}
}