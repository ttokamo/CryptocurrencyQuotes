package by.overone.it.controllers;

import by.overone.it.dto.Quote;
import by.overone.it.enums.AvailableCryptocurrencies;
import by.overone.it.json.JsonParser;
import by.overone.it.pojo.User;
import by.overone.it.property_reader.GetCryptoProperty;
import by.overone.it.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuotesController {

    @Autowired
    private JsonParser jsonParser;
    @Autowired
    private UserService userService;
    @Autowired
    private GetCryptoProperty getCryptoProperty;

    @GetMapping("/quotes-page/{id}")
    public String getQuotes(@PathVariable("id") String userId) {
        User user = userService.getUserById(userId);
        Quote quote = jsonParser.getQuoteFromJson(
                getCryptoProperty.getProperty(
                        user.getCryptoSymbol()));
        userService.updateCryptoPrice(quote.getPrice(), userId);
        return quote.toString();
    }

    @GetMapping("/available-cryptocurrencies")
    public AvailableCryptocurrencies[] availableCrypto() {
        return AvailableCryptocurrencies.values();
    }
}
