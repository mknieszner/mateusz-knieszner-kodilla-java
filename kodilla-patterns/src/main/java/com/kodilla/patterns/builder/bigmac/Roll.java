package com.kodilla.patterns.builder.bigmac;

/**
 * Represents bread roll.
 */
public class Roll {
  private final boolean withSesameSeeds;

  public Roll(final boolean withSesameSeeds) {
    this.withSesameSeeds = withSesameSeeds;
  }

  public boolean isWithSesameSeeds() {
    return withSesameSeeds;
  }

  @Override
  public String toString() {
    return "Roll{" + "withSesameSeeds=" + withSesameSeeds + '}';
  }
}
