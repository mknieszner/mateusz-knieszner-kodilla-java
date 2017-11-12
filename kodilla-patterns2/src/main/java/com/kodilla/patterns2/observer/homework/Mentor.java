package com.kodilla.patterns2.observer.homework;


/**
 * Represents Mentor.
 */
public class Mentor implements Observer {
  private final String username;
  private int updateCount;

  public Mentor(final String username) {
    this.username = username;
  }

  public String getUsername() {
    return username;
  }

  public int getUpdateCount() {
    return updateCount;
  }

  @Override
  public void update(final TaskQueue taskQueue) {
    System.out.println(username + ": New task in " + taskQueue.getName() + "\n"
        + " (total: " + taskQueue.getTasks().size() + " tasks)");
    updateCount++;
  }
}
