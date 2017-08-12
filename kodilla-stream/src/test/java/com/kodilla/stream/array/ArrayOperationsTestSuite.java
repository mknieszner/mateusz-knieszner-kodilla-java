package com.kodilla.stream.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * TestSuite for ArrayOperations interface.
 */
public class ArrayOperationsTestSuite {
    private static final double expectedTestAverage = 5.0;
    private static final double assertEqualsDelta = 0.01;

    @Test
    public void testGetAverage() {
        //Given
        int[] test = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        //When
        double testAverage = ArrayOperations.getAverage(test);

        //Then
        Assert.assertEquals(expectedTestAverage, testAverage, assertEqualsDelta);
    }
}
