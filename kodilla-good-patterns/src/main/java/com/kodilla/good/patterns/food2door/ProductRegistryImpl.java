package com.kodilla.good.patterns.food2door;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * ProductRegistry interface implementation.
 */
public class ProductRegistryImpl implements ProductRegistry {
    Map<String, Integer> productRegistry = new HashMap<>();

    @Override
    public void addSupply(Supply supply) {
        if (productRegistry.containsKey(supply.getProductName())) {
            int temp = productRegistry.get(supply.getProductName());
            productRegistry.replace(supply.getProductName(), temp + supply.getProductQuantity());
        } else {
            productRegistry.put(supply.getProductName(), supply.getProductQuantity());
        }
    }

    @Override
    public Map<String, Integer> getRegistry() {
        return Collections.unmodifiableMap(productRegistry);
    }

    @Override
    public boolean process(Supply supply) {
        if (productRegistry.containsKey(supply.getProductName())) {
            int temp = productRegistry.get(supply.getProductName());
            productRegistry.replace(supply.getProductName(), temp,
                    temp - supply.getProductQuantity());
            return true;
        } else {
            return false;
        }
    }
}
