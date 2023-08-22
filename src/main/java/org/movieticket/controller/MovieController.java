package org.movieticket.controller;

import org.movieticket.entity.Movie;
import org.movieticket.entity.Screen;
import org.movieticket.service.CinemaService;
import org.movieticket.service.MovieService;
import org.movieticket.service.ScreenService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Base64;

@Controller
public class MovieController {

    private MovieService movieService;
    private ScreenService screenService;
    private CinemaService cinemaService;

    public MovieController(MovieService movieService, ScreenService screenService, CinemaService cinemaService) {
        this.movieService = movieService;
        this.screenService = screenService;
        this.cinemaService = cinemaService;
    }

    @GetMapping("/adminMovie")
    public String AddMovie(Model model, HttpServletRequest request) {
        model.addAttribute("screendata", screenService.getAll());
        model.addAttribute("moviedata", movieService.getAll());
        String re = request.getParameter("r");
        if (re != null) {
            if (re.equalsIgnoreCase("success")) {
                model.addAttribute("msgsuc", "Movie was Successfully Created.");
            } else {
                model.addAttribute("msgerr", "Error:  Unable to Create Movie; Please try again.");
            }
        }
        return "admin/movie";
    }

    @PostMapping("/saveMovie")
    public String saveMovie(@ModelAttribute Movie movie, @RequestParam("movieImage") MultipartFile file) {
        try {

            Screen screen = screenService.getScreen(movie.getScreen().getScreenId()).get();
            String encodedString = Base64.getEncoder().encodeToString(file.getBytes());
            String imageData = String.format("data:%s;base64,%s", file.getContentType(), encodedString);

            movie.setScreen(screen);
            movie.setImageData(imageData);

            Movie movieObj = movieService.save(movie);
            if (movieObj.getMovieId() > 0) {
                return "redirect:/adminMovie?r=success";
            } else {
                return "redirect:/adminMovie?r=error";
            }
        } catch (Exception e) {
            return "redirect:/adminMovie?r=error";
        }
    }

}