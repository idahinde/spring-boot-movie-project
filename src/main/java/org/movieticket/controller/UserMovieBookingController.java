package org.movieticket.controller;

import org.movieticket.entity.Movie;
import org.movieticket.entity.MovieBooking;
import org.movieticket.entity.User;
import org.movieticket.service.MovieBookingService;
import org.movieticket.service.MovieService;
import org.movieticket.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

@Controller
public class UserMovieBookingController {

    private UserService userService;
    private MovieService movieService;
    private MovieBookingService movieBookingService;

    public UserMovieBookingController(UserService userService, MovieService movieService, MovieBookingService movieBookingService) {
        this.userService = userService;
        this.movieService = movieService;
        this.movieBookingService = movieBookingService;
    }

    @PostMapping("/postMovieBook")
    public String postMovieBooking(@RequestParam("movieId") int movieId, @RequestParam("userId") int userId) {

        try {

            Movie movie = movieService.getMovie(movieId).get();
            User user = userService.getUser(userId).get();

            MovieBooking movieBooking = new MovieBooking(user, movie, Date.valueOf(LocalDate.now()), Time.valueOf(LocalTime.now()));
            MovieBooking movieBookingObj = movieBookingService.save(movieBooking);
            if (movieBookingObj.getBookingId() > 0) {
                return "redirect:/userMovieList?r=success";
            } else {
                return "redirect:/userMovieList?r=error";
            }
        } catch (Exception e) {
            return "redirect:/userMovieList?r=error";
        }
    }

    @GetMapping("/userMovieBookingList")
    public String bookingList(Model model, HttpSession httpSession) {

        try {

            Object userObj = httpSession.getAttribute("userId");
            if (userObj == null) {
                return "redirect:/userLogin";
            }

            int userId = Integer.valueOf(userObj.toString());
            model.addAttribute("moviebookinglistdata", movieBookingService.getMovieBookingByUserId(userId));

        } catch (Exception e) {
        }
        return "user/movieBookingList";
    }

}
