package com.kodilla.patterns.builder.bigmac;

import com.kodilla.patterns.builder.pizza.Pizza;
import com.kodilla.patterns.strategy.social.Millenials;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.internal.matchers.Null;

import java.util.NoSuchElementException;

/**
 * Test Suite for BigMac class.
 */
public class BigMacTestSuite {
  private BigMac bigMac;

  @Test
  public void testBigMacBuilder() {
    //Given

    //When
     bigMac = new BigMac
        .BigMacBuilder()
        .addToBigMac(Other.BACON, 1)
        .addToBigMac(Other.CHILI_PEPPERS, 1)
        .addToBigMac(Patty.CHICKEN_PATTY, 2)
        .removeFromBigMac(Patty.CHICKEN_PATTY, 1)
        .build();

    final int ingredientsQuantity = bigMac.getIngredients().values()
        .stream()
        .mapToInt(Integer::intValue)
        .sum();
    final int expectedIngredientsQuantity = 7;

    //Then
    Assert.assertEquals(expectedIngredientsQuantity, ingredientsQuantity);
  }

  @Rule
  public ExpectedException expectedEx = ExpectedException.none();

  @Test
  public void testBigMacBuilderRemoveUnexistingIngredientException() {
    //Given
    expectedEx.expect(IllegalArgumentException.class);
    expectedEx.expectMessage("Can not be removed! Does not exist!");

    //When
    bigMac = new BigMac
        .BigMacBuilder()
        .removeFromBigMac(Patty.CHICKEN_PATTY, 2)
        .build();

    //Then
    //Exception should be thrown
  }

  @Test
  public void testBigMacBuilderZeroQuantityException() {
    //Given
    expectedEx.expect(IllegalArgumentException.class);
    expectedEx.expectMessage("Quantity to add has to be greater than zero!");

    //When
    bigMac = new BigMac
        .BigMacBuilder()
        .addToBigMac(Patty.BEEF_PATTY, 0)
        .build();

    //Then
    //Exception should be thrown
  }

  @Test
  public void testBigMacBuilderLessThanZeroFinalQuantityException() {
    //Given
    expectedEx.expect(IllegalArgumentException.class);
    expectedEx.expectMessage("Final quantity less than zero!");

    //When
    bigMac = new BigMac
        .BigMacBuilder()
        .removeFromBigMac(Patty.BEEF_PATTY, 3)
        .build();

    //Then
    //Exception should be thrown
  }

  @Test
  public void testBigMacBuilderAddToBigMacNegativeArgumentException() {
    //Given
    expectedEx.expect(IllegalArgumentException.class);
    expectedEx.expectMessage("Quantity to add has to be greater than zero!");

    //When
    bigMac = new BigMac
        .BigMacBuilder()
        .addToBigMac(Patty.BEEF_PATTY, -1)
        .build();

    //Then
    //Exception should be thrown
  }

  @Test
  public void testBigMacBuilderRemoveFromBigMacNegativeArgumentException() {
    //Given
    expectedEx.expect(IllegalArgumentException.class);
    expectedEx.expectMessage("Quantity to remove has to be greater than zero!");

    //When
    bigMac = new BigMac
        .BigMacBuilder()
        .removeFromBigMac(Patty.BEEF_PATTY, -1)
        .build();

    //Then
    //Exception should be thrown
  }
}
