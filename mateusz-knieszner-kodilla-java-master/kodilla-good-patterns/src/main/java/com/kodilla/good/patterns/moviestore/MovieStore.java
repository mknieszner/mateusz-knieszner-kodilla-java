package com.kodilla.good.patterns.moviestore;

/**
 * Interface provides addMovieList and  getAllTitlesSeparatedWithExclamationPoint method.
 */
public interface MovieStore {

    public void addMovie(Movie movie);

    public String getAllTitlesSeparatedWithExclamationPoint();
}
