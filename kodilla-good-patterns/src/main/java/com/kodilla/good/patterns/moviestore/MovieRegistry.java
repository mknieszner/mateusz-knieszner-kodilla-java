package com.kodilla.good.patterns.moviestore;

/**
 *
 */
public interface MovieRegistry {

    public void addMovie(Movie movie);

    public String getAllTitlesSeparatedWithExclamationPoint();
}
