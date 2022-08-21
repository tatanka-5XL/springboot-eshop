package cz.petrpribil.ita.rest;

import cz.petrpribil.ita.model.CartDto;
import cz.petrpribil.ita.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("api/v1/carts")
@CrossOrigin("http://localhost:8088")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

    @GetMapping
    public Collection<CartDto> findAll() {
        return cartService.findAll();
    }

}
