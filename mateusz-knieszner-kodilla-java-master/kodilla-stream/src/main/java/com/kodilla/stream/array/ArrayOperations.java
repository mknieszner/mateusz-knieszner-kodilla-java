package com.kodilla.stream.array;

import java.util.stream.IntStream;

/**
 * Interface, provides method that calculate average.
 */
public interface ArrayOperations {
    static double getAverage(final int[] numbers) {
        IntStream.range(0, numbers.length).forEach(n -> System.out.println(numbers[n]));
        return IntStream.range(0, numbers.length).map(n -> numbers[n]).average().getAsDouble();
    }
}