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
 *
 */
@Configuration
public class BoardConfig {

  @Autowired
  @Qualifier("board")
  Board board;



  @Bean(name = "task1")
  @Scope("prototype")
  public Task getTask1() {
    return new Task("task1");
  }

  @Bean(name = "task2")
  @Scope("prototype")
  public Task getTask2() {
    return new Task("task2");
  }

  @Bean(name = "task3")
  @Scope("prototype")
  public Task getTask3() {
    return new Task("task3");
  }

  @Bean(name = "board")
  @Scope("prototype")
  public Board getBoard() {
    return new Board();
  }
}
