package com.kodilla.exception.test;

/**
 * Tests Second challenge class.
 */
public class ExceptionHandling {

    public static void main(String[] args) {
        SecondChallenge secondChallenge = new SecondChallenge();

        try {
            secondChallenge.probablyIWillThrowException(3, 1);
        } catch (Exception e) {
            System.out.println("Wrong input! : " + e);
        }
    }
}
