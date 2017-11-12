package com.kodilla.good.patterns.challenges;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

/**
 * Holds list of single orders.
 */
public class ProductList {
  private final Map<String, Product> productList;

  public ProductList(final Map<String, Product> productList) {
    this.productList = new HashMap<>(productList);
  }

  public void addProduct(final String name, final Product product) {
    productList.put(name, product);
  }

  public Map<String, Product> getList() {
    return Collections.unmodifiableMap(productList);
  }
}
