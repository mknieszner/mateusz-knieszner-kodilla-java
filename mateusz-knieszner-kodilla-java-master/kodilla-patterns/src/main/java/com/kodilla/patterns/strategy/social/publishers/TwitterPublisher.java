package com.kodilla.patterns.strategy.social.publishers;

import com.kodilla.patterns.strategy.social.SocialPublisher;

/**
 * Class used to share via Twitter.
 */
public class TwitterPublisher implements SocialPublisher {
  @Override
  public void share() {
    System.out.println("Twitter");
  }
}
