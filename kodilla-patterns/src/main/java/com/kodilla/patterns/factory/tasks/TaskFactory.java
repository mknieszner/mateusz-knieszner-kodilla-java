package com.kodilla.patterns.factory.tasks;

/**
 * Generates task objects.
 */
public enum TaskFactory {
  DRIVING("Driving"),
  PAINTING("Painting"),
  SHOPPING("Shopping");

  private final String taskName;

  TaskFactory(final String taskName) {
    this.taskName = taskName;
  }

  public final Task createTask() {
    switch (this) {
      case DRIVING:
        return new DrivingTask(DRIVING.taskName, "Warsaw", "car");
      case PAINTING:
        return new PaintingTask(PAINTING.taskName, "blue", "wall");
      case SHOPPING:
        return new ShoppingTask(SHOPPING.taskName, "laptop", 1);
      default:
        throw new IllegalArgumentException("Unknown task: " + this);
    }
  }
}