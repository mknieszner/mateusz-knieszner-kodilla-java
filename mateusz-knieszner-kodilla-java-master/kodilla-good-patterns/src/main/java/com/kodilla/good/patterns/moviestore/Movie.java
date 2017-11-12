package com.kodilla.good.patterns.moviestore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Movie class.
 */
public class Movie {
  private final String id;
  private final List<String> movieTranslations;


  public Movie(final String id, final List<String> movieTranslations) {
    this.movieTranslations = new ArrayList<>(movieTranslations);
    this.id = id;
  }

  public String getId() {
    return id;
  }

  public List<String> getMovieTranslations() {
    return Collections.unmodifiableList(movieTranslations);
  }
}
