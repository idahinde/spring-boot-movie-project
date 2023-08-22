package org.movieticket.service;

import org.movieticket.entity.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieService {

    Movie save(Movie movie);

    Optional<Movie> getMovie(int id);

    List<Movie> getAll();
}
