package com.kodilla.good.patterns.challenges;

/**
 * Interface provides validate method.
 */
@FunctionalInterface
public interface OrderService {
    boolean validate(User user, String itemName);
}