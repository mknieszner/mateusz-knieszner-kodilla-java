package com.kodilla.good.patterns.food2door;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * ProductRegistry interface implementation.
 */
public class ProductRegistryImpl implements ProductRegistry {
    private Map<String, Integer> productRegistry = new HashMap<>();

    @Override
    public void addSupply(Supply supply) {
        productRegistry.merge(supply.getProductName(), supply.getProductQuantity(), Integer::sum);
    }

    @Override
    public Map<String, Integer> getRegistry() {
        return Collections.unmodifiableMap(productRegistry);
    }

    @Override
    public boolean process(Supply supply) {
        Integer notNullIfProcessed = productRegistry.merge(
                supply.getProductName(), supply.getProductQuantity(),
                (registryValue, supplyQuantity) -> {
            if (registryValue - supplyQuantity > 0 ) {
                return registryValue - supplyQuantity;
            } else {
                return registryValue;
                }
        });

        if (notNullIfProcessed != null) {
            return true;
        } else {
            return false;
        }
    }
}
