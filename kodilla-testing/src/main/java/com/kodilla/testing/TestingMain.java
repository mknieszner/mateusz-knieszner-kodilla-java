package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;

/**
 * Class tests Calculator class
 */
public class TestingMain {
    public static void main(String[] args) {
        final Calculator calculator = new Calculator();

        if (calculator.add(1, 1) == 2) {
            System.out.println("test add method OK");
        } else {
            System.out.println("Error!");
        }

        if (calculator.subtract(1, 1) == 0) {
            System.out.println("test subtract method OK");
        } else {
            System.out.println("Error!");
        }
    }
}