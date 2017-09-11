package com.kodilla.patterns.builder.bigmac;

import java.util.*;

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

    public BigMacBuilder ingredients(final IngredientCategory ingredientCategory, final Integer quantity) {
      if (quantity > 0) {
        addToBigMac(ingredientCategory, quantity);
      } else if (quantity < 0) {
        removeFromBigMac(ingredientCategory, quantity);
      } else {
        throw new IllegalArgumentException("Quantity can not be zero!");
      }

      return this;
    }

    public BigMac build() {
      return new BigMac(this);
    }

    private void addToBigMac(final IngredientCategory ingredientCategory, final Integer quantityToAdd) {
      ingredients.merge(ingredientCategory, quantityToAdd, Integer::sum);
    }

    private void removeFromBigMac(final IngredientCategory ingredientCategory, final Integer quantityToRemove) {
      final Integer difference = differenceIfPossible(ingredientCategory, quantityToRemove);
      if (difference == 0) {
        ingredients.remove(ingredientCategory);
      } else {
        ingredients.put(ingredientCategory, difference);
      }
    }

    private Integer differenceIfPossible(final IngredientCategory ingredientCategory, final Integer quantityToRemove) {
      final Integer presentQuantity = checkNotNull(ingredients.get(ingredientCategory), "Can not be removed! Does not exist!");
      return checkNotNull(getDifferenceIfMoreThanZero(presentQuantity, quantityToRemove), "Final quantity less than zero!");
    }

    private Integer getDifferenceIfMoreThanZero(final Integer existingValue, final Integer quantityToAdd) {
      return existingValue + quantityToAdd >= 0 ? existingValue + quantityToAdd : null;
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


