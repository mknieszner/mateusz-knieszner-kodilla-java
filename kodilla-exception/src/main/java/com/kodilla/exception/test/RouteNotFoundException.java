package com.kodilla.exception.test;

/**
 * Airport does not exist in HashMap.
 */
public class RouteNotFoundException extends Exception {
    public RouteNotFoundException(final String message) {
        super(message);
    }
}
