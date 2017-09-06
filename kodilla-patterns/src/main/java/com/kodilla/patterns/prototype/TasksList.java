package com.kodilla.patterns.prototype;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public final class TasksList {
  final String name;
  final List<Task> tasks = new ArrayList<>();

  public TasksList(final String name) {
    this.name = name;
  }

  public List<Task> getTasks() {
    return tasks;
  }

  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    String s = String.format("   List [" + name + "]");
    for (final Task task : tasks) {
      s = String.format(s + "\n" + task.toString());
    }
    return s;
  }
}