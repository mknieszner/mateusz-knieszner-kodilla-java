package com.kodilla.good.patterns.challenges;

/**
 * OrderDto class holds User and isOrdered fields.
 */
public class OrderDto {
    private User user;
    private boolean isOrdered;

    public OrderDto(final User user, final boolean isOrdered) {
        this.user = user;
        this.isOrdered = isOrdered;
    }

    public User getUser() {
        return user;
    }

    public boolean isExistInMagazine() {
        return isOrdered;
    }
}
