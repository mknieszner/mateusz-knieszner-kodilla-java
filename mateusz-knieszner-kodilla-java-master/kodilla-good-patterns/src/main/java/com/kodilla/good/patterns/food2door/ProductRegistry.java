package com.kodilla.good.patterns.food2door;

import java.util.Map;

/**
 * Product registry interface for all suppliers.
 */
public interface ProductRegistry {
    void addSupply(Supply supply);

    Map<String, Integer> getRegistry();

    boolean process(Supply supply);

}
