package com.kodilla.patterns.factory.tasks;

import com.kodilla.patterns.factory.Shape;
import com.kodilla.patterns.factory.ShapeFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Test Suite for factory class.
 */
public class TaskFactoryTestSuite {
  private static final boolean EXPECTED_BOOLEAN = true;

  @Test
  public void testShoppingTaskFactoryTest() {
    //Given
    final Task shoppingTask;

    //When
    shoppingTask = TaskFactory.createTask(TaskFactory.Tasks.SHOPPING);
    shoppingTask.executeTask();
    final String expectedName = "Shopping";

    //Then
    Assert.assertEquals(expectedName, shoppingTask.getTaskName());
    Assert.assertEquals(EXPECTED_BOOLEAN, shoppingTask.isTaskExecuted());
  }

  @Test
  public void testPaintingTaskFactoryTest() {
    //Given
    final Task paintingTask;

    //When
    paintingTask = TaskFactory.createTask(TaskFactory.Tasks.PAINTING);
    paintingTask.executeTask();
    final String expectedName = "Painting";

    //Then
    Assert.assertEquals(expectedName, paintingTask.getTaskName());
    Assert.assertEquals(EXPECTED_BOOLEAN, paintingTask.isTaskExecuted());
  }

  @Test
  public void testDrivingTaskFactoryTest() {
    //Given
    final Task drivingTask;

    //When
    drivingTask = TaskFactory.createTask(TaskFactory.Tasks.DRIVING);
    drivingTask.executeTask();
    final String expectedName = "Driving";

    //Then
    Assert.assertEquals(expectedName, drivingTask.getTaskName());
    Assert.assertEquals(EXPECTED_BOOLEAN, drivingTask.isTaskExecuted());
  }
}