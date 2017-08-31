package com.kodilla.good.patterns.flightservice;

/**
 * Basic airport class.
 */
public class Airport {
    private final String name;

    public Airport(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
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
