package com.kodilla.exception.test;

/**
 * Basic flight class.
 */
public class Flight {
    private final String departureAirport;
    private final String arrivalAirport;

    public Flight(final Airport departureAirport, final Airport arrivalAirport) {
        this.departureAirport = departureAirport.getName();
        this.arrivalAirport = arrivalAirport.getName();
    }

    public Flight(final String departureAirportName, final String arrivalAirportName) {
        this.departureAirport = departureAirportName;
        this.arrivalAirport = arrivalAirportName;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }
}
