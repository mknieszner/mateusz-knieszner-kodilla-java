package com.kodilla.good.patterns.food2door;

import java.util.Map;

/**
 *
 */
public interface FoodRegistry {
    public Map<String, Integer> getRegistry();

    public boolean addSupply(String productName, int productQuantity);

}
