package com.kodilla.good.patterns.food2door;

/**
 * ProductService interface implementation.
 */
public class WholesaleProductService implements ProductService {

    @Override
    public boolean validate(String productName, int productQuantity) {
        if (productQuantity < 100) {
            return false;
        }
        return true;
    }
}
