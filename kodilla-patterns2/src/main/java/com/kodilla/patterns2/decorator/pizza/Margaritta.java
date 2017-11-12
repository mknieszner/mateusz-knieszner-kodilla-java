package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Represents margaritta pizza.
 */
public class Margaritta implements PizzaOrder {

  @Override
  public BigDecimal getCost() {
    return new BigDecimal(10);
  }

  @Override
  public Map<Ingredient, Integer> getIngredients() {
    final Map<Ingredient, Integer> ingredients = new HashMap<>();
    ingredients.merge(new Ingredient("Cheese"), 1, (oldValue, newValue) -> oldValue + newValue);
    ingredients.merge(new Ingredient("Sauce"), 1, (oldValue, newValue) -> oldValue + newValue);
    return ingredients;
  }
}
