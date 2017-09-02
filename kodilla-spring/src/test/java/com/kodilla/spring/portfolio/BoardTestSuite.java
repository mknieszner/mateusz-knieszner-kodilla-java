package com.kodilla.spring.portfolio;

import com.kodilla.spring.library.Library;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;

import static org.springframework.test.util.AssertionErrors.assertEquals;

/**
 *
 */

public class BoardTestSuite {
  private ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);

  @Autowired
  private final Board board = context.getBean(Board.class);

  @Test
  public void testTaskAdd() {
    //Given
    final Task testTask1 = context.getBean("task1", Task.class);
    final Task testTask2 = context.getBean("task2", Task.class);
    final Task testTask3 = context.getBean("task3", Task.class);

    //When
    board.addToToDoList(testTask1);
    board.addToInProgressList(testTask2);
    board.addToDoneList(testTask3);

    //Then
    Assert.assertEquals(
        "",
        board.getDoneList()
            .getTasks()
            .stream()
            .map(Task::getContent)
            .collect(Collectors.joining(", ")));
  }
}