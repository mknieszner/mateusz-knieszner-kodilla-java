package com.kodilla.good.patterns.moviestore;

import java.util.List;

/**
 *
 */
public interface MovieRegistry {

    public void addMovieList(String listName, List<Movie> list);

    public String getAllTitlesSeparatedWithExclamationPoint();
}
