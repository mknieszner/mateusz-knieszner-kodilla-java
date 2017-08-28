package com.kodilla.good.patterns.food2door;

import java.util.Map;

/**
 * Food Supplier interface.
 */
public interface FoodSupplier {
    public boolean process(String productName, int productQuantity);

    String getSupplier();

    Map<String, Integer> getRegistry();

    boolean addSupply(String productName, int productQuantity);
}
