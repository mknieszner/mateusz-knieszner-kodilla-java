package com.kodilla.good.patterns.challenges;

/**
 * Interface provides 2 argumentless methods: getUser, getProductList.
 * Respectively first returns User, second ProductList.
 */
public interface OrderDto {

  User getUser();

  ProductList getProductList();
}
