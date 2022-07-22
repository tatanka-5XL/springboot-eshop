package cz.petrpribil.ita.rest;

import cz.petrpribil.ita.model.ProductDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @GetMapping("greeting")
    public ProductDto test() {
        return new ProductDto(
                "Sekera",
                "Super rychle seka, lehka a ucinna",
                "https://www.mall.cz/i/45314226/550/550",
                1500L,
                5L,
                1L
        );
    }
}
