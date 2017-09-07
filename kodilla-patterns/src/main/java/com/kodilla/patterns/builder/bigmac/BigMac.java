package com.kodilla.patterns.builder.bigmac;

import com.kodilla.patterns.prototype.library.Library;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Represents BigMac sandwich.
 */
public class BigMac {
  private final Roll roll;
  private final Sauce sauce;
  private final List<Ingredient> ingredients;

  /**
   * Builder for BigMac class.
   */
  public static class BigMacBuilder {
    private Roll roll;
    private Sauce sauce;
    private final List<Ingredient> ingredients = new ArrayList<>();

    public BigMacBuilder sauce(final Sauce sauce) {
      this.sauce = sauce;
      return this;
    }

    public BigMacBuilder roll(final Roll roll) {
      this.roll = roll;
      return this;
    }

    public BigMacBuilder ingredients(final Ingredient ingredients) {
      this.ingredients.add(ingredients);
      return this;
    }

    public BigMac build() {
      return new BigMac(roll, sauce, ingredients);
    }
  }

  private BigMac(final Roll roll, final Sauce sauce, final List<Ingredient> ingredients) {
    this.roll = roll;
    this.sauce = sauce;
    this.ingredients = ingredients;
  }

  public Roll getRoll() {
    return roll;
  }

  public Sauce getSauce() {
    return sauce;
  }

  public List<Ingredient> getIngredients() {
    return Collections.unmodifiableList(ingredients);
  }

  @Override
  public String toString() {
    return "BigMac{" + "roll=" + roll + ", sauce=" + sauce + ", ingredients=" + ingredients + '}';
  }
}


