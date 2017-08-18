package com.kodilla.exception.challenge;

/**
 * Divides two arguments.
 */
public class FirstChallenge {

    private double divide(final double a, final double b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException();
        }
        return a / b;
    }

    /**
     * This main can throw an ArithmeticException!!!
     *
     * @param args
     */
    public static void main(String[] args) {
        final FirstChallenge firstChallenge = new FirstChallenge();

        try {
            final double result = firstChallenge.divide(3, 0);
            System.out.println(result);
        } catch (ArithmeticException e) {
            System.out.println("Do not divide by zero!: " + e);
        } finally {
            System.out.println("End!");
        }
    }
}