package com.kodilla.good.patterns.challenges;

/**
 * Storehouse interface provides createOrder method.
 */
@FunctionalInterface
public interface ProductRegistry {

    void createOrder(OrderRequest orderRequest);
}
