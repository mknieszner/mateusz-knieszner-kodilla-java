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
    private final MovieStoreImpl movieStore = new MovieStoreImpl(new MovieRegistryImpl());

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Test
    public void getAllTitlesSeparatedWithExclamationPointTest() {
        final List<String> ironManTranslations = new ArrayList<>();
        final List<String> avengersTranslations = new ArrayList<>();
        final List<String> flashTranslations = new ArrayList<>();

        ironManTranslations.add("Żelazny Człowiek");
        ironManTranslations.add("Iron Man");
        avengersTranslations.add("Mściciele");
        avengersTranslations.add("Avengers");
        flashTranslations.add("Błyskawica");
        flashTranslations.add("Flash");

        final Movie movie = new Movie("IM", ironManTranslations);
        final Movie movie1 = new Movie("AV", avengersTranslations);
        final Movie movie2 = new Movie("FL", flashTranslations);

        movieStore.addMovie(movie);
        movieStore.addMovie(movie1);
        movieStore.addMovie(movie2);

        System.out.println(movieStore.getAllTitlesSeparatedWithExclamationPoint());
        assertEquals("Żelazny Człowiek!Iron Man!Mściciele!Avengers!Błyskawica!Flash\n",
                systemOutRule.getLogWithNormalizedLineSeparator());
    }
}

