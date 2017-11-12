package com.kodilla.stream.sand;

import java.math.BigDecimal;

/**
 * Europe quantity class.
 */
public final class Europe implements SandStorage {
    @Override
    public BigDecimal getSandBeansQuantity() {
        final BigDecimal sandQuantity = new BigDecimal("12345678901234567890");
        return sandQuantity;
    }
}