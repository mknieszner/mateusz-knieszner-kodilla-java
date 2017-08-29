package com.kodilla.good.patterns.flightservice;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Flight registry.
 */
public class FlightRegistry {
    private final AirportRegistry airportRegistry = new AirportRegistry(new HashMap<>());

    public void registerAirport(final Airport airport) {
        airportRegistry.addAirport(airport, airport.getAirportList());
    }

    public List<Airport> getAllAirportsFrom(final Airport airport) {
        return Collections.unmodifiableList(airportRegistry.getRegistry().get(airport));
    }

    public List<Airport> getAllAirportsTo(final Airport airport) {
        return Collections.unmodifiableList(airportRegistry.getRegistry().entrySet().stream()
                .filter((entry) -> entry.getValue().contains(airport))
                .map(Map.Entry::getKey).collect(Collectors.toList()));
    }

    public List<Airport> getAllTransferAirports(final Airport departureAirport,
                                                final Airport arrivalAirport) {
        List<Airport> departureAirportFlightList = getAllAirportsFrom(departureAirport);
        List<Airport> arrivalAirportFlightList = getAllAirportsTo(arrivalAirport);
        List<Airport> transferList = new ArrayList<>();

        for (Airport airport : departureAirportFlightList) {
            if (arrivalAirportFlightList.contains(airport)) {
                transferList.add(airport);
            }
        }
        return transferList;
    }

    public boolean isTransferConnectionPossible(final Airport departureAirport,
                                                final Airport transferAirport,
                                                final Airport arrivalAirport) {
        if (getAllTransferAirports(departureAirport, arrivalAirport)
                .contains(transferAirport)) {
            return true;
        } else {
            return false;
        }
    }
}