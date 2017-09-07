package com.kodilla.patterns.factory.tasks;

import com.kodilla.patterns.factory.Circle;
import com.kodilla.patterns.factory.Rectangle;
import com.kodilla.patterns.factory.Shape;
import com.kodilla.patterns.factory.Square;

/**
 * Generates task objects.
 */
public class TaskFactory {
  static final String DRIVING = "Driving";
  static final String PAINTING = "Painting";
  static final String SHOPPING = "Shopping";

  public final Task createTask(final String taskName) {
    switch (taskName) {
      case DRIVING:
        return new DrivingTask(DRIVING, "Warsaw", "car");
      case PAINTING:
        return new PaintingTask(PAINTING, "blue", "wall");
      case SHOPPING:
        return new ShoppingTask(SHOPPING, "laptop", 1);
      default:
        return null;
    }
  }
}

