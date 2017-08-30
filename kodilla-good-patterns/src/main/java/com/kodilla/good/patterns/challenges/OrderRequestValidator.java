package com.kodilla.good.patterns.challenges;

/**
 * Interface provides method used to validate OrderRequest respective fields.
 */
public interface OrderRequestValidator {
    boolean validate(final OrderRequest orderRequest);
}