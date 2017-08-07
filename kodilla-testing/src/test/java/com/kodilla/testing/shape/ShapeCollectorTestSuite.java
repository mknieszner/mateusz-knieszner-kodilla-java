package com.kodilla.testing.shape;

import org.junit.*;

/**
 * Test suite for classes of ShapeCollector.
 */
public class ShapeCollectorTestSuite {

    @BeforeClass
    public static void beforeAllShapeCollectorTests() {
        System.out.println("This is the beginning of ShapeCollector tests.");
    }

    @AfterClass
    public static void afterAllShapeCollectorTests() {
        System.out.println("All ShapeCollector tests are finished.");
    }

    @Test
    public void testAddShape() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        //When
        shapeCollector.addShape(new Circle(4));
        //Then
        Assert.assertEquals(new Circle(4), shapeCollector.getFigure(0));
    }


    @Test
    public void testRemoveShapeNotExisting() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();

        //When
        boolean result = shapeCollector.removeFigure(new Square(4));

        //Then
        Assert.assertFalse(result);
    }

    @Test
    public void testRemoveShape() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        shapeCollector.addShape(new Circle(4));

        //When
        boolean result = shapeCollector.removeFigure(new Circle(4));

        //Then
        Assert.assertTrue(result);
        Assert.assertEquals(0, shapeCollector.size());
    }

    @Test
    public void testGetShape() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        shapeCollector.addShape(new Triangle(1, 3));

        //When
        Shape testShape = shapeCollector.getFigure(0);

        //Then
        Assert.assertEquals(new Triangle(1, 3), testShape);
    }
}
