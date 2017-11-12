package com.kodilla.patterns.builder.pizza;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 */
public class PizzaTestSuite {
  @Test
  public void testPizzaNew() {
    //Given
    final Pizza pizza = new Pizza.PizzaBuilder()
        .ingredient("Onion")
        .bottom("Thin")
        .sauce("Spicy")
        .ingredient("Ham")
        .ingredient("Mushrooms")
        .build();
    System.out.println(pizza);

    //When
    final int howManyIngredients = pizza.getIngredients().size();

    //Then
    Assert.assertEquals(3, howManyIngredients);
  }
}