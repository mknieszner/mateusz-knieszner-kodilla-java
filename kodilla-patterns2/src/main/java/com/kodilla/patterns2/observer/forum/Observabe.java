package com.kodilla.patterns2.observer.forum;

/**
 *
 */
public interface Observabe {
  void registerObserver(Observer observer);
  void removeObserver(Observer observer);
  void notifyObservers();
}
