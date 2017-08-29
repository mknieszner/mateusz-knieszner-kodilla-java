package com.kodilla.good.patterns.food2door;

import java.util.Collections;
import java.util.Map;

/**
 * FoodSupplier interface implementation. Supplier offers 2+1 discount.
 */
public class TwoPlusOneFoodSupplier implements FoodSupplier {

    private String name;
    private ProductRegistry productRegistry;
    private ProductValidator productValidator;

    public TwoPlusOneFoodSupplier(String name,
                                  ProductRegistry productRegistry,
                                  ProductValidator productValidator) {
        this.name = name;
        this.productRegistry = productRegistry;
        this.productValidator = productValidator;
    }

    @Override
    public boolean process(Supply supply) {
        Supply newSupply = new Supply(supply.getProductName(),
                supply.getProductQuantity() * 3 / 2);
        if (productValidator.validate(newSupply)) {
            productRegistry.process(newSupply);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String getSupplier() {
        return name;
    }

    @Override
    public Map<String, Integer> getRegistry() {
        return Collections.unmodifiableMap(productRegistry.getRegistry());
    }

    public boolean addSupply(String productName, int productQuantity) {
        return productRegistry.addSupply(productName, productQuantity);
    }
}
