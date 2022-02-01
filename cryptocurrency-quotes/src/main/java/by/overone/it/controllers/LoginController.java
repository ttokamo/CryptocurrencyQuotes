package by.overone.it.controllers;

import by.overone.it.pojo.User;
import by.overone.it.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private UserService userService;
    @Autowired
    private User user;

    @GetMapping({"/", "/login"})
    public String loginController() {
        return "login-page";
    }

    @PostMapping("/check-login")
    public String checkInputData(
            @RequestParam("nickname") String nickname,
            @RequestParam("cryptoSymbol") String cryptoSymbol)
    {
        user.setCryptoSymbol(cryptoSymbol);
        user.setNickname(nickname);
        return "redirect:/quotes-pages";
    }
}
