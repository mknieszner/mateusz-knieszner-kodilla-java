package com.kodilla.exception.test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


/**
 * Class checks if airports are available.
 */
public class FlightRegistry {
    private final Map<String, Boolean> flightMap = new HashMap<>();

    public Map<String, Boolean> getRegistry() {
        return Collections.unmodifiableMap(flightMap);
    }

    public void registerAirport(final Airport airport) {
        flightMap.put(airport.getName(), airport.isAvailable());
    }

    private boolean isAirportAvailable(final Airport airport) throws RouteNotFoundException {
        if (!flightMap.containsKey(airport.getName())) {
            throw new RouteNotFoundException("Airport: " + airport.getName() + " not found!");
        }
        return airport.isAvailable();
    }

    private boolean isConnectionPossible(final Airport departureAirport,
                                         final Airport arrivalAirport)
            throws RouteNotFoundException {

        return isAirportAvailable(arrivalAirport) && isAirportAvailable(departureAirport);
    }

    public boolean findFlight(final Flight flight) throws RouteNotFoundException {

        return isConnectionPossible(flight.getArrivalAirport(), flight.getDepartureAirport());
    }
}


