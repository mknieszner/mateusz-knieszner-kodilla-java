package com.kodilla.good.patterns.flightservice;

import java.util.List;

/**
 * Basic airport class.
 */
public class Airport {
    private final String name;
    private final List<Airport> airportList;
    private final boolean availability;


    public Airport(final String name, final List<Airport> airportList, boolean availability) {
        this.name = name;
        this.airportList = airportList;
        this.availability = availability;
    }

    public List<Airport> getAirportList() {
        return airportList;
    }

    public String getName() {
        return name;
    }

    public boolean isAvailable() {
        return availability;
    }

    @Override
    public String toString() {
        return "Airport{" + "name='" + name + '\'' + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Airport airport = (Airport) o;

        return name.equals(airport.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
