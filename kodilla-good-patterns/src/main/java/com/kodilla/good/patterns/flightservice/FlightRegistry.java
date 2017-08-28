package com.kodilla.good.patterns.flightservice;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Flight registry.
 */
public class FlightRegistry {
    private final AirportRegistry airportRegistry = new AirportRegistry(new HashMap<>());

    public void registerAirport(final Airport airport, final AirportList airportList) {
        airportRegistry.addAirport(airport, airportList.getAirportList());
    }

    public List<Airport> getAllAirportsFrom(final Airport airport) {
        return Collections.unmodifiableList(airportRegistry.getAirportMap().get(airport));
    }

    public List<Airport> getAllAirportsTo(final Airport airport) {
        return Collections.unmodifiableList(airportRegistry.getAirportMap().entrySet().stream().
                filter((entry) -> entry.getValue().contains(airport))
                .map(Map.Entry::getKey).collect(Collectors.toList()));
    }

    public List<Airport> getAllTransferAirports(final Airport departureAirport,
                                                final Airport arrivalAirport) {
        List<Airport> departureAirportFligthList = getAllAirportsFrom(departureAirport);
        List<Airport> arrivalAirportFligthList = getAllAirportsTo(arrivalAirport);
        List<Airport> transferList = new ArrayList<>();

        for (Airport airport : departureAirportFligthList) {
            if (arrivalAirportFligthList.contains(airport)) {
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