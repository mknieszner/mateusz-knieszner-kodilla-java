package com.kodilla.spring.calculator;

import org.springframework.stereotype.Component;

/**
 * Calculator class.
 */
@Component
public class Calculator {
    private final Display display;

    public Calculator(final Display display) {
        this.display = display;
    }

    public double add(double a, double b) {
        return display.displayValue(a + b);
    }

    public double sub(double a, double b) {
        return display.displayValue(a - b);
    }

    public double mul(double a, double b) {
        return display.displayValue(a * b);
    }

    public double div(double a, double b) {
        if (b == 0) {
            return Double.POSITIVE_INFINITY * a;
        }
        return display.displayValue(a / b);
    }
}
