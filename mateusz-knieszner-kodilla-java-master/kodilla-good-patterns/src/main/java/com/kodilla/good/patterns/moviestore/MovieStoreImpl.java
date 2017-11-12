package com.kodilla.good.patterns.moviestore;

/**
 * MovieStore interface Implementation.
 */
class MovieStoreImpl implements MovieStore {
    private final MovieRegistry movieRegistry;

    public MovieStoreImpl(final MovieRegistry movieRegistry) {
        this.movieRegistry = movieRegistry;
    }

    public void addMovie(final Movie movie) {
        movieRegistry.addMovie(movie);
    }

    public String getAllTitlesSeparatedWithExclamationPoint() {
        return movieRegistry.getAllTitlesSeparatedWithExclamationPoint();
    }
}