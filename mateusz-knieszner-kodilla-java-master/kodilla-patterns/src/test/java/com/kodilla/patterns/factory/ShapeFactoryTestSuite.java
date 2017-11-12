package com.kodilla.patterns.factory;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 */
public class ShapeFactoryTestSuite {
  @Test
  public void testFactoryCircle() {
    //Given
    final ShapeFactory factory = new ShapeFactory();
    //When
    final Shape circle = factory.makeShape(ShapeFactory.CIRCLE);
    //Then
    Assert.assertEquals(Math.PI * Math.pow(4.50, 2.0), circle.getField(), 0);
    Assert.assertEquals("The rounded circle", circle.getName());
  }

  @Test
  public void testFactorySquare() {
    //Given
    final ShapeFactory factory = new ShapeFactory();
    //When
    final Shape square = factory.makeShape(ShapeFactory.SQUARE);
    //Then
    Assert.assertEquals(28.0, square.getCircumference(), 0);
    Assert.assertEquals("The angular square", square.getName());
  }

  @Test
  public void testFactoryRectangle() {
    //Given
    final ShapeFactory factory = new ShapeFactory();
    //When
    final Shape rectangle = factory.makeShape(ShapeFactory.RECTANGLE);
    //Then
    Assert.assertEquals(37.50, rectangle.getField(), 0);
    Assert.assertEquals("The long rectangle", rectangle.getName());
  }
}