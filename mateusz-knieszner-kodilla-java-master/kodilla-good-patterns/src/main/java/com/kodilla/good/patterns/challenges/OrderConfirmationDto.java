package com.kodilla.good.patterns.challenges;

/**
 * Holds essential fields to confirm process execution.
 */
public class OrderConfirmationDto {
    private String user;
    private boolean isOrdered;

    public OrderConfirmationDto(final String user, final boolean isOrdered) {
        this.user = user;
        this.isOrdered = isOrdered;
    }

    public String getUsername() {
        return user;
    }

    public boolean isExistInMagazine() {
        return isOrdered;
    }
}
