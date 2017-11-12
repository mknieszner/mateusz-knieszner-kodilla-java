package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;
import java.util.Map;

/**
 * Abstract class for Basic Pizza Order Decorator pattern.
 */
public abstract class AbstractBasicPizzaOrderDecorator implements PizzaOrder {
  private final PizzaOrder pizzaOrder;

  protected AbstractBasicPizzaOrderDecorator(final PizzaOrder pizzaOrder) {
    this.pizzaOrder = pizzaOrder;
  }

  @Override
  public BigDecimal getCost() {
    return pizzaOrder.getCost();
  }

  @Override
  public Map<Ingredient, Integer> getIngredients() {
    return pizzaOrder.getIngredients();
  }
}
