package com.kodilla.patterns.strategy.social;

/**
 * Represents user.
 */
public class User {
  private final String Username;
  protected SocialPublisher socialPublisher;


  public User(final String username) {
    Username = username;
  }

  public void sharePost() {
    socialPublisher.share();
  }

  public void setSocialMedia(final SocialPublisher socialPublisher) {
    this.socialPublisher = socialPublisher;
  }
}
