package com.kodilla.patterns2.facade;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Order {
  private final Long orderId;
  private final Long userId;
  private boolean isPaid;
  private boolean isVerified;
  private boolean isSubmitted;
  private final List<Item> items = new ArrayList<>();
  private ProductService productService;

  public Order(final Long orderId, final Long userId, final ProductService productService) {
    this.orderId = orderId;
    this.userId = userId;
    this.productService = productService;
  }

  public BigDecimal calculateValue() {
    BigDecimal sum = BigDecimal.ZERO;
    for (final Item item : items) {
      sum = sum.add(productService.getPrice(item.getProductId())).multiply(new BigDecimal(item.getQty()));
    }
    return sum;
  }

  public Long getOrderId() {
    return orderId;
  }

  public Long getUserId() {
    return userId;
  }

  public boolean isPaid() {
    return isPaid;
  }

  public void setPaid(final boolean isPaid) {
    this.isPaid = isPaid;
  }

  public boolean isVerified() {
    return isVerified;
  }

  public void setVerified(final boolean verified) {
    isVerified = verified;
  }

  public boolean isSubmitted() {
    return isSubmitted;
  }

  public void setSubmitted(final boolean submitted) {
    isSubmitted = submitted;
  }

  public List<Item> getItems() {
    return items;
  }
}
