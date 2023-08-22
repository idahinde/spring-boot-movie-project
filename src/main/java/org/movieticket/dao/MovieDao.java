package org.movieticket.dao;

import org.movieticket.entity.Movie;
import org.movieticket.repository.MovieRepository;
import org.movieticket.service.MovieService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MovieDao implements MovieService {

    private MovieRepository repository;

    public MovieDao(MovieRepository repository) {
        this.repository = repository;
    }

    @Override
    public Movie save(Movie movie) {
        return repository.save(movie);
    }

    @Override
    public Optional<Movie> getMovie(int id) {
        return repository.findById(id);
    }

    @Override
    public List<Movie> getAll() {
        return repository.findAll();
    }

}
