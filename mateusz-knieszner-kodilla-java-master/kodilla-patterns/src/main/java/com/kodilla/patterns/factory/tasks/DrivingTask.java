package com.kodilla.patterns.factory.tasks;

/**
 * Represents driving task.
 */
public class DrivingTask implements Task {
  private final String taskName;
  private final String where;
  private final String using;
  private boolean isTaskExecuted = false;


  public DrivingTask(final String taskName, final String where, final String using) {
    this.taskName = taskName;
    this.where = where;
    this.using = using;
  }

  @Override
  public void executeTask() {
    System.out.printf("%s to %s using %s. %n", taskName, where, using);
    isTaskExecuted = true;
  }

  @Override
  public String getTaskName() {
    return taskName;
  }

  @Override
  public boolean isTaskExecuted() {
    return isTaskExecuted;
  }
}
