package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;


/**
 * Class checks if airports are available.
 */
public class FlightMap {

    private boolean findFlight(final Flight flight) throws RouteNotFoundException {
        final Map<String, Boolean> flightMap = new HashMap<>();
        flightMap.put("", true);
        flightMap.put("a", false);

        boolean departureAirportFound = false;
        boolean arrivalAirportFound = false;
        boolean departureAirportAvailability = false;
        boolean arrivalAirportAvailability = false;

        for (Map.Entry<String, Boolean> mapEntry : flightMap.entrySet()) {
            if (mapEntry.getKey().equals(flight.getDepartureAirport())) {
                departureAirportAvailability = mapEntry.getValue();
                departureAirportFound = true;
            }
            if (mapEntry.getKey().equals(flight.getArrivalAirport())) {
                arrivalAirportAvailability = mapEntry.getValue();
                arrivalAirportFound = true;
            }
        }

        if (!(departureAirportFound && arrivalAirportFound)) {
            throw new RouteNotFoundException("Airport not found!");
        }

        return arrivalAirportAvailability && departureAirportAvailability;
    }

    public static void main(String[] args) {
        final FlightMap flightMap = new FlightMap();
        final Flight flight = new Flight("", "b");

        try {
            System.out.println(flightMap.findFlight(flight));
        } catch (RouteNotFoundException e) {
            System.out.println("Exception: " + e);
        }
    }
}


