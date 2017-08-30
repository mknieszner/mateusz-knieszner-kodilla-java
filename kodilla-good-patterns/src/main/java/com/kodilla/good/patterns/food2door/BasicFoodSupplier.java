package com.kodilla.good.patterns.food2door;

import java.util.Collections;
import java.util.Map;

/**
 * FoodSupplier interface implementation.
 */
public abstract class BasicFoodSupplier implements FoodSupplier {
    private String name;
    protected ProductRegistry productRegistry;
    protected ProductValidator productValidator;

    public BasicFoodSupplier(String name,
                             ProductRegistry productRegistry,
                             ProductValidator productService) {
        this.name = name;
        this.productRegistry = productRegistry;
        this.productValidator = productService;
    }

    @Override
    public boolean process(Supply supply) {
        return productValidator.validate(supply)
                && productRegistry.process(supply);
    }

    @Override
    public String getSupplier() {
        return name;
    }

    @Override
    public Map<String, Integer> getRegistry() {
        return Collections.unmodifiableMap(productRegistry.getRegistry());
    }

    public void addSupply(Supply supply) {
        productRegistry.addSupply(supply);
    }
}
