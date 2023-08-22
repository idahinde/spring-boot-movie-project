package org.movieticket.dao;

import org.movieticket.entity.Screen;
import org.movieticket.repository.ScreenRepository;
import org.movieticket.service.ScreenService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ScreenDao implements ScreenService {

    private ScreenRepository repository;

    public ScreenDao(ScreenRepository repository) {
        this.repository = repository;
    }

    @Override
    public Screen save(Screen screen) {
        return repository.save(screen);
    }

    @Override
    public Optional<Screen> getScreen(int id) {
        return repository.findById(id);
    }

    @Override
    public List<Screen> getByCinema(int cinemaId) {
        return repository.findAllByCinemaId(cinemaId);
    }

    @Override
    public List<Screen> getAll() {
        return repository.findAll();
    }

}
