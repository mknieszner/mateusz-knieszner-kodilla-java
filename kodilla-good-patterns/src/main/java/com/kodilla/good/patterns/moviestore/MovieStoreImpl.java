package com.kodilla.good.patterns.moviestore;

import java.util.List;

/**
 * MovieStore interface Implementation.
 */
class MovieStoreImpl implements MovieStore {
    private MovieRegistry movieRegistry;

    public MovieStoreImpl(MovieRegistry movieRegistry) {
        this.movieRegistry = movieRegistry;
    }

    public void addMovieList(final String listName, final List<String> list) {
        movieRegistry.addMovieList(listName, list);
    }

    public String getAllTitlesSeparatedWithExclamationPoint() {
        return movieRegistry.getAllTitlesSeparatedWithExclamationPoint();
    }
}