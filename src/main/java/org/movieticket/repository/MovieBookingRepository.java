package org.movieticket.repository;

import org.movieticket.entity.MovieBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieBookingRepository extends JpaRepository<MovieBooking, Integer> {

    @Query(" select mb from  MovieBooking mb where mb.user.userId=:userId ")
    List<MovieBooking> getMovieBookingByUserId(@Param("userId") int id);

}
