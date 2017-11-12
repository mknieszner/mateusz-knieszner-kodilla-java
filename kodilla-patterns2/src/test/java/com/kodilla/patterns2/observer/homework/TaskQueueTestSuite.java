package com.kodilla.patterns2.observer.homework;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test Suite for TaskQueue class.
 */
public class TaskQueueTestSuite {
  @Test
  public void testUpdate() {
    //Given
    final TaskQueue firstUserQueue = new TaskQueue("First User Queue");
    final TaskQueue secondUserQueue = new TaskQueue("Second User Queue");
    final Mentor johnSmith = new Mentor("John Smith");
    final Mentor ivoneEscobar = new Mentor("Ivone Escobar");
    final Mentor jessiePinkman = new Mentor("Jessie Pinkman");

    firstUserQueue.registerObserver(johnSmith);
    firstUserQueue.registerObserver(ivoneEscobar);
    firstUserQueue.registerObserver(jessiePinkman);
    secondUserQueue.registerObserver(jessiePinkman);

    //When
    firstUserQueue.addTask("task1");
    firstUserQueue.addTask("task2");
    firstUserQueue.addTask("task3");
    firstUserQueue.addTask("task4");
    secondUserQueue.addTask("task1");

    //Then
    assertEquals(4, johnSmith.getUpdateCount());
    assertEquals(4, ivoneEscobar.getUpdateCount());
    assertEquals(5, jessiePinkman.getUpdateCount());
  }
}
