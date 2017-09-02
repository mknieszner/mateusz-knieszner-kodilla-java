package com.kodilla.spring.calculator;

import com.kodilla.spring.shape.Shape;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

/**
 * Test Suite for Calculator class.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculatorTestSuite {

  @Autowired
  private Calculator calculator;

  @Rule
  public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

  @Test
  public void addTest() {
    //Given
    final String expectedResult = "2";

    //When
    calculator.add(1, 1);

    //Then
    assertEquals(expectedResult, systemOutRule.getLogWithNormalizedLineSeparator());
  }

  @Test
  public void subTest() {
    //Given
    final String expectedResult = "0";

    //When
    calculator.sub(1, 1);

    //Then
    assertEquals(expectedResult, systemOutRule.getLogWithNormalizedLineSeparator());
  }

  @Test
  public void mulTest() {
    //Given
    final String expectedResult = "1";

    //When
    calculator.mul(1, 1);

    //Then
    assertEquals(expectedResult, systemOutRule.getLogWithNormalizedLineSeparator());
  }

  @Test
  public void divTest() {
    //Given
    final String expectedResult = "1,5";

    //When
    calculator.div(3, 2);

    //Then
    assertEquals(expectedResult, systemOutRule.getLogWithNormalizedLineSeparator());
  }

  @Rule
  public ExpectedException expectedEx = ExpectedException.none();

  @Test
  public void divNullTest() {
    //Given
    expectedEx.expect(IllegalArgumentException.class);
    expectedEx.expectMessage("Do not divide by zero!");

    //When
    calculator.div(-3, 0);

    //Then
    //Exception should be thrown.
  }
}
