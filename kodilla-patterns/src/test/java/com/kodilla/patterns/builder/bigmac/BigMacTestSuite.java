package com.kodilla.patterns.builder.bigmac;

import com.kodilla.patterns.builder.pizza.Pizza;
import org.junit.Assert;
import org.junit.Test;

/**
 * Test Suite for BigMac class.
 */
public class BigMacTestSuite {
  @Test
  public void testBigMacNew() {
    //Given

    //When
    final BigMac bigMac = new BigMac.BigMacBuilder()
        .ingredients(Ingredient.BACON)
        .ingredients(Ingredient.CHILI_PEPPERS)
        .sauce(Sauce.STANDARD)
        .roll(new Roll(true))
        .build();
    final int ingredientsQuantity = bigMac.getIngredients().size();
    final int expectedIngredientsQuantity = 2;

    //Then
    Assert.assertEquals(expectedIngredientsQuantity, ingredientsQuantity);
  }
}
