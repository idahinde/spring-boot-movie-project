package org.movieticket.service;

import org.movieticket.entity.Screen;

import java.util.List;
import java.util.Optional;

public interface ScreenService {

    Screen save(Screen screen);

    Optional<Screen> getScreen(int id);

    List<Screen> getByCinema(int cinemaId);

    List<Screen> getAll();
}
