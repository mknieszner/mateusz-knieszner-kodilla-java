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
@ComponentScan("com.kodilla.spring.portfolio")
public class BoardConfig {

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

  @Bean(name = "taskList1")
  public TaskList getTaskList1() {
    return new TaskList();
  }

  @Bean(name = "taskList2")
  public TaskList getTaskList2() {
    return new TaskList();
  }

  @Bean(name = "taskList3")
  public TaskList getTaskList3() {
    return new TaskList();
  }
}
