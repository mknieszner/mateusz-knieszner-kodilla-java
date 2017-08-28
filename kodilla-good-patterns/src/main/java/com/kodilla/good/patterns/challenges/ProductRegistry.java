package com.kodilla.good.patterns.challenges;

/**
 * Magazine interface provides createOrder method.
 */
@FunctionalInterface
public interface ProductRegistry {

    void createOrder(User user, String itemName);
}
