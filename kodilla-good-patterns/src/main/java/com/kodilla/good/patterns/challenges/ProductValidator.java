package com.kodilla.good.patterns.challenges;

/**
 * Provides method used to validate list of products.
 */
@FunctionalInterface
public interface ProductValidator {

  /**
   * @param productList - list of single orders.
   * @return true if the list is valid, false if not
   */
  boolean validate(ProductList productList);
}
