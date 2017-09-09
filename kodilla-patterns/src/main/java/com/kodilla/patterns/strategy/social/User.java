package com.kodilla.patterns.strategy.social;

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
    if (socialPublisher == null) {
      throw new NullPointerException("Social publisher can not be null!");
    }
    this.socialPublisher = socialPublisher;
  }
}
