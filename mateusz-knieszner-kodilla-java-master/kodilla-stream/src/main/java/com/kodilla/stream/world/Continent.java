package com.kodilla.stream.world;

import java.util.ArrayList;
import java.util.List;

/**
 * Contains list of countries.
 */
public class Continent {
    private final List<Country> countryList = new ArrayList<>();

    public void addCountry(final Country countryToAdd) {
        countryList.add(countryToAdd);
    }

    public List<Country> getCountryList() {
        return countryList;
    }
}
