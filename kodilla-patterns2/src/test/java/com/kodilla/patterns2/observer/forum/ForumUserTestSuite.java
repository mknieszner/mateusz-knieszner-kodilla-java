package com.kodilla.patterns2.observer.forum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 *
 */
public class ForumUserTestSuite {
  @Test
  public void testUpdate() {
    //Given
    final ForumTopic javaHelpForum = new JavaHelpForumTopic();
    final ForumTopic javaToolsForum = new JavaToolsForumTopic();
    final ForumUser johnSmith = new ForumUser("John Smith");
    final ForumUser ivoneEscobar = new ForumUser("Ivone Escobar");
    final ForumUser jessiePinkman = new ForumUser("Jessie Pinkman");
    javaHelpForum.registerObserver(johnSmith);
    javaToolsForum.registerObserver(ivoneEscobar);
    javaHelpForum.registerObserver(jessiePinkman);
    javaToolsForum.registerObserver(jessiePinkman);

    //When
    javaHelpForum.addPost("Hie Everyone! Could...");
    javaHelpForum.addPost("Beter try to use while...");
    javaToolsForum.addPost("Help pls, my SQL db...");
    javaHelpForum.addPost("Why while? Is this...");
    javaToolsForum.addPost("When I try to log...");

    //Then
    assertEquals(3, johnSmith.getUpdateCount());
    assertEquals(2, ivoneEscobar.getUpdateCount());
    assertEquals(5, jessiePinkman.getUpdateCount());
  }
}
