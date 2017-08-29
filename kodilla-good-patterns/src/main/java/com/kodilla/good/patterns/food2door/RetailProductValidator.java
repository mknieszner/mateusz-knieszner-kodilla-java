package com.kodilla.good.patterns.food2door;

/**
 * ProductService interface implementation.
 */
public class RetailProductValidator implements ProductValidator {

    @Override
    public boolean validate(Supply supply) {
        if (supply.getProductQuantity() > 100) {
            return false;
        }
        return true;
    }
}
