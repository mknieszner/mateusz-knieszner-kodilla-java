package com.kodilla.good.patterns.food2door;

/**
 * Interface provides validate method.
 */
@FunctionalInterface
public interface ProductService {

    boolean validate(String productName, int productQuantity);
}
