package com.kodilla.patterns.factory.tasks;

/**
 * Generates task objects.
 */
public abstract class TaskFactory {
  /**
   * Types of task that can be used.
   */
  public enum TaskType {
    DRIVING("Driving"),
    PAINTING("Painting"),
    SHOPPING("Shopping");
    private final String taskName;

    TaskType(final String taskName) {
      this.taskName = taskName;
    }
  }

  public static final Task createTask(final TaskType taskType) {
    switch (taskType) {
      case DRIVING:
        return new DrivingTask(taskType.taskName, "Warsaw", "car");
      case PAINTING:
        return new PaintingTask(taskType.taskName, "blue", "wall");
      case SHOPPING:
        return new ShoppingTask(taskType.taskName, "laptop", 1);
      default:
        throw new IllegalArgumentException("Unknown task: " + taskType.taskName);
    }
  }
}