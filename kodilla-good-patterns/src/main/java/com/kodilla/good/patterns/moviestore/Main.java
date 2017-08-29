package com.kodilla.good.patterns.moviestore;

import java.util.ArrayList;
import java.util.List;

/**
 * Main class for movie store package.
 */
public class Main {

    public static void main(String[] args) {
        final MovieStoreImpl movieStore = new MovieStoreImpl(new MovieRegistryImpl());

        final List<Movie> ironManTranslations = new ArrayList<>();
        ironManTranslations.add(new Movie("Żelazny Człowiek"));
        ironManTranslations.add(new Movie("Iron Man"));

        final List<Movie> avengersTranslations = new ArrayList<>();
        avengersTranslations.add(new Movie("Mściciele"));
        avengersTranslations.add(new Movie("Avengers"));

        final List<Movie> flashTranslations = new ArrayList<>();
        flashTranslations.add(new Movie("Błyskawica"));
        flashTranslations.add(new Movie("Flash"));

        movieStore.addMovieList("IM", ironManTranslations);
        movieStore.addMovieList("AV", avengersTranslations);
        movieStore.addMovieList("FL", flashTranslations);

        System.out.println(movieStore.getAllTitlesSeparatedWithExclamationPoint());

    }
}

