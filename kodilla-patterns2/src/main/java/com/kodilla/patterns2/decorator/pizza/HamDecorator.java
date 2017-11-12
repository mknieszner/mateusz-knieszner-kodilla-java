package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * Ham Decorator.
 */
public class HamDecorator extends AbstractBasicPizzaOrderDecorator {
  protected HamDecorator(final PizzaOrder pizzaOrder) {
    super(pizzaOrder);
  }

  @Override
  public BigDecimal getCost() {
    return super.getCost().add(new BigDecimal(3));
  }

  @Override
  public Map<Ingredient, Integer> getIngredients() {
    final Map<Ingredient, Integer> ingredients = super.getIngredients();
    ingredients.merge(new Ingredient("Ham"), 1, (oldValue, newValue) -> oldValue + newValue);
    return ingredients;
  }
}
