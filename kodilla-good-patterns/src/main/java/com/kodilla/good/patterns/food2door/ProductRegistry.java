package com.kodilla.good.patterns.food2door;

import java.util.Map;

/**
 * Product registry interface for all suppliers.
 */
public interface ProductRegistry {
    boolean addSupply(String productName, int productQuantity);

    Map<String, Integer> getRegistry();

    void process(Supply supply);

}
