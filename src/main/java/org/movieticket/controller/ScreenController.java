package org.movieticket.controller;

import org.movieticket.entity.Cinema;
import org.movieticket.entity.Screen;
import org.movieticket.service.CinemaService;
import org.movieticket.service.ScreenService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ScreenController {

    private ScreenService screenService;
    private CinemaService cinemaService;

    public ScreenController(ScreenService screenService, CinemaService cinemaService) {
        this.screenService = screenService;
        this.cinemaService = cinemaService;
    }

    @GetMapping("/adminScreen")
    public String cinema(Model model, HttpServletRequest request) {
        model.addAttribute("cinemadata", cinemaService.getAll());
        model.addAttribute("screendata", screenService.getAll());
        String re = request.getParameter("r");
        if (re != null) {
            if (re.equalsIgnoreCase("success")) {
                model.addAttribute("msgsuc", "Screen was Successfully Created.");
            } else {
                model.addAttribute("msgerr", "Error:  Unable to Create Screen; Please try again.");
            }
        }
        return "admin/screen";
    }

    @PostMapping("/saveScreen")
    public String saveCinema(@ModelAttribute Screen screen) {

        try {

            Cinema cinema = cinemaService.getCinema(screen.getCinema().getCinemaId()).get();
            screen.setCinema(cinema);
            Screen screenObj = screenService.save(screen);
            if (screenObj.getScreenId() > 0) {
                return "redirect:/adminScreen?r=success";
            } else {
                return "redirect:/adminScreen?r=error";
            }
        } catch (Exception e) {
            return "redirect:/adminScreen?r=error";
        }
    }

}
