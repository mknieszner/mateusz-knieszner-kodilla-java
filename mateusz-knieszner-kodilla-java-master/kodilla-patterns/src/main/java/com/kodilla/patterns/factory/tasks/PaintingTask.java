package com.kodilla.patterns.factory.tasks;

/**
 * Represents painting task.
 */
public class PaintingTask implements Task {
  private final String taskName;
  private final String whatToPaint;
  private final String color;
  private boolean isTaskExecuted = false;


  public PaintingTask(final String taskName, final String color, final String whatToPaint) {
    this.taskName = taskName;
    this.whatToPaint = whatToPaint;
    this.color = color;
  }

  @Override
  public void executeTask() {
    System.out.printf("%s %s %s. %n", taskName, whatToPaint, color);
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
