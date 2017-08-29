package com.kodilla.good.patterns.moviestore;

import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;

/**
 * Movie class.
 */
public class Movie {
    private final String id;
    private final List<String> movieTranslations;


    public Movie(final String id, final List<String> movieTranslations) {
        this.movieTranslations = movieTranslations;
        this.id = id;

    }

    public String getId() {
        return id;
    }

    public List<String> getMovieTranslations() {
        return Collections.unmodifiableList(movieTranslations);
    }

    public String movieTranslationsToString() {
        StringJoiner stringJoiner = new StringJoiner("!");

        for (String movieTranslation : movieTranslations) {
            stringJoiner.add(movieTranslation);
        }

        return stringJoiner.toString();
    }
}
