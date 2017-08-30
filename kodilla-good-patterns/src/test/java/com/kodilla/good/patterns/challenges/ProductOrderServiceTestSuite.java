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
    private final InformationService informationService = new InformationServiceImpl();
    private final OrderRequestValidator orderRequestValidator = new OrderRequestValidatorImpl();
    private final ProductRegistry productRegistry = new ProductRegistryImpl();
    private Order order = new Order(new HashMap<>());
    private ProductOrderService productOrderService = new ProductOrderService(
            informationService,
            orderRequestValidator,
            productRegistry);

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Test
    public void processInformationServiceTest() {
        //Given
        User user = new UserImpl("John");
        order.addOrder("aaa", 3);
        order.addOrder("bbb", 1);
        Request orderRequest = new OrderRequestImpl(user, order);

        //When
        productOrderService.process(orderRequest);

        //Then
        assertEquals("Inform: John about his order: aaa:3;bbb:1",
                systemOutRule.getLogWithNormalizedLineSeparator());
    }


}
