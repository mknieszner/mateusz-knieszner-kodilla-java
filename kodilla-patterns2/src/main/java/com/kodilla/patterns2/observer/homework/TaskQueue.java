package com.kodilla.patterns2.observer.homework;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents Task Queue.
 */
public class TaskQueue implements Observabe {
  private final List<Observer> observers;
  private final List<String> tasks;
  private final String name;

  public TaskQueue(final String name) {
    this.observers = new ArrayList<>();
    this.tasks = new ArrayList<>();
    this.name = name;
  }

  public void addTask(final String task) {
    tasks.add(task);
    notifyObservers();
  }

  @Override
  public void registerObserver(final Observer observer) {
    observers.add(observer);
  }

  @Override
  public void removeObserver(final Observer observer) {
    observers.remove(observer);
  }

  @Override
  public void notifyObservers() {
    for (final Observer observer : observers) {
      observer.update(this);
    }
  }

  public List<String> getTasks() {
    return tasks;
  }

  public String getName() {
    return name;
  }
}
