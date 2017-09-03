package com.kodilla.good.patterns.challenges;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

/**
 * Test Suite for ProductOrderService class.
 */
public class ProductOrderServiceTestSuite {
  private final InformationService informationService = new OrderInformationService();
  private final OrderValidator orderValidator = new OrderValidatorImpl();
  private final ProductRegistry productRegistry = new ProductRegistryImpl();
  private ProductList productList = new ProductList(new HashMap<>());
  private ProductOrderService productOrderService = new ProductOrderService(
      informationService,
      orderValidator,
      productRegistry);

  @Rule
  public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

  @Test
  public void processInformationServiceTest() {
    //Given
    final User user = new UserImpl("John");
    productList.addProduct("aaa", new Product("aaa", 3));
    productList.addProduct("bbb", new Product("bbb", 1));
    final OrderRequest orderRequest = new OrderDto(user, productList);

    //When
    productOrderService.process(orderRequest);

    //Then
    assertEquals("Sending message: \"Dear John, your order :"
            + " aaa : 3;bbb : 1 was sent.\" to user: John",
        systemOutRule.getLogWithNormalizedLineSeparator());
  }
}
