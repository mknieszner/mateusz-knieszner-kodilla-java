package com.kodilla.good.patterns.moviestore;

import java.util.List;

/**
 * Interface provides addMovieList and  getAllTitlesSeparatedWithExclamationPoint method.
 */
public interface MovieStore {

    public void addMovieList(final String listName, final List<String> list);

    public String getAllTitlesSeparatedWithExclamationPoint();


}
