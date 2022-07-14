package com.example.application;

import com.example.exception.NotCalculateFormulaException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class FormulaTest {
	
	@DisplayName("공식의 유효성 검사 테스트")
	@Test
	void testCase1() {
		assertThatExceptionOfType(NotCalculateFormulaException.class)
			.isThrownBy(() -> new Formula("2", "+"));
	}
}