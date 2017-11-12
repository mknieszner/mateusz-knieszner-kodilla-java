package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;
import java.util.Map;

/**
 * Pizza Order interface.
 */
public interface PizzaOrder {
  BigDecimal getCost();
  Map<Ingredient, Integer> getIngredients();
}
