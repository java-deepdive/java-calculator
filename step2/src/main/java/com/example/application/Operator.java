package com.example.application;

public class Operator {
    private final ArithmeticOperators value;

    public Operator(ArithmeticOperators value) {
        this.value = value;
    }

    public Operator(String input) {
        this(ArithmeticOperators.of(input));
    }

    public double calculate(Operand left, Operand right) {
        return Math.round(value.calculate(left, right) * 100) / 100.0;
    }
}
