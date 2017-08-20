package com.kodilla.exception.test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


/**
 * Class checks if airports are available.
 */
public class FlightRegistry {
    private final Map<String, Boolean> flightMap = new HashMap<>();

    public void registerAirport(Airport airport) {
        flightMap.put(airport.getName(), airport.isAvailable());
    }

    public Map<String, Boolean> getRegistry() {
        return Collections.unmodifiableMap(flightMap);
    }

    public boolean findFlight(final Flight flight) throws RouteNotFoundException {
        final Airport arrivalAirport = flight.getArrivalAirport();
        final Airport departureAirport = flight.getDepartureAirport();

        if (flightMap.containsKey(arrivalAirport.getName())
                && flightMap.containsKey(departureAirport.getName())) {
            return arrivalAirport.isAvailable() && departureAirport.isAvailable();
        } else {
            throw new RouteNotFoundException("Route not found!");
        }
    }
}


