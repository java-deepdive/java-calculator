package com.example.application;

import com.example.exception.NotSupportedOperationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;


@DisplayName("문자열 계산기 테스트")
class CalculatorTest {

	private Calculator calculator;

	@BeforeEach
	void setUp() {
		calculator = new Calculator();
	}

	@DisplayName("더하기 테스트")
	@Test
	void testCase1() {
		String actual = calculator.calculate("1 + 2");

		assertThat(actual).isEqualTo("3.0");
	}

	@DisplayName("빼기 테스트")
	@Test
	void testCase2() {
		String actual = calculator.calculate("1 - 2");

		assertThat(actual).isEqualTo("-1.0");
	}

	@DisplayName("곱하기 테스트")
	@Test
	void testCase3() {
		String actual = calculator.calculate("1 * 2");

		assertThat(actual).isEqualTo("2.0");
	}

	@DisplayName("나누기 테스트")
	@Test
	void testCase4() {
		String actual = calculator.calculate("1 / 2");

		assertThat(actual).isEqualTo("0.5");
	}

	@DisplayName("나누기 테스트")
	@Test
	void testCase4_1() {
		assertThatExceptionOfType(ArithmeticException.class)
				.isThrownBy(() -> calculator.calculate("1 / 0"));
	}

	@DisplayName("지원되지 않은 연산 테스트")
	@Test
	void testCase5() {
		assertThatExceptionOfType(NotSupportedOperationException.class)
				.isThrownBy(() -> calculator.calculate("1 ? 2"));
	}
}