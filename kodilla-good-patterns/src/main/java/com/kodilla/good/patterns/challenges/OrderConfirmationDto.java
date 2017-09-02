package com.kodilla.good.patterns.challenges;

/**
 * Holds User and isOrdered fields.
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
