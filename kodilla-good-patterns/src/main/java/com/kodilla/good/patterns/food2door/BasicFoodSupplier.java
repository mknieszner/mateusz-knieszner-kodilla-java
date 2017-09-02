package com.kodilla.good.patterns.food2door;

import java.util.Collections;
import java.util.Map;

/**
 * FoodSupplier interface implementation.
 */
public abstract class BasicFoodSupplier implements FoodSupplier {
    private final String name;
    private final ProductRegistry productRegistry;
    private final  ProductValidator productValidator;

    public BasicFoodSupplier(final String name,
                             final ProductRegistry productRegistry,
                             final ProductValidator productService) {
        this.name = name;
        this.productRegistry = productRegistry;
        this.productValidator = productService;
    }

    @Override
    public boolean process(final Supply supply) {
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

    public void addSupply(final Supply supply) {
        productRegistry.addSupply(supply);
    }
}
