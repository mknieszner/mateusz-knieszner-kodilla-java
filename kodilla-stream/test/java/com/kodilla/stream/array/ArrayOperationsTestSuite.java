package com.kodilla.stream.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * TestSuite for ArrayOperations interface
 */
public class ArrayOperationsTestSuite {
    @Test
    public void testGetAverage() {
        //Given
        int[] test = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        //When
        double averageTest = ArrayOperations.getAverage(test);

        //Then
        Assert.assertEquals(5.0, averageTest, 0.01);
    }
}
