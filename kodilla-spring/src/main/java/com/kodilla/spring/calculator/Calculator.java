package com.kodilla.spring.calculator;

import org.springframework.beans.factory.annotation.Autowired;
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

  public final void add(final double a, final double b) {
    display.displayValue(a + b);
  }

  public void sub(final double a, final double b) {
    display.displayValue(a - b);
  }

  public void mul(final double a, final double b) {
    display.displayValue(a * b);
  }

  public void div(final double a, final double b) throws IllegalArgumentException {
    if (b == 0) {
      throw new IllegalArgumentException("Do not divide by zero!");
    }
    display.displayValue(a / b);
  }
}