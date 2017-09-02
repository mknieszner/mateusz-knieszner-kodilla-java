package com.kodilla.spring;

import com.kodilla.spring.shape.Shape;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Test Suite for SpringRunner class.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringRunnerTestSuite {

  @Autowired
  private ApplicationContext context;

  @Test
  public void testCircleLoadedIntoContainer() {
    //Given
    final Shape shape = (Shape) context.getBean("circle");

    //When
    final String name = shape.getShapeName();

    //Then
    Assert.assertEquals("This is a circle.", name);
  }

  @Test
  public void testRectangleLoadedIntoContainer() {
    //Given
    final Shape shape = (Shape) context.getBean("triangle");

    //When
    final String name = shape.getShapeName();

    //Then
    Assert.assertEquals("This is a triangle.", name);
  }

  @Test
  public void testSquareLoadedIntoContainer() {
    //Given
    final Shape shape = (Shape) context.getBean("createSquare");

    //When
    final String name = shape.getShapeName();

    //Then
    Assert.assertEquals("This is a square.", name);
  }

  @Test
  public void testShapeLoadedIntoContainer() {
    //Given
    final Shape shape = (Shape) context.getBean("choosenShape");

    //When
    final String name = shape.getShapeName();

    //Then
    System.out.println("Choosen shape says: " + name);
  }
}