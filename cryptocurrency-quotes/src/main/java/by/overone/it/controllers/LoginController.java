package by.overone.it.controllers;

import by.overone.it.pojo.User;
import by.overone.it.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;
    @Autowired
    private User user;

    @GetMapping({"/", "/login"})
    public String loginController() {
        return "login-page";
    }
}
