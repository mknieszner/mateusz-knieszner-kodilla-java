package com.kodilla.exception.test;

/**
 * Input test class.
 */
public class SecondChallenge {
    public String probablyIWillThrowException(final double x, final double y) throws Exception {
        if (x >= 2 || x < 1 || y == 1.5) {
            throw new Exception("Arguments  (x= " + x + ", y= " + y + "),"
                    + "Test: x >= 2 || x < 1 || y == 1.5");
        }
        return "Done!";
    }
}