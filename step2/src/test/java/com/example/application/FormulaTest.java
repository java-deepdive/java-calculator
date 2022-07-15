package com.example.application;

import com.example.exception.NotCalculateFormulaException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertAll;

/**
 * '식'에 대한 검증이 필요한 부분
 *
 * 1. 연산자와 피 연산자에 대한 구분한다.
 * 2. 식은 피 연산자 > 연산자 > 피 연산자 순으로 나열한다.
 * 3. 홀수 개의 연산자와 짝수 개의 피 연산자를 포함한다.
 */
class FormulaTest {
	
	@DisplayName("식의 유효성 검사 실패 테스트")
	@Test
	void testCase1() {
		assertThatExceptionOfType(NotCalculateFormulaException.class)
			.isThrownBy(() -> new Formula("2", "+"));
	}
	
	private static Stream<Arguments> dummyOperand() {
		return Stream.of(
			Arguments.of("2", "-", "1"),
			Arguments.of("5", "+", "4")
		);
	}
	@DisplayName("식의 유효성 검사 성공 테스트")
	@MethodSource(value = "dummyOperand")
	@ParameterizedTest(name = "{0} {1} {2} 식에 대한 연산")
	void testCase2(String left, String operator, String right) {
		Formula formula = new Formula(left, operator, right);
		
		assertAll(
			() -> {
				Operand actual = formula.operand();
				double expected = Double.parseDouble(left);
				assertThat(actual.value()).isEqualTo(expected);
			},
			() -> {
				Operand actual = formula.operand();
				double expected = Double.parseDouble(right);
				assertThat(actual.value()).isEqualTo(expected);
			}
		);
	}
	
	@DisplayName("식에 대한 길이 검증")
	@MethodSource(value = "dummyOperand")
	@ParameterizedTest(name = "{0} {1} {2} 식에 대한 연산")
	void testCase3(String left, String operator, String right) {
		Formula formula = new Formula(left, operator, right);
		int size = formula.size();
		assertThat(size).isEqualTo(3);
	}
}
