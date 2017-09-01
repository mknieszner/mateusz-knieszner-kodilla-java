package com.kodilla.spring.calculator;

import com.kodilla.spring.shape.Shape;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Test Suite for Calculator class.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculatorTestSuite {

  @Autowired
  private Calculator calculator;
  private double result;

  @Test
  public void addTest() {
    //Given

    //When
    result = calculator.add(1, 1);

    //Then
    Assert.assertEquals(2, result, 0.01);
  }

  @Test
  public void subTest() {
    //Given

    //When
    result = calculator.sub(1, 1);

    //Then
    Assert.assertEquals(0, result, 0.01);
  }

  @Test
  public void mulTest() {
    //Given

    //When
    result = calculator.mul(1, 1);

    //Then
    Assert.assertEquals(1, result, 0.01);
  }

  @Test
  public void divTest() {
    //Given

    //When
    result = calculator.div(3, 2);

    //Then
    Assert.assertEquals(1.5, result, 0.01);
  }

  @Test
  public void divNullTest() {
    //Given

    //When
    result = calculator.div(-3, 0);

    //Then
    Assert.assertEquals(Double.NEGATIVE_INFINITY, result, 0.01);
  }
}
