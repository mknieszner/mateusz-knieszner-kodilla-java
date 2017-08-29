package com.kodilla.good.patterns.flightservice;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Registry of airports with respective Lists of departure airports.
 */
public class AirportRegistry {
    private Map<Airport, List<Airport>> airportMap;

    public AirportRegistry(final Map<Airport, List<Airport>> airportMap) {
        this.airportMap = airportMap;
    }

    public void addAirport(Airport airport, List<Airport> airportList) {
        airportMap.put(airport, airportList);
    }

    public Map<Airport, List<Airport>> getRegistry() {
        return Collections.unmodifiableMap(airportMap);
    }
}
