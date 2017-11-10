package com.kodilla.patterns2.facade;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 *
 */
@Service
public class ShopService {
  private final List<Order> orders = new ArrayList<>();
  @Autowired
  private Authenticator authenticator;
  @Autowired
  private ProductService productService;

  public Long openOrder(final Long userId) {
    if (authenticator.isAuthenticated(userId)) {
      final Long maxOrder = (long) orders.stream()
          .mapToInt(o -> o.getOrderId().intValue())
          .max().orElse(0);
      orders.add(new Order(maxOrder + 1, userId, productService));
      return maxOrder + 1;
    } else {
      return -1L;
    }
  }

  public void addItem(final Long orderId, final Long productId, final double qty) {
    orders.stream().filter(o -> o.getOrderId().equals(orderId)).forEach(o -> o.getItems().add(new Item(productId, qty)));
  }

  public boolean removeItem(final Long orderId, final Long productId) {
    final Iterator<Order> orderIterator = orders.stream()
        .filter(o -> o.getOrderId().equals(orderId)).iterator();
    while (orderIterator.hasNext()) {
      final Order theOrder = orderIterator.next();
      final int orderSize = theOrder.getItems().size();
      for (int n = 0; n < theOrder.getItems().size(); n++) {
        if (theOrder.getItems().get(n).getProductId().equals(productId)) {
          theOrder.getItems().remove(n);
          return true;
        }
      }
    }
    return false;
  }

  public BigDecimal calculateValue(final Long orderId) {
    final Iterator<Order> orderIterator = orders.stream()
        .filter(o -> o.getOrderId().equals(orderId)).iterator();
    while (orderIterator.hasNext()) {
      final Order theOrder = orderIterator.next();
      return theOrder.calculateValue();
    }
    return BigDecimal.ZERO;
  }

  public boolean doPayment(final Long orderId) {
    final Iterator<Order> orderIterator = orders.stream()
        .filter(o -> o.getOrderId().equals(orderId)).iterator();
    while (orderIterator.hasNext()) {
      final Order theORder = orderIterator.next();
      if (theORder.isPaid()) {
        return true;
      } else {
        final Random generator = new Random();
        theORder.setPaid(generator.nextBoolean());
        return theORder.isPaid();
      }
    }
    return false;
  }

  public boolean verifyOrder(final Long orderId) {
    final Iterator<Order> orderIterator = orders.stream()
        .filter(o -> o.getOrderId().equals(orderId)).iterator();
    while (orderIterator.hasNext()) {
      final Order theOrder = orderIterator.next();
      final boolean result = theOrder.isPaid();
      final Random generator = new Random();
      if (!theOrder.isVerified()) {
        theOrder.setVerified(result && generator.nextBoolean());
      }
      return theOrder.isVerified();
    }
    return false;
  }

  public boolean submitOrder(final Long orderId) {
    final Iterator<Order> orderIterator = orders.stream()
        .filter(o -> o.getOrderId().equals(orderId)).iterator();
    while (orderIterator.hasNext()) {
      final Order theOrder = orderIterator.next();
      if (theOrder.isVerified()) {
        theOrder.setSubmitted(true);
      }
      return theOrder.isSubmitted();
    }
    return false;
  }

  public void cancelOrder(final Long orderId) {
    final Iterator<Order> orderIterator = orders.stream()
        .filter(o -> o.getOrderId().equals(orderId)).iterator();
    while (orderIterator.hasNext()) {
      final Order theOrder = orderIterator.next();
      orders.remove(theOrder);
    }
  }
}
