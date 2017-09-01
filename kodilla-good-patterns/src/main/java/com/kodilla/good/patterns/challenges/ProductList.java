package com.kodilla.good.patterns.challenges;

import java.util.Collections;
import java.util.Map;
import java.util.StringJoiner;

/**
 * Holds list of single user single order.
 */
public class ProductList {
  private Map<String, Product> productList;

  public ProductList(Map<String, Product> productList) {
    this.productList = productList;
  }

  public void addProduct(String name, Product product) {
    productList.put(name, product);
  }

  public Map<String, Product> getList() {
    return Collections.unmodifiableMap(productList);
  }
}
