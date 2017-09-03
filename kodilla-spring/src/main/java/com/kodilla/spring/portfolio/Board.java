package com.kodilla.spring.portfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * Represents task board.
 */
@Component
public class Board {
  private final TaskList toDoList;
  private final TaskList inProgressList;
  private final TaskList doneList;

  @Autowired
  public Board(@Qualifier("taskList1") final TaskList toDoList,
               @Qualifier("taskList2") final TaskList inProgressList,
               @Qualifier("taskList3") final TaskList doneList) {
    this.toDoList = toDoList;
    this.inProgressList = inProgressList;
    this.doneList = doneList;
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
