package com.kodilla.stream.invoice.simple;

/**
 * Simple product class.
 */
public final class SimpleProduct {
    private final String productName;
    private final double productPrice;

    public SimpleProduct(final String productName, final double productPrice) {
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public String getProductName() {
        return productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SimpleProduct)) {
            return false;
        }
        final SimpleProduct that = (SimpleProduct) o;
        return productName.equals(that.productName);
    }

    @Override
    public int hashCode() {
        int result;
        final long temp;
        result = productName.hashCode();
        temp = Double.doubleToLongBits(productPrice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}