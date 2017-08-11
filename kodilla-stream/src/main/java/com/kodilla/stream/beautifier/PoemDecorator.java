package com.kodilla.stream.beautifier;

/**
 * Functional interface, provides method that decorate string.
 */
@FunctionalInterface
public interface PoemDecorator {
    public void decorateText(String stringToDecorate);
}
