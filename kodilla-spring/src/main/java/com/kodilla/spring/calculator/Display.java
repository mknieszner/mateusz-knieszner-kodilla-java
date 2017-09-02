package com.kodilla.spring.calculator;

import org.springframework.stereotype.Component;

import java.text.DecimalFormat;

/**
 * Calculator display.
 */
@Component
public class Display {

  public void displayValue(final double val) {
    final DecimalFormat df = new DecimalFormat();
    df.setMaximumFractionDigits(5);
    System.out.print(df.format(val));
  }
}
