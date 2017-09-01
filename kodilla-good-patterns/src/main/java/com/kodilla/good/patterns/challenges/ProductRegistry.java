package com.kodilla.good.patterns.challenges;

/**
 *  Represents an operation that accepts OrderDto input argument and returns no result.
 */
@FunctionalInterface
public interface ProductRegistry {

    void createOrder(OrderDto orderRequest);
}
