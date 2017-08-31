package com.kodilla.spring.calculator;

import com.kodilla.spring.shape.Shape;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
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
    private ApplicationContext context =
            new AnnotationConfigApplicationContext("com.kodilla.spring.calculator");
    private Calculator calculator = context.getBean(Calculator.class);
    private double expectedResult;

    @Test
    public void addTest() {
        //Given

        //When
        expectedResult = calculator.add(1, 1);

        //Then
        Assert.assertEquals(2, expectedResult, 0.01);
    }

    @Test
    public void subTest() {
        //Given

        //When
        expectedResult = calculator.sub(1, 1);

        //Then
        Assert.assertEquals(0, expectedResult, 0.01);
    }

    @Test
    public void mulTest() {
        //Given

        //When
        expectedResult = calculator.mul(1, 1);

        //Then
        Assert.assertEquals(1, expectedResult, 0.01);
    }

    @Test
    public void divTest() {
        //Given

        //When
        expectedResult = calculator.div(3, 2);

        //Then
        Assert.assertEquals(1.5, expectedResult, 0.01);
    }

    @Test
    public void divNullTest() {
        //Given

        //When
        expectedResult = calculator.div(-3, 0);

        //Then
        Assert.assertEquals(Double.NEGATIVE_INFINITY, expectedResult, 0.01);
    }
}
