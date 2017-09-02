package com.kodilla.good.patterns.food2door;

/**
 * FoodSupplier interface implementation. Supplier offers 2+1 discount.
 */
public class TwoPlusOneFoodSupplier extends BasicFoodSupplier implements FoodSupplier {

    public TwoPlusOneFoodSupplier(final String name,
                                  final ProductRegistry productRegistry,
                                  final ProductValidator productValidator) {
        super(name, productRegistry, productValidator);
    }

    public boolean process(final Supply supply) {
        final Supply increasedSupply = new Supply(supply.getProductName(),
                supply.getProductQuantity() * 3 / 2);
        return super.process(increasedSupply);
    }
}
