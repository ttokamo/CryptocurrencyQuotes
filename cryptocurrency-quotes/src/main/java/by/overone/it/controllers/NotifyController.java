package by.overone.it.controllers;

import by.overone.it.enums.AvailableCryptocurrencies;
import by.overone.it.pojo.User;
import by.overone.it.service.UserService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

@RestController
public class NotifyController {
    @Autowired
    private UserService userService;

    @PostMapping("/check-login")
    @SneakyThrows
    public void notify(
            @RequestParam("nickname") String nickname,
            @RequestParam("symbol") String cryptoSymbol,
            HttpServletResponse response
    ) {
        User user = userService.getUserByNickname(nickname);
        if (user == null) {
            user = new User();
            user.setCryptoSymbol(cryptoSymbol);
            user.setNickname(nickname);
            userService.saveUser(user);
        } else if (!user.getCryptoSymbol().equals(cryptoSymbol)) {
            if (Arrays.toString(AvailableCryptocurrencies.values()).contains(cryptoSymbol.toUpperCase())) {
                userService.updateCryptoSymbol(cryptoSymbol, user.getId());
            }
        }

        response.sendRedirect("/quotes-page/" + user.getId());
    }
}
