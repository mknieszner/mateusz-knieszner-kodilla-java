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
 * Test suite for BoardConfig.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardTestSuite {

  @Test
  public void testContext() {
    //Given
    final String expectedResult = "task3";
    final ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);

    final Board board = context.getBean(Board.class);
    final Task task1 = context.getBean("task1", Task.class);
    final Task task2 = context.getBean("task2", Task.class);
    final Task task3 = context.getBean("task3", Task.class);

    board.addToInProgressList(task1);
    board.addToToDoList(task2);
    board.addToDoneList(task3);

    //When
    final String result = board.getDoneList().getTasks()
        .stream()
        .map(Task::getContent)
        .collect(Collectors.joining(", "));

    //Then
    Assert.assertEquals(expectedResult, result);
  }
}