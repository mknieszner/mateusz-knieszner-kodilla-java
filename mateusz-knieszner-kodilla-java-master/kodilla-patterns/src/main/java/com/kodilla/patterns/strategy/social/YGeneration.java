package com.kodilla.patterns.strategy.social;

import com.kodilla.patterns.strategy.social.publishers.FacebookPublisher;

/**
 * Represents YGeneration user.
 * Default social media used by user is Facebook.
 */
public class YGeneration extends User {
  public YGeneration(final String username) {
    super(username);
    this.socialPublisher = new FacebookPublisher();
  }
}
