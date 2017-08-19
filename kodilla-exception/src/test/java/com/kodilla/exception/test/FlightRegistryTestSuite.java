package com.kodilla.exception.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
        Assert.assertEquals(2, flightRegistry.getRegistry().size());
    }

    @Test(expected = RouteNotFoundException.class)
    public void testFindFlightException() throws RouteNotFoundException {
        //Given
        flightRegistry.registerAirport(availableAirport);
        final Flight flight = new Flight(availableAirport, unavailableAirport);

        //When
        flightRegistry.findFlight(flight);

        //Then
        //RouteNotFoundException should be thrown
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
        Assert.assertFalse(isFlightAvailable);
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
        Assert.assertTrue(isFlightAvailable);
    }
}
