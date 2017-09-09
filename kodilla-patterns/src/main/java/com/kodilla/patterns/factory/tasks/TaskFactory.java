package com.kodilla.patterns.factory.tasks;

/**
 * Generates task objects.
 */
public class TaskFactory {
  public static final Task createTask(final Tasks task) {
    switch (task) {
      case DRIVING:
        return new DrivingTask(task.taskName, "Warsaw", "car");
      case PAINTING:
        return new PaintingTask(task.taskName, "blue", "wall");
      case SHOPPING:
        return new ShoppingTask(task.taskName, "laptop", 1);
      default:
        throw new IllegalArgumentException("Unknown task: " + task.taskName);
    }
  }

  /**
   * Tasks that can be used.
   */
  public enum Tasks {
    DRIVING("Driving"),
    PAINTING("Painting"),
    SHOPPING("Shopping");
    private final String taskName;

    Tasks(final String taskName) {
      this.taskName = taskName;
    }
  }
}