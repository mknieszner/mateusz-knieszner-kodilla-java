package com.kodilla.good.patterns.moviestore;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * MovieRegistry interface implementation.
 */
public class MovieRegistryImpl implements MovieRegistry {
    private Map<String, List<Movie>> movieMap = new HashMap<>();

    @Override
    public void addMovieList(final String listName, final List<Movie> movieList) {
        movieMap.put(listName, movieList);
    }

    @Override
    public String getAllTitlesSeparatedWithExclamationPoint() {
        return movieMap.values()
                .stream()
                .flatMap(list -> (list.stream()))
                .map(Movie::getTitle)
                .collect(Collectors.joining("!"));
    }
}
