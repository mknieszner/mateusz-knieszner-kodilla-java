package com.kodilla.good.patterns.flightservice;

import java.util.Collections;
import java.util.List;

/**
 * List of airports.
 */
public class AirportList {
    private List<Airport> airportList;

    public AirportList(final List<Airport> airportList) {
        this.airportList = airportList;
    }

    public List<Airport> getAirportList() {
        return Collections.unmodifiableList(airportList);
    }

    public void addAirport(Airport airport) {
        airportList.add(airport);
    }
}
