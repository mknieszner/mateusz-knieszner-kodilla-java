package com.kodilla.stream.world;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * Test suite for Word class.
 */
public class WorldTestSuite {
    @Test
    public void testGetPeopleQuantity() {
        //Give
        final World world = getBuildedTestWorld();

        //when
        final BigDecimal totalPeople = world.getPeopleQuantity();

        //Then
        final BigDecimal expectedPeople = new BigDecimal("911");
        Assert.assertEquals(expectedPeople, totalPeople);
    }

    private static World getBuildedTestWorld() {
        final World world = new World();
        buildTestAsia(world);
        buildTestEurope(world);
        buildTestNorthAmerica(world);
        return world;
    }

    private static void buildTestNorthAmerica(final World world) {
        final Continent northAmerica = new Continent();
        northAmerica.addCountry(new Country(new BigDecimal(100)));
        northAmerica.addCountry(new Country(new BigDecimal(10)));
        northAmerica.addCountry(new Country(new BigDecimal(100)));
        northAmerica.addCountry(new Country(new BigDecimal(100)));
        world.addContinent(northAmerica);
    }

    private static void buildTestEurope(final World world) {
        final Continent europe = new Continent();
        europe.addCountry(new Country(new BigDecimal(100)));
        europe.addCountry(new Country(new BigDecimal(100)));
        europe.addCountry(new Country(new BigDecimal(100)));
        europe.addCountry(new Country(new BigDecimal(100)));
        europe.addCountry(new Country(new BigDecimal(100)));
        world.addContinent(europe);
    }

    private static void buildTestAsia(final World world) {
        final Continent asia = new Continent();
        asia.addCountry(new Country(new BigDecimal(1)));
        asia.addCountry(new Country(new BigDecimal(100)));
        world.addContinent(asia);
    }
}
