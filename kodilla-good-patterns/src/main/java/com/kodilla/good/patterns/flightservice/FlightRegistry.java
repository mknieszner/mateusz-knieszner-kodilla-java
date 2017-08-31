package com.kodilla.good.patterns.flightservice;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Flight registry.
 */
public class FlightRegistry {
    private List<Flight> flightList = new ArrayList<>();

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

    public static void main(String[] args) {
        FlightRegistry flightRegistry = new FlightRegistry();
        Flight flight0 = new Flight(new Airport("a"), new Airport("b"));
        Flight flight1 = new Flight(new Airport("b"), new Airport("c"));
        Flight flight2 = new Flight(new Airport("d"), new Airport("b"));
        Flight flight3 = new Flight(new Airport("b"), new Airport("e"));
        Flight flight4 = new Flight(new Airport("f"), new Airport("b"));
        Flight flight5 = new Flight(new Airport("b"), new Airport("g"));

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

