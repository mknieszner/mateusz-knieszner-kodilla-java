package com.kodilla.patterns2.decorator.pizza;

import com.kodilla.patterns2.decorator.taxiportal.BasicTaxiOrder;
import com.kodilla.patterns2.decorator.taxiportal.TaxiOrder;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

/**
 * Test Suite for Pizza Order.
 */
public class PizzaOrderTestSuite {
  @Test
  public void testMargaritaCost() {
    //Given
    final PizzaOrder theOrder = new Margaritta();

    //When
    final BigDecimal calculatedCost = theOrder.getCost();

    //Then
    assertEquals(new BigDecimal(10.00), calculatedCost);
  }

  @Test
  public void testMargaritaIngredients() {
    //Given
    final PizzaOrder theOrder = new Margaritta();

    //When
    final Map<Ingredient, Integer> ingredients = theOrder.getIngredients();

    //Then
    assertThat(ingredients).hasSize(2)
        .containsEntry(new Ingredient("Sauce"), 1)
        .containsEntry(new Ingredient("Cheese"), 1);;
  }

  @Test
  public void testCapriciosaExtraCheeseIngredients() {
    //Given
    PizzaOrder theOrder = new Margaritta();
    theOrder = new HamDecorator(theOrder);
    theOrder = new MushroomDecorator(theOrder);
    theOrder = new ExtraCheeseDecorator(theOrder);

    //When
    final Map<Ingredient, Integer> ingredients = theOrder.getIngredients();

    //Then
    assertThat(ingredients)
        .hasSize(4)
        .containsEntry(new Ingredient("Mushrooms"), 1)
        .containsEntry(new Ingredient("Ham"), 1)
        .containsEntry(new Ingredient("Sauce"), 1)
        .containsEntry(new Ingredient("Cheese"), 2);
  }

  @Test
  public void testCapriciosaExtraCheeseCost() {
    //Given
    PizzaOrder theOrder = new Margaritta();
    theOrder = new HamDecorator(theOrder);
    theOrder = new MushroomDecorator(theOrder);
    theOrder = new ExtraCheeseDecorator(theOrder);

    //When
    final BigDecimal calculatedCost = theOrder.getCost();

    //Then
    assertEquals(new BigDecimal(19.00), calculatedCost);
  }
}
