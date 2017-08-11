package com.kodilla.stream.sand;

import java.math.BigDecimal;

/**
 * Africa quantity class.
 */
public final class Africa implements SandStorage {
    @Override
    public BigDecimal getSandBeansQuantity() {
        BigDecimal sandQuantity = new BigDecimal("99999999901234567890");
        return sandQuantity;
    }
}