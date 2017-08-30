package com.kodilla.good.patterns.challenges;

/**
 * Interface provides 2 methods: getUser, getOrder.
 * Interface is used to restrict methods which are not substantial to process order.
 * */
public interface OrderRequest {

    User getUser();

    Order getOrder();
}
