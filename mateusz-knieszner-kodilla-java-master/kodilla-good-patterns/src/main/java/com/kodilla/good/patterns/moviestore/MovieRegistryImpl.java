package com.kodilla.good.patterns.moviestore;

import java.util.*;
import java.util.stream.Collectors;

/**
 * MovieRegistry interface implementation.
 */
public class MovieRegistryImpl implements MovieRegistry {
    private List<Movie> movieList = new ArrayList<>();

    @Override
    public void addMovie(final Movie movie) {
        movieList.add(movie);
    }

    @Override
    public String getAllTitlesSeparatedWithExclamationPoint() {
        return movieList.stream()
                .flatMap(Movie -> Movie.getMovieTranslations()
                        .stream())
                .collect(Collectors.joining("!"));
    }
}
