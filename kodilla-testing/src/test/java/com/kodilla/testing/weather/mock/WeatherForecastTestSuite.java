package com.kodilla.testing.weather.mock;

import static org.mockito.Mockito.*;

import org.junit.*;

import java.util.HashMap;

import com.kodilla.testing.weather.stub.*;

/**
 *
 */
public class WeatherForecastTestSuite {
    @Test
    public void testCalculateForecastWithMock() {
        //Given
        final Temperatures temperaturesMock = mock(Temperatures.class);
        final HashMap<Integer, Double> temperaturesMap = new HashMap<Integer, Double>();
        temperaturesMap.put(0, 25.5);
        temperaturesMap.put(1, 26.2);
        temperaturesMap.put(2, 24.8);
        temperaturesMap.put(3, 25.2);
        temperaturesMap.put(4, 26.1);
        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);

        final WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

        //When
        final int quantityOfSensors = weatherForecast.calculateForecast().size();

        //Then
        Assert.assertEquals(5, quantityOfSensors);
    }
}