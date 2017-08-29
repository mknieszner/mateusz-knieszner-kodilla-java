package com.kodilla.good.patterns.food2door;

/**
 * FoodSupplier interface implementation. Supplier offers 2+1 discount.
 */
public class TwoPlusOneFoodSupplier extends BasicFoodSupplier implements FoodSupplier {

    public TwoPlusOneFoodSupplier(String name,
                                  ProductRegistry productRegistry,
                                  ProductValidator productValidator) {
        super(name, productRegistry, productValidator);
    }

    @Override
    public boolean process(Supply supply) {
        Supply increasedSupply = new Supply(supply.getProductName(),
                supply.getProductQuantity() * 3 / 2);
        if (productValidator.validate(increasedSupply)
                && productRegistry.process(increasedSupply)) {
            return true;
        } else {
            return false;
        }
    }
}
