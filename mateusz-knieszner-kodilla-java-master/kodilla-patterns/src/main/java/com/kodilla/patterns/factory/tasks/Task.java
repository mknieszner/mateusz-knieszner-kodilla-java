package com.kodilla.patterns.factory.tasks;

/**
 * Provides essential task methods.
 */
public interface Task {
  void executeTask();

  String getTaskName();

  boolean isTaskExecuted();
}
