package com.kodilla.good.patterns.challenges;

/**
 * Interface provides 2 essential methods to validate order.
 */
public interface OrderData {

  /**
   * @return User - User data.
   */
  User getUser();

  /**
   * @return ProductList - User's list of single orders.
   */
  ProductList getProductList();
}
