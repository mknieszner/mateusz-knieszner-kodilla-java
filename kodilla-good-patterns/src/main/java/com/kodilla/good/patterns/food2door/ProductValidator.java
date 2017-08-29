package com.kodilla.good.patterns.food2door;

/**
 * Interface provides validate method.
 */
@FunctionalInterface
public interface ProductValidator {

    boolean validate(Supply supply);
}
