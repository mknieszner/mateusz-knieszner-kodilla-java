package com.kodilla.good.patterns.flightservice;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Test suite for FlightRegistry class.
 */
public class FlightRegistryTestSuite {
    private final FlightRegistry flightRegistry = new FlightRegistry();

    @Test
    public void getAllAirportsFromTest() {
        //Given
        List<Airport> airportList = new ArrayList<>();
        airportList.add(new Airport("TESTAirport", new ArrayList<>(), true));
        airportList.add(new Airport("TESTAirport2", new ArrayList<>(), true));
        Airport airport2 = new Airport("", airportList, true);
        flightRegistry.registerAirport(airport2);

        //When
        List testList = flightRegistry.getAllAirportsFrom(airport2);

        //Then
        assertEquals("Airport{name='TESTAirport'}Airport{name='TESTAirport2'}",
                testList.get(0).toString() + testList.get(1).toString());
    }

    @Test
    public void getAllAirportsToTest() {
        //Given
        List<Airport> arrivalAirportList = new ArrayList<>();
        Airport arrivalAirport = new Airport("arrivalAirport", arrivalAirportList, true);
        List<Airport> departureAirportList = new ArrayList<>();
        departureAirportList.add(arrivalAirport);
        Airport departureAirport1 = new Airport("departureAirport1", departureAirportList, true);
        Airport departureAirport2 = new Airport("departureAirport2", departureAirportList, true);
        flightRegistry.registerAirport(arrivalAirport);
        flightRegistry.registerAirport(departureAirport1);
        flightRegistry.registerAirport(departureAirport2);

        //When
        List testList = flightRegistry.getAllAirportsTo(arrivalAirport);

        //Then
        assertEquals("Airport{name='departureAirport1'}Airport{name='departureAirport2'}",
                testList.get(0).toString() + testList.get(1).toString());
    }

    @Test
    public void isTransferConnectionPossibleTest() {
        //Given
        List<Airport> departureAirportList = new ArrayList<>();
        Airport departureAirport = new Airport("departureAirport", departureAirportList, true);
        List<Airport> transferAirportList = new ArrayList<>();
        transferAirportList.add(departureAirport);
        Airport transferAirport = new Airport("transferAirport", transferAirportList, true);
        List<Airport> arrivalAirportList = new ArrayList<>();
        arrivalAirportList.add(transferAirport);
        Airport arrivalAirport = new Airport("arrivalAirport", arrivalAirportList, true);

        flightRegistry.registerAirport(arrivalAirport);
        flightRegistry.registerAirport(transferAirport);
        flightRegistry.registerAirport(departureAirport);

        //When
        boolean test = flightRegistry.isTransferConnectionPossible(
                arrivalAirport, transferAirport, departureAirport);

        //Then
        assertTrue(test);
    }
}
