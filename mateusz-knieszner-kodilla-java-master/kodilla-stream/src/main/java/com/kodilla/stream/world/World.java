package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Contains list of continents.
 */
public class World {
    private final List<Continent> continentList = new ArrayList<>();

    public void addContinent(final Continent continentToAdd) {
        continentList.add(continentToAdd);
    }

    public List<Continent> getContinentList() {
        return continentList;
    }

    public BigDecimal getPeopleQuantity() {
        return continentList.stream()
                .flatMap(continent -> continent.getCountryList().stream())
                .map(Country::getPeopleQuantity)
                .reduce(BigDecimal.ZERO, (sum, current) -> sum = sum.add(current));
    }
}
