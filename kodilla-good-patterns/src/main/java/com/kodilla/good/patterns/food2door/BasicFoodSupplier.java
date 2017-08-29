package com.kodilla.good.patterns.food2door;

import java.util.Collections;
import java.util.Map;

/**
 * FoodSupplier interface implementation.
 */
public class BasicFoodSupplier implements FoodSupplier {
    private String name;
    private ProductRegistry productRegistry;
    private ProductValidator productValidator;

    public BasicFoodSupplier(String name,
                             ProductRegistry productRegistry,
                             ProductValidator productService) {
        this.name = name;
        this.productRegistry = productRegistry;
        this.productValidator = productService;
    }

    @Override
    public boolean process(Supply supply) {
        if (productValidator.validate(supply)) {
            productRegistry.process(supply);
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
