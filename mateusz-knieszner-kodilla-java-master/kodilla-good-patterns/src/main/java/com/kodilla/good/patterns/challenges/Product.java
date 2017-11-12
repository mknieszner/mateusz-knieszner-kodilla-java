package com.kodilla.good.patterns.challenges;

/**
 * Represents product.
 */
public class Product {
  private final String name;
  private final Integer quantity;

  public Product(final String name, final Integer quantity) {
    this.name = name;
    this.quantity = quantity;
  }

  public String getName() {
    return name;
  }

  public Integer getQuantity() {
    return quantity;
  }
}