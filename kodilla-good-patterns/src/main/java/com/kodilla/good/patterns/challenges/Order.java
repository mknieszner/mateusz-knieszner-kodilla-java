package com.kodilla.good.patterns.challenges;

import java.util.Map;
import java.util.StringJoiner;

/**
 * Holds list of single user single order.
 */
public class Order {
    private Map<String, Integer> orderList;

    public Order(Map<String, Integer> orderList) {
        this.orderList = orderList;
    }

    public String getOrderToSting() {
        StringJoiner stringJoiner = new StringJoiner(";");
        for (Map.Entry entry : orderList.entrySet()) {
            stringJoiner.add(entry.getKey() + ":" + entry.getValue());
        }
        return stringJoiner.toString();
    }

    public void addOrder(String name, Integer quantity) {
        orderList.put(name, quantity);
    }
}
