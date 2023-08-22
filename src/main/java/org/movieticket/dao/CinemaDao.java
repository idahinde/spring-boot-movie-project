package org.movieticket.dao;

import org.movieticket.entity.Cinema;
import org.movieticket.repository.CinemaRepository;
import org.movieticket.service.CinemaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CinemaDao implements CinemaService {

    private CinemaRepository repository;

    public CinemaDao(CinemaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Cinema save(Cinema cinema) {
        return repository.save(cinema);
    }

    @Override
    public Optional<Cinema> getCinema(int id) {
        return repository.findById(id);
    }

    @Override
    public List<Cinema> getAll() {
        return repository.findAll();
    }

}
