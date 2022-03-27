package com.example;

import com.example.application.Calculator;

import java.util.Scanner;

public class CalcApplication {

	public static void main(String[] args) {
		System.out.println("계산기 프로그램 시작");
		Calculator calculator = new Calculator();

		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("메뉴 1. 계산, 2. 종료");
			String flag = scanner.nextLine();
			if("2".equals(flag)) {
				break;
			}
			System.out.print("연산 식 입력: ");
			String line = scanner.nextLine();
			String calculate = calculator.calculate(line);
			System.out.println("calculate = " + calculate);
		}

		System.out.println("계산기 프로그램 종료");
	}
}
