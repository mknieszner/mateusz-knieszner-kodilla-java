package com.kodilla.exception.test;

/**
 * Basic airport class.
 */
public class Airport {
  private final String name;
  private final boolean availability;

  public Airport(final String name, final boolean availability) {
    this.name = name;
    this.availability = availability;
  }

  public String getName() {
    return name;
  }

  public boolean isAvailable() {
    return availability;
  }
}
