package com.kodilla.good.patterns.moviestore;

public class MovieStoreMockTestSuite {
    /*

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Test
    public void getAllTitlesSeparatedWithExclamationPointTest() {

        MovieStore movieStore = mock(MovieStore.class);
        MovieRegistry movieRegistry = mock(MovieRegistry.class);

        Movie movie = mock(Movie.class);
        Movie movie1 = mock(Movie.class);
        Movie movie2 = mock(Movie.class);

        List<Movie> movieList = Arrays.asList(movie, movie1, movie2);
        movieList.add(movie);
        movieList.add(movie1);
        movieList.add(movie2);


        when(movieStore.getMovieRegistry()).thenReturn(movieRegistry.getMovieList());
        when(movieRegistry.getMovieList()).thenReturn(movieList);



        final List<String> ironManTranslations = new ArrayList<>();
        final List<String> avengersTranslations = new ArrayList<>();
        final List<String> flashTranslations = new ArrayList<>();



        when(movie.getId()).thenReturn("IM");
        //when(movie.getMovieTranslations()).thenReturn(ironManTranslations);
        when(movie1.getId()).thenReturn("AV");
        //when(movie1.getMovieTranslations()).thenReturn(avengersTranslations);
        when(movie2.getId()).thenReturn("FL");
        //when(movie2.getMovieTranslations()).thenReturn(flashTranslations);

        when(movie.getMovieTranslations()).thenReturn(movie.getMovieTranslations());
        when(movie1.getMovieTranslations()).thenReturn(movie1.getMovieTranslations());
        when(movie2.getMovieTranslations()).thenReturn(movie2.getMovieTranslations());

        when(movieStore.getAllTitlesSeparatedWithExclamationPoint()).thenReturn(

                movieList.stream()
                .flatMap(Movie -> Movie.getMovieTranslations().stream())
                .collect(Collectors.joining("!")));

        System.out.println(movieStore.getAllTitlesSeparatedWithExclamationPoint());
        assertEquals("Żelazny Człowiek!Iron Man!Mściciele!Avengers!Błyskawica!Flash\n",
                systemOutRule.getLogWithNormalizedLineSeparator());
    }
    */
}
