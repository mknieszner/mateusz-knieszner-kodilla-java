package com.kodilla.exception.test;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

/**
 * Test Suite for FlightRegistry class.
 */
public class FlightRegistryTestSuite {
    private FlightRegistry flightRegistry;
    private Airport availableAirport = new Airport("", true);
    private Airport unavailableAirport = new Airport("a", false);

    @Before
    public void before() {
        flightRegistry = new FlightRegistry();
    }

    @Test
    public void testRegisterAirport() {
        //Given

        //When
        flightRegistry.registerAirport(availableAirport);
        flightRegistry.registerAirport(unavailableAirport);

        //Then
        assertEquals(2, flightRegistry.getRegistry().size());
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testFindFlightException() throws RouteNotFoundException {
        flightRegistry.registerAirport(availableAirport);
        final Flight flight = new Flight(availableAirport, unavailableAirport);

        thrown.expect(RouteNotFoundException.class);
        thrown.expectMessage("Airport not found!");
        flightRegistry.findFlight(flight);
    }

    @Test
    public void testFindFlightUnavailableAirports() {
        //Given
        Boolean isFlightAvailable = true;
        flightRegistry.registerAirport(availableAirport);
        flightRegistry.registerAirport(unavailableAirport);
        final Flight flight = new Flight(availableAirport, unavailableAirport);

        //When
        try {
            isFlightAvailable = flightRegistry.findFlight(flight);
        } catch (RouteNotFoundException e) {
            System.out.println("Exception: " + e);
        }

        //Then
        assertFalse(isFlightAvailable);
    }

    @Test
    public void testFindFlightAvailableAirports() {
        //Given
        final Flight flight = new Flight(availableAirport, availableAirport);
        Boolean isFlightAvailable = false;
        flightRegistry.registerAirport(availableAirport);

        //When
        try {
            isFlightAvailable = flightRegistry.findFlight(flight);
        } catch (RouteNotFoundException e) {
            System.out.println("Exception: " + e);
        }

        //Then
        assertTrue(isFlightAvailable);
    }
}
