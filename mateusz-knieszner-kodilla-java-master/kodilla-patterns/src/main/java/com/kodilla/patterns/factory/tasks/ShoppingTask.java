package com.kodilla.patterns.factory.tasks;

/**
 * Represents shopping task.
 */
public class ShoppingTask implements Task {
  private final String taskName;
  private final String whatToBuy;
  private final double quantity;
  private boolean isTaskExecuted = false;

  public ShoppingTask(final String taskName, final String whatToBuy, final double quantity) {
    this.taskName = taskName;
    this.whatToBuy = whatToBuy;
    this.quantity = quantity;
  }

  @Override
  public void executeTask() {
    System.out.printf("%s %.1f x %s. %n", taskName, quantity, whatToBuy);
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
