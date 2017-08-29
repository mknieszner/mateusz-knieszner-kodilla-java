package com.kodilla.good.patterns.challenges;

/**
 * OrderRequest interface implementation. Holds single user with his single order.
 */
public class OrderRequestImpl implements OrderRequest {
    private final User user;
    private final Order order;

    public OrderRequestImpl(final User user, final Order order) {
        this.user = user;
        this.order = order;
    }

    @Override
    public User getUser() {
        return user;
    }

    @Override
    public Order getOrder() {
        return order;
    }
}
