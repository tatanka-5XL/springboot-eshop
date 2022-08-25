package cz.petrpribil.ita.rest;

import cz.petrpribil.ita.model.CartDto;
import cz.petrpribil.ita.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/carts")
@CrossOrigin("http://localhost:8088")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

    @PostMapping("products/{productId}")
    CartDto createCart(@PathVariable("productId") Long productId) {
        return cartService.createCart(productId);
    }

    @PostMapping("{cartId}/products/{productId}")
    CartDto addToCart(@PathVariable("productId") Long productId, @PathVariable("cartId") Long cartId) {
        return cartService.addToCart(productId, cartId);
    }

    @GetMapping("{cartId}")
    CartDto findCart(@PathVariable("cartId") Long cartId) {
        return cartService.findCart(cartId);
    }
}
