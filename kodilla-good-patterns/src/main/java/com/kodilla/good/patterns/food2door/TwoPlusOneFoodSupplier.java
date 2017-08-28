package com.kodilla.good.patterns.food2door;

import java.util.Collections;
import java.util.Map;

/**
 * FoodSupplier interface implementation. Supplier offers 2+1 discount.
 */
public class TwoPlusOneFoodSupplier implements FoodSupplier {

    private String name;
    private ProductRegistry productRegistry;
    private ProductService productService;

    public TwoPlusOneFoodSupplier(String name,
                                  ProductRegistry productRegistry,
                                  ProductService productService) {
        this.name = name;
        this.productRegistry = productRegistry;
        this.productService = productService;
    }

    @Override
    public boolean process(String productName, int productQuantity) {
        productQuantity += productQuantity / 2;
        if (productService.validate(productName, productQuantity)) {
            productRegistry.process(productName, productQuantity);
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
