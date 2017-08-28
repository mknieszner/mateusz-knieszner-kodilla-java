package com.kodilla.good.patterns.moviestore;

import java.util.ArrayList;
import java.util.List;

/**
 * Main class for movie store package.
 */
public class Main {

    public static void main(String[] args) {
        final MovieStoreImpl movieStore = new MovieStoreImpl(new MovieRegistryImpl());

        final List<String> ironManTranslations = new ArrayList<>();
        ironManTranslations.add("Żelazny Człowiek");
        ironManTranslations.add("Iron Man");

        final List<String> avengersTranslations = new ArrayList<>();
        avengersTranslations.add("Mściciele");
        avengersTranslations.add("Avengers");

        final List<String> flashTranslations = new ArrayList<>();
        flashTranslations.add("Błyskawica");
        flashTranslations.add("Flash");

        movieStore.addMovieList("IM", ironManTranslations);
        movieStore.addMovieList("AV", avengersTranslations);
        movieStore.addMovieList("FL", flashTranslations);

        System.out.println(movieStore.getAllTitlesSeparatedWithExclamationPoint());

    }
}

