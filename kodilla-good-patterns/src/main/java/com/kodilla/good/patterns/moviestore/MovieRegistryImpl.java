package com.kodilla.good.patterns.moviestore;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * MovieRegistry interface implementation.
 */
public class MovieRegistryImpl implements MovieRegistry {

    private Map<String, List<String>> movieList = new HashMap<>();

    @Override
    public void addMovieList(final String listName, final List<String> list) {
        movieList.put(listName, list);
    }

    @Override
    public String getAllTitlesSeparatedWithExclamationPoint() {
        return movieList.values()
                .stream()
                .flatMap(list -> (list.stream()))
                .collect(Collectors.joining("!"));
    }
}
