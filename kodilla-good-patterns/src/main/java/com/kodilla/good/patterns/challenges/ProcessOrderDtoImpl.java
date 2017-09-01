package com.kodilla.good.patterns.challenges;

import java.util.Collections;
import java.util.Map;
import java.util.StringJoiner;

/**
 * ProcessOrderDto interface implementation.
 */
public class ProcessOrderDtoImpl implements ProcessOrderDto {
  private final User user;
  private final ProductList productList;

  public ProcessOrderDtoImpl(final User user, final ProductList productList) {
    this.user = user;
    this.productList = productList;
  }

  @Override
  public User getUser() {
    return user;
  }

  @Override
  public String getMessage() {
    Map<String, Product> listOfProducts = productList.getList();
    StringJoiner stringJoiner = new StringJoiner(";");

    for (Product product : listOfProducts.values()) {
      stringJoiner.add(product.getName() + ":" + product.getQuantity());
    }
    return "Dear " + user.getName() + ", your order : " + stringJoiner.toString() + " was sent.";
  }

  public ProductList getProductList() {
    return productList;
  }

  @Override
  public String getUsername() {
    return user.getName();
  }
}
