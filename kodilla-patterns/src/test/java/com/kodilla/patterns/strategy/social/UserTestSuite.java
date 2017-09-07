package com.kodilla.patterns.strategy.social;

import com.kodilla.patterns.strategy.social.publishers.FacebookPublisher;
import com.kodilla.patterns.strategy.social.publishers.SnapchatPublisher;
import com.kodilla.patterns.strategy.social.publishers.TwitterPublisher;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import static org.junit.Assert.assertEquals;

/**
 * Test suite for social media strategies.
 */
public class UserTestSuite {
  private User millenialsUser;
  private User yGenerationUser;
  private User zGenerationUser;

  @Before
  public void before() {
    millenialsUser = new Millenials("Jarek");
    yGenerationUser = new YGeneration("Darek");
    zGenerationUser = new ZGeneration("Marek");
  }

  @Rule
  public SystemOutRule systemOutRule = new SystemOutRule().enableLog();

  @Test
  public void testDefaultSharingMedia() {
    //Given

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
    millenialsUser.setSocialMedia(new FacebookPublisher());

    //When
    millenialsUser.sharePost();
    final String expectedResult = "Facebook\n";

    //Then
    assertEquals(expectedResult, systemOutRule.getLogWithNormalizedLineSeparator());
  }
}
