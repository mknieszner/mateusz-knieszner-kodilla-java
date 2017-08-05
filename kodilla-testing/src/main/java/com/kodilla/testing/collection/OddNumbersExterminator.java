package com.kodilla.testing.collection;

import java.util.ArrayList;

public class OddNumbersExterminator {

    public ArrayList<Integer> exterminate(ArrayList<Integer> numbers) {
        ArrayList<Integer> oddList = new ArrayList<>();
        if (numbers != null) {
            for (Integer i : numbers) {
                if (i % 2 == 0) {
                    oddList.add(i);
                }
            }
            return oddList;
        }
        return null;
    }
}
