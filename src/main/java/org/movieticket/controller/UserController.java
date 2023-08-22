package org.movieticket.controller;

import org.movieticket.entity.Login;
import org.movieticket.entity.User;
import org.movieticket.service.MovieService;
import org.movieticket.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    private UserService userService;
    private MovieService movieService;

    public UserController(MovieService movieService, UserService userService) {
        this.userService = userService;
        this.movieService = movieService;
    }

    @GetMapping(value = "/userLogin")
    public String userLogin(Model model, HttpServletRequest request) {
        String r = request.getParameter("r");
        if (r != null) {
            if (r.equalsIgnoreCase("error")) {
                model.addAttribute("msgerr", "Error: Invalid E-Mail Address Or Password.");
            }
        }
        return "user/userLogin";
    }

    @PostMapping("/userLoginEvent")
    public String login(@ModelAttribute Login login, HttpSession session) {

        User user = userService.loginFormed(login);
        if (user != null) {
            session.setAttribute("userId", user.getUserId());
            session.setAttribute("userFirstName", user.getFirstName());
            session.setAttribute("userLastName", user.getLastName());
            session.setAttribute("userEmailAddress", user.getEmailAddress());
            return "redirect:/userMovieList";
        }
        return "redirect:/userLogin?r=error";
    }

    @GetMapping(value = "/userRegister")
    public String userRegister(Model model, HttpServletRequest request) {
        String re = request.getParameter("r");
        if (re != null) {
            if (re.equalsIgnoreCase("success")) {
                model.addAttribute("msgsuc", "User was Successfully Registered.");
            } else {
                model.addAttribute("msgerr", "<b>Error</a> Unable to Register User Account; Please try again.");
            }
        }
        return "user/userRegister";
    }

    @PostMapping("/createUserAccount")
    public String createUser(@ModelAttribute User user, HttpServletRequest request) {

        User userObj = userService.save(user);
        if (userObj.getUserId() > 0) {
            return "redirect:/userRegister?r=success";
        } else {
            return "redirect:/userRegister?r=error";
        }
    }

    @GetMapping("/userMovieList")
    public String userDashBoard(Model model, HttpServletRequest request, HttpSession httpSession) {

        Object userObj = httpSession.getAttribute("userId");
        if (userObj == null) {
            return "redirect:/userLogin";
        }

        String re = request.getParameter("r");
        if (re != null) {
            if (re.equalsIgnoreCase("success")) {
                model.addAttribute("msgsuc", "Movie Ticket was Successfully Booked.");
            } else {
                model.addAttribute("msgerr", "Error:  Unable to Book Cinema Movie Ticket; Please try again.");
            }
        }
        model.addAttribute("moviedatalistref", movieService.getAll());
        return "user/movielist";
    }

    @GetMapping("/userLogout")
    public String logOut(HttpSession httpSession) {
        httpSession.invalidate();
        return "redirect:/userLogin";
    }

}