package com.kodilla.good.patterns.food2door;

/**
 * ProductService interface implementation.
 */
public class WholesaleProductValidator implements ProductValidator {

    @Override
    public boolean validate(final Supply supply) {
        if (supply.getProductQuantity() < 100) {
            return false;
        }
        return true;
    }
}
