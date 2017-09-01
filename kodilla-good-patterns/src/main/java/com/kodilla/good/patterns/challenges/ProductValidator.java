package com.kodilla.good.patterns.challenges;

/**
 * Represents an operation that accepts ProductList input argument and returns boolean.
 */
@FunctionalInterface
public interface ProductValidator {
    boolean validate(ProductList productList);
}
