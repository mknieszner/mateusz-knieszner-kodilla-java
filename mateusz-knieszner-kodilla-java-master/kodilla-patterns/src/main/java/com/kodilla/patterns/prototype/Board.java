package com.kodilla.patterns.prototype;

import java.util.HashSet;
import java.util.Set;

/**
 *
 */
public final class Board extends Prototype {
  String name;
  Set<TasksList> lists = new HashSet<>();

  public Board(final String name) {
    this.name = name;
  }

  public void setName(final String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public Set<TasksList> getLists() {
    return lists;
  }

  public Board shallowCopy() throws CloneNotSupportedException {
    return (Board) super.clone();
  }

  public Board deepCopy() throws CloneNotSupportedException {
    final Board clonedBoard = (Board) super.clone();
    clonedBoard.lists = new HashSet<>();
    for (final TasksList theList : lists) {
      final TasksList clonedList = new TasksList(theList.getName());
      for (final Task task : theList.getTasks()) {
        clonedList.getTasks().add(task);
      }
      clonedBoard.getLists().add(clonedList);
    }
    return clonedBoard;
  }
}