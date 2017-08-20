package com.kodilla.exception.test;

/**
 * Thrown when a route was not found.
 */
public class RouteNotFoundException extends Exception {
    public RouteNotFoundException(final String message) {
        super(message);
    }
}
