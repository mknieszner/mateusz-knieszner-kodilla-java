package com.kodilla.good.patterns.challenges;

/**
 *  Represents an operation that accepts OrderData input argument and returns no result.
 */
@FunctionalInterface
public interface ProductRegistry {

    void createOrder(OrderData orderRequest);
}
