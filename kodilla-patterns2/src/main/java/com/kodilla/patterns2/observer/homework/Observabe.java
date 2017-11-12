package com.kodilla.patterns2.observer.homework;

/**
 * Observable interface for Task Queue.
 */
public interface Observabe {
  void registerObserver(Observer observer);
  void removeObserver(Observer observer);
  void notifyObservers();
}
