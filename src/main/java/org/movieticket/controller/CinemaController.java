package org.movieticket.controller;

import org.movieticket.entity.Cinema;
import org.movieticket.service.CinemaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CinemaController {

    private CinemaService cinemaService;

    public CinemaController(CinemaService cinemaService) {
        this.cinemaService = cinemaService;
    }

    @GetMapping("/adminCinema")
    public String cinema(Model model, HttpServletRequest request) {
        model.addAttribute("cinemadata", cinemaService.getAll());
        String re = request.getParameter("r");
        if (re != null) {
            if (re.equalsIgnoreCase("success")) {
                model.addAttribute("msgsuc", "Cinema was Successfully Created.");
            } else {
                model.addAttribute("msgerr", "Error:  Unable to Create Cinema; Please try again.");
            }
        }
        return "admin/cinema";
    }

    @PostMapping("/saveCinema")
    public String saveCinema(@RequestParam("cinemaName") String c) {

        try {

            Cinema cinema = new Cinema(c);
            Cinema cinemaObj = cinemaService.save(cinema);
            if (cinemaObj.getCinemaId() > 0) {
                return "redirect:/adminCinema?r=success";
            } else {
                return "redirect:/adminCinema?r=error";
            }
        } catch (Exception e) {
            return "redirect:/adminCinema?r=error";
        }
    }

}
