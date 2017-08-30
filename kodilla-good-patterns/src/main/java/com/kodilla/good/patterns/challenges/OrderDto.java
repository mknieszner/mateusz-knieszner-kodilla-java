package com.kodilla.good.patterns.challenges;

/**
 * OrderDto class holds User and isOrdered fields.
 */
public class OrderDto {
    private String user;
    private boolean isOrdered;

    public OrderDto(final String user, final boolean isOrdered) {
        this.user = user;
        this.isOrdered = isOrdered;
    }

    public String getUser() {
        return user;
    }

    public boolean isExistInMagazine() {
        return isOrdered;
    }
}
