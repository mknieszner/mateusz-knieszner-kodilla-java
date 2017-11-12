package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * Extra Cheese Decorator.
 */
public class ExtraCheeseDecorator extends AbstractBasicPizzaOrderDecorator {
  protected ExtraCheeseDecorator(final PizzaOrder pizzaOrder) {
    super(pizzaOrder);
  }

  @Override
  public BigDecimal getCost() {
    return super.getCost().add(new BigDecimal(4));
  }

  @Override
  public Map<Ingredient, Integer> getIngredients() {
    final Map<Ingredient, Integer> ingredients = super.getIngredients();
    ingredients.merge(new Ingredient("Cheese"), 1, (oldValue, newValue) -> oldValue + newValue);
    return ingredients;
  }
}
