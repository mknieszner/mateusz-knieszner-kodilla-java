package com.kodilla.stream.invoice.simple;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Basic invoice class.
 */
public final class SimpleInvoice {
    private final List<SimpleItem> items = new ArrayList<>();

    public void addItem(final SimpleItem item) {
        items.add(item);
    }

    public boolean removeItem(final SimpleItem item) {
        return items.remove(item);
    }

    public double getValueToPay() {
        return items.stream().collect(Collectors.summingDouble(SimpleItem::getValue));
    }
}