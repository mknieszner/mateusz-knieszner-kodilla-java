package com.kodilla.good.patterns.food2door;

/**
 *
 */
public class HealthFood implements FoodSupplier {
    private String name;
    private FoodRegistry foodRegistry;

    public HealthFood(String name, FoodRegistry foodRegistry) {
        this.name = name;
        this.foodRegistry = foodRegistry;
    }

    @Override
    public boolean process(String productName, int productQuantity) {
        return foodRegistry.addSupply(productName, productQuantity);
    }

    @Override
    public String getSupplier() {
        return name;
    }

    public void addSupply(String productName, int productQuantity) {

    }
}
