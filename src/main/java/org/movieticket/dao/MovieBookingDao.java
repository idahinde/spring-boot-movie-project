package org.movieticket.dao;

import org.movieticket.entity.MovieBooking;
import org.movieticket.repository.MovieBookingRepository;
import org.movieticket.service.MovieBookingService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MovieBookingDao implements MovieBookingService {

    private MovieBookingRepository repository;

    public MovieBookingDao(MovieBookingRepository repository) {
        this.repository = repository;
    }

    @Override
    public MovieBooking save(MovieBooking movieBooking) {
        return repository.save(movieBooking);
    }

    @Override
    public Optional<MovieBooking> getMovieBooking(int id) {
        return repository.findById(id);
    }

    @Override
    public List<MovieBooking> getAll() {
        return repository.findAll();
    }

    @Override
    public List<MovieBooking> getMovieBookingByUserId(int id) {
        return repository.getMovieBookingByUserId(id);
    }

}
