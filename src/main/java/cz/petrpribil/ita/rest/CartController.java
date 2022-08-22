package cz.petrpribil.ita.rest;

import cz.petrpribil.ita.model.CartDto;
import cz.petrpribil.ita.model.CartRequestDto;
import cz.petrpribil.ita.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@RestController
@RequestMapping("api/v1/carts")
@CrossOrigin("http://localhost:8088")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

    @PostMapping("products/{id}")
    public CartDto createCart(@PathVariable("id") Long id, @Valid @RequestBody CartRequestDto cartRequestDto) {
        return cartService.createCart(id, cartRequestDto);
    }

}
