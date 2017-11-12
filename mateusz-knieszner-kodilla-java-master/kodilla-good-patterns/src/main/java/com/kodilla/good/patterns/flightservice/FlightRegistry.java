package com.kodilla.good.patterns.flightservice;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Flight registry.
 */
public class FlightRegistry {
    private final List<Flight> flightList = new ArrayList<>();

    public void addFlight(final Flight flight) {
        flightList.add(flight);
    }


    public List<Flight> getAllFlightsFrom(final Airport airport) {
        return Collections.unmodifiableList(flightList
                .stream()
                .filter(flight -> flight.getDepartureAirport().equals(airport))
                .collect(Collectors.toList()));
    }

    public List<Flight> getAllFlightsTo(final Airport airport) {
        return Collections.unmodifiableList(flightList
                .stream()
                .filter(flight -> (flight.getArrivalAirport()).equals(airport))
                .collect(Collectors.toList()));
    }

    public String getAllTransferFlights(final Airport airport) {
        return getAllFlightsTo(airport)
                .stream()
                .map((Flight flight) -> getAllFlightsFrom(airport)
                        .stream()
                        .map(flight1 -> String.format("Flight{From=%s ,Via=%s, To=%s}",
                                flight.getDepartureAirport().toString(),
                                flight1.getDepartureAirport().toString(),
                                flight1.getArrivalAirport().toString()))
                        .collect(Collectors.joining("\n")))
                .collect(Collectors.joining("\n"));
    }

    public static void main(final String[] args) {
        final FlightRegistry flightRegistry = new FlightRegistry();
        final Flight flight0 = new Flight(new Airport("a"), new Airport("b"));
        final Flight flight1 = new Flight(new Airport("b"), new Airport("c"));
        final Flight flight2 = new Flight(new Airport("d"), new Airport("b"));
        final Flight flight3 = new Flight(new Airport("b"), new Airport("e"));
        final Flight flight4 = new Flight(new Airport("f"), new Airport("b"));
        final Flight flight5 = new Flight(new Airport("b"), new Airport("g"));

        flightRegistry.addFlight(flight0);
        flightRegistry.addFlight(flight1);
        flightRegistry.addFlight(flight2);
        flightRegistry.addFlight(flight3);
        flightRegistry.addFlight(flight4);
        flightRegistry.addFlight(flight5);

        System.out.println(flightRegistry.getAllFlightsFrom(new Airport("b"))
                .stream()
                .map(flight -> (flight.toString()))
                .collect(Collectors.joining("\n")));
        System.out.println("\n --- \n");
        System.out.println(flightRegistry.getAllFlightsTo(new Airport("b"))
                .stream()
                .map(flight -> (flight.toString()))
                .collect(Collectors.joining("\n")));
        System.out.println("\n --- \n");
        System.out.println(flightRegistry.getAllTransferFlights(new Airport("b")));
    }
}