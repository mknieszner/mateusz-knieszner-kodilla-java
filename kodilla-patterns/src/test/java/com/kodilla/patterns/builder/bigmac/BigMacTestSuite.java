package com.kodilla.patterns.builder.bigmac;

import com.kodilla.patterns.builder.pizza.Pizza;
import com.kodilla.patterns.strategy.social.Millenials;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Test Suite for BigMac class.
 */
public class BigMacTestSuite {
  @Test
  public void testBigMacBuilder() {
    //Given

    //When
    final BigMac bigMac = new BigMac
        .BigMacBuilder()
        .ingredients(Other.BACON, 1)
        .ingredients(Other.CHILI_PEPPERS, 1)
        .ingredients(Patty.CHICKEN_PATTY, 1)
        .ingredients(Patty.CHICKEN_PATTY, -1)
        .build();

    final int ingredientsQuantity = bigMac.getIngredients().values()
        .stream()
        .mapToInt(Integer::intValue)
        .sum();
    final int expectedIngredientsQuantity = 6;

    //Then
    Assert.assertEquals(expectedIngredientsQuantity, ingredientsQuantity);
  }

  @Rule
  public ExpectedException expectedEx = ExpectedException.none();

  @Test
  public void testBigMacBuilderFinalQuantityException() {
    //Given
    expectedEx.expect(IllegalArgumentException.class);
    expectedEx.expectMessage("Final quantity less than zero!");

    //When
    new BigMac
        .BigMacBuilder()
        .ingredients(Patty.BEEF_PATTY, -2)
        .build();

    //Then
    //Exception should be thrown
  }

  @Test
  public void testBigMacBuilderZeroQuantityException() {
    //Given
    expectedEx.expect(IllegalArgumentException.class);
    expectedEx.expectMessage("Quantity can not be Zero!");

    //When
    new BigMac
        .BigMacBuilder()
        .ingredients(Patty.BEEF_PATTY, 0)
        .build();

    //Then
    //Exception should be thrown
  }
}
