package com.kodilla.good.patterns.challenges;

/**
 *  Provides method used to create Order.
 */
@FunctionalInterface
public interface ProductRegistry {

    /**
     * @param orderDto - user and message data.
     */
    void createOrder(OrderData orderDto);
}
