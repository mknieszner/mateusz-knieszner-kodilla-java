package com.kodilla.good.patterns.challenges;

import java.util.Collections;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Collectors;

/**
 * OrderRequest interface implementation.
 */
public class OrderDto implements OrderRequest {
  private final User user;
  private final ProductList productList;

  public OrderDto(final User user, final ProductList productList) {
    this.user = user;
    this.productList = productList;
  }

  @Override
  public User getUser() {
    return user;
  }

  private String getNormalizedOrder() {
    return productList.getList()
        .values()
        .stream()
        .map(product -> product.getName() + " : " + product.getQuantity())
        .collect(Collectors.joining(";"));
  }

  @Override
  public String getMessage() {
    return "Dear " + user.getName() + ", your order : " + getNormalizedOrder() + " was sent.";
  }

  public ProductList getProductList() {
    return productList;
  }

  @Override
  public String getUsername() {
    return user.getName();
  }
}
