package com.kodilla.good.patterns.food2door;

/**
 * ProductService interface implementation.
 */
public class RetailProductService implements ProductService {

    @Override
    public boolean validate(String productName, int productQuantity) {
        if (productQuantity < 100) {
            return false;
        }
        return true;
    }
}
