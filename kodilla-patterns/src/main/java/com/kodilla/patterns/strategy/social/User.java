package com.kodilla.patterns.strategy.social;

/**
 * Represents user.
 */
public class User {
  private final String username;
  protected SocialPublisher socialPublisher;

  public User(final String username) {
    this.username = username;
  }

  public void sharePost() {
    socialPublisher.share();
  }

  public void setSocialMedia(final SocialPublisher socialPublisher) {
    this.socialPublisher = socialPublisher;
  }
}
