package com.kodilla.spring.portfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * Represents task board.
 */
public class Board {
  private final TaskList toDoList;
  private final TaskList inProgressList;
  private final TaskList doneList;

  public Board() {
    this.toDoList = new TaskList();
    this.inProgressList = new TaskList();
    this.doneList = new TaskList();
  }

  public void addToToDoList(final Task task) {
    toDoList.addTask(task);
  }

  public void addToInProgressList(final Task task) {
    inProgressList.addTask(task);
  }

  public void addToDoneList(final Task task) {
    doneList.addTask(task);
  }

  public TaskList getDoneList() {
    return doneList;
  }
}
