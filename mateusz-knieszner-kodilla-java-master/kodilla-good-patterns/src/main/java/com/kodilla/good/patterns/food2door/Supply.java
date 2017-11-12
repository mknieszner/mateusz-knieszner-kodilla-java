package com.kodilla.good.patterns.food2door;

/**
 * Supply class.
 */
public class Supply {
    private final String productName;
    private final int productQuantity;

    public Supply(final String productName, final int productQuantity) {
        this.productName = productName;
        this.productQuantity = productQuantity;
    }

    public String getProductName() {
        return productName;
    }

    public int getProductQuantity() {
        return productQuantity;
    }
}
