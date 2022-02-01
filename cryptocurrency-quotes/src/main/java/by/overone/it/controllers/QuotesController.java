package by.overone.it.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuotesController {

    @GetMapping("/quotes-pages")
    public void getQuotes() {

    }
}
