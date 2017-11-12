package com.kodilla.spring.forum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Test Suite for ForumUser class.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ForumUserTestSuite {

  @Autowired
  private ApplicationContext context;

  @Test
  public void testGetUsername() {

    //Given
    final ForumUser user = context.getBean(ForumUser.class);

    //When
    final String name = user.getUsername();

    //Then
    Assert.assertEquals("John Smith", name);
  }
}
