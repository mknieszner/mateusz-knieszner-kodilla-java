package com.kodilla.spring.calculator;

import org.springframework.stereotype.Component;

/**
 * Calculator display.
 */
@Component
public class Display {

  public double displayValue(final double val) {
    System.out.println(val);
    return val;
  }
}
