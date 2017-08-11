package com.kodilla.stream.world;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;


/**
 * Test suite for Word Class.
 */
public class WorldTestSuite {
    Country poland = new Country(new BigDecimal(100));
    Country england = new Country(new BigDecimal(100));
    Country france = new Country(new BigDecimal(100));
    Country canada = new Country(new BigDecimal(100));
    Country usa = new Country(new BigDecimal(100));
    Country mexico = new Country(new BigDecimal(100));
    Country russia = new Country(new BigDecimal(10));
    Country china = new Country(new BigDecimal(100));
    Country india = new Country(new BigDecimal(1));
    Country spain = new Country(new BigDecimal(100));
    Country germany = new Country(new BigDecimal(100));

    Continent europe = new Continent();
    Continent northAmerica = new Continent();
    Continent asia = new Continent();
    World world = new World();


    @Test
    public void testGetPeopleQuantity() {
        //Give
        asia.addCountry(india);
        asia.addCountry(russia);
        europe.addCountry(poland);
        europe.addCountry(england);
        europe.addCountry(france);
        europe.addCountry(spain);
        europe.addCountry(germany);
        northAmerica.addCountry(canada);
        northAmerica.addCountry(usa);
        northAmerica.addCountry(mexico);
        northAmerica.addCountry(china);
        world.addContinent(asia);
        world.addContinent(northAmerica);
        world.addContinent(europe);

        //when
        BigDecimal totalPeople = world.getPeopleQuantity();

        //Then
        BigDecimal expectedPeople = new BigDecimal("911");
        Assert.assertEquals(expectedPeople, totalPeople);

    }

}
