package com.example.application;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class ArrayTest {
	private final List<String> items = new ArrayList<>();

	@Test
	void testCase1() {
		for(int i = 0 ; i < 100 ; i++) {
			items.add("" + i);
		}

		for(int i = 0 ; i < 100 ; i++) {
			items.remove(i);
		}
	}
}
