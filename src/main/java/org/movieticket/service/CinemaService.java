package org.movieticket.service;

import org.movieticket.entity.Cinema;

import java.util.List;
import java.util.Optional;

public interface CinemaService {

    Cinema save(Cinema cinema);

    Optional<Cinema> getCinema(int id);

    List<Cinema> getAll();
}
