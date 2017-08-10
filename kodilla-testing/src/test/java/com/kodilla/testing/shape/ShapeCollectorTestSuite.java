package com.kodilla.testing.shape;

import org.junit.*;

/**
 * Test suite for classes of ShapeCollector.
 */
public class ShapeCollectorTestSuite {
    private ShapeCollector shapeCollector;

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
        Shape testShape = new Square(4);

        //When
        boolean result = shapeCollector.removeFigure(testShape);

        //Then
        Assert.assertFalse(result);
    }

    @Test
    public void testRemoveShape() {
        //Given
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
        shapeCollector.addShape(new Triangle(1, 3));

        //When
        Shape testShape = shapeCollector.getFigure(0);

        //Then
        Assert.assertEquals(new Triangle(1, 3), testShape);
    }

    @Test
    public void testShowFigures() {
        //Given
        shapeCollector.addShape(new Triangle(1, 3));

        //When
        String testShapeList = shapeCollector.showFigures();

        //Then
        Assert.assertEquals(new Triangle(1, 3).toString(), testShapeList);
    }
}
