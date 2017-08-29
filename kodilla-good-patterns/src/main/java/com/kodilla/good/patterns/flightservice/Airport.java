package com.kodilla.good.patterns.flightservice;

/**
 * Basic airport class.
 */
public class Airport {
    private final String name;
    private final boolean availability;


    public Airport(String name, boolean availability) {
        this.name = name;
        this.availability = availability;
    }

    public String getName() {
        return name;
    }

    public boolean isAvailable() {
        return availability;
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
