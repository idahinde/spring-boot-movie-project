package org.movieticket.service;

import org.movieticket.entity.MovieBooking;

import java.util.List;
import java.util.Optional;

public interface MovieBookingService {

    MovieBooking save(MovieBooking movieBooking);

    Optional<MovieBooking> getMovieBooking(int id);

    List<MovieBooking> getAll();

    List<MovieBooking> getMovieBookingByUserId(int id);

}
