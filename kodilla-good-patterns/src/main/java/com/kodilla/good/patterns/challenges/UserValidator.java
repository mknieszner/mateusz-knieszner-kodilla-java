package com.kodilla.good.patterns.challenges;

/**
 * Represents an operation that accepts User input argument and returns boolean.
 */
@FunctionalInterface
public interface UserValidator {
  boolean validate(User user);
}
