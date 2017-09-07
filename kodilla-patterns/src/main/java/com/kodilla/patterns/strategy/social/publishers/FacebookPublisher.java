package com.kodilla.patterns.strategy.social.publishers;

import com.kodilla.patterns.strategy.social.SocialPublisher;

/**
 * Class used to share via Facebook.
 */
public class FacebookPublisher implements SocialPublisher {
  @Override
  public void share() {
    System.out.println("Facebook");
  }
}
