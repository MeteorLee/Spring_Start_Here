package com.example.Controllers;

import com.example.Model.Country;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountryController {

    private Country country;

    public CountryController(Country country) {
        this.country = country;
    }

    @GetMapping("/france")
    public Country france() {
        Country c = country.of("France", 67);
        return c;
    }

    @GetMapping("/all")
    public List<Country> countries() {
        Country c1 = country.of("France", 67);
        Country c2 = country.of("Spain", 47);

        return List.of(c1, c2);
    }
}
