package com.kodilla.spring.portfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 */
public class Task {
  private String content;


  public Task(final String content) {
    this.content = content;
  }

  public String getContent() {
    return content;
  }
}
