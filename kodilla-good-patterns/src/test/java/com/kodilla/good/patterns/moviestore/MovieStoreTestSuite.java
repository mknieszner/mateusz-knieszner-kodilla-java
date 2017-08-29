package com.kodilla.good.patterns.moviestore;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Test Suite for MovieStore Class.
 */
public class MovieStoreTestSuite {
    final MovieStoreImpl movieStore = new MovieStoreImpl(new MovieRegistryImpl());

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Test
    public void getAllTitlesSeparatedWithExclamationPointTest() {
        final List<Movie> ironManTranslations = new ArrayList<>();
        final List<Movie> avengersTranslations = new ArrayList<>();
        final List<Movie> flashTranslations = new ArrayList<>();

        ironManTranslations.add(new Movie("Żelazny Człowiek"));
        ironManTranslations.add(new Movie("Iron Man"));
        avengersTranslations.add(new Movie("Mściciele"));
        avengersTranslations.add(new Movie("Avengers"));
        flashTranslations.add(new Movie("Błyskawica"));
        flashTranslations.add(new Movie("Flash"));

        movieStore.addMovieList("IM", ironManTranslations);
        movieStore.addMovieList("AV", avengersTranslations);
        movieStore.addMovieList("FL", flashTranslations);

        System.out.println(movieStore.getAllTitlesSeparatedWithExclamationPoint());
        assertEquals("Żelazny Człowiek!Iron Man!Mściciele!Avengers!Błyskawica!Flash\n",
                systemOutRule.getLogWithNormalizedLineSeparator());
    }
}

