package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;


/**
 * Class checks if airports are available.
 */
public class FlightRegistry {
    private final Map<String, Boolean> flightMap;

    public FlightRegistry() {
        flightMap = new HashMap<>();
    }

    public void registerAirport(Airport airport) {
        flightMap.put(airport.getName(), airport.isAvailable());
    }

    public Map<String, Boolean> getRegistry() {
        return new HashMap<>(flightMap);
    }

    public boolean findFlight(final Flight flight) throws RouteNotFoundException {
        boolean arrivalAirportAvailability;
        boolean departureAirportAvailability;

        if (flightMap.containsKey(flight.getArrivalAirport())) {
            arrivalAirportAvailability = flightMap.get(flight.getArrivalAirport());
        } else {
            throw new RouteNotFoundException("Airport not found!");
        }

        if (flightMap.containsKey(flight.getDepartureAirport())) {
            departureAirportAvailability = flightMap.get(flight.getDepartureAirport());
        } else {
            throw new RouteNotFoundException("Airport not found!");
        }

        return arrivalAirportAvailability && departureAirportAvailability;
    }
}


