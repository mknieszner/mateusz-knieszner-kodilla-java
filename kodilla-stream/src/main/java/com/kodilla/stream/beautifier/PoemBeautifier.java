package com.kodilla.stream.beautifier;

/**
 * Class contains decorate method.
 */
public class PoemBeautifier {
    public static void decorate(final String stringToDecorate, final PoemDecorator poemDecorator) {
        poemDecorator.decorateText(stringToDecorate);
    }
}
