package cz.petrpribil.ita.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @GetMapping
    public String test() {
        return "Zdarec";
    }
}
