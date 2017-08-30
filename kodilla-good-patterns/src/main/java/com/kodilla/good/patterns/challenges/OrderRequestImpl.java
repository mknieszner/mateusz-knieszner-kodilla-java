package com.kodilla.good.patterns.challenges;

/**
 * OrderRequest interface implementation.
 */
public class OrderRequestImpl implements Request {
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
    public String getOrderToString() {
        return order.getOrderToSting();
    }

    public Order getOrder() {
        return order;
    }

    @Override
    public String getUserName() {
        return user.getName();
    }



}
