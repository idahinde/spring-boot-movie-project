package org.movieticket.controller;

import org.movieticket.entity.Admin;
import org.movieticket.entity.Login;
import org.movieticket.service.AdminService;
import org.movieticket.service.MovieBookingService;
import org.movieticket.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class AdminController {

    private AdminService adminService;
    private UserService userService;
    private MovieBookingService movieBookingService;

    public AdminController(AdminService adminService, UserService userService, MovieBookingService movieBookingService) {
        this.userService = userService;
        this.adminService = adminService;
        this.movieBookingService = movieBookingService;
    }

    @GetMapping(value = "/adminLogin")
    public String adminLogin(Model model, HttpServletRequest request) {
        String r = request.getParameter("r");
        if (r != null) {
            if (r.equalsIgnoreCase("error")) {
                model.addAttribute("msgerr", "Error: Invalid E-Mail Address Or Password.");
            }
        }
        return "admin/adminLogin";
    }

    @PostMapping("/adminLoginEvent")
    public String login(@ModelAttribute Login login, HttpServletRequest request) {

        Admin admin = adminService.loginFormed(login);
        if (admin != null) {
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("adminId", admin.getAdminId());
            httpSession.setAttribute("firstName", admin.getFirstName());
            httpSession.setAttribute("lastName", admin.getLastName());
            httpSession.setAttribute("emailAddress", admin.getEmailAddress());
            return "redirect:/adminDashboard";
        }
        return "redirect:/adminLogin?r=error";
    }

    @GetMapping(value = "/adminRegister")
    public String adminRegister(Model model, HttpServletRequest request) {
        String re = request.getParameter("r");
        if (re != null) {
            if (re.equalsIgnoreCase("success")) {
                model.addAttribute("msgsuc", "Admin was Successfully Registered.");
            } else {
                model.addAttribute("msgerr", "<b>Error</a> Unable to Register Admin Account; Please try again.");
            }
        }
        return "admin/adminRegister";
    }

    @PostMapping("/createAdminAccount")
    public String createAdmin(@ModelAttribute Admin admin) {

        Admin adminObj = adminService.save(admin);
        if (adminObj.getAdminId() > 0) {
            return "redirect:/adminRegister?r=success";
        } else {
            return "redirect:/adminRegister?r=error";
        }
    }

    @GetMapping("/adminDashboard")
    public String adminDashBoard(Model model) {
        return "admin/dashboard";
    }

    @GetMapping("/adminUserList")
    public String userAccountList(Model model) {
        model.addAttribute("useradtalist", userService.getAll());
        return "admin/userList";
    }

    @GetMapping("/adminMovieBookingList")
    public String movieBookingList(Model model) {
        model.addAttribute("moviebookdtalist", movieBookingService.getAll());
        return "admin/movieBookingList";
    }

}
