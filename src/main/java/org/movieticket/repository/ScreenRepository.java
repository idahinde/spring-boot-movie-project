package org.movieticket.repository;

import org.movieticket.entity.Screen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScreenRepository extends JpaRepository<Screen, Integer> {

    @Query("select s from Screen s where s.cinema.cinemaId=:cinemaId ")
    List<Screen> findAllByCinemaId(@Param("cinemaId") int id);

}
