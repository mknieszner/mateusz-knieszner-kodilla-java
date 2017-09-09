package com.kodilla.patterns.strategy.social;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Represents user.
 */
public abstract class User {
  private final String username;
  protected SocialPublisher socialPublisher;

  public User(final String username) {
    this.username = username;
  }

  public void sharePost() {
    socialPublisher.share();
  }

  public void setSocialMedia(final SocialPublisher socialPublisher) throws NullPointerException {
    this.socialPublisher = checkNotNull(socialPublisher,"Social publisher can not be null!");
  }
}
