package com.kodilla.stream.world;

import java.math.BigDecimal;

/**
 * Contains people quantity.
 */
public class Country {

    private final BigDecimal peopleQuantity;

    public Country(final BigDecimal peopleQuantity) {
        this.peopleQuantity = peopleQuantity;
    }

    public BigDecimal getPeopleQuantity(){
        return peopleQuantity;
    }
}
