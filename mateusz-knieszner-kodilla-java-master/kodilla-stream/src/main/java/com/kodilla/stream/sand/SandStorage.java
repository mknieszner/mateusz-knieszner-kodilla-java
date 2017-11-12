package com.kodilla.stream.sand;

import java.math.BigDecimal;

/**
 * Sand storage interface.
 */
@FunctionalInterface
public interface SandStorage {
    BigDecimal getSandBeansQuantity();
}