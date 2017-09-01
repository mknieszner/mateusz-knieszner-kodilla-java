package com.kodilla.good.patterns.challenges;

/**
 * User interface implementation.
 */
public class UserImpl implements User {
  private String name;

  public UserImpl(final String name) {
    this.name = name;
  }

  @Override
  public String getName() {
    return name;
  }
}
