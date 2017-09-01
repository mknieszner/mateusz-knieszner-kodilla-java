package com.kodilla.good.patterns.challenges;

/**
 * Interface provides method used to validate OrderRequest respective fields.
 */
@FunctionalInterface
public interface OrderValidator {
    boolean validate(OrderDto orderDto);
}