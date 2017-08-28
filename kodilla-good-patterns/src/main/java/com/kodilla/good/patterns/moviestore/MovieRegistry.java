package com.kodilla.good.patterns.moviestore;

import java.util.List;

/**
 *
 */
public interface MovieRegistry {

    public void addMovieList(String listName, List<String> list);

    public String getAllTitlesSeparatedWithExclamationPoint();
}
