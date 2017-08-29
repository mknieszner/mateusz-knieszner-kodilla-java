package com.kodilla.good.patterns.moviestore;

import java.util.List;

/**
 * MovieStore interface Implementation.
 */
class MovieStoreImpl implements MovieStore {
    private final MovieRegistry movieRegistry;

    public MovieStoreImpl(MovieRegistry movieRegistry) {
        this.movieRegistry = movieRegistry;
    }

    public void addMovieList(final String listName, final List<Movie> movieList) {
        movieRegistry.addMovieList(listName, movieList);
    }

    public String getAllTitlesSeparatedWithExclamationPoint() {
        return movieRegistry.getAllTitlesSeparatedWithExclamationPoint();
    }
}