package com.kodilla.patterns.builder.bigmac;

import java.util.*;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

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

    public BigMac build() {
      return new BigMac(this);
    }

    public BigMacBuilder addToBigMac(final IngredientCategory ingredientCategory, final Integer quantityToAdd) {
      checkArgument(quantityToAdd > 0, "Quantity to add has to be greater than zero!");
      ingredients.merge(ingredientCategory, quantityToAdd, Integer::sum);
      return this;
    }

    public BigMacBuilder removeFromBigMac(final IngredientCategory ingredientCategory, final Integer quantityToRemove) {
      checkArgument(quantityToRemove > 0, "Quantity to remove has to be greater than zero!");
      final Integer difference = getDifferenceIfPossible(ingredientCategory, quantityToRemove)
          .orElseThrow(() -> new IllegalArgumentException(("Final " + "quantity less than zero!")));
      if (difference == 0) {
        ingredients.remove(ingredientCategory);
      } else {
        ingredients.put(ingredientCategory, difference);
      }
      return this;
    }

    private Optional<Integer> getDifferenceIfPossible(final IngredientCategory ingredientCategory, final Integer quantityToRemove) {
      final Integer presentQuantity = Optional.ofNullable(ingredients.get(ingredientCategory))
          .orElseThrow(() -> new IllegalArgumentException("Can not be removed! Does not exist!"));
      return Optional.ofNullable(getDifferenceIfMoreThanZero(presentQuantity, quantityToRemove));
    }

    private Integer getDifferenceIfMoreThanZero(final Integer existingValue, final Integer quantityToRemove) {
      return existingValue - quantityToRemove >= 0 ? existingValue - quantityToRemove : null;
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


