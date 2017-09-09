package com.kodilla.patterns.strategy.social;

import com.kodilla.patterns.strategy.social.publishers.FacebookPublisher;
import com.kodilla.patterns.strategy.social.publishers.SnapchatPublisher;
import com.kodilla.patterns.strategy.social.publishers.TwitterPublisher;
import org.junit.*;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

/**
 * Test suite for social media strategies.
 */
public class UserTestSuite {
  private User millenialsUser;
  @Rule
  public SystemOutRule systemOutRule = new SystemOutRule().enableLog();

  @Test
  public void testDefaultSharingMedia() {
    //Given
    millenialsUser = new Millenials("Jarek");
    final User yGenerationUser = new YGeneration("Darek");
    final User zGenerationUser = new ZGeneration("Marek");

    //When
    millenialsUser.sharePost();
    yGenerationUser.sharePost();
    zGenerationUser.sharePost();
    final String expectedResult = "Snapchat\n" + "Facebook\n" + "Twitter\n";

    //Then
    assertEquals(expectedResult, systemOutRule.getLogWithNormalizedLineSeparator());
  }

  @Test
  public void testIndividualSharingMedia() {
    //Given
    millenialsUser = new Millenials("Jarek");

    //When
    millenialsUser.setSocialMedia(new FacebookPublisher());
    millenialsUser.sharePost();
    final String expectedResult = "Facebook\n";

    //Then
    assertEquals(expectedResult, systemOutRule.getLogWithNormalizedLineSeparator());
  }

  @Rule
  public ExpectedException expectedEx = ExpectedException.none();

  @Test
  public void testNullPublisherException() throws NullPointerException {
    //Given
    millenialsUser = new Millenials("Jarek");
    expectedEx.expect(NullPointerException.class);
    expectedEx.expectMessage("Social publisher can not be null!");

    //When
    millenialsUser.setSocialMedia(null);
    millenialsUser.sharePost();

    //Then
    //Exception should be thrown
  }
}
