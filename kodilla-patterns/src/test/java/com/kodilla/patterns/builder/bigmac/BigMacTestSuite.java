package com.kodilla.patterns.builder.bigmac;

import com.kodilla.patterns.builder.pizza.Pizza;
import org.junit.Assert;
import org.junit.Test;

/**
 * Test Suite for BigMac class.
 */
public class BigMacTestSuite {
  @Test
  public void testBigMacBuilder() {
    //Given

    //When
    final BigMac bigMac = new BigMac.BigMacBuilder()
        .ingredients(Other.BACON,1)
        .ingredients(Other.CHILI_PEPPERS,1)
        .ingredients(Patty.BEEF_PATTY,-2)
        .ingredients(Patty.CHICKEN_PATTY,1)
        .build();

    System.out.println(bigMac);
    final int ingredientsQuantity = bigMac.getIngredients().values().stream().mapToInt(Integer::intValue).sum();
    final int expectedIngredientsQuantity = 5;

    //Then
    Assert.assertEquals(expectedIngredientsQuantity, ingredientsQuantity);
  }
}
