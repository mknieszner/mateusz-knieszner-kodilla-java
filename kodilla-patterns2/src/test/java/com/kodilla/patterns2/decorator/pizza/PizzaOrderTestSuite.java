package com.kodilla.patterns2.decorator.pizza;

import com.kodilla.patterns2.decorator.taxiportal.BasicTaxiOrder;
import com.kodilla.patterns2.decorator.taxiportal.TaxiOrder;
import org.junit.Test;

import java.math.BigDecimal;

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
    final String description = theOrder.getIngredients().toString();

    //Then
    assertEquals("{Sauce=1, Cheese=1}", description);
  }

  @Test
  public void testCapriciosaExtraCheeseIngredients() {
    //Given
    PizzaOrder theOrder = new Margaritta();
    theOrder = new HamDecorator(theOrder);
    theOrder = new MushroomDecorator(theOrder);
    theOrder = new ExtraCheeseDecorator(theOrder);

    //When
    final String description = theOrder.getIngredients().toString();

    //Then
    assertEquals("{Mushrooms=1, Ham=1, Sauce=1, Cheese=2}", description);
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
