// Write your code here

package com.example.movie;

import java.util.*;

public interface MovieRepository {
    ArrayList<Movie> getMovies();

    Movie gettingMovie(int movieId);

    Movie addMovie(Movie addingMovie);

    Movie updateMovie(int movieId, Movie addingMovie);

    void deleteMovie(int movieId);
}