package com.kodilla.good.patterns.challenges;

/**
 * Provides method used to validate OrderData respective fields.
 */
@FunctionalInterface
public interface OrderValidator {
    /**
     * @param orderDto - user and his order data
     * @return boolean - true if order is valid, false if not
     */
    boolean validate(OrderData orderDto);
}