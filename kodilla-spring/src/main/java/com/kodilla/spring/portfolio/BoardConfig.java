package com.kodilla.spring.portfolio;

import com.kodilla.spring.reader.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Configuration class.
 */
@Configuration
public class BoardConfig {

  @Bean
  Board getBoard() {
    return new Board(getTaskList1(), getTaskList2(), getTaskList3());
  }

  @Bean(name = "task1")
  public Task getTask1() {
    return new Task("task1");
  }

  @Bean(name = "task2")
  public Task getTask2() {
    return new Task("task2");
  }

  @Bean(name = "task3")
  public Task getTask3() {
    return new Task("task3");
  }

  @Bean
  public TaskList getTaskList1() {
    return new TaskList();
  }

  @Bean
  public TaskList getTaskList2() {
    return new TaskList();
  }

  @Bean
  public TaskList getTaskList3() {
    return new TaskList();
  }
}
