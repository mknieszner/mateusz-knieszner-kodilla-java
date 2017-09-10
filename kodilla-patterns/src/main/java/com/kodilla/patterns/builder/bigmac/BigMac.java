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
    }

    public BigMacBuilder ingredients(final IngredientCategory ingredientCategory, final Integer quantity) {
      addToBigMac(ingredientCategory, quantity);
      return this;
    }

    public BigMac build() {
      addToBigMac(Roll.WITH_SESAME_SEEDS, 1);
      addToBigMac(Patty.BEEF_PATTY, 2);
      addToBigMac(Sauce.STANDARD, 1);
      return new BigMac(this);
    }

    private void addToBigMac(final IngredientCategory ingredientCategory, final Integer quantityToAdd) {
      if (quantityToAdd > 0) {
        ingredients.merge(ingredientCategory, quantityToAdd, Integer::sum);
      } else if (quantityToAdd < 0) {
        safeMergeIntoIngredients(ingredientCategory, quantityToAdd);
      } else {
        throw new IllegalArgumentException("Quantity can not be Zero!");
      }
    }

    private void safeMergeIntoIngredients(final IngredientCategory ingredientCategory, final Integer quantityToAdd) {
      final Integer presentQuantity = ingredients.get(ingredientCategory);
      if (presentQuantity != null) {
        mergeIfSumIsMoreOrEqualZero(presentQuantity, quantityToAdd, ingredientCategory);
      } else {
        throw new IllegalArgumentException("Final quantity less than zero!");
      }
    }

    private void mergeIfSumIsMoreOrEqualZero(final Integer existingValue, final Integer quantityToAdd, final IngredientCategory ingredientCategory) {
      final Integer sum = getSumIfMoreThanZero(existingValue, quantityToAdd);
      if (sum != null) {
        if (sum == 0) {
          ingredients.remove(ingredientCategory);
        } else {
          ingredients.put(ingredientCategory, sum);
        }
      }
    }

    private Integer getSumIfMoreThanZero(final Integer existingValue, final Integer quantityToAdd) {
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


