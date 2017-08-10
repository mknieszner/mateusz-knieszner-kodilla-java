package com.kodilla.testing.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * Class contain exterminate method.
 */
public class OddNumbersExterminator {

    /**
     * Method remove odd numbers from ArrayList.
     *
     * @param numbers List with numbers.
     * @return Even number ArrayList.
     */
    public ArrayList<Integer> exterminate(final List<Integer> numbers) {
        final List<Integer> oddList = new ArrayList<>();

        for (Integer i : numbers) {
            if (i % 2 == 0) {
                oddList.add(i);
            }
        }
        return (ArrayList<Integer>) oddList;
    }
}

