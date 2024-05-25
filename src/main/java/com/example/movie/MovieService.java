
package com.example.movie;

import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import com.example.movie.Movie;
import com.example.movie.MovieRepository;

import java.util.*;

// Do not modify the below code

public class MovieService implements MovieRepository {

    private static HashMap<Integer, Movie> movieList = new HashMap<>();
    int unique = 6;

    public MovieService() {
        movieList.put(1, new Movie(1, "Avengers: Endgame", "Robert Downey Jr."));
        movieList.put(2, new Movie(2, "Avatar", "Sam Worthington"));
        movieList.put(3, new Movie(3, "Titanic", "Leonardo DiCaprio"));
        movieList.put(4, new Movie(4, "Star Wars: The Force Awakens", "Daisy Ridley"));
        movieList.put(5, new Movie(5, "Jurassic World", "Chris Pratt"));
    }

    // Do not modify the above code

    // Write your code here

    @Override
    public ArrayList<Movie> getMovies() {
        Collection<Movie> movieColl = movieList.values();
        ArrayList<Movie> movies = new ArrayList<>(movieColl);
        return movies;
    }

    @Override
    public Movie gettingMovie(int movieId) {
        Movie eachNumber = movieList.get(movieId);
        if (eachNumber == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return eachNumber;
    }

    @Override
    public Movie addMovie(Movie addingMovie) {
        addingMovie.setMovieId(unique);
        movieList.put(unique, addingMovie);
        unique += 1;
        return addingMovie;
    }

    @Override
    public Movie updateMovie(int movieId, Movie addingMovie) {
        Movie existing = movieList.get(movieId);
        if (existing == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        if (existing.getMovieName() != null) {
            existing.setmovieName(existing.getMovieName());
        }
        if (existing.getLeadActor() != null) {
            existing.setLeadActor(existing.getLeadActor());
        }
        return existing;
    }

    @Override
    public void deleteMovie(int movieId) {
        Movie delete = movieList.get(movieId);
        if (delete == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            movieList.remove(movieId);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
    }
}
