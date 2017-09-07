package com.kodilla.patterns.strategy.social;

import com.kodilla.patterns.strategy.social.publishers.SnapchatPublisher;

/**
 * Represents millenials user.
 * Default social media used by user is Snapchat.
 */
public class Millenials extends User {
  public Millenials(final String username) {
    super(username);
    this.socialPublisher = new SnapchatPublisher();
  }
}
