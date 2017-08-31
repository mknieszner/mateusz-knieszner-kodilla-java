package com.kodilla.good.patterns.flightservice;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Test suite for FlightRegistry class.
 */
public class FlightRegistryTestSuite {
    private FlightRegistry flightRegistry;
    private List<Flight> expectedFlightList;
    private final Flight flight0 = new Flight(new Airport("a"), new Airport("b"));
    private final Flight flight1 = new Flight(new Airport("b"), new Airport("c"));
    private final Flight flight2 = new Flight(new Airport("d"), new Airport("b"));
    private final Flight flight3 = new Flight(new Airport("b"), new Airport("e"));
    private final Flight flight4 = new Flight(new Airport("f"), new Airport("b"));
    private final Flight flight5 = new Flight(new Airport("b"), new Airport("g"));

    @Before
    public void before() {
        flightRegistry = new FlightRegistry();
    }

    @Test
    public void getAllFlightsFromTest() {
        //Given
        flightRegistry.addFlight(flight1);
        flightRegistry.addFlight(flight3);
        flightRegistry.addFlight(flight5);

        //When
        expectedFlightList = flightRegistry.getAllFlightsFrom(new Airport("b"));

        //Then
        assertEquals(expectedFlightList.size(), 3);
    }

    @Test
    public void getAllFlightsToTest() {
        //Given
        flightRegistry.addFlight(flight0);
        flightRegistry.addFlight(flight2);
        flightRegistry.addFlight(flight4);

        //When
        expectedFlightList = flightRegistry.getAllFlightsTo(new Airport("b"));


        //Then
        assertEquals(expectedFlightList.size(), 3);
    }

    @Rule
    public SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Test
    public void getAllTransferFlightsTest() {
        //Given
        flightRegistry.addFlight(flight0);
        flightRegistry.addFlight(flight1);
        flightRegistry.addFlight(flight2);

        //When
        System.out.println(flightRegistry.getAllTransferFlights(new Airport("b")));

        //Then
        assertEquals(
                "Flight{From=Airport{name='a'} ,Via=Airport{name='b'}"
                            + ", To=Airport{name='c'}}\n"
                        + "Flight{From=Airport{name='d'} ,Via=Airport{name='b'}"
                            + ", To=Airport{name='c'}}\n",
                systemOutRule.getLogWithNormalizedLineSeparator());
    }
}
