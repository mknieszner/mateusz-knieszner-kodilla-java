package com.kodilla.patterns.strategy.social;

import com.kodilla.patterns.strategy.social.publishers.TwitterPublisher;

/**
 * Represents ZGeneration user.
 * Default social media used by user is Twitter.
 */
public class ZGeneration extends User {
  public ZGeneration(final String username) {
    super(username);
    this.socialPublisher = new TwitterPublisher();
  }
}
