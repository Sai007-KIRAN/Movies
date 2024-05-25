package com.example.movie;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.*;
import com.example.movie.MovieService;

@RestController

class MovieController {
    MovieService service = new MovieService();

    @GetMapping("/movies")
    public ArrayList<Movie> getMovies() {
        return service.getMovies();
    }

    @GetMapping("/movies/{movieId}")
    public Movie gettingMovie(@PathVariable("movieId") int movieId) {
        return service.gettingMovie(movieId);
    }

    @PostMapping("/movies")
    public Movie addMovie(@RequestBody Movie addingMovie) {
        return service.addMovie(addingMovie);
    }

    @PutMapping("/movies/{movieId}")
    public Movie updateMovie(@PathVariable("movieId") int movieId, @RequestBody Movie addingMovie) {
        return service.updateMovie(movieId, addingMovie);
    }

    @DeleteMapping("/movies/{movieId}")
    void deleteMovie(@PathVariable("movieId") int movieId) {
        service.deleteMovie(movieId);
    }
}