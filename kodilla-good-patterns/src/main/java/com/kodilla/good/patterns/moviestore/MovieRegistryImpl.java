package com.kodilla.good.patterns.moviestore;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * MovieRegistry interface implementation.
 */
public class MovieRegistryImpl implements MovieRegistry {
    private Map<String, List<String>> movieMap = new HashMap<>();

    @Override
    public void addMovie(Movie movie) {
        movieMap.put(movie.getId(), movie.getMovieTranslations());
    }

    @Override
    public String getAllTitlesSeparatedWithExclamationPoint() {
        return movieMap.values()
                .stream()
                .flatMap(Collection::stream)
                .collect(Collectors.joining("!"));
    }
}
