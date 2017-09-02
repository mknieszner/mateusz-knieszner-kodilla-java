package com.kodilla.spring.portfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Represents task list.
 */
public class TaskList {

  private final List<Task> tasks;

  public TaskList() {
    this.tasks = new ArrayList<>();
  }

  public void addTask(final Task task) {
    tasks.add(task);
  }

  public List<Task> getTasks() {
    return Collections.unmodifiableList(tasks);
  }
}
