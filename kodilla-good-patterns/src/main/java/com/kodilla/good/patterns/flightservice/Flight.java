package com.kodilla.good.patterns.flightservice;

/**
 * Basic flight class.
 */
public class Flight {
    private final Airport departureAirport;
    private final Airport arrivalAirport;

    public Flight(final Airport departureAirport, final Airport arrivalAirport) {
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
    }

    public Airport getDepartureAirport() {
        return departureAirport;
    }

    public Airport getArrivalAirport() {
        return arrivalAirport;
    }
}
