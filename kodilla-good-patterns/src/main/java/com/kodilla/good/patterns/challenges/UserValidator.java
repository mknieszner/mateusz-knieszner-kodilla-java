package com.kodilla.good.patterns.challenges;

/**
 * Provides method used to validate user.
 */
@FunctionalInterface
public interface UserValidator {
  /**
   * @param user - user.
   * @return true if the user is valid, false if not
   */
  boolean validate(User user);
}
