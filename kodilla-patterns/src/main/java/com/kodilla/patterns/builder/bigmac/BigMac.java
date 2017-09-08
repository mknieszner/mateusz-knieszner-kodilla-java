package com.kodilla.patterns.builder.bigmac;

import java.util.*;

/**
 * Represents BigMac sandwich.
 */
public class BigMac {
  private final Map<IngredientCategory, Integer> ingredients;

  /**
   * Builder for BigMac class.
   */
  public static class BigMacBuilder {
    private final Map<IngredientCategory, Integer> ingredients = new HashMap<>();

    public BigMacBuilder() {
      addToBigMac(Roll.WITH_SESAME_SEEDS, 1);
      addToBigMac(Patty.BEEF_PATTY, 2);
      addToBigMac(Sauce.STANDARD, 1);
    }

    public BigMacBuilder ingredients(final IngredientCategory ingredientCategory, final Integer quantity) {
      addToBigMac(ingredientCategory, quantity);
      return this;
    }

    public BigMac build() {
      return new BigMac(this);
    }

    private void addToBigMac(final IngredientCategory ingredientCategory, final Integer quantity) {
      if (ingredients.merge(ingredientCategory, quantity, this::safeMerge) == 0) {
        ingredients.remove(ingredientCategory);
      }
    }

    private Integer safeMerge(final int existingValue, final int quantity) {
      return existingValue + quantity >= 0 ? existingValue + quantity : existingValue;
    }
  }

  private BigMac(final BigMacBuilder bigMacBuilder) {
    this.ingredients = bigMacBuilder.ingredients;
  }

  public Map<IngredientCategory, Integer> getIngredients() {
    return Collections.unmodifiableMap(ingredients);
  }

  @Override
  public String toString() {
    return "BigMac's ingredients=" + ingredients + '.';
  }
}


